package model.graph;

import model.graph.block.PhpBasicBlock;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class ControlFlowBlockGraph {
  private Graph<PhpBasicBlock, DefaultEdge> graph;

  public ControlFlowBlockGraph() {
    graph = new DefaultDirectedGraph<PhpBasicBlock, DefaultEdge>(DefaultEdge.class);
  }

  public Graph<PhpBasicBlock, DefaultEdge> getGraph() {
    return graph;
  }
}
