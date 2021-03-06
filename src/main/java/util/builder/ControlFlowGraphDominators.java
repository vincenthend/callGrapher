package util.builder;

import logger.Logger;
import model.graph.ControlFlowGraph;
import model.graph.statement.PhpStatement;
import org.jgrapht.Graph;
import org.jgrapht.alg.lca.TarjanLCAFinder;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import util.iterator.ControlFlowDepthFirstIterator;
import util.iterator.ControlFlowDominatorIterator;

import java.util.*;

public class ControlFlowGraphDominators implements Iterable<PhpStatement>{
  private ControlFlowGraph cfg;
  private Graph<PhpStatement, DefaultEdge> tree;
  private List<PhpStatement> vertexList;
  private Map<PhpStatement, Integer> vertexId;
  private Map<PhpStatement, Integer> parent;

  public ControlFlowGraphDominators(ControlFlowGraph cfg) {
    this.cfg = cfg;
    vertexList = new ArrayList<>();
    vertexId = new HashMap<>();
    parent = new HashMap<>();
    tree = new DefaultDirectedGraph<>(DefaultEdge.class);

    compute();
  }

  private void traverseGraph() {
    // Create DFS tree
    ControlFlowDepthFirstIterator iterator = new ControlFlowDepthFirstIterator(cfg);
    int num = 0;
    while (iterator.hasNext()) {
      // Compute vertex
      PhpStatement statement = iterator.next();
      vertexList.add(statement);
      vertexId.put(statement, num);

      // Get parent ID
      if (statement != cfg.getFirstVertex()) {
        parent.put(statement, vertexId.get(iterator.getParent()));
      } else {
        parent.put(statement, -1);
      }

      // Compute spanning tree
      tree.addVertex(statement);
      if (iterator.getParent() != null) {
        tree.addEdge(iterator.getParent(), statement);
      }

      num++;
    }
  }

  private void compute() {
    // Create spanning tree and init data
    traverseGraph();

    // Keep computing while still changing
    boolean changed = true;
    while (changed) {
      changed = false;
      for (int i = 0; i < vertexList.size(); i++) {
        PhpStatement v = vertexList.get(i);
        if(v != cfg.getFirstVertex()) {
          for (DefaultEdge edge : cfg.getGraph().incomingEdgesOf(v)) {
            PhpStatement u = cfg.getGraph().getEdgeSource(edge);

            int parentId = parent.get(v);
            // If there is no common ancestor of U and parent, change parent
            int nca = nearestCommonAncestor(u, vertexList.get(parentId));
            if (nca == -99) {
              Logger.error("Found error");
            }
            if (vertexId.get(u) != parentId && parentId != nca) {
              tree.removeEdge(vertexList.get(parentId), v);
              parent.put(v, nca);
              tree.addEdge(vertexList.get(nca), v);
              changed = true;
            }
          }
        }
      }
    }
  }

  private int nearestCommonAncestor(PhpStatement u, PhpStatement parent) {
    TarjanLCAFinder<PhpStatement, DefaultEdge> lcaFinder
      = new TarjanLCAFinder<>(tree, cfg.getFirstVertex());
    return vertexId.getOrDefault(lcaFinder.getLCA(parent, u), -99);
  }

  public Graph<PhpStatement, DefaultEdge> getTree() {
    return tree;
  }

  @Override
  public ControlFlowDominatorIterator iterator() {
    return new ControlFlowDominatorIterator(this, cfg.getFirstVertex());
  }
}