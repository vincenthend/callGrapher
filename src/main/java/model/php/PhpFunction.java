package model.php;

import model.graph.ControlFlowGraph;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * PhpClass PhpFunction, contains data about a function
 */
public class PhpFunction implements Comparable<PhpFunction>, Serializable{
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

  public PhpFunction(PhpFunction f){
    this.functionName = f.functionName;
    this.className = f.className;
    this.code = f.code;
    if(f.parameters != null) {
      this.parameters = new HashMap<>();
      for (Map.Entry<String, String> param : f.parameters.entrySet()) {
        this.parameters.put(param.getKey(), param.getValue());
      }
    }
    this.controlFlowGraph = f.controlFlowGraph.cloneObject();
  }

  public PhpFunction cloneObject(){
    return new PhpFunction(this);
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
    if(className == null || o.className == null){
      if(functionName.equals(o.functionName) && className == o.className){
        return 0;
      } else {
        return 1;
      }
    } else {
      if(functionName.equals(o.functionName) && className.equals(o.className)){
        return 0;
      } else {
        return 1;
      }
    }
  }

  @Override
  public String toString() {
    return getCalledName();
  }
}
