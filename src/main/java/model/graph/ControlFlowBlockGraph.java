package model.graph;

import model.graph.statement.block.PhpBasicBlock;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class ControlFlowBlockGraph {
  private Graph<PhpBasicBlock, DefaultEdge> graph;

  public ControlFlowBlockGraph() {
    graph = new DefaultDirectedGraph<>(DefaultEdge.class);
  }

  public ControlFlowBlockGraph(ControlFlowBlockGraph controlFlowBlockGraph){
    graph = new DefaultDirectedGraph<>(DefaultEdge.class);
    for(PhpBasicBlock p : controlFlowBlockGraph.graph.vertexSet()){
      graph.addVertex(p);
    }

    for(DefaultEdge e : controlFlowBlockGraph.getGraph().edgeSet()){
      PhpBasicBlock sourceStat = controlFlowBlockGraph.graph.getEdgeSource(e);
      PhpBasicBlock targetStat = controlFlowBlockGraph.graph.getEdgeTarget(e);
      graph.addEdge(sourceStat, targetStat);
    }
  }

  public Graph<PhpBasicBlock, DefaultEdge> getGraph() {
    return graph;
  }
}
