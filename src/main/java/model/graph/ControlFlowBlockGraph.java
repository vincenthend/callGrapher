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

  public ControlFlowBlockGraph cloneObject(){
    ControlFlowBlockGraph cfbg = new ControlFlowBlockGraph();
    Map<PhpBasicBlock, PhpBasicBlock> vertexMapping = new HashMap<>();

    cfbg.graph = new DefaultDirectedGraph<>(DefaultEdge.class);
    for(PhpBasicBlock p : this.graph.vertexSet()){
      PhpBasicBlock cloneVert = p.cloneObject();
      cfbg.graph.addVertex(cloneVert);
      vertexMapping.put(p, cloneVert);
    }

    for(DefaultEdge e : this.getGraph().edgeSet()){
      PhpBasicBlock sourceStat = vertexMapping.get(this.graph.getEdgeSource(e));
      PhpBasicBlock targetStat = vertexMapping.get(this.graph.getEdgeTarget(e));
      cfbg.graph.addEdge(sourceStat, targetStat);
    }
    return cfbg;
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
