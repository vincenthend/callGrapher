package grammar;

import model.ControlFlowGraph;

public class PhpMethodParserVisitor extends PhpParserBaseVisitor<ControlFlowGraph> {

  @Override
  public ControlFlowGraph visitHtmlDocument(PhpParser.HtmlDocumentContext ctx) {
    ControlFlowGraph graph = new ControlFlowGraph();
    for (PhpParser.HtmlElementOrPhpBlockContext block : ctx.htmlElementOrPhpBlock()) {
      if (block.phpBlock() != null) {
        graph = visit(block.phpBlock()); //TODO: Append instead of assign
      }
    }
    return graph;
  }

  @Override
  public ControlFlowGraph visitPhpBlock(PhpParser.PhpBlockContext ctx) {
    ControlFlowGraph graph = new ControlFlowGraph();
    for (PhpParser.TopStatementContext block : ctx.topStatement()) {
      if (block.statement() != null) {
        graph = visit(block.statement()); //TODO: Append instead of assign
      }
    }
    return graph;
  }

  @Override
  public ControlFlowGraph visitStatement(PhpParser.StatementContext ctx) {
    ControlFlowGraph graph = new ControlFlowGraph();

    if (ctx.ifStatement() != null) {
      // If statement
      graph = visit(ctx.ifStatement());
    } else if (ctx.blockStatement() != null) {

    } else if (ctx.whileStatement() != null) {

    } else if (ctx.doWhileStatement() != null) {

    } else if (ctx.forStatement() != null) {

    } else if (ctx.switchStatement() != null) {

    } else if (ctx.breakStatement() != null) {

    } else if (ctx.continueStatement() != null) {

    } else if (ctx.returnStatement() != null) {

    } else if (ctx.yieldExpression() != null) {

    } else if (ctx.globalStatement() != null) {

    } else if (ctx.staticVariableStatement() != null) {

    } else if (ctx.echoStatement() != null) {

    } else if (ctx.expressionStatement() != null) {

    } else if (ctx.unsetStatement() != null) {

    } else if (ctx.foreachStatement() != null) {

    } else if (ctx.foreachStatement() != null) {

    } else if (ctx.foreachStatement() != null) {

    } else if (ctx.foreachStatement() != null) {

    } else if (ctx.foreachStatement() != null) {

    } else {
      // handle general statement

    }
    return graph;
  }

  // ifStatement
  @Override
  public ControlFlowGraph visitIfStatement(PhpParser.IfStatementContext ctx) {
    ControlFlowGraph graph = new ControlFlowGraph();
    // Add root vertex
    graph = visit(ctx.statement());

    if (ctx.elseIfStatement().size() != 0) {
      //process each else if statement
    }
    if (ctx.elseStatement() != null) {
      graph = visit(ctx.elseStatement());
    } else {
      // Add direct link to end
    }

    return graph;
  }

  @Override
  public ControlFlowGraph visitForStatement(PhpParser.ForStatementContext ctx) {
    return super.visitForStatement(ctx);
  }

  @Override
  public ControlFlowGraph visitForeachStatement(PhpParser.ForeachStatementContext ctx) {
    return super.visitForeachStatement(ctx);
  }

  // expressionStatement
  @Override
  public ControlFlowGraph visitExpressionStatement(PhpParser.ExpressionStatementContext ctx) {
    return super.visitExpressionStatement(ctx);
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
