package model.graph.statement.special;

import model.graph.statement.ExpressionStatement;

public class IncludeStatement extends SpecialStatement {

  public IncludeStatement(ExpressionStatement e) {
    super(e.getStatementContent());
    this.originalStatement = e;
  }

  public IncludeStatement(IncludeStatement e) {
    super(e);
    this.originalStatement = e.originalStatement;
  }

  @Override
  public IncludeStatement cloneObject() {
    return new IncludeStatement(this);
  }

  @Override
  public String toString() {
    return "[INCLUDE]";
  }
}