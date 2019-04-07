package model.graph.block.statement;

public class BranchStatement extends PhpStatement {
  private BranchStatementType type;

  public BranchStatement(String code) {
    super(StatementType.BRANCH, code);
    type = BranchStatementType.BRANCH_START;
  }

  public BranchStatement(BranchStatementType branchType) {
    super(StatementType.BRANCH, "");
    this.type = branchType;
  }

  public BranchStatementType getType() {
    return type;
  }

  @Override
  public String toString() {
    return super.toString() + " " + type.toString();
  }

  public enum BranchStatementType {
    BRANCH_START,
    BRANCH_CONDITION,
    BRANCH_POINT,
    BRANCH_END,
  }
}
