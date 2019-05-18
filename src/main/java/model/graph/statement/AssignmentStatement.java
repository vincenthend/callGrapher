package model.graph.statement;

public class AssignmentStatement extends PhpStatement {
  private String assignedVariable;
  private String assignedType;
  private boolean assignEach;

  public AssignmentStatement(String assignedVariable, String assignedType, String code) {
    super(StatementType.ASSIGNMENT, code);
    this.assignedVariable = assignedVariable;
    this.assignedType = assignedType;
    this.assignEach = false;
  }

  public AssignmentStatement(AssignmentStatement a){
    super(a);
    this.assignedVariable = a.assignedVariable;
    this.assignedType = a.assignedType;
    this.assignEach = a.assignEach;
  }

  @Override
  public AssignmentStatement cloneObject() {
    return new AssignmentStatement(this);
  }

  @Override
  public String toString() {
    return super.toString()+" "+assignedVariable+" = "+assignedType;
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

  public boolean isAssignEach() {
    return assignEach;
  }

  public void setAssignEach(boolean assignEach) {
    this.assignEach = assignEach;
  }
}
