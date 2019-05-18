package model.graph.statement;

public class ExpressionStatement extends PhpStatement {
  private String expressionType;
  public ExpressionStatement(String expressionType, String code) {
    super(StatementType.EXPRESSION, code);
    this.expressionType = expressionType;
  }

  public ExpressionStatement(ExpressionStatement e){
    super(e);
    this.expressionType = e.expressionType;
  }

  @Override
  public PhpStatement cloneObject() {
    return new ExpressionStatement(this.expressionType, this.statementContent);
  }

  @Override
  public String toString() {
    return super.toString()+" "+getStatementContent()+" ["+expressionType+"]";
  }
}
