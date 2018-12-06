package model;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.corba.se.impl.orbutil.graph.GraphImpl;

import java.util.HashSet;

public class Function {
  public String functionName;
  public String code;
  public String className;
  public HashSet<Function> connections;
  public Function caller;

  public Function(String functionName, String className, String code){
    this.functionName = functionName;
    this.className = className;
    this.code = code;
    connections = new HashSet<Function>();
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

}
