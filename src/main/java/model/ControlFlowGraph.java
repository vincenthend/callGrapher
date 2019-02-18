package model;

import model.statement.PhpStatement;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.HashSet;
import java.util.Set;

public class ControlFlowGraph {
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

  public void connectStatement(PhpStatement existing, PhpStatement new_vertex) {
    graph.addVertex(new_vertex);
    lastVertices.add(new_vertex);
    lastVertices.remove(existing);
    graph.addEdge(existing, new_vertex);
  }

  public void connectExistingStatement(PhpStatement p, PhpStatement p1){
    graph.addEdge(p, p1);
  }

  public void addFirstStatement(PhpStatement a) {
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
}
