package model;

import org.jgrapht.Graphs;

import java.util.HashMap;
import java.util.Map;

/**
 * PhpClass ProjectData saves data of the project (PhpClass, PhpFunction, CFG, etc)
 */
public class ProjectData {
  private Map<String, PhpFunction> functionMap;
  private Map<String, PhpClass> classMap;

  public ProjectData() {
    functionMap = new HashMap<>();
    classMap = new HashMap<>();
  }

  public Map<String, PhpFunction> getFunctionMap() {
    return functionMap;
  }

  public Map<String, PhpClass> getClassDataMap() {
    return classMap;
  }

  public PhpClass getClass(String className) {
    return (classMap.containsKey(className)) ? classMap.get(className) : null;
  }

  public PhpFunction getFunction(String functionCalledName) {
    return (functionMap.containsKey(functionCalledName)) ? functionMap.get(functionCalledName) : null;
  }

  public void addFunction(PhpFunction f) {
    functionMap.put(f.getCalledName(), f);
  }

  public void addClass(PhpClass c) {
    classMap.put(c.getClassName(), c);
  }

  public ControlFlowGraph getCombinedControlFlowGraph() {
    ControlFlowGraph controlFlowGraph = new ControlFlowGraph();
    for (PhpFunction phpFunction : functionMap.values()) {
      Graphs.addGraph(controlFlowGraph.getGraph(), phpFunction.getControlFlowGraph().graph);
    }
    return controlFlowGraph;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    for (PhpFunction f : functionMap.values()) {
      stringBuilder.append(f.toString());
      stringBuilder.append(", ");
    }
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}
