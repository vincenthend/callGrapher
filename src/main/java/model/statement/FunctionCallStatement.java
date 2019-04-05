package model.statement;

import model.PhpFunction;

import java.util.LinkedList;
import java.util.List;

public class FunctionCallStatement extends PhpStatement {
  private PhpFunction function;
  private String callerVariable;
  private List<String> parameterList;

  public FunctionCallStatement(PhpFunction function, List<String> parameterList, String callerVariable) {
    super(StatementType.FUNCTION_CALL, function.getCode());
    this.function = function;
    this.parameterList = new LinkedList<>();
    this.parameterList.addAll(parameterList);
    this.callerVariable = callerVariable;
  }

  public PhpFunction getFunction() {
    return function;
  }

  public String getCallerVariable() {
    return callerVariable;
  }

  public List<String> getParameterMap() {
    return parameterList;
  }

  @Override
  public String toString() {
    return super.toString() + " " + function.getCalledName();
  }

  @Override
  public FunctionCallStatement clone() throws CloneNotSupportedException {
    FunctionCallStatement statement = (FunctionCallStatement) super.clone();
    statement.function = function;
    return statement;
  }
}
