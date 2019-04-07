package model.graph.block.statement;

public class ContinueStatement extends PhpStatement {
  public ContinueStatement() {
    super(StatementType.CONTINUE, "continue;");
  }
}
