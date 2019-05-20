package util.diff;

import model.graph.ControlFlowBlockGraph;
import model.graph.ControlFlowGraph;
import model.graph.similarity.BlockSimilarity;
import model.graph.similarity.SimilarityTable;
import model.graph.statement.PhpStatement;
import model.graph.statement.block.PhpBasicBlock;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import util.builder.ControlFlowGraphTranslator;

import java.util.*;

public class ControlFlowGraphDiff {
  private static final float ALPHA = 2;
  private static final float BETA = 1;
  private static final float GAMMA = 1;

  private ControlFlowGraph g1;
  private ControlFlowGraph g2;
  private ControlFlowBlockGraph blockGraphOld;
  private ControlFlowBlockGraph blockGraphNew;
  private BidiMap<PhpBasicBlock, PhpBasicBlock> mapping;
  private SimilarityTable similarityTable;


  public ControlFlowGraphDiff(ControlFlowGraph g1, ControlFlowGraph g2){
    this.g1 = g1;
    this.g2 = g2;

    if(g1 != null){
      blockGraphOld = new ControlFlowGraphTranslator().translateToBlockGraph(g1);
    }
    if(g2 != null){
      blockGraphNew = new ControlFlowGraphTranslator().translateToBlockGraph(g2);
    }
    computeSimilarityTable();
    matchBasicBlock();
  }

  public ControlFlowBlockGraph diffGraph() {
    if (g1 != null && g2 != null) {
      return diffBlockControlFlowGraph();
    } else if (g1 == null) {
      return blockGraphNew.cloneObject();
    } else {
      return blockGraphOld.cloneObject();
    }
  }

  public ControlFlowBlockGraph diffGraphAnnotate() {
    if (g1 != null && g2 != null) {
      return markChangedBlock();
    } else if (g1 == null) {
      ControlFlowBlockGraph cfgb = new ControlFlowGraphTranslator().translateToBlockGraph(g2);
      DepthFirstIterator<PhpBasicBlock, DefaultEdge> iterator = new DepthFirstIterator<>(cfgb.getGraph());
      while (iterator.hasNext()) {
        iterator.next().setChanged(true);
      }
      return cfgb;
    } else {
      ControlFlowBlockGraph cfgb = new ControlFlowGraphTranslator().translateToBlockGraph(g1);
      DepthFirstIterator<PhpBasicBlock, DefaultEdge> iterator = new DepthFirstIterator<>(cfgb.getGraph());
      while (iterator.hasNext()) {
        iterator.next().setChanged(true);
      }
      return cfgb;
    }
  }

  /**
   * Count similarity between two {@link PhpBasicBlock}.
   *
   * @param blockOld old/source PhpBasicBlock
   * @param blockNew new/destination PhpBasicBlock
   * @return similarity value between the two block
   */
  private float countSimilarity(PhpBasicBlock blockOld, PhpBasicBlock blockNew) {
    List<PhpStatement> statementsOld = blockOld.getBlockStatements();
    List<PhpStatement> statementsNew = blockNew.getBlockStatements();
    Set<String> oldStatementSet = new HashSet<>();
    Set<String> newStatementSet = new HashSet<>();

    // Create set of string
    for (PhpStatement statement : statementsOld) {
      oldStatementSet.add(statement.toString());
    }
    for (PhpStatement statement : statementsNew) {
      newStatementSet.add(statement.toString());
    }

    Set<String> intersectSet = new HashSet<>(oldStatementSet);
    intersectSet.retainAll(newStatementSet);

    Set<String> unionSet = new HashSet<>(oldStatementSet);
    unionSet.addAll(newStatementSet);
    if (unionSet.isEmpty()) {
      return 0;
    } else {
      return (float) intersectSet.size() / (float) unionSet.size();
    }
  }

