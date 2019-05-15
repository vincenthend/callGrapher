package model.graph;

import model.graph.statement.PhpStatement;
import model.graph.statement.StatementType;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ControlFlowGraph implements Cloneable {
  private Graph<PhpStatement, DefaultEdge> graph;
  private Set<PhpStatement> lastVertices;
  private PhpStatement firstVertex;
  private int maxId;

  public ControlFlowGraph() {
    graph = new DefaultDirectedGraph<>(DefaultEdge.class);
    firstVertex = null;
    lastVertices = new HashSet<>();
    maxId = 0;
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
   * Adds statement p1 after p. P1 may have existed
   *
   * @param p  statement before
   * @param p1 statement after
   */
  public void addStatement(PhpStatement p, PhpStatement p1) {
    if (!graph.vertexSet().contains(p1)) {
      graph.addVertex(p1);
      lastVertices.add(p1);
      lastVertices.remove(p);
      p1.setStatementId(maxId);
      maxId += 1;
    }
    graph.addEdge(p, p1);
  }

  /**
   * Add statement after last vertices. Statement haven't existed in the graph.
   *
   * @param a added statement
   */
  public void addStatement(PhpStatement a) {
    graph.addVertex(a);
    a.setStatementId(maxId);
    maxId += 1;
    if (lastVertices.isEmpty() && firstVertex == null) {
      firstVertex = a;
    } else {
      PhpStatement[] phpStatements = lastVertices.toArray(new PhpStatement[lastVertices.size()]);
      for (PhpStatement statement : phpStatements) {
        if (statement.getStatementType() != StatementType.RETURN) {
          graph.addEdge(statement, a);
          lastVertices.remove(statement);
        }
      }
    }

    lastVertices.add(a);
  }

  /**
   * Append ControlFlowGraph to an existing statement.
   *
   * @param existing appended statement
   * @param g        appended CFG
   */
  public void appendGraph(PhpStatement existing, ControlFlowGraph g) {
    if (g != null && !g.graph.vertexSet().isEmpty()) {
      // Take care of ID
      Set<PhpStatement> vertexSet = g.getGraph().vertexSet();
      for (PhpStatement phpStatement : vertexSet) {
        phpStatement.setStatementId(phpStatement.getStatementId() + maxId);
      }
      maxId += vertexSet.size();

      Graphs.addGraph(graph, g.getGraph());
      graph.addEdge(existing, g.firstVertex);
      lastVertices.remove(existing);
      lastVertices.addAll(g.lastVertices);
    }
  }

  /**
   * Append ControlFlowGraph to a list of statement
   *
   * @param existing appended statmeents
   * @param g        appended CFG
   */
  public void appendGraph(Iterable<PhpStatement> existing, ControlFlowGraph g) {
    if (g != null && g.firstVertex != null) {
      // Take care of ID
      Set<PhpStatement> vertexSet = g.getGraph().vertexSet();
      for (PhpStatement phpStatement : vertexSet) {
        phpStatement.setStatementId(phpStatement.getStatementId() + maxId);
      }
      maxId += vertexSet.size();

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
   *
   * @param g appended CFG
   */
  public void appendGraph(ControlFlowGraph g) {
    if (g != null) {
      // Take care of ID
      Set<PhpStatement> vertexSet = g.getGraph().vertexSet();
      for (PhpStatement phpStatement : vertexSet) {
        phpStatement.setStatementId(phpStatement.getStatementId() + maxId);
      }
      maxId += vertexSet.size();

      Graphs.addGraph(graph, g.getGraph());
      if (firstVertex == null) {
        firstVertex = g.firstVertex;
      } else {
        HashSet<PhpStatement> removeList = new HashSet<>();
        if (g.firstVertex != null) {
          for (PhpStatement p : lastVertices) {
            if (p.getStatementType() != StatementType.RETURN) {
              graph.addEdge(p, g.firstVertex);
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
  public ControlFlowGraph clone() throws CloneNotSupportedException {
    ControlFlowGraph cfg = (ControlFlowGraph) super.clone();

    Graph<PhpStatement, DefaultEdge> graphClone = new DefaultDirectedGraph<>(DefaultEdge.class);
    Map<PhpStatement, PhpStatement> map = new HashMap<>();
    for (PhpStatement p : graph.vertexSet()) {
      PhpStatement cloneStatement = p.clone();
      map.put(p, cloneStatement);
      graphClone.addVertex(cloneStatement);
    }

    for (DefaultEdge e : graph.edgeSet()) {
      PhpStatement sourceStat = graph.getEdgeSource(e);
      PhpStatement targetStat = graph.getEdgeTarget(e);
      graphClone.addEdge(map.get(sourceStat), map.get(targetStat));
    }

    cfg.graph = graphClone;
    cfg.firstVertex = map.get(firstVertex);
    cfg.lastVertices = new HashSet<>();
    for (PhpStatement l : lastVertices) {
      cfg.lastVertices.add(map.get(l));
    }

    return cfg;
  }
}
