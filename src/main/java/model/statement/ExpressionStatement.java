package model.statement;

public class ExpressionStatement extends PhpStatement {
  private String expressionType;
  public ExpressionStatement(String expressionType, String code) {
    super(StatementType.EXPRESSION, code);
    this.expressionType = expressionType;
  }

  @Override
  public String toString() {
    return super.toString()+" "+getStatementContent()+" ["+expressionType+"]";
  }

  @Override
  public ExpressionStatement clone() throws CloneNotSupportedException {
    ExpressionStatement statement = (ExpressionStatement) super.clone();
    statement.expressionType = this.expressionType;
    return statement;
  }
}
