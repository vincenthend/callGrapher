package model.statement;

public class BranchStatement extends PhpStatement {
  public BranchStatement(String code) {
    super(StatementType.BRANCH, code);
  }
}
