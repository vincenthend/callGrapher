package model.graph.block.statement;

public class BranchStatement extends PhpStatement {
  public BranchStatement(String code) {
    super(StatementType.BRANCH, code);
  }

  @Override
  public String toString() {
    return "["+getStatementType().toString() + "]";
  }
}
