package model;

import model.statement.PhpStatement;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class ControlFlowGraph {
  Graph<PhpStatement, DefaultEdge> graph;

  public ControlFlowGraph(){
    graph = new DefaultDirectedGraph<PhpStatement, DefaultEdge>(DefaultEdge.class);
  }

  public Graph<PhpStatement, DefaultEdge> getGraph() {
    return graph;
  }
}
