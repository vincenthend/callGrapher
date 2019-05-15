package model.graph.statement;

public class BreakStatement extends PhpStatement {
  public BreakStatement() {
    super(StatementType.BREAK, "break;");
  }
}
