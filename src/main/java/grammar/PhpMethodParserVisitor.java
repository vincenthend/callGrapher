package grammar;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import model.ProjectData;
import model.graph.ControlFlowEdge;
import model.graph.ControlFlowGraph;
import model.graph.block.statement.AssignmentStatement;
import model.graph.block.statement.BranchStatement;
import model.graph.block.statement.BreakStatement;
import model.graph.block.statement.ContinueStatement;
import model.graph.block.statement.ExpressionStatement;
import model.graph.block.statement.FunctionCallStatement;
import model.graph.block.statement.PhpStatement;
import model.graph.block.statement.ReturnStatement;
import model.graph.block.statement.StatementType;
import model.php.PhpClass;
import model.php.PhpFunction;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.jgrapht.Graphs;
import org.jgrapht.traverse.DepthFirstIterator;

public class PhpMethodParserVisitor extends PhpParserBaseVisitor<ControlFlowGraph> {
  private ProjectData projectData;
  private PhpClass currentClass;

  public PhpMethodParserVisitor(ProjectData p, PhpClass currentClass) {
    super();
    this.projectData = p;
    this.currentClass = currentClass;
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
    graph.addStatement(new BranchStatement(code));

    ControlFlowGraph par_graph;
    ControlFlowGraph stat_graph;

    // Visit conditions and append branch conditions
    par_graph = visit(ctx.parenthesis().expression());
    graph.appendGraph(par_graph);

    PhpStatement branch_point = graph.getLastVertices().iterator().next();
//    PhpStatement branch_point = new BranchStatement(BranchStatement.BranchStatementType.BRANCH_POINT);
//    graph.addStatement(branch_point);

    // Visit statement block and append to conditions
    stat_graph = visit(ctx.statement());
    graph.appendGraph(stat_graph, ControlFlowEdge.ControlFlowEdgeType.BRANCH);

    //TODO Refactor this

    // Add root vertex
    if (ctx.elseIfStatement().size() != 0) {
      for (PhpParser.ElseIfStatementContext e : ctx.elseIfStatement()) {
        // Visit elseif's condition and append to previous conditions
        par_graph = new ControlFlowGraph();
        par_graph.appendGraph(visit(e.parenthesis().expression()));
//        par_graph.addStatement(new BranchStatement(BranchStatement.BranchStatementType.BRANCH_POINT));

        // Visit block and append to conditions
        stat_graph = visit(e.statement());
        par_graph.appendGraph(stat_graph, ControlFlowEdge.ControlFlowEdgeType.BRANCH);

        graph.appendGraph(branch_point, par_graph);
      }
    } else if (ctx.elseIfColonStatement().size() != 0) {
      for (PhpParser.ElseIfColonStatementContext e : ctx.elseIfColonStatement()) {
        // Visit elseif's condition and append to previous conditions
        par_graph = new ControlFlowGraph();
//        par_graph.addStatement(new BranchStatement(BranchStatement.BranchStatementType.BRANCH_CONDITION));
        par_graph.appendGraph(visit(e.parenthesis().expression()));
//        par_graph.addStatement(new BranchStatement(BranchStatement.BranchStatementType.BRANCH_POINT));

        // Visit block and append to conditions
        stat_graph = visit(e.innerStatementList());
        par_graph.appendGraph(stat_graph, ControlFlowEdge.ControlFlowEdgeType.BRANCH);

        graph.appendGraph(branch_point, par_graph);
      }
    }

    if (ctx.elseStatement() != null) {
      stat_graph = visit(ctx.elseStatement().statement());
      graph.appendGraph(branch_point, stat_graph, ControlFlowEdge.ControlFlowEdgeType.BRANCH);
    } else if (ctx.elseColonStatement() != null) {
      stat_graph = visit(ctx.elseStatement().statement());
      graph.appendGraph(branch_point, stat_graph, ControlFlowEdge.ControlFlowEdgeType.BRANCH);
    }

//    graph.addStatement(new BranchStatement(BranchStatement.BranchStatementType.BRANCH_END));
    if(ctx.elseStatement() == null && ctx.elseColonStatement() == null){
      graph.getLastVertices().add(branch_point);
    }
    return graph;
  }

