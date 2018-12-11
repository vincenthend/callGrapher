package model;

import java.util.HashMap;
import java.util.Map;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class ProjectData {
  private Map<String, Function> functionMap;
  private Graph<Function, DefaultEdge> callGraph;

  public ProjectData() {
    functionMap = new HashMap<String, Function>();
    callGraph = new DefaultDirectedGraph<Function, DefaultEdge>(DefaultEdge.class);
  }

  public void add(Function function){
    functionMap.put(function.getCalledName(), function);
    callGraph.addVertex(function);
  }

  public Graph<Function, DefaultEdge> getCallGraph() {
    return callGraph;
  }

  public Map<String, Function> getFunctionMap() {
    return functionMap;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    for(Function f : callGraph.vertexSet()){
      stringBuilder.append(f.getCalledName());
      stringBuilder.append(", ");
    }
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}
