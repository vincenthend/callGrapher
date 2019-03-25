package model.statement;

public class AssignmentStatement extends PhpStatement {
  private String assignedVariable;
  private String assignedType;

  public AssignmentStatement(String assignedVariable, String assignedType, String code) {
    super(StatementType.ASSIGNMENT, code);
    this.assignedVariable = assignedVariable;
    this.assignedType = assignedType;
  }

  @Override
  public String toString() {
    return super.toString()+" [assignment]";
  }

  @Override
  public AssignmentStatement clone() throws CloneNotSupportedException {
    AssignmentStatement statement = (AssignmentStatement) super.clone();
    statement.assignedType = this.assignedType;
    statement.assignedVariable = this.assignedVariable;
    return statement;
  }

  public String getAssignedVariable() {
    return assignedVariable;
  }

  public void setAssignedVariable(String assignedVariable) {
    this.assignedVariable = assignedVariable;
  }

  public String getAssignedType() {
    return assignedType;
  }

  public void setAssignedType(String assignedType) {
    this.assignedType = assignedType;
  }
}
