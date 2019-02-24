package model.statement;

import model.Function;

public class FunctionCallStatement extends PhpStatement {
  Function function;

  public FunctionCallStatement(Function function) {
    super(StatementType.FUNCTION_CALL, function.code);
    this.function = function;
  }

  public Function getFunction() {
    return function;
  }

  @Override
  public String toString() {
    return "[" + getStatementType() + "] " + function.getCalledName();
  }

  @Override
  public FunctionCallStatement clone() throws CloneNotSupportedException {
    FunctionCallStatement statement = (FunctionCallStatement) super.clone();
    statement.function = function;
    return statement;
  }
}
