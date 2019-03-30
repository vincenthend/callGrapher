package model.statement;

public class BreakStatement extends PhpStatement {
  public BreakStatement() {
    super(StatementType.BREAK, "break;");
  }
}
