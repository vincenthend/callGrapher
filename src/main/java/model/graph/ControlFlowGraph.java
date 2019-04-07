package model.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.graph.block.statement.PhpStatement;
import model.graph.block.statement.StatementType;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class ControlFlowGraph implements Cloneable {
  private Graph<PhpStatement,ControlFlowEdge> graph;
  private Set<PhpStatement> lastVertices;
  private PhpStatement firstVertex;

  public ControlFlowGraph() {
    graph = new DefaultDirectedGraph<PhpStatement, ControlFlowEdge>(ControlFlowEdge.class);
    firstVertex = null;
    lastVertices = new HashSet<>();
  }

  public Graph<PhpStatement, ControlFlowEdge> getGraph() {
    return graph;
  }

  public Set<PhpStatement> getLastVertices() {
    return lastVertices;
  }

  public PhpStatement getFirstVertex() {
    return firstVertex;
  }

  /**
   * Adds statement p1 after p.
   * @param p statement before
   * @param p1 statement after
   */
  public void addStatement(PhpStatement p, PhpStatement p1) {
    addStatement(p, p1, ControlFlowEdge.ControlFlowEdgeType.GENERAL);
  }

  public void addStatement(PhpStatement p, PhpStatement p1, ControlFlowEdge.ControlFlowEdgeType type) {
    ControlFlowEdge edge = new ControlFlowEdge(type);
    if(!graph.vertexSet().contains(p1)) {
      graph.addVertex(p1);
      lastVertices.add(p1);
      lastVertices.remove(p);
    }
    graph.addEdge(p, p1, edge);
  }

  public void addStatement(PhpStatement a) {
    addStatement(a, ControlFlowEdge.ControlFlowEdgeType.GENERAL);
  }

  public void addStatement(PhpStatement a, ControlFlowEdge.ControlFlowEdgeType type) {
    graph.addVertex(a);

    if(lastVertices.size() == 0 && firstVertex == null) {
      firstVertex = a;
    } else {
      PhpStatement[] phpStatements = lastVertices.toArray(new PhpStatement[lastVertices.size()]);
      for(PhpStatement statement : phpStatements){
        if(statement.getStatementType() != StatementType.RETURN){
          ControlFlowEdge edge = new ControlFlowEdge(type);
          graph.addEdge(statement, a, edge);
          lastVertices.remove(statement);
        }
      }
    }

    lastVertices.add(a);
  }

  /**
   * Append ControlFlowGraph to an existing statement.
   * @param existing appended statement
   * @param g appended CFG
   */
  public void appendGraph(PhpStatement existing, ControlFlowGraph g){
    appendGraph(existing, g, ControlFlowEdge.ControlFlowEdgeType.GENERAL);
  }

  public void appendGraph(PhpStatement existing, ControlFlowGraph g, ControlFlowEdge.ControlFlowEdgeType type){
    if(g != null && g.graph.vertexSet().size() != 0) {
      Graphs.addGraph(graph, g.getGraph());
      ControlFlowEdge edge = new ControlFlowEdge(type);
      graph.addEdge(existing, g.firstVertex, edge);
      lastVertices.remove(existing);
      lastVertices.addAll(g.lastVertices);
    }
  }

  /**
   * Append ControlFlowGraph to a list of statement
   * @param existing appended statmeents
   * @param g appended CFG
   */
  public void appendGraph(Iterable<PhpStatement> existing, ControlFlowGraph g){
    appendGraph(existing, g, ControlFlowEdge.ControlFlowEdgeType.GENERAL);
  }

  public void appendGraph(Iterable<PhpStatement> existing, ControlFlowGraph g, ControlFlowEdge.ControlFlowEdgeType type){
    if(g != null && g.firstVertex != null) {
      Graphs.addGraph(graph, g.getGraph());
      for (PhpStatement p : existing) {
        ControlFlowEdge edge = new ControlFlowEdge(type);
        graph.addEdge(p, g.firstVertex, edge);
        lastVertices.remove(p);
      }
      lastVertices.addAll(g.lastVertices);
    }
  }

  /**
   * Append a ControlFlowGraph to this ControlFlowGraph
   * @param g appended CFG
   */
  public void appendGraph(ControlFlowGraph g){
    appendGraph(g, ControlFlowEdge.ControlFlowEdgeType.GENERAL);
  }

  public void appendGraph(ControlFlowGraph g, ControlFlowEdge.ControlFlowEdgeType type){
    if(g != null) {
      Graphs.addGraph(graph, g.getGraph());
      if (firstVertex == null) {
        firstVertex = g.firstVertex;
      } else {
        HashSet<PhpStatement> removeList = new HashSet<>();
        if(g.firstVertex != null) {
          for (PhpStatement p : lastVertices) {
            if(p.getStatementType() != StatementType.RETURN){
              ControlFlowEdge edge = new ControlFlowEdge(type);
              graph.addEdge(p, g.firstVertex, edge);
              removeList.add(p);
            }
          }
        }
        lastVertices.removeAll(removeList);
      }
      lastVertices.addAll(g.lastVertices);
    }
  }

  @Override
  public ControlFlowGraph clone() throws CloneNotSupportedException{
    ControlFlowGraph cfg = (ControlFlowGraph) super.clone();

    Graph<PhpStatement,ControlFlowEdge> graphClone = new DefaultDirectedGraph<PhpStatement, ControlFlowEdge>(ControlFlowEdge.class);
    Map<PhpStatement,PhpStatement> map = new HashMap<>();
    for(PhpStatement p : graph.vertexSet()){
      PhpStatement cloneStatement = p.clone();
      map.put(p, cloneStatement);
      graphClone.addVertex(cloneStatement);
    }

    for(ControlFlowEdge e : graph.edgeSet()){
      PhpStatement sourceStat = graph.getEdgeSource(e);
      PhpStatement targetStat = graph.getEdgeTarget(e);
      ControlFlowEdge edge = new ControlFlowEdge(e.getEdgeType());
      graphClone.addEdge(map.get(sourceStat), map.get(targetStat), edge);
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
