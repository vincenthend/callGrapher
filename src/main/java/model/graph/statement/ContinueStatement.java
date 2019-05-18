package model.graph.statement;

public class ContinueStatement extends PhpStatement {
  public ContinueStatement() {
    super(StatementType.CONTINUE, "continue;");
  }

  public ContinueStatement(ContinueStatement c){
    super(c);
  }

  @Override
  public PhpStatement cloneObject() {
    return new ContinueStatement();
  }
}
