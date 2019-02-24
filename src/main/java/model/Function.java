package model;

public class Function implements Comparable<Function>{
  private String functionName;
  public String code;
  public String className;
  public ControlFlowGraph graph;


  public Function(String functionName, String className, String code){
    this.functionName = functionName;
    this.className = className;
    this.code = code;
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

  @Override
  public int compareTo(Function o) {
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
