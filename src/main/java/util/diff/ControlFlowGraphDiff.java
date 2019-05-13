package util.diff;

import model.graph.ControlFlowBlockGraph;
import model.graph.ControlFlowGraph;
import model.graph.block.BlockSimilarity;
import model.graph.block.PhpBasicBlock;
import model.graph.block.SimilarityTable;
import model.graph.block.statement.PhpStatement;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;
import util.ControlFlowGraphTranslator;

import java.util.*;

public class ControlFlowGraphDiff {
  private final float ALPHA = 2;
  private final float BETA = 1;
  private final float GAMMA = 1;

  public ControlFlowBlockGraph diffGraph(ControlFlowGraph g1, ControlFlowGraph g2) {
    if (g1 != null && g2 != null) {
      ControlFlowBlockGraph b1 = new ControlFlowGraphTranslator().translateToBlockGraph(g1);
      ControlFlowBlockGraph b2 = new ControlFlowGraphTranslator().translateToBlockGraph(g2);

      SimilarityTable similarityTable = computeSimilarityTable(b1, b2);
      BidiMap<PhpBasicBlock, PhpBasicBlock> blockMatchingMap = matchBasicBlock(similarityTable, b1, b2);

      return diffBlockControlFlowGraph(blockMatchingMap, b1, b2);
    } else if (g1 == null) {
      return new ControlFlowGraphTranslator().translateToBlockGraph(g2);
    } else {
      return new ControlFlowGraphTranslator().translateToBlockGraph(g1);
    }
  }

