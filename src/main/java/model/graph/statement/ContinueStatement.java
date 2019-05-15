package model.graph.statement;

public class ContinueStatement extends PhpStatement {
  public ContinueStatement() {
    super(StatementType.CONTINUE, "continue;");
  }
}
