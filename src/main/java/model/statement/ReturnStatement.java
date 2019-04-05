package model.statement;

public class ReturnStatement extends PhpStatement {
  private String returnedVar;
  public ReturnStatement(String returnedVar) {
    super(StatementType.RETURN, returnedVar);
    this.returnedVar = returnedVar;
  }

  public String getReturnedVar() {
    return returnedVar;
  }

  @Override
  public ReturnStatement clone() throws CloneNotSupportedException {
    ReturnStatement statement = (ReturnStatement) super.clone();
    statement.returnedVar = this.returnedVar;
    return statement;
  }
}
