package grammar;

import model.ControlFlowGraph;
import model.statement.BranchStatement;
import model.statement.GeneralStatement;
import model.statement.PhpStatement;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

import java.util.Set;

public class PhpMethodParserVisitor extends PhpParserBaseVisitor<ControlFlowGraph> {

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

  // ifStatement
  @Override
  public ControlFlowGraph visitIfStatement(PhpParser.IfStatementContext ctx) {
    System.out.println("ifStatement");
    ControlFlowGraph graph = new ControlFlowGraph();

    // Add branch root
    CharStream input = ctx.start.getInputStream();
    Interval interval = new Interval(ctx.parenthesis().start.getStartIndex(), ctx.parenthesis().stop.getStopIndex());
    String code = input.getText(interval);
    PhpStatement branchStatement = new BranchStatement(code);
    graph.addFirstStatement(branchStatement);

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
    if (ctx.elseIfStatement().size() != 0) {
      for (PhpParser.ElseIfStatementContext e : ctx.elseIfStatement()) {
        // Visit elseif's condition and append to previous conditions
        par_graph = visit(e.parenthesis().expression());
        graph.appendGraph(par_statements, par_graph);
        par_statements = par_graph.lastVertices;

        // Visit block and append to conditions
        stat_graph = visit(e.statement());
        graph.appendGraph(par_statements, stat_graph);
      }
    }
    if (ctx.elseStatement() != null) {
      stat_graph = visit(ctx.elseStatement().statement());
      graph.appendGraph(par_statements, stat_graph);
    } else {
      graph.lastVertices.addAll(if_par_statements);
    }
    return graph;
  }

  @Override
  public ControlFlowGraph visitForStatement(PhpParser.ForStatementContext ctx) {
    System.out.println("forStatement");
    return super.visitForStatement(ctx);
  }

  @Override
  public ControlFlowGraph visitForeachStatement(PhpParser.ForeachStatementContext ctx) {
    super.visitForeachStatement(ctx);
    System.out.println("elseStatement");
    return super.visitForeachStatement(ctx);
  }

  public ControlFlowGraph visitExpression(ParserRuleContext ctx){
    ControlFlowGraph graph = new ControlFlowGraph();
    CharStream input = ctx.start.getInputStream();
    Interval interval = new Interval(ctx.start.getStartIndex(), ctx.stop.getStopIndex());
    String code = input.getText(interval);
    graph.addFirstStatement(new GeneralStatement(code));
    return graph;
  }


  /* Handle Expressions */

  @Override
  public ControlFlowGraph visitChainExpression(PhpParser.ChainExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx);
    return graph;
  }

  @Override
  public ControlFlowGraph visitComparisonExpression(PhpParser.ComparisonExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx);
    return graph;
  }

  @Override
  public ControlFlowGraph visitAssignmentExpression(PhpParser.AssignmentExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx);
    return graph;
  }

  @Override
  public ControlFlowGraph visitScalarExpression(PhpParser.ScalarExpressionContext ctx) {
    ControlFlowGraph graph = visitExpression(ctx);
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
