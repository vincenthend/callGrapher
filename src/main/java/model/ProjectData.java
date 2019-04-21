package model;

import logger.Logger;
import model.graph.ControlFlowGraph;
import model.php.PhpClass;
import model.php.PhpFunction;
import org.jgrapht.Graphs;
import util.ControlFlowNormalizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PhpClass ProjectData saves data of the project (PhpClass, PhpFunction, CFG, etc)
 */
public class ProjectData {
  private Map<String, PhpFunction> functionMap;
  private Map<String, PhpFunction> normalizedFunctions;
  private Map<String, PhpClass> classMap;

  public ProjectData() {
    functionMap = new HashMap<>();
    classMap = new HashMap<>();
    normalizedFunctions = new HashMap<>();
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

  public PhpFunction getNormalizedFunction(String functionCalledName) {
    return normalizedFunctions.getOrDefault(functionCalledName, null);
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
    for (PhpFunction phpFunction : normalizedFunctions.values()) {
      Graphs.addGraph(controlFlowGraph.getGraph(), phpFunction.getControlFlowGraph().getGraph());
    }
    return controlFlowGraph;
  }

  public ControlFlowGraph getCombinedControlFlowGraph() {
    ControlFlowGraph controlFlowGraph = new ControlFlowGraph();
    for (PhpFunction phpFunction : functionMap.values()) {
      Graphs.addGraph(controlFlowGraph.getGraph(), phpFunction.getControlFlowGraph().getGraph());
    }
    return controlFlowGraph;
  }

  public void normalizeFunctions(){
    for (PhpFunction phpFunction : functionMap.values()){
      try {
        Logger.info("Normalizing "+phpFunction.getCalledName());
        PhpFunction normalizedFunc = phpFunction.clone();
        ControlFlowNormalizer normalizer = new ControlFlowNormalizer(this);
        normalizer.normalize(phpFunction);
        normalizedFunctions.put(normalizedFunc.getCalledName(), normalizedFunc);
      } catch (CloneNotSupportedException e) {
        e.printStackTrace();
      }
    }
  }

  public void normalizeFunctions(List<String> functionNames){
    for (String functionName : functionNames){
      try {
        PhpFunction function = getFunction(functionName);
        Logger.info("Normalizing "+function.getCalledName());
        PhpFunction normalizedFunc = function.clone();
        ControlFlowNormalizer normalizer = new ControlFlowNormalizer(this);
        normalizer.normalize(normalizedFunc);
        normalizedFunctions.put(normalizedFunc.getCalledName(), normalizedFunc);
      } catch (CloneNotSupportedException e) {
        e.printStackTrace();
      }
    }
  }
}