  /**
   * Compute the similarity table between two graphs.
   *
   * @return {@link SimilarityTable} between the two graphs.
   */
  private void computeSimilarityTable() {
    similarityTable = new SimilarityTable(blockGraphOld, blockGraphNew);
    Set<PhpBasicBlock> blockSetOld = blockGraphOld.getGraph().vertexSet();
    Set<PhpBasicBlock> blockSetNew = blockGraphNew.getGraph().vertexSet();

    for (PhpBasicBlock blockOld : blockSetOld) {
      for (PhpBasicBlock blockNew : blockSetNew) {
        float simM = countSimilarity(blockOld, blockNew);

        // Get parent block
        Iterator<DefaultEdge> oldBlockEdge = blockGraphOld.getGraph().incomingEdgesOf(blockOld).iterator();
        Iterator<DefaultEdge> newBlockEdge = blockGraphNew.getGraph().incomingEdgesOf(blockNew).iterator();
        PhpBasicBlock combinedOldParent = new PhpBasicBlock();
        PhpBasicBlock combinedNewParent = new PhpBasicBlock();
        while (oldBlockEdge.hasNext()) {
          List<PhpStatement> oldStatement = blockGraphOld.getGraph().getEdgeSource(oldBlockEdge.next()).getBlockStatements();
          combinedOldParent.addStatement(oldStatement);
        }
        while (newBlockEdge.hasNext()) {
          List<PhpStatement> newStatement = blockGraphNew.getGraph().getEdgeSource(newBlockEdge.next()).getBlockStatements();
          combinedNewParent.addStatement(newStatement);
        }
        float simM1 = countSimilarity(combinedOldParent, combinedNewParent);

        // Get child block
        oldBlockEdge = blockGraphOld.getGraph().outgoingEdgesOf(blockOld).iterator();
        newBlockEdge = blockGraphNew.getGraph().outgoingEdgesOf(blockNew).iterator();
        PhpBasicBlock combinedOldChild = new PhpBasicBlock();
        PhpBasicBlock combinedNewChild = new PhpBasicBlock();
        while (oldBlockEdge.hasNext()) {
          List<PhpStatement> oldStatement = blockGraphOld.getGraph().getEdgeTarget(oldBlockEdge.next()).getBlockStatements();
          combinedOldChild.addStatement(oldStatement);
        }
        while (newBlockEdge.hasNext()) {
          List<PhpStatement> newStatement = blockGraphNew.getGraph().getEdgeTarget(newBlockEdge.next()).getBlockStatements();
          combinedNewChild.addStatement(newStatement);
        }
        float simM2 = countSimilarity(combinedOldChild, combinedNewChild);

        float similarity = (ALPHA * simM + BETA * simM1 + GAMMA * simM2) / (ALPHA + BETA + GAMMA);
        similarityTable.setSimilarity(blockOld, blockNew, similarity);
      }
    }
  }


  /**
   * Match basic blocks from control flow graph using similarityTable computed.
   *
   * @return mapping between basic blocks.
   */
  private void matchBasicBlock() {
    mapping = new DualHashBidiMap<>();
    Queue<BlockSimilarity> similarities = similarityTable.getSortedSimilarity();

    // Match blocks by iterating queue
    while (!similarities.isEmpty()) {
      BlockSimilarity blockSim = similarities.remove();
      if (!mapping.containsKey(blockSim.getOldBlock()) && !mapping.containsValue(blockSim.getNewBlock())) {
        mapping.put(blockSim.getOldBlock(), blockSim.getNewBlock());
      }
    }
  }

  private ControlFlowBlockGraph diffBlockControlFlowGraph() {
    ControlFlowBlockGraph markedGraph = markChangedBlock();
    Set<PhpBasicBlock> vertexSet = markedGraph.getGraph().vertexSet();
    PhpBasicBlock[] vertices = vertexSet.toArray(new PhpBasicBlock[vertexSet.size()]);
    for(int i = 0; i < vertices.length; i++){
      if(!vertices[i].isChanged()){
        markedGraph.getGraph().removeVertex(vertices[i]);
      }
    }

    return markedGraph;
  }

