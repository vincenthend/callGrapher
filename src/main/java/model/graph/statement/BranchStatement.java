package model.graph.statement;

public class BranchStatement extends PhpStatement {

  public BranchStatement(String code) {
    super(StatementType.BRANCH, code);
  }

  public BranchStatement(BranchStatement b){
    super(b);
  }

  @Override
  public PhpStatement cloneObject() {
    return new BranchStatement(this);
  }

  @Override
  public String toString() {
    return super.toString() + " " + statementContent;
  }
}
