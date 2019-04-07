package util;

import model.graph.ControlFlowEdge;
import model.graph.ControlFlowGraph;
import model.graph.block.statement.PhpStatement;
import org.jgrapht.Graph;
import org.jgrapht.alg.lca.BinaryLiftingLCAFinder;
import org.jgrapht.alg.lca.TarjanLCAFinder;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControlFlowGraphDominators {
  ControlFlowGraph cfg;
  Graph<PhpStatement, DefaultEdge> tree;
  List<PhpStatement> vertexList;
  Map<PhpStatement, Integer> vertexId;
  Map<PhpStatement, Integer> parent;

  public static Graph<PhpStatement, DefaultEdge> computeDominatorGraph(ControlFlowGraph cfg) {
    ControlFlowGraphDominators cfgd = new ControlFlowGraphDominators(cfg);
//    cfgd.traverseGraph();
    cfgd.compute();
    return cfgd.tree;
  }

  private ControlFlowGraphDominators(ControlFlowGraph cfg) {
    this.cfg = cfg;
    vertexList = new ArrayList<>();
    vertexId = new HashMap<>();
    parent = new HashMap<>();
    tree = new DefaultDirectedGraph<PhpStatement, DefaultEdge>(DefaultEdge.class);
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
      if (cfg.getGraph().incomingEdgesOf(statement).size() > 0) {
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
        for (ControlFlowEdge edge : cfg.getGraph().incomingEdgesOf(v)) {
          PhpStatement u = cfg.getGraph().getEdgeSource(edge);

          int parentId = parent.get(v);
          // If there is no common ancestor of U and parent, change parent
          int nca = nearestCommonAncestor(u, vertexList.get(parentId));
          if(nca == -99){
            System.out.println("error");
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

  private int nearestCommonAncestor(PhpStatement u, PhpStatement parent) {
    TarjanLCAFinder<PhpStatement, DefaultEdge> lcaFinder
      = new TarjanLCAFinder<PhpStatement, DefaultEdge>(tree, cfg.getFirstVertex());
    return vertexId.getOrDefault(lcaFinder.getLCA(parent, u), -99);
  }
}