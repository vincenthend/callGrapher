package model.graph;

import logger.Logger;
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
  private ControlFlowBlockGraph flowBlockGraph;
  private int maxId;

  public ControlFlowGraph() {
    graph = new DefaultDirectedGraph<>(DefaultEdge.class);
    firstVertex = null;
    lastVertices = new HashSet<>();
    maxId = 0;
  }

  public ControlFlowGraph(ControlFlowGraph c) {
    // Clone graph
    Graph<PhpStatement, DefaultEdge> graphClone = new DefaultDirectedGraph<>(DefaultEdge.class);
    Map<PhpStatement, PhpStatement> map = new HashMap<>();
    for (PhpStatement p : c.graph.vertexSet()) {
      PhpStatement cloneStatement = p.cloneObject();
      map.put(p, cloneStatement);
      graphClone.addVertex(cloneStatement);
    }
    for (DefaultEdge e : c.graph.edgeSet()) {
      PhpStatement sourceStat = c.graph.getEdgeSource(e);
      PhpStatement targetStat = c.graph.getEdgeTarget(e);
      graphClone.addEdge(map.get(sourceStat), map.get(targetStat));
    }
    this.graph = graphClone;

    this.firstVertex = map.get(c.firstVertex);
    this.lastVertices = new HashSet<>();
    for (PhpStatement l : c.lastVertices) {
      this.lastVertices.add(map.get(l));
    }

    this.maxId = c.maxId;
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

  public void replaceStatement(PhpStatement statement, PhpStatement replacement) {
    graph.addVertex(replacement);

    Set<DefaultEdge> outgoingEdge = graph.outgoingEdgesOf(statement);
    for (DefaultEdge edge : outgoingEdge) {
      graph.addEdge(replacement, graph.getEdgeTarget(edge));
    }
    Set<DefaultEdge> incomingEdge = graph.incomingEdgesOf(statement);
    for (DefaultEdge edge : incomingEdge) {
      graph.addEdge(graph.getEdgeSource(edge), replacement);
    }

    graph.removeVertex(statement);
    if (firstVertex == statement) {
      firstVertex = replacement;
    }
    if (lastVertices.contains(statement)) {
      lastVertices.remove(statement);
      lastVertices.add(replacement);
    }
  }

  public void removeStatement(PhpStatement statement) {
    if (firstVertex != statement) {
      Set<DefaultEdge> outgoingEdge = graph.outgoingEdgesOf(statement);
      Set<DefaultEdge> incomingEdge = graph.incomingEdgesOf(statement);

      // Reattach neighbor
      for (DefaultEdge inEdge : incomingEdge) {
        for (DefaultEdge outEdge : outgoingEdge) {
          if(graph.getEdgeSource(inEdge) != graph.getEdgeTarget(outEdge)) {
            graph.addEdge(graph.getEdgeSource(inEdge), graph.getEdgeTarget(outEdge));
          }
        }
      }

      graph.removeVertex(statement);

      if (lastVertices.contains(statement)) {
        lastVertices.remove(statement);
      }
      if (lastVertices.isEmpty()) {
        for (DefaultEdge inEdge : incomingEdge) {
          lastVertices.add(graph.getEdgeSource(inEdge));
        }
      }
    }
  }

  public ControlFlowGraph cloneObject() {
    return new ControlFlowGraph(this);
  }

  public ControlFlowBlockGraph getFlowBlockGraph() {
    return flowBlockGraph;
  }

  public void setFlowBlockGraph(ControlFlowBlockGraph flowBlockGraph) {
    this.flowBlockGraph = flowBlockGraph;
  }
}
