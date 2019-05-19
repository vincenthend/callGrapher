package analyzer;

import grammar.PhpParser;
import grammar.PhpParserBaseVisitor;
import model.ProjectData;
import model.graph.ControlFlowGraph;
import model.graph.statement.*;
import model.graph.statement.fill.BreakStatement;
import model.graph.statement.fill.ContinueStatement;
import model.php.PhpFunction;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;
import util.PhpAssignedTypeIdentifier;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhpMethodParserVisitor extends PhpParserBaseVisitor<ControlFlowGraph> {
  private ProjectData projectData;

  public PhpMethodParserVisitor(ProjectData p) {
    super();
    this.projectData = p;
  }

  @Override
  protected ControlFlowGraph defaultResult() {
    return new ControlFlowGraph();
  }

  @Override
  protected ControlFlowGraph aggregateResult(ControlFlowGraph aggregate, ControlFlowGraph nextResult) {
    ControlFlowGraph graph;
    if (aggregate != null && nextResult != null) {
      aggregate.appendGraph(nextResult);
      graph = aggregate;
    } else if (aggregate == null) {
      graph = nextResult;
    } else {
      graph = aggregate;
    }
    return graph;
  }

  @Override
  public ControlFlowGraph visitIfStatement(PhpParser.IfStatementContext ctx) {
    ControlFlowGraph graph = new ControlFlowGraph();

    // Add branch root
    CharStream input = ctx.start.getInputStream();
    Interval interval = new Interval(ctx.parenthesis().expression().start.getStartIndex(), ctx.parenthesis().expression().stop.getStopIndex());
    String code = input.getText(interval);

    ControlFlowGraph parenthesesGraph;
    ControlFlowGraph statementGraph;

    // Visit conditions and append branch conditions
    parenthesesGraph = visit(ctx.parenthesis().expression());

    BranchStatement branchStatement = new BranchStatement(code, new ArrayList<>(parenthesesGraph.getGraph().vertexSet()));
    graph.addStatement(branchStatement);
    graph.appendGraph(parenthesesGraph);

    PhpStatement branchPoint = graph.getLastVertices().iterator().next();

//    PhpStatement branch_point = new BranchStatement(BranchStatement.BranchStatementType.BRANCH_POINT);
//    graph.addStatement(branch_point);

    // Visit statement block and append to conditions
    statementGraph = visit(ctx.statement());
    graph.appendGraph(statementGraph);

    //TODO Refactor this

    // Add root vertex
    if (!ctx.elseIfStatement().isEmpty()) {
      for (PhpParser.ElseIfStatementContext e : ctx.elseIfStatement()) {
        // Visit elseif's condition and append to previous conditions
        parenthesesGraph = new ControlFlowGraph();
        parenthesesGraph.appendGraph(visit(e.parenthesis().expression()));
//        par_graph.addStatement(new BranchStatement(BranchStatement.BranchStatementType.BRANCH_POINT));

        // Visit block and append to conditions
        statementGraph = visit(e.statement());
        parenthesesGraph.appendGraph(statementGraph);

        graph.appendGraph(branchPoint, parenthesesGraph);
      }
    } else if (!ctx.elseIfColonStatement().isEmpty()) {
      for (PhpParser.ElseIfColonStatementContext e : ctx.elseIfColonStatement()) {
        // Visit elseif's condition and append to previous conditions
        parenthesesGraph = new ControlFlowGraph();
        parenthesesGraph.appendGraph(visit(e.parenthesis().expression()));

        // Visit block and append to conditions
        statementGraph = visit(e.innerStatementList());
        parenthesesGraph.appendGraph(statementGraph);

        graph.appendGraph(branchPoint, parenthesesGraph);
      }
    }

    if (ctx.elseStatement() != null) {
      statementGraph = visit(ctx.elseStatement().statement());
      graph.appendGraph(branchPoint, statementGraph);
    } else if (ctx.elseColonStatement() != null) {
      statementGraph = visit(ctx.elseColonStatement().innerStatementList());
      graph.appendGraph(branchPoint, statementGraph);
    }

    if (ctx.elseStatement() == null && ctx.elseColonStatement() == null) {
      graph.getLastVertices().add(branchPoint);
    }
    return graph;
  }

  @Override
  public ControlFlowGraph visitSwitchStatement(PhpParser.SwitchStatementContext ctx) {
    ControlFlowGraph graph = new ControlFlowGraph();

    // Get switch condition
    CharStream input = ctx.start.getInputStream();
    Interval interval = new Interval(ctx.parenthesis().expression().start.getStartIndex(), ctx.parenthesis().expression().stop.getStopIndex());
    String code = input.getText(interval);

    // Append condition as branchPoint
    ControlFlowGraph parenthesesGraph = visit(ctx.parenthesis().expression());
    graph.addStatement(new BranchStatement(code, new ArrayList<>(parenthesesGraph.getGraph().vertexSet())));
    graph.appendGraph(parenthesesGraph);
    PhpStatement branchPoint = graph.getLastVertices().iterator().next();

    // Get switch condition
    if (!ctx.switchBlock().isEmpty()) {
      ControlFlowGraph switchGraph = new ControlFlowGraph();

      List<ParseTree> defaultParsedStatement = new LinkedList<>();
      boolean foundDefault = false;
      for (PhpParser.SwitchBlockContext s : ctx.switchBlock()) {
        if (s.expression().isEmpty()) {
          // Is A Default Statement
          switchGraph.appendGraph(visit(s.innerStatementList()));
          foundDefault = true;
        } else {
          // Is A Case Statement
          List<ParseTree> caseParsedStatement = new LinkedList<>();

          // Iterate every inner statement to separate default statement
          for (PhpParser.InnerStatementContext innerS : s.innerStatementList().innerStatement()) {
            if (!foundDefault) {
              if (innerS.statement().identifier() != null && innerS.statement().identifier().Default() != null) {
                foundDefault = true;
                defaultParsedStatement.add(innerS);
              } else {
                caseParsedStatement.add(innerS);
              }
            } else {
              defaultParsedStatement.add(innerS);
            }
          }
          switchGraph = handleCaseBlock(s, caseParsedStatement);
        }

        // Handle switch's graph
        // Connect first statement to branchPoint
        graph.appendGraph(switchGraph);
        if (switchGraph.getFirstVertex() != null) {
          graph.addStatement(branchPoint, switchGraph.getFirstVertex());
        }

        // Handle default's graph
        if(!defaultParsedStatement.isEmpty()) {
          ControlFlowGraph defaultGraph = handleDefaultBlock(defaultParsedStatement);
          graph.appendGraph(defaultGraph);
          if (defaultGraph.getFirstVertex() != null) {
            graph.addStatement(branchPoint, defaultGraph.getFirstVertex());
          } else {
            graph.getLastVertices().add(branchPoint);
          }
          defaultParsedStatement.clear();
        }
      }

      if(!foundDefault){
        graph.getLastVertices().add(branchPoint);
      }
    }

    reduceBreakContinueStatement(graph);
    return graph;
  }

  private ControlFlowGraph handleDefaultBlock(List<ParseTree> parsedStatement) {
    ControlFlowGraph defaultGraph = new ControlFlowGraph();
    for (ParseTree pt : parsedStatement) {
      defaultGraph.appendGraph(visit(pt));
    }
    return defaultGraph;
  }

  private ControlFlowGraph handleCaseBlock(PhpParser.SwitchBlockContext s, List<ParseTree> caseParsedStatement) {
    // Append graph for switch condition
    ControlFlowGraph parentheseGraph = new ControlFlowGraph();
    parentheseGraph.appendGraph(visit(s.expression().get(0)));

    // Visit block and append to conditions
    ControlFlowGraph statementGraph = new ControlFlowGraph();
    for (ParseTree pt : caseParsedStatement) {
      statementGraph.appendGraph(visit(pt));
    }
    // Append to par_graph and then to switch_graph
    parentheseGraph.appendGraph(statementGraph);

    return parentheseGraph;
  }

  @Override
  public ControlFlowGraph visitForStatement(PhpParser.ForStatementContext ctx) {
    ControlFlowGraph init;
    ControlFlowGraph expression = null;
    ControlFlowGraph update = null;
    if (ctx.forInit() != null) {
      init = visit(ctx.forInit());
    } else {
      init = new ControlFlowGraph();
    }
    if (ctx.expressionList() != null) {
      expression = visit(ctx.expressionList());
    }
    if (ctx.forUpdate() != null) {
      update = visit(ctx.forUpdate());
    }

    ControlFlowGraph statement;
    if (ctx.statement() != null) {
      statement = visit(ctx.statement());
    } else {
      statement = visit(ctx.innerStatementList());
    }

    init.appendGraph(expression);
    init.appendGraph(statement);
    init.appendGraph(update);

    // connect loop to first statement
    for (PhpStatement p : init.getLastVertices()) {
      init.addStatement(p, init.getFirstVertex());
    }
//    init.getLastVertices().removeAll(init.getLastVertices());
//    init.getLastVertices().addAll(init.getLastVertices());

    reduceBreakContinueStatement(init);
    return init;
  }

  @Override
  public ControlFlowGraph visitForeachStatement(PhpParser.ForeachStatementContext ctx) {
    ControlFlowGraph cfg = new ControlFlowGraph();

    String array = ctx.chain(0).getText();
    String key = null;
    String value;
    PhpStatement keyAssignment;
    PhpStatement valueAssignment;
    if (ctx.chain().size() > 1 && ctx.expression() != null) {
      key = ctx.chain(ctx.chain().size() - 1).getText();
      value = ctx.chain(ctx.chain().size() - 2).getText();
    } else {
      value = ctx.chain(ctx.chain().size() - 1).getText();
    }
    valueAssignment = new AssignmentStatement(value, array, value + "=" + array);
    cfg.addStatement(valueAssignment);
    if (key != null) {
      keyAssignment = new AssignmentStatement(key, "string", key + "= key");
      cfg.addStatement(keyAssignment);
    }

    ControlFlowGraph statement = visit(ctx.statement());
    cfg.appendGraph(statement);

    // connect loop to first statement
    for (PhpStatement p : statement.getLastVertices()) {
      cfg.addStatement(p, cfg.getFirstVertex());
    }

    reduceBreakContinueStatement(cfg);
    return cfg;
  }

  @Override
  public ControlFlowGraph visitWhileStatement(PhpParser.WhileStatementContext ctx) {
    ControlFlowGraph init = visit(ctx.parenthesis());
    ControlFlowGraph statement;
    Set<PhpStatement> initStatement = new HashSet<>();
    initStatement.addAll(init.getLastVertices());
    if (ctx.statement() != null) {
      statement = visit(ctx.statement());
    } else {
      statement = visit(ctx.innerStatementList());
    }
    init.appendGraph(statement);

    // connect loop to first statement
    for (PhpStatement p : init.getLastVertices()) {
      init.addStatement(p, init.getFirstVertex());
    }

    init.getLastVertices().removeAll(statement.getLastVertices());
    init.getLastVertices().add(init.getFirstVertex());

    reduceBreakContinueStatement(init);
    return init;
  }

  @Override
  public ControlFlowGraph visitDoWhileStatement(PhpParser.DoWhileStatementContext ctx) {
    ControlFlowGraph init = visit(ctx.parenthesis());
    ControlFlowGraph statement = visit(ctx.statement());
    statement.appendGraph(init);
    // TODO Fix this error
    // connect loop to first statement
    for (PhpStatement p : init.getLastVertices()) {
      statement.addStatement(p, statement.getFirstVertex());
    }

    reduceBreakContinueStatement(statement);
    return statement;
  }

  @Override
  public ControlFlowGraph visitContinueStatement(PhpParser.ContinueStatementContext ctx) {
    ControlFlowGraph graph = new ControlFlowGraph();
    graph.addStatement(new ContinueStatement());
    return graph;
  }

  @Override
  public ControlFlowGraph visitBreakStatement(PhpParser.BreakStatementContext ctx) {
    ControlFlowGraph graph = new ControlFlowGraph();
    graph.addStatement(new BreakStatement());
    return graph;
  }

  private void reduceBreakContinueStatement(ControlFlowGraph loopGraph) {
    DepthFirstIterator<PhpStatement, DefaultEdge> iterator = new DepthFirstIterator<>(loopGraph.getGraph());
    List<PhpStatement> removeList = new LinkedList<>();
    while (iterator.hasNext()) {
      PhpStatement statement = iterator.next();
      if (statement.getStatementType() == StatementType.BREAK) {
        // Add statement to removeList
        List<PhpStatement> predStatements = Graphs.predecessorListOf(loopGraph.getGraph(), statement);
        removeList.add(statement);
        // Add all predecessor as last vertices
        loopGraph.getLastVertices().addAll(predStatements);
      } else if (statement.getStatementType() == StatementType.CONTINUE) {
        // Remove break statement edges
        List<PhpStatement> predStatements = Graphs.predecessorListOf(loopGraph.getGraph(), statement);
        removeList.add(statement);
        for (PhpStatement pred : predStatements) {
          loopGraph.addStatement(pred, loopGraph.getFirstVertex());
        }
      }
    }
    loopGraph.getGraph().removeAllVertices(removeList);
    loopGraph.getLastVertices().removeAll(removeList);
  }

  @Override
  public ControlFlowGraph visitReturnStatement(PhpParser.ReturnStatementContext ctx) {
    PhpStatement returnStatement;
    if (ctx.expression() != null) {
      returnStatement = new ReturnStatement(ctx.expression().getText());
    } else {
      returnStatement = new ReturnStatement("");
    }
    ControlFlowGraph childGraph = super.visitReturnStatement(ctx);
    childGraph.addStatement(returnStatement);
    return childGraph;
  }

  @Override
  public ControlFlowGraph visitTryCatchFinally(PhpParser.TryCatchFinallyContext ctx) {
    return visit(ctx.blockStatement());
  }

  @Override
  public ControlFlowGraph visitFunctionCall(PhpParser.FunctionCallContext ctx) {
    ControlFlowGraph graph = new ControlFlowGraph();
    CharStream input = ctx.start.getInputStream();
    Interval interval = new Interval(ctx.functionCallName().start.getStartIndex(), ctx.functionCallName().stop.getStopIndex());
    String name = input.getText(interval);

    // Get Arguments
    List<PhpParser.ActualArgumentContext> argsCtx = ctx.actualArguments().arguments().actualArgument();
    List<String> args = new LinkedList<>();
    for (PhpParser.ActualArgumentContext argCtx : argsCtx) {
      args.add(argCtx.getText());
      ControlFlowGraph argCfg = visit(argCtx);
      graph.appendGraph(argCfg);
    }

    graph.addStatement(new FunctionCallStatement(new PhpFunction(name, null, "", null), args, null, name));
    return graph;
  }

  @Override
  public ControlFlowGraph visitMemberAccess(PhpParser.MemberAccessContext ctx) {
    ControlFlowGraph graph = new ControlFlowGraph();
    if (ctx.actualArguments() != null) { // Method access by member
      PhpParser.ChainContext parentCtx = (PhpParser.ChainContext) ctx.getParent();
      StringBuilder varName = new StringBuilder();

      boolean callFound = false;
      Iterator<ParseTree> iterator = parentCtx.children.iterator();
      while (iterator.hasNext() && !callFound) {
        ParseTree tree = iterator.next();
        if (tree == ctx) {
          callFound = true;
        } else {
          Pattern p = Pattern.compile("^((->|\\$)?[a-zA-Z0-9_]+)(\\(.*)?$");
          Matcher m = p.matcher(tree.getText());

          if (m.find()) {
            varName.append(m.group(1));
          }
        }
      }

      // Get Arguments
      List<PhpParser.ActualArgumentContext> argsCtx = ctx.actualArguments().arguments().actualArgument();
      List<String> args = new LinkedList<>();
      for (PhpParser.ActualArgumentContext argCtx : argsCtx) {
        args.add(argCtx.getText());
        ControlFlowGraph argCfg = visit(argCtx);
        graph.appendGraph(argCfg);
      }

      // Get function graph
      PhpFunction tempFunc = new PhpFunction(ctx.keyedFieldName().getText(), null, "", null);
      graph.addStatement(new FunctionCallStatement(tempFunc, args, varName.toString(), varName.toString() + "->" + tempFunc.getFunctionName()));
    }/* else { // Variable access by member
      graph = visitExpression(ctx, "member");
    }*/
    return graph;
  }

  /* Handle Expressions */
  private ControlFlowGraph visitExpression(ParserRuleContext ctx, String type) {
    ControlFlowGraph graph = new ControlFlowGraph();
    CharStream input = ctx.start.getInputStream();
    Interval interval = new Interval(ctx.start.getStartIndex(), ctx.stop.getStopIndex());
    String code = input.getText(interval);
    graph.addStatement(new ExpressionStatement(type, code));
    return graph;
  }

  @Override
  public ControlFlowGraph visitChainExpression(PhpParser.ChainExpressionContext ctx) {
    ControlFlowGraph childGraph = super.visitChainExpression(ctx);
    int memberSize = ctx.chain().memberAccess().size();
    boolean hasArgs = false;
    if (memberSize != 0) {
      hasArgs = ctx.chain().memberAccess(memberSize - 1).actualArguments() != null;
    }
    if (ctx.chain().chainBase() != null && hasArgs) {
      ControlFlowGraph graph = visitExpression(ctx, "chain");
      graph.appendGraph(childGraph);
      return graph;
    } else {
      return childGraph;
    }
  }

  @Override
  public ControlFlowGraph visitNewExpr(PhpParser.NewExprContext ctx) {
    ControlFlowGraph graph = new ControlFlowGraph();
    CharStream input = ctx.start.getInputStream();
    Interval interval = new Interval(ctx.typeRef().start.getStartIndex(), ctx.typeRef().stop.getStopIndex());
    String name = input.getText(interval);

    // Get Arguments
    List<String> args = new LinkedList<>();
    if (ctx.arguments() != null) {
      List<PhpParser.ActualArgumentContext> argsCtx = ctx.arguments().actualArgument();
      for (PhpParser.ActualArgumentContext argCtx : argsCtx) {
        args.add(argCtx.getText());
        ControlFlowGraph argCfg = visit(argCtx);
        graph.appendGraph(argCfg);
      }
    }

    PhpFunction tempFunc = new PhpFunction("__construct", name, "", null);
    PhpFunction phpFunction = projectData.getFunction(tempFunc.getCalledName());
    if (phpFunction == null) {
      graph.addStatement(new FunctionCallStatement(tempFunc, args, null, ctx.getText()));
    } else {
      graph.addStatement(new FunctionCallStatement(phpFunction, args, null, ctx.getText()));
    }
    return graph;
  }

  @Override
  public ControlFlowGraph visitAssignmentExpression(PhpParser.AssignmentExpressionContext ctx) {
    ParserRuleContext assigneeContext = null;
    if (ctx.expression() != null) {
      assigneeContext = ctx.expression();
    } else if (ctx.chain().size() > 1) {
      assigneeContext = ctx.chain(1);
    } else if (ctx.newExpr() != null) {
      assigneeContext = ctx.newExpr();
    }
    CharStream input = ctx.start.getInputStream();
    Interval interval = new Interval(assigneeContext.start.getStartIndex(), assigneeContext.stop.getStopIndex());
    String assignedType = PhpAssignedTypeIdentifier.identify(input.getText(interval));

    ControlFlowGraph graph = new ControlFlowGraph();
    graph.addStatement(new AssignmentStatement(ctx.chain(0).getText(), assignedType, ctx.getText()));
//    ControlFlowGraph assignedGraph = visit(ctx.chain(0));
    ControlFlowGraph assigneeGraph = visit(assigneeContext);
//    assignedGraph.appendGraph(assigneeGraph);
    assigneeGraph.appendGraph(graph);

    return assigneeGraph;
  }

/*


  @Override
  public ControlFlowGraph visitComparisonExpression(PhpParser.ComparisonExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "comparison");
    ControlFlowGraph childGraph = super.visitComparisonExpression(ctx);
    childGraph.appendGraph(graph);
    return childGraph;
  }

@Override
  public ControlFlowGraph visitUnaryOperatorExpression(PhpParser.UnaryOperatorExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "unaryop");
    ControlFlowGraph childGraph = super.visitUnaryOperatorExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }

  @Override
  public ControlFlowGraph visitSpecialWordExpression(PhpParser.SpecialWordExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "specialword");
    ControlFlowGraph childGraph = super.visitSpecialWordExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }*/

  @Override
  public ControlFlowGraph visitArrayCreationExpression(PhpParser.ArrayCreationExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "arraycreation");
    ControlFlowGraph childGraph = super.visitArrayCreationExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }

  @Override
  public ControlFlowGraph visitNewExpression(PhpParser.NewExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "new");
    ControlFlowGraph childGraph = super.visitNewExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }

