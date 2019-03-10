package model.statement;

import model.PhpFunction;

public class FunctionCallStatement extends PhpStatement {
  PhpFunction function;

  public FunctionCallStatement(PhpFunction function) {
    super(StatementType.FUNCTION_CALL, function.getCode());
    this.function = function;
  }

  public PhpFunction getFunction() {
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
