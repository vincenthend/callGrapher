package model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * PhpClass PhpFunction, contains data about a function
 */
public class PhpFunction implements Comparable<PhpFunction>, Cloneable{
  private String functionName;
  private String code;
  private String className;
  private Map<String, String> parameters;
  private ControlFlowGraph controlFlowGraph;


  public PhpFunction(String functionName, String className, String code, Map<String, String> parameters){
    this.functionName = functionName;
    this.className = className;
    this.code = code;
    this.parameters = parameters;
  }

  public String getCode() {
    return code;
  }

  public String getClassName() {
    return className;
  }

  public ControlFlowGraph getControlFlowGraph() {
    return controlFlowGraph;
  }

  public String getFunctionName(){
    return functionName;
  }

  public Map<String, String> getParameters() {
    return parameters;
  }

  public String getCalledName(){
    StringBuilder sb = new StringBuilder();
    if(className != null) {
      sb.append(className);
      sb.append("::");
    }
    sb.append(functionName);
    return sb.toString();
  }

  public void setControlFlowGraph(ControlFlowGraph controlFlowGraph) {
    this.controlFlowGraph = controlFlowGraph;
  }

  @Override
  public int compareTo(PhpFunction o) {
    if(functionName.equals(o.functionName) && className.equals(o.className)){
      return 0;
    } else {
      return 1;
    }
  }

  @Override
  public String toString() {
    return getCalledName();
  }

  @Override
  public PhpFunction clone() throws CloneNotSupportedException {
    PhpFunction cloned = new PhpFunction(functionName, className, code, parameters);
    cloned.controlFlowGraph = controlFlowGraph.clone();
    return cloned;
  }
}
