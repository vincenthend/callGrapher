package model;

import model.statement.PhpStatement;

import java.util.HashMap;
import java.util.Map;

public class ProjectData {
  private Map<String, Function> functionMap;
  private ControlFlowGraph controlFlowGraph;

  public ProjectData() {
    functionMap = new HashMap<String, Function>();
    controlFlowGraph = new ControlFlowGraph();
  }

  public ControlFlowGraph getControlFlowGraph() {
    return controlFlowGraph;
  }

  public Map<String, Function> getFunctionMap() {
    return functionMap;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    for(PhpStatement f : controlFlowGraph.getGraph().vertexSet()){
      stringBuilder.append(f.toString());
      stringBuilder.append(", ");
    }
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}
