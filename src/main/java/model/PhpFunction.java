package model;

/**
 * PhpClass PhpFunction, contains data about a function
 */
public class PhpFunction implements Comparable<PhpFunction>{
  private String functionName;
  private String code;
  private String className;
  private ControlFlowGraph controlFlowGraph;
  public String returnedType;


  public PhpFunction(String functionName, String className, String code){
    this.functionName = functionName;
    this.className = className;
    this.code = code;
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
}
