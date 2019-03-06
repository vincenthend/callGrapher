package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import model.statement.FunctionCallStatement;
import model.statement.PhpStatement;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class ControlFlowGraph implements Cloneable {
  public Graph<PhpStatement, DefaultEdge> graph;
  public Set<PhpStatement> lastVertices;
  public PhpStatement firstVertex;

  public ControlFlowGraph() {
    graph = new DefaultDirectedGraph<PhpStatement, DefaultEdge>(DefaultEdge.class);
    firstVertex = null;
    lastVertices = new HashSet<>();
  }

  public Graph<PhpStatement, DefaultEdge> getGraph() {
    return graph;
  }

  public void addStatement(PhpStatement p, PhpStatement p1) {
    if(graph.vertexSet().contains(p1)) {
      graph.addEdge(p, p1);
    } else {
      graph.addVertex(p1);
      lastVertices.add(p1);
      lastVertices.remove(p);
      graph.addEdge(p, p1);
    }
  }

  public void addStatement(PhpStatement a) {
    graph.addVertex(a);
    firstVertex = a;
    lastVertices.add(a);
  }

  /**
   * Append ControlFlowGraph to all
   * @param existing
   * @param g
   */
  public void appendGraph(PhpStatement existing, ControlFlowGraph g){
    if(g != null && g.graph.vertexSet().size() != 0) {
      Graphs.addGraph(graph, g.getGraph());
      graph.addEdge(existing, g.firstVertex);
      lastVertices.remove(existing);
      lastVertices.addAll(g.lastVertices);
    }
  }

  /**
   * Append ControlFlowGraph to all
   * @param existing
   * @param g
   */
  public void appendGraph(Iterable<PhpStatement> existing, ControlFlowGraph g){
    if(g != null) {
      Graphs.addGraph(graph, g.getGraph());
      for (PhpStatement p : existing) {
        graph.addEdge(p, g.firstVertex);
        lastVertices.remove(p);
      }
      lastVertices.addAll(g.lastVertices);
    }
  }

  /**
   * Append ControlFlowGraph to ControlFlowGraph
   * @param g
   */
  public void appendGraph(ControlFlowGraph g){
    if(g != null) {
      Graphs.addGraph(graph, g.getGraph());
      if (firstVertex == null) {
        firstVertex = g.firstVertex;
      } else {
        HashSet<PhpStatement> removeList = new HashSet<>();
        if(g.firstVertex != null) {
          for (PhpStatement p : lastVertices) {
            graph.addEdge(p, g.firstVertex);
            removeList.add(p);
          }
        }
        lastVertices.removeAll(removeList);
      }
      lastVertices.addAll(g.lastVertices);
    }
  }

  public static void normalizeFunctionCall(ControlFlowGraph cfg){
    // Find FunctionCallStatement
    for(Object object : cfg.getGraph().vertexSet().toArray()){
      PhpStatement phpStatement = (PhpStatement) object;
      if(phpStatement instanceof FunctionCallStatement){
        if(((FunctionCallStatement) phpStatement).getFunction().graph != null) {
          List<PhpStatement> predList = Graphs.predecessorListOf(cfg.getGraph(), phpStatement);
          List<PhpStatement> succList = Graphs.successorListOf(cfg.getGraph(), phpStatement);
          ControlFlowGraph functionGraph = ((FunctionCallStatement) phpStatement).getFunction().graph;

          try {
            ControlFlowGraph functionGraphClone = functionGraph.clone();
            normalizeFunctionCall(functionGraph);
            Graphs.addGraph(cfg.graph, functionGraphClone.graph);

            // Connect predecessor to first vertex
            for (PhpStatement predStat : predList) {
              cfg.graph.addEdge(predStat, functionGraphClone.firstVertex);
            }
            // Connect successors to last vertex
            for (PhpStatement succStat : succList) {
              for (PhpStatement lastVertex : functionGraphClone.lastVertices) {
                cfg.graph.addEdge(lastVertex, succStat);
              }
            }
            // Remove function call
            cfg.getGraph().removeVertex(phpStatement);
            if(cfg.lastVertices.contains(phpStatement)){
              cfg.lastVertices.addAll(functionGraphClone.lastVertices);
              cfg.lastVertices.remove(phpStatement);
            }
            if(cfg.firstVertex == phpStatement){
              cfg.firstVertex = functionGraphClone.firstVertex;
            }
          } catch (CloneNotSupportedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

  @Override
  public ControlFlowGraph clone() throws CloneNotSupportedException{
    ControlFlowGraph cfg = (ControlFlowGraph) super.clone();

    Graph<PhpStatement,DefaultEdge> graphClone = new DefaultDirectedGraph<PhpStatement, DefaultEdge>(DefaultEdge.class);
    Map<PhpStatement,PhpStatement> map = new HashMap<>();
    for(PhpStatement p : graph.vertexSet()){
      PhpStatement cloneStatement = p.clone();
      map.put(p, cloneStatement);
      graphClone.addVertex(cloneStatement);
    }

    for(DefaultEdge e : graph.edgeSet()){
      PhpStatement sourceStat = graph.getEdgeSource(e);
      PhpStatement targetStat = graph.getEdgeTarget(e);
      graphClone.addEdge(map.get(sourceStat), map.get(targetStat));
    }

    cfg.graph = graphClone;
    cfg.firstVertex = map.get(firstVertex);
    cfg.lastVertices = new HashSet<>();
    for(PhpStatement l : lastVertices) {
      cfg.lastVertices.add(map.get(l));
    }

    return cfg;
  }
}