  @Override
  public ControlFlowGraph visitForStatement(PhpParser.ForStatementContext ctx) {
    ControlFlowGraph init = visit(ctx.forInit());
    ControlFlowGraph expression = visit(ctx.expressionList());
    ControlFlowGraph update = visit(ctx.forUpdate());

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
      init.addStatement(p, init.getFirstVertex(), ControlFlowEdge.ControlFlowEdgeType.LOOP);
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
      key = ctx.chain(ctx.chain().size()-1).getText();
      value = ctx.chain(ctx.chain().size()-2).getText();
    } else {
      value = ctx.chain(ctx.chain().size()-1).getText();
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
      cfg.addStatement(p, cfg.getFirstVertex(), ControlFlowEdge.ControlFlowEdgeType.LOOP);
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
      init.addStatement(p, init.getFirstVertex(), ControlFlowEdge.ControlFlowEdgeType.LOOP);
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
      statement.addStatement(p, statement.getFirstVertex(), ControlFlowEdge.ControlFlowEdgeType.LOOP);
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
    DepthFirstIterator<PhpStatement, ControlFlowEdge> iterator = new DepthFirstIterator<PhpStatement, ControlFlowEdge>(loopGraph.getGraph());
    List<PhpStatement> removeList = new LinkedList<>();
    while (iterator.hasNext()) {
      PhpStatement statement = iterator.next();
      if (statement.getStatementType() == StatementType.BREAK) {
        // Add statement to removeList
        List<PhpStatement> predStatements = Graphs.predecessorListOf(loopGraph.getGraph(), statement);
        removeList.add(statement);
        // Add all predecessor as last vertices
        loopGraph.getLastVertices().addAll(predStatements);
      } else if (statement.getStatementType() == StatementType.CONTINUE){
        // Remove break statement edges
        List<PhpStatement> predStatements = Graphs.predecessorListOf(loopGraph.getGraph(), statement);
        removeList.add(statement);
        for (PhpStatement pred: predStatements) {
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
    if(ctx.expression() != null){
      returnStatement = new ReturnStatement(ctx.expression().getText());
    } else {
      returnStatement = new ReturnStatement("");
    }
    ControlFlowGraph childGraph = super.visitReturnStatement(ctx);
    childGraph.addStatement(returnStatement);
    return childGraph;
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

    graph.addStatement(new FunctionCallStatement(new PhpFunction(name, null, "", null), args, null));
    return graph;
  }

  @Override
  public ControlFlowGraph visitMemberAccess(PhpParser.MemberAccessContext ctx) {
    ControlFlowGraph graph = new ControlFlowGraph();
    if (ctx.actualArguments() != null) { // Method access by member
      PhpParser.ChainContext parent_ctx = (PhpParser.ChainContext) ctx.getParent();
      String var_name;
      if (parent_ctx.chainBase() != null) {
        var_name = parent_ctx.chainBase().getText();
      } else if (parent_ctx.functionCall() != null) {
        var_name = parent_ctx.functionCall().functionCallName().getText();
      } else if (parent_ctx.newExpr() != null) {
        var_name = parent_ctx.newExpr().typeRef().getText();
      } else {
        var_name = parent_ctx.getText();
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
      PhpFunction temp_func = new PhpFunction(ctx.keyedFieldName().getText(), null, "", null);
      graph.addStatement(new FunctionCallStatement(temp_func, args, var_name));
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
    if(memberSize != 0){
      hasArgs = ctx.chain().memberAccess(memberSize-1).actualArguments() != null;
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
    if(ctx.arguments() != null){
      List<PhpParser.ActualArgumentContext> argsCtx = ctx.arguments().actualArgument();
      for(PhpParser.ActualArgumentContext argCtx : argsCtx) {
        args.add(argCtx.getText());
        ControlFlowGraph argCfg = visit(argCtx);
        graph.appendGraph(argCfg);
      }
    }

    PhpFunction temp_func = new PhpFunction("__construct", name, "", null);
    graph.addStatement(new FunctionCallStatement(temp_func, args, null));
    return graph;
  }

  @Override
  public ControlFlowGraph visitAssignmentExpression(PhpParser.AssignmentExpressionContext ctx) {
    ParserRuleContext assigneeContext = null;
    if(ctx.expression() != null){
      assigneeContext = ctx.expression();
    } else if (ctx.chain().size() > 1){
      assigneeContext = ctx.chain(1);
    } else if (ctx.newExpr() != null){
      assigneeContext = ctx.newExpr();
    }
    String assignedType = new PhpAssignedTypeVisitor(projectData).visit(assigneeContext);

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