  private ControlFlowBlockGraph markChangedBlock() {
    ControlFlowBlockGraph blockGraph = new ControlFlowBlockGraph(blockGraphOld);
    Set<PhpBasicBlock> changedNode = new HashSet<>();

    DepthFirstIterator<PhpBasicBlock, DefaultEdge> iteratorOld = new DepthFirstIterator<>(blockGraphOld.getGraph());
    DepthFirstIterator<PhpBasicBlock, DefaultEdge> iteratorNew = new DepthFirstIterator<>(blockGraphNew.getGraph());

    // Traverse old graph
    while (iteratorOld.hasNext()) {
      PhpBasicBlock blockOld = iteratorOld.next();
      PhpBasicBlock blockNew = mapping.getOrDefault(blockOld, null);
      if (blockNew != null) {
        if(isBasicBlockChanged(blockOld, blockNew)) {
          blockOld.setChanged(true);
          changedNode.add(blockOld);
        }
      } else {
        blockOld.setChanged(true);
        changedNode.add(blockOld);
      }
    }

    // Find added block in the future
    while (iteratorNew.hasNext()) {
      PhpBasicBlock blockNew = iteratorNew.next();
      PhpBasicBlock blockOld = mapping.getKey(blockNew);
      if (blockOld == null) {
        Set<PhpBasicBlock> neighborBlockSet = new HashSet<>();
        neighborBlockSet.addAll(Graphs.successorListOf(blockGraphNew.getGraph(),blockNew));
        neighborBlockSet.addAll(Graphs.predecessorListOf(blockGraphNew.getGraph(),blockNew));
        for (PhpBasicBlock block : neighborBlockSet) {
          PhpBasicBlock neighborBlock = mapping.getKey(block);
          if(neighborBlock != null){
            neighborBlock.setChanged(true);
            changedNode.add(neighborBlock);
          }
        }
      }
    }

    markChangedClosure(changedNode);

    return blockGraph.cloneObject();
  }

  private void markChangedClosure(Set<PhpBasicBlock> blockSet){
    if(!blockSet.isEmpty()) {
      List<Set<PhpBasicBlock>> reachableNodeList = new ArrayList<>();
      for (PhpBasicBlock block : blockSet) {
        BreadthFirstIterator<PhpBasicBlock, DefaultEdge> bfs = new BreadthFirstIterator<>(blockGraphOld.getGraph(), block);
        Set<PhpBasicBlock> reachableSet = new HashSet<>();
        while (bfs.hasNext()) {
          reachableSet.add(bfs.next());
        }
        reachableNodeList.add(reachableSet);
      }

      // Compute intersection
      Set<PhpBasicBlock> closure = new HashSet<>();
      for(Set<PhpBasicBlock> reachableSet : reachableNodeList){
        Set<PhpBasicBlock> temp = new HashSet<>();
        temp.addAll(reachableNodeList.get(0));
        for(Set<PhpBasicBlock> reachableSet2 : reachableNodeList) {
          if(reachableSet2 != reachableSet) {
            temp.retainAll(reachableSet2);
            closure.addAll(temp);
          }
        }
      }

      for(PhpBasicBlock block : closure){
        block.setChanged(true);
      }
    }
  }

  private boolean isBasicBlockChanged(PhpBasicBlock blockOld, PhpBasicBlock blockNew) {
    boolean isChanged = true;
    List<PhpStatement> stateOld = blockOld.getBlockStatements();
    List<PhpStatement> stateNew = blockNew.getBlockStatements();

    if (stateOld.size() == stateNew.size()) {
      boolean contentSame = true;
      for (int i = 0; i < stateOld.size(); i++) {
        // Check for same content
        contentSame &= stateOld.get(i).toString().equals(stateNew.get(i).toString());
      }

      if (contentSame && isNeighborChanged(blockOld)) {
          isChanged = false;
      }
    }

    return isChanged;
  }

  private boolean isNeighborChanged(PhpBasicBlock blockOld){
    // Collect all parent & child node
    Set<PhpBasicBlock> neighborsOldList = new HashSet<>();
    neighborsOldList.addAll(Graphs.neighborListOf(blockGraphOld.getGraph(), blockOld));
    // Check for same parent&child node
    boolean sameNeighborContent = true;
    for (PhpBasicBlock oldNeighborBlock : neighborsOldList) {
      PhpBasicBlock newNeighborsBlock = mapping.getOrDefault(oldNeighborBlock, null);
      if (newNeighborsBlock != null) {
        List<PhpStatement> stateNeighNew = newNeighborsBlock.getBlockStatements();
        List<PhpStatement> stateNeighOld = oldNeighborBlock.getBlockStatements();

        if (stateNeighNew.size() == stateNeighOld.size()) {
          for (int j = 0; j < stateNeighOld.size(); j++) {
            sameNeighborContent &= stateNeighOld.get(j).toString().equals(stateNeighNew.get(j).toString());
          }
        } else {
          sameNeighborContent = false;
        }
      }
    }
    return sameNeighborContent;
  }
}
