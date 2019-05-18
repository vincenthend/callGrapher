package model.graph.statement;

public class ReturnStatement extends PhpStatement {
  private String returnedVar;
  public ReturnStatement(String returnedVar) {
    super(StatementType.RETURN, returnedVar);
    this.returnedVar = returnedVar;
  }

  public ReturnStatement(ReturnStatement r){
    super(r);
    this.returnedVar = r.returnedVar;
  }

  public String getReturnedVar() {
    return returnedVar;
  }

  @Override
  public PhpStatement cloneObject() {
    return new ReturnStatement(this);
  }

  @Override
  public String toString() {
    return super.toString()+" "+returnedVar;
  }
}