  public ControlFlowBlockGraph diffGraphAnnotate(ControlFlowGraph g1, ControlFlowGraph g2) {
    if (g1 != null && g2 != null) {
      ControlFlowBlockGraph b1 = new ControlFlowGraphTranslator().translateToBlockGraph(g1);
      ControlFlowBlockGraph b2 = new ControlFlowGraphTranslator().translateToBlockGraph(g2);

      SimilarityTable similarityTable = computeSimilarityTable(b1, b2);
      BidiMap<PhpBasicBlock, PhpBasicBlock> blockMatchingMap = matchBasicBlock(similarityTable, b1, b2);

      return annotateBlockControlFlowGraph(blockMatchingMap, b1, b2);
    } else if (g1 == null) {
      ControlFlowBlockGraph cfgb = new ControlFlowGraphTranslator().translateToBlockGraph(g2);
      DepthFirstIterator<PhpBasicBlock, DefaultEdge> iterator = new DepthFirstIterator<PhpBasicBlock, DefaultEdge>(cfgb.getGraph());
      while(iterator.hasNext()){
        iterator.next().setChanged(true);
      }
      return cfgb;
    } else {
      ControlFlowBlockGraph cfgb = new ControlFlowGraphTranslator().translateToBlockGraph(g1);
      DepthFirstIterator<PhpBasicBlock, DefaultEdge> iterator = new DepthFirstIterator<PhpBasicBlock, DefaultEdge>(cfgb.getGraph());
      while(iterator.hasNext()){
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
    if (unionSet.size() == 0) {
      return 0;
    } else {
      return (float) intersectSet.size() / (float) unionSet.size();
    }
  }

  /**
   * Compute the similarity table between two graphs.
   *
   * @param blockGraphOld old/source graph
   * @param blockGraphNew new / destination
   * @return {@link SimilarityTable} between the two graphs.
   */
  private SimilarityTable computeSimilarityTable(ControlFlowBlockGraph blockGraphOld, ControlFlowBlockGraph blockGraphNew) {
    SimilarityTable similarityTable = new SimilarityTable(blockGraphOld, blockGraphNew);
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

    return similarityTable;
  }


  private BidiMap<PhpBasicBlock, PhpBasicBlock> matchBasicBlock(SimilarityTable similarityTable, ControlFlowBlockGraph blockGraphOld, ControlFlowBlockGraph blockGraphNew) {
    BidiMap<PhpBasicBlock, PhpBasicBlock> blockMapping = new DualHashBidiMap<>();
    Queue<BlockSimilarity> similarities = similarityTable.getSortedSimilarity();

    // Match blocks by iterating queue
    while (!similarities.isEmpty()) {
      BlockSimilarity blockSim = similarities.remove();
      if (!blockMapping.containsKey(blockSim.getOldBlock()) && !blockMapping.containsValue(blockSim.getNewBlock())) {
        blockMapping.put(blockSim.getOldBlock(), blockSim.getNewBlock());
      }
    }

    return blockMapping;
  }

  private ControlFlowBlockGraph diffBlockControlFlowGraph(BidiMap<PhpBasicBlock, PhpBasicBlock> mapping, ControlFlowBlockGraph gOld, ControlFlowBlockGraph gNew) {
    ControlFlowBlockGraph blockGraph = new ControlFlowBlockGraph(gOld);

    DepthFirstIterator<PhpBasicBlock, DefaultEdge> iteratorOld = new DepthFirstIterator<PhpBasicBlock, DefaultEdge>(gOld.getGraph());

    // Traverse old graph
    while (iteratorOld.hasNext()) {
      PhpBasicBlock blockOld = iteratorOld.next();
      PhpBasicBlock blockNew = mapping.getOrDefault(blockOld, null);
      if (blockNew != null) {
        boolean changed = isBasicBlockChanged(mapping, gOld, gNew, blockOld, blockNew);
        if (!changed) {
          blockGraph.getGraph().removeVertex(blockOld);
        } else {
          blockOld.setChanged(true);
        }
      } else {
        blockOld.setChanged(true);
      }
    }

    return blockGraph;
  }

  private ControlFlowBlockGraph annotateBlockControlFlowGraph(BidiMap<PhpBasicBlock, PhpBasicBlock> mapping, ControlFlowBlockGraph gOld, ControlFlowBlockGraph gNew) {
    ControlFlowBlockGraph blockGraph = new ControlFlowBlockGraph(gOld);

    DepthFirstIterator<PhpBasicBlock, DefaultEdge> iteratorOld = new DepthFirstIterator<PhpBasicBlock, DefaultEdge>(gOld.getGraph());

    // Traverse old graph
    while (iteratorOld.hasNext()) {
      PhpBasicBlock blockOld = iteratorOld.next();
      PhpBasicBlock blockNew = mapping.getOrDefault(blockOld, null);
      if (blockNew != null) {
        blockOld.setChanged(isBasicBlockChanged(mapping, gOld, gNew, blockOld, blockNew));
      } else {
        blockOld.setChanged(true);
      }
    }
    return blockGraph;
  }

  private boolean isBasicBlockChanged(BidiMap<PhpBasicBlock, PhpBasicBlock> mapping, ControlFlowBlockGraph gOld, ControlFlowBlockGraph gNew, PhpBasicBlock blockOld, PhpBasicBlock blockNew){
    boolean isChanged = true;
    List<PhpStatement> stateOld = blockOld.getBlockStatements();
    List<PhpStatement> stateNew = blockNew.getBlockStatements();

    if (stateOld.size() == stateNew.size()) {
      boolean contentSame = true;
      for (int i = 0; i < stateOld.size(); i++) {
        // Check for same content
        contentSame &= stateOld.get(i).toString().equals(stateNew.get(i).toString());
      }

      if (contentSame) {
        // Collect all parent & child node
        Set<PhpBasicBlock> neighborsOldList = new HashSet<>();
        neighborsOldList.addAll(Graphs.neighborListOf(gOld.getGraph(), blockOld));
        // Check for same parent&child node
        boolean sameNeighborContent = true;
        for (PhpBasicBlock oldNeighborBlock : neighborsOldList) {
          PhpBasicBlock newNeighborsBlock = mapping.getOrDefault(oldNeighborBlock,null);
          if(newNeighborsBlock != null){
            List<PhpStatement> stateNeighNew = newNeighborsBlock.getBlockStatements();
            List<PhpStatement> stateNeighOld = oldNeighborBlock.getBlockStatements();


            if(stateNeighNew.size() == stateNeighOld.size()) {
              for (int j = 0; j < stateNeighOld.size(); j++) {
                sameNeighborContent &= stateNeighOld.get(j).toString().equals(stateNeighNew.get(j).toString());
              }
            } else {
              sameNeighborContent = false;
            }
          }
        }

        if(sameNeighborContent){
          isChanged = false;
        }
      }
    }

    return isChanged;
  }
}
