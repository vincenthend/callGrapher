package model.statement;

public class ExpressionStatement extends PhpStatement {
  private String expressionType;
  public ExpressionStatement(String expressionType, String code) {
    super(StatementType.EXPRESSION, code);
    this.expressionType = expressionType;
  }

  @Override
  public String toString() {
    return super.toString()+" ["+expressionType+"]";
  }
}
