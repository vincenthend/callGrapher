package model.statement;

public class ContinueStatement extends PhpStatement {
  public ContinueStatement() {
    super(StatementType.CONTINUE, "continue;");
  }
}
