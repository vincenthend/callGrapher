package model;

import logger.Logger;
import org.jgrapht.Graphs;
import util.ControlFlowNormalizer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * PhpClass ProjectData saves data of the project (PhpClass, PhpFunction, CFG, etc)
 */
public class ProjectData {
  private Map<String, PhpFunction> functionMap;
  private List<PhpFunction> normalizedFunctions;
  private Map<String, PhpClass> classMap;

  public ProjectData() {
    functionMap = new HashMap<>();
    classMap = new HashMap<>();
    normalizedFunctions = new LinkedList<>();
  }

  public Map<String, PhpFunction> getFunctionMap() {
    return functionMap;
  }

  public Map<String, PhpClass> getClassDataMap() {
    return classMap;
  }

  public PhpClass getClass(String className) {
    return classMap.getOrDefault(className, null);
  }

  public PhpFunction getFunction(String functionCalledName) {
    return functionMap.getOrDefault(functionCalledName, null);
  }

  public void addFunction(PhpFunction f) {
    functionMap.put(f.getCalledName(), f);
  }

  public void addClass(PhpClass c) {
    classMap.put(c.getClassName(), c);
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

  public ControlFlowGraph getCombinedNormalizedControlFlowGraph() {
    ControlFlowGraph controlFlowGraph = new ControlFlowGraph();
    for (PhpFunction phpFunction : normalizedFunctions) {
      System.out.println(phpFunction.getControlFlowGraph().getFirstVertex());
      Graphs.addGraph(controlFlowGraph.getGraph(), phpFunction.getControlFlowGraph().getGraph());
    }
    return controlFlowGraph;
  }

  public ControlFlowGraph getCombinedControlFlowGraph() {
    ControlFlowGraph controlFlowGraph = new ControlFlowGraph();
    for (PhpFunction phpFunction : functionMap.values()) {
      System.out.println(phpFunction.getControlFlowGraph().getFirstVertex());
      Graphs.addGraph(controlFlowGraph.getGraph(), phpFunction.getControlFlowGraph().getGraph());
    }
    return controlFlowGraph;
  }

  public void normalizeControlFlowGraph(){
    normalizedFunctions.clear();
    for (PhpFunction phpFunction : functionMap.values()){
      try {
        Logger.info("Normalizing "+phpFunction.getCalledName());
        PhpFunction normalizedFunc = phpFunction.clone();
        ControlFlowNormalizer normalizer = new ControlFlowNormalizer(normalizedFunc, this);
        normalizer.normalize();//TODO Refactor this to move to functionMap
        normalizedFunctions.add(normalizedFunc);
      } catch (CloneNotSupportedException e) {
        e.printStackTrace();
      }
    }
  }
}
