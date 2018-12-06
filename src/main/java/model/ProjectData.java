package model;

import model.Function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectData {
  public Map<String, Function> functionMap;
  public List<Function> functionList;

  public ProjectData() {
    functionMap = new HashMap<String, Function>();
    functionList = new ArrayList<Function>();
  }

  public void add(Function function){
//    if(functionMap.containsKey(function.functionName)){
//      functionMap.get(function.functionName).add(function);
//    } else {
//      functionList.add(function);
//      functionMap.put(function.getCalledName(), function);
//    }
    functionList.add(function);
    functionMap.put(function.getCalledName(), function);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    for(Function f : functionList){
      stringBuilder.append(f.getCalledName());
      stringBuilder.append(", ");
    }
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}
