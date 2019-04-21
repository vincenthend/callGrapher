package model.php;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhpClass implements Comparable<PhpClass> {
  private String className;
  private Map<String, PhpFunction> functionMap;
  private Map<String, Set<String>> attributeMap;
  private boolean constructorNorm;

  public PhpClass(String className) {
    this.className = className;
    this.functionMap = new HashMap<>();
    this.attributeMap = new HashMap<>();
    constructorNorm = false;
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

  public Map<String, Set<String>> getAttributeMap() {
    return attributeMap;
  }

  public void setAttributeMap(Map<String, Set<String>> attributeMap) {
    this.attributeMap = attributeMap;
  }

  public boolean isConstructorNorm() {
    return constructorNorm;
  }

  public void setConstructorNorm(boolean constructorNorm) {
    this.constructorNorm = constructorNorm;
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
