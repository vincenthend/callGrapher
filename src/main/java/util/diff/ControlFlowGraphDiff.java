package util.diff;

import model.graph.ControlFlowBlockGraph;
import model.graph.ControlFlowGraph;
import model.graph.block.BlockSimilarity;
import model.graph.block.PhpBasicBlock;
import model.graph.block.SimilarityTable;
import model.graph.block.statement.PhpStatement;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;
import util.ControlFlowGraphTranslator;

import java.util.*;

public class ControlFlowGraphDiff {
  private final float ALPHA = 2;
  private final float BETA = 1;
  private final float GAMMA = 1;

  public ControlFlowBlockGraph diffGraph(ControlFlowGraph g1, ControlFlowGraph g2) {
    ControlFlowBlockGraph b1 = new ControlFlowGraphTranslator(g1).translate();
    ControlFlowBlockGraph b2 = new ControlFlowGraphTranslator(g2).translate();

    SimilarityTable similarityTable = computeSimilarityTable(b1, b2);
    BidiMap<PhpBasicBlock, PhpBasicBlock> blockMatchingMap = matchBasicBlock(similarityTable, b1, b2);

    return diffBlockControlFlowGraph(blockMatchingMap, b1, b2);
  }

  public ControlFlowBlockGraph diffGraphAnnotate(ControlFlowGraph g1, ControlFlowGraph g2) {
    ControlFlowBlockGraph b1 = new ControlFlowGraphTranslator(g1).translate();
    ControlFlowBlockGraph b2 = new ControlFlowGraphTranslator(g2).translate();

    SimilarityTable similarityTable = computeSimilarityTable(b1, b2);
    BidiMap<PhpBasicBlock, PhpBasicBlock> blockMatchingMap = matchBasicBlock(similarityTable, b1, b2);

    return annotateBlockControlFlowGraph(blockMatchingMap, b1, b2);
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
      return (float)intersectSet.size() / (float)unionSet.size();
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
        boolean same = true;
        List<PhpStatement> stateOld = blockOld.getBlockStatements();
        List<PhpStatement> stateNew = blockNew.getBlockStatements();

        if (stateOld.size() == stateNew.size()) {
          for (int i = 0; i < stateOld.size(); i++) {
            if (!stateOld.get(i).toString().equals(stateNew.get(i).toString())) {
              same = false;
            }
          }
        } else {
          same = false;
        }
        if (same) {
          blockGraph.getGraph().removeVertex(blockOld);
        }
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
        boolean same = true;
        List<PhpStatement> stateOld = blockOld.getBlockStatements();
        List<PhpStatement> stateNew = blockNew.getBlockStatements();

        if (stateOld.size() == stateNew.size()) {
          for (int i = 0; i < stateOld.size(); i++) {
            if (!stateOld.get(i).toString().equals(stateNew.get(i).toString())) {
              blockOld.setChanged(true);
            }
          }
        } else {
          blockOld.setChanged(true);
        }
      }
    }
    return blockGraph;
  }
}
