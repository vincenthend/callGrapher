package model.graph.statement;

import java.util.ArrayList;
import java.util.List;

public class BranchStatement extends PhpStatement {
  private List<PhpStatement> conditionStatements;

  public BranchStatement(String code, List<PhpStatement> conditionStatements) {
    super(StatementType.BRANCH, code);
    this.conditionStatements = conditionStatements;
  }

  public BranchStatement(BranchStatement b){
    super(b);
    this.conditionStatements = new ArrayList<>();
    for(PhpStatement statement : b.conditionStatements){
      this.conditionStatements.add(statement.cloneObject());
    }
  }

  @Override
  public PhpStatement cloneObject() {
    return new BranchStatement(this);
  }

  public List<PhpStatement> getConditionStatements() {
    return conditionStatements;
  }

  public void setConditionStatements(List<PhpStatement> conditionStatements) {
    this.conditionStatements = conditionStatements;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
