package model.graph.statement;

import predictor.type.PredictedFunctionType;
import predictor.type.PredictedVariableContent;
import model.php.PhpFunction;
import predictor.PhpFunctionPredictor;
import predictor.PhpVariablePredictor;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FunctionCallStatement extends PhpStatement {
  private PhpFunction function;
  private String callerVariable;
  private List<String> parameterList;
  private PredictedFunctionType functionType;
  private Set<PredictedVariableContent> variableContent;

  public FunctionCallStatement(PhpFunction function, List<String> parameterList, String callerVariable, String code) {
    super(StatementType.FUNCTION_CALL, code);
    this.function = function;
    this.parameterList = new LinkedList<>();
    this.parameterList.addAll(parameterList);
    this.callerVariable = callerVariable;
    this.functionType = PhpFunctionPredictor.predictFunctionType(function);
    this.variableContent = new HashSet<>(PhpVariablePredictor.predictVariableContent(parameterList));
  }

  public FunctionCallStatement(FunctionCallStatement f){
    super(f);
    this.function = f.function;
    this.parameterList = new LinkedList<>();
    this.parameterList.addAll(f.parameterList);
    this.callerVariable = f.callerVariable;
    this.functionType = f.functionType;
    this.variableContent = f.variableContent;
  }

  @Override
  public PhpStatement cloneObject() {
    return new FunctionCallStatement(this);
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

  public PredictedFunctionType getFunctionType() {
    return functionType;
  }

  public Set<PredictedVariableContent> getVariableContent() {
    return variableContent;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    if(functionType == PredictedFunctionType.BUILT_IN){
      sb.append(function.getCalledName());
    } else {
      sb.append(functionType);
    }

    if(!variableContent.isEmpty()){
      sb.append(variableContent);
    }
    return sb.toString();
  }
}