/*  @Override
  public ControlFlowGraph visitBackQuoteStringExpression(PhpParser.BackQuoteStringExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "backquote");
    ControlFlowGraph childGraph = super.visitBackQuoteStringExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }

  @Override
  public ControlFlowGraph visitConditionalExpression(PhpParser.ConditionalExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "conditional");
    ControlFlowGraph childGraph = super.visitConditionalExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }


  @Override
  public ControlFlowGraph visitArithmeticExpression(PhpParser.ArithmeticExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "arithmetic");
    ControlFlowGraph childGraph = super.visitArithmeticExpression(ctx);
    childGraph.appendGraph(graph);
    return childGraph;
  }

  @Override
  public ControlFlowGraph visitIndexerExpression(PhpParser.IndexerExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "indexer");
    ControlFlowGraph childGraph = super.visitIndexerExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }

  @Override
  public ControlFlowGraph visitPrefixIncDecExpression(PhpParser.PrefixIncDecExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "incdec");
    ControlFlowGraph childGraph = super.visitPrefixIncDecExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }

  @Override
  public ControlFlowGraph visitLogicalExpression(PhpParser.LogicalExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "logical");
    ControlFlowGraph childGraph = super.visitLogicalExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }

  @Override
  public ControlFlowGraph visitPrintExpression(PhpParser.PrintExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "print");
    ControlFlowGraph childGraph = super.visitPrintExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }

  @Override
  public ControlFlowGraph visitPostfixIncDecExpression(PhpParser.PostfixIncDecExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "postfixincdec");
    ControlFlowGraph childGraph = super.visitPostfixIncDecExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }

  @Override
  public ControlFlowGraph visitIncludeExpression(PhpParser.IncludeExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "include");
    ControlFlowGraph childGraph = super.visitIncludeExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }

  @Override
  public ControlFlowGraph visitCastExpression(PhpParser.CastExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "cast");
    ControlFlowGraph childGraph = super.visitCastExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }

  @Override
  public ControlFlowGraph visitInstanceOfExpression(PhpParser.InstanceOfExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "instanceof");
    ControlFlowGraph childGraph = super.visitInstanceOfExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }

  @Override
  public ControlFlowGraph visitLambdaFunctionExpression(PhpParser.LambdaFunctionExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "lambda");
    ControlFlowGraph childGraph = super.visitLambdaFunctionExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }

  @Override
  public ControlFlowGraph visitBitwiseExpression(PhpParser.BitwiseExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "bitwise");
    ControlFlowGraph childGraph = super.visitBitwiseExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }

  @Override
  public ControlFlowGraph visitCloneExpression(PhpParser.CloneExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "clone");
    ControlFlowGraph childGraph = super.visitCloneExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }

  @Override
  public ControlFlowGraph visitYieldExpression(PhpParser.YieldExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "yield");
    ControlFlowGraph childGraph = super.visitYieldExpression(ctx);
    graph.appendGraph(childGraph);
    return graph;
  }*/

  //  whileStatement
//  doWhileStatement
//  forStatement
//  switchStatement
//  breakStatement
//  continueStatement
//  returnStatement
//  yieldExpression ';'
//  globalStatement
//  staticVariableStatement
//  echoStatement
//  unsetStatement
//  foreachStatement
//  tryCatchFinally
//  throwStatement
//  gotoStatement
//  declareStatement
//  emptyStatement
//  inlineHtmlStatement

}
