package model.graph.statement;

public class BreakStatement extends PhpStatement {
  public BreakStatement() {
    super(StatementType.BREAK, "break;");
  }

  public BreakStatement(BreakStatement b){
    super(b);
  }

  @Override
  public PhpStatement cloneObject() {
    return new BreakStatement(this);
  }
}
