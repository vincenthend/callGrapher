package model;

import model.statement.PhpStatement;
import org.jgrapht.Graphs;

import java.util.HashMap;
import java.util.Map;

public class ProjectData {
  private Map<String, Function> functionMap;
  private ControlFlowGraph controlFlowGraph;

  public ProjectData() {
    functionMap = new HashMap<>();
    controlFlowGraph = new ControlFlowGraph();
  }

  public void add(Function function){
    functionMap.put(function.getCalledName(), function);
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
    for(Function f : functionMap.values()){
      stringBuilder.append(f.toString());
      stringBuilder.append(", ");
    }
    stringBuilder.append("]");
    return stringBuilder.toString();
  }

  public void appendControlFlowGraph(ControlFlowGraph cfg) {
    Graphs.addGraph(controlFlowGraph.getGraph(), cfg.getGraph());
  }
}
