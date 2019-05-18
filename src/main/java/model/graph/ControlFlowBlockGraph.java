package model.graph;

import model.graph.statement.block.PhpBasicBlock;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.HashMap;
import java.util.Map;

public class ControlFlowBlockGraph {
  private Graph<PhpBasicBlock, DefaultEdge> graph;
  private ControlFlowGraph flowGraph;

  public ControlFlowBlockGraph() {
    graph = new DefaultDirectedGraph<>(DefaultEdge.class);
  }

  public ControlFlowBlockGraph(ControlFlowBlockGraph controlFlowBlockGraph){
    Map<PhpBasicBlock, PhpBasicBlock> vertexMapping = new HashMap<>();

    graph = new DefaultDirectedGraph<>(DefaultEdge.class);
    for(PhpBasicBlock p : controlFlowBlockGraph.graph.vertexSet()){
      PhpBasicBlock cloneVert = p.cloneObject();
      graph.addVertex(cloneVert);
      vertexMapping.put(p, cloneVert);
    }

    for(DefaultEdge e : controlFlowBlockGraph.getGraph().edgeSet()){
      PhpBasicBlock sourceStat = vertexMapping.get(controlFlowBlockGraph.graph.getEdgeSource(e));
      PhpBasicBlock targetStat = vertexMapping.get(controlFlowBlockGraph.graph.getEdgeTarget(e));
      graph.addEdge(sourceStat, targetStat);
    }
  }

  public Graph<PhpBasicBlock, DefaultEdge> getGraph() {
    return graph;
  }

  public ControlFlowGraph getFlowGraph() {
    return flowGraph;
  }

  public void setFlowGraph(ControlFlowGraph flowGraph) {
    this.flowGraph = flowGraph;
  }
}
