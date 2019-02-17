package model.statement;

import model.Function;

public class FunctionCallStatement extends PhpStatement {
  Function function;

  public FunctionCallStatement(Function function) {
    super(StatementType.FUNCTION_CALL, function.code);
  }
}
