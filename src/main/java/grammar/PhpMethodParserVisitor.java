package grammar;

import logger.Logger;
import model.ControlFlowGraph;
import model.PhpClass;
import model.PhpFunction;
import model.ProjectData;
import model.statement.BranchStatement;
import model.statement.ExpressionStatement;
import model.statement.FunctionCallStatement;
import model.statement.PhpStatement;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

import java.util.*;

public class PhpMethodParserVisitor extends PhpParserBaseVisitor<ControlFlowGraph> {
  public ProjectData projectData;
  public Map<String, String> variableMap;
  public PhpClass currentClass;

  public PhpMethodParserVisitor(ProjectData p, PhpClass currentClass) {
    super();
    this.projectData = p;
    this.currentClass = currentClass;
    variableMap = new HashMap<>();
  }

  @Override
  protected ControlFlowGraph defaultResult() {
    return new ControlFlowGraph();
  }

  @Override
  protected ControlFlowGraph aggregateResult(ControlFlowGraph aggregate, ControlFlowGraph nextResult) {
    ControlFlowGraph graph;
    if(aggregate != null && nextResult != null){
      aggregate.appendGraph(nextResult);
      graph = aggregate;
    } else if(aggregate == null){
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
    PhpStatement branchStatement = new BranchStatement(code);
    graph.addStatement(branchStatement);

    ControlFlowGraph par_graph;
    ControlFlowGraph stat_graph;
    Set<PhpStatement> par_statements;

    // Visit conditions and append to branch
    par_graph = visit(ctx.parenthesis().expression());
    par_statements = par_graph.lastVertices;
    graph.appendGraph(branchStatement, par_graph);
    Set<PhpStatement> if_par_statements = par_statements;

    // Visit block and append to conditions
    stat_graph = visit(ctx.statement());
    graph.appendGraph(par_statements, stat_graph);

    // Add root vertex
    if(ctx.elseIfStatement().size() != 0){
      for(PhpParser.ElseIfStatementContext e : ctx.elseIfStatement()) {
        // Visit elseif's condition and append to previous conditions
        par_graph = visit(e.parenthesis().expression());
        graph.appendGraph(par_statements, par_graph);
        par_statements = par_graph.lastVertices;

        // Visit block and append to conditions
        stat_graph = visit(e.statement());
        graph.appendGraph(par_statements, stat_graph);
      }
    } else if(ctx.elseIfColonStatement().size() != 0){
      for(PhpParser.ElseIfColonStatementContext e : ctx.elseIfColonStatement()) {
        // Visit elseif's condition and append to previous conditions
        par_graph = visit(e.parenthesis().expression());
        graph.appendGraph(par_statements, par_graph);
        par_statements = par_graph.lastVertices;

        // Visit block and append to conditions
        stat_graph = visit(e.innerStatementList());
        graph.appendGraph(par_statements, stat_graph);
      }
    }

    if(ctx.elseStatement() != null){
      stat_graph = visit(ctx.elseStatement().statement());
      graph.appendGraph(par_statements, stat_graph);
    } else if(ctx.elseColonStatement() != null){
      stat_graph = visit(ctx.elseStatement().statement());
      graph.appendGraph(par_statements, stat_graph);
    } else {
      graph.lastVertices.addAll(if_par_statements);
    }

    return graph;
  }

  @Override
  public ControlFlowGraph visitForStatement(PhpParser.ForStatementContext ctx) {
    ControlFlowGraph init = visit(ctx.forInit());
    ControlFlowGraph expression = visit(ctx.expressionList());
    ControlFlowGraph update = visit(ctx.forUpdate());

    ControlFlowGraph statement;
    if(ctx.statement() != null){
      statement = visit(ctx.statement());
    } else {
      statement = visit(ctx.innerStatementList());
    }

    init.appendGraph(expression);
    init.appendGraph(statement);
    init.appendGraph(update);

    for(PhpStatement p : update.lastVertices) {
      init.addStatement(p, init.firstVertex);
    }
    init.lastVertices.removeAll(statement.lastVertices);
    init.lastVertices.addAll(update.lastVertices);
    return init;
  }

  @Override
  public ControlFlowGraph visitForeachStatement(PhpParser.ForeachStatementContext ctx) {
    super.visitForeachStatement(ctx);
    return super.visitForeachStatement(ctx);
  }

  @Override
  public ControlFlowGraph visitWhileStatement(PhpParser.WhileStatementContext ctx) {
    ControlFlowGraph init = visit(ctx.parenthesis());
    ControlFlowGraph statement;
    Set<PhpStatement> initStatement = new HashSet<>();
    initStatement.addAll(init.lastVertices);
    if(ctx.statement() != null){
      statement = visit(ctx.statement());
    } else {
      statement = visit(ctx.innerStatementList());
    }

    init.appendGraph(statement);
    for(PhpStatement p : init.lastVertices) {
      init.addStatement(p, init.firstVertex);
    }

    init.lastVertices.removeAll(statement.lastVertices);
    init.lastVertices.addAll(initStatement);
    return init;
  }

  @Override
  public ControlFlowGraph visitDoWhileStatement(PhpParser.DoWhileStatementContext ctx) {
    ControlFlowGraph init = visit(ctx.parenthesis());
    ControlFlowGraph statement = visit(ctx.statement());

    statement.appendGraph(init);
    for(PhpStatement p : init.lastVertices) {
      statement.addStatement(p, statement.firstVertex);
    }
    return statement;
  }

  @Override
  public ControlFlowGraph visitFunctionCall(PhpParser.FunctionCallContext ctx) {
    ControlFlowGraph graph = new ControlFlowGraph();
    CharStream input = ctx.start.getInputStream();
    Interval interval = new Interval(ctx.functionCallName().start.getStartIndex(), ctx.functionCallName().stop.getStopIndex());
    String name = input.getText(interval);

    graph.addStatement(new FunctionCallStatement(new PhpFunction(name, null, "")));
    return graph;
  }

  @Override
  public ControlFlowGraph visitMemberAccess(PhpParser.MemberAccessContext ctx) {
    ControlFlowGraph graph = new ControlFlowGraph();
    if(ctx.actualArguments() != null) { // Method access by member
      PhpParser.ChainContext chain_ctx = (PhpParser.ChainContext) ctx.getParent();
      String var_name = chain_ctx.chainBase().getText();
      String caller_class;
      if (var_name.equals("$this")) {
        caller_class = this.currentClass.getClassName();
      } else if(currentClass.getAttributeMap().containsKey(var_name)){
        caller_class = currentClass.getAttributeMap().get(var_name).get(0);
      } else {
        caller_class = variableMap.get(var_name);
      }

      if(chain_ctx.memberAccess().size() != 1){
        // Find chain type
        List<PhpParser.MemberAccessContext> memberList = chain_ctx.memberAccess();
        int i = 0;
        boolean stop = false;
        while(memberList.get(i) != ctx && !stop){
          PhpClass phpClass = projectData.getClass(caller_class);
          if(phpClass != null){
            //TODO : Fix Here, what if it hasn't been parsed
            List<String> attrMap = phpClass.getAttributeMap().get("$"+memberList.get(i).keyedFieldName().getText());
            if(attrMap != null && attrMap.size() != 0) {
              caller_class = attrMap.get(0);
            } else {
              caller_class = "";
              stop = true;
            }
            i++;
          } else {
            caller_class = "";
            stop = true;
          }
        }
      }

      // Get function graph
      PhpFunction temp_func = new PhpFunction(ctx.keyedFieldName().getText(), caller_class, "");
      PhpFunction phpFunction = projectData.getFunction(temp_func.getCalledName());
      if (phpFunction != null) {
        graph.addStatement(new FunctionCallStatement(phpFunction));
      } else {
        graph.addStatement(new FunctionCallStatement(temp_func));
      }
    } else { // Variable access by member
      graph = visitExpression(ctx, "member");
    }
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
    if(ctx.chain().chainBase() != null && ctx.chain().memberAccess().size() == 0){
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

    PhpFunction temp_func = new PhpFunction("__construct", name, "");
    PhpFunction phpFunction = projectData.getFunction(temp_func.getCalledName());
    if (phpFunction == null) {
      graph.addStatement(new FunctionCallStatement(temp_func));
    }
    return graph;
  }

  @Override
  public ControlFlowGraph visitComparisonExpression(PhpParser.ComparisonExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "comparison");
    ControlFlowGraph childGraph = super.visitComparisonExpression(ctx);
    childGraph.appendGraph(graph);
    return childGraph;
  }

  @Override
  public ControlFlowGraph visitAssignmentExpression(PhpParser.AssignmentExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx, "assignment");
    ControlFlowGraph childGraph = super.visitAssignmentExpression(ctx);
    childGraph.appendGraph(graph);

    String variableName = ctx.chain(0).getText();
    String assignedType = new PhpAssignedTypeVisitor(projectData).visit(ctx.expression());
    PhpClass c = currentClass;
    //TODO : Fix if attribute is chaining
    if(c.getAttributeMap().containsKey(variableName)){
      c.getAttributeMap().get(variableName).add(assignedType);
    } else {
      variableMap.put(variableName, assignedType);
    }
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
  }

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

  @Override
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
  }

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
