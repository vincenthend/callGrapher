package model.graph.statement.fill;

import model.graph.statement.PhpStatement;
import model.graph.statement.StatementType;

public class ContinueStatement extends PhpStatement {
  public ContinueStatement() {
    super(StatementType.CONTINUE, "continue;");
  }

  public ContinueStatement(ContinueStatement c){
    super(c);
  }

  @Override
  public PhpStatement cloneObject() {
    return new ContinueStatement();
  }
}
