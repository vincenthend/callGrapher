package model;

import logger.Logger;
import model.graph.ControlFlowGraph;
import model.php.PhpClass;
import model.php.PhpFunction;
import org.jgrapht.Graphs;
import util.builder.ControlFlowNormalizer;

import java.util.HashMap;
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

  public void normalizeFunction(String functionName, int maxDepth) {
    try {
      PhpFunction function = getFunction(functionName);
      if (function != null) {
        Logger.info("Normalizing " + function.getCalledName());
        PhpFunction normalizedFunc = function.clone();
        ControlFlowNormalizer normalizer = new ControlFlowNormalizer(this, maxDepth);
        normalizer.normalize(normalizedFunc);
        normalizedFunctions.put(normalizedFunc.getCalledName(), normalizedFunc);
      } else {
        throw new IllegalStateException();
      }
    } catch (CloneNotSupportedException e) {
      Logger.error("Failed to clone");
    } catch (IllegalStateException ex) {
      Logger.error("Function " + functionName + " doesn't exist");
      normalizedFunctions.put(functionName, null);
      throw new IllegalStateException();
    }
  }
}
