package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhpClass implements Comparable<PhpClass> {
  private String className;
  private Map<String, PhpFunction> functionMap;
  private Map<String, List<String>> attributeMap;

  public PhpClass(String className) {
    this.className = className;
    this.functionMap = new HashMap<>();
    this.attributeMap = new HashMap<>();
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public Map<String, PhpFunction> getFunctionMap() {
    return functionMap;
  }

  public void setFunctionMap(Map<String, PhpFunction> functionMap) {
    this.functionMap = functionMap;
  }

  public Map<String, List<String>> getAttributeMap() {
    return attributeMap;
  }

  public void setAttributeMap(Map<String, List<String>> attributeMap) {
    this.attributeMap = attributeMap;
  }

  @Override
  public int compareTo(PhpClass o) {
    if(className.equals(o.className)){
      return 0;
    } else {
      return 1;
    }
  }
}
