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
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

public class ControlFlowGraph implements Cloneable {
  private Graph<PhpStatement, DefaultEdge> graph;
  private Set<PhpStatement> lastVertices;
  private PhpStatement firstVertex;

  public ControlFlowGraph() {
    graph = new DefaultDirectedGraph<PhpStatement, DefaultEdge>(DefaultEdge.class);
    firstVertex = null;
    lastVertices = new HashSet<>();
  }

  public Graph<PhpStatement, DefaultEdge> getGraph() {
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

    if(lastVertices.size() == 0 && firstVertex == null) {
      firstVertex = a;
    } else {
      PhpStatement[] phpStatements = lastVertices.toArray(new PhpStatement[lastVertices.size()]);
      for(PhpStatement statement : phpStatements){
        graph.addEdge(statement, a);
        lastVertices.remove(statement);
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
    if(g != null && g.graph.vertexSet().size() != 0) {
      Graphs.addGraph(graph, g.getGraph());
      graph.addEdge(existing, g.firstVertex);
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
   * Append a ControlFlowGraph to this ControlFlowGraph
   * @param g appended CFG
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

  public void normalizeControlFlowGraph(){
    // Find FunctionCallStatement
    GraphIterator<PhpStatement, DefaultEdge> iterator = new DepthFirstIterator<PhpStatement, DefaultEdge> (graph);
    while(iterator.hasNext()){
      PhpStatement statement = iterator.next();
      Graphs.successorListOf(graph, statement);
      iterator.next();
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
