package util;

import model.graph.ControlFlowGraph;
import model.graph.similarity.BlockSimilarity;
import model.graph.similarity.BlockSimilarityTable;
import model.graph.similarity.SimilarityTable;
import model.graph.similarity.StatementSimilarity;
import model.graph.statement.PhpStatement;
import model.graph.statement.block.PhpBasicBlock;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class FlowGraphMatcher {
  private static final float ALPHA = 2;
  private static final float BETA = 1;
  private static final float GAMMA = 1;

  private ControlFlowGraph graphOld;
  private ControlFlowGraph graphNew;
  private SimilarityTable similarityTable;
  private BidiMap<PhpStatement, PhpStatement> mapping;

  public FlowGraphMatcher(ControlFlowGraph g1, ControlFlowGraph g2){
    graphOld = g1;
    graphNew = g2;
  }

  /**
   * Count similarity between two {@link PhpBasicBlock}.
   *
   * @param statementOld old/source PhpBasicBlock
   * @param statementNew new/destination PhpBasicBlock
   * @return similarity value between the two block
   */
  private float countSimilarity(PhpStatement statementOld, PhpStatement statementNew) {
    return statementOld.similarTo(statementNew);
  }

  private float countSimilarityNeighbor(List<PhpStatement> statementOld, List<PhpStatement> statementNew) {
    Set<String> oldStatementSet = new HashSet<>();
    Set<String> newStatementSet = new HashSet<>();

    // Create set of string
    for (PhpStatement statement : statementOld) {
      oldStatementSet.add(statement.toString());
    }
    for (PhpStatement statement : statementNew) {
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
   * @return {@link BlockSimilarityTable} between the two graphs.
   */
  private void computeSimilarityTable() {
    similarityTable = new SimilarityTable(graphOld, graphNew);
    Set<PhpStatement> statementSetOld = graphOld.getGraph().vertexSet();
    Set<PhpStatement> statementSetNew = graphNew.getGraph().vertexSet();

    for (PhpStatement statementOld : statementSetOld) {
      for (PhpStatement statementNew : statementSetNew) {
        float simM = countSimilarity(statementOld, statementNew);

        // Get parent block
        Iterator<DefaultEdge> oldBlockEdge = graphOld.getGraph().incomingEdgesOf(statementOld).iterator();
        Iterator<DefaultEdge> newBlockEdge = graphNew.getGraph().incomingEdgesOf(statementNew).iterator();
        List<PhpStatement> combinedOldParent = new ArrayList<>();
        List<PhpStatement> combinedNewParent = new ArrayList<>();
        while (oldBlockEdge.hasNext()) {
          PhpStatement oldStatement = graphOld.getGraph().getEdgeSource(oldBlockEdge.next());
          combinedOldParent.add(oldStatement);
        }
        while (newBlockEdge.hasNext()) {
          PhpStatement newStatement = graphNew.getGraph().getEdgeSource(newBlockEdge.next());
          combinedNewParent.add(newStatement);
        }
        float simM1 = countSimilarityNeighbor(combinedOldParent, combinedNewParent);

        // Get child block
        oldBlockEdge = graphOld.getGraph().outgoingEdgesOf(statementOld).iterator();
        newBlockEdge = graphNew.getGraph().outgoingEdgesOf(statementNew).iterator();
        List<PhpStatement> combinedOldChild = new ArrayList<>();
        List<PhpStatement> combinedNewChild = new ArrayList<>();
        while (oldBlockEdge.hasNext()) {
          PhpStatement oldStatement = graphOld.getGraph().getEdgeTarget(oldBlockEdge.next());
          combinedOldChild.add(oldStatement);
        }
        while (newBlockEdge.hasNext()) {
          PhpStatement newStatement = graphNew.getGraph().getEdgeTarget(newBlockEdge.next());
          combinedNewChild.add(newStatement);
        }
        float simM2 = countSimilarityNeighbor(combinedOldChild, combinedNewChild);

        float similarity = (ALPHA * simM + BETA * simM1 + GAMMA * simM2) / (ALPHA + BETA + GAMMA);
        similarityTable.setSimilarity(statementOld, statementNew, similarity);
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
    Queue<StatementSimilarity> similarities = similarityTable.getSortedSimilarity();

    // Match blocks by iterating queue
    while (!similarities.isEmpty()) {
      StatementSimilarity blockSim = similarities.remove();
      if (!mapping.containsKey(blockSim.getOldBlock()) && !mapping.containsValue(blockSim.getNewBlock())) {
        mapping.put(blockSim.getOldBlock(), blockSim.getNewBlock());
      }
    }
  }

  public float countGraphSimilarity(){
    computeSimilarityTable();
    matchBasicBlock();
    Set<PhpStatement> valueSet = mapping.values();
    float sum = 0;
    int n = Integer.min(graphOld.getGraph().vertexSet().size() , graphNew.getGraph().vertexSet().size());
    for(PhpStatement blockNew : valueSet){
      PhpStatement blockOld = mapping.getKey(blockNew);
      sum += similarityTable.getSimilarity(blockOld, blockNew);
    }

    return valueSet.isEmpty() ? 0 : sum/n;
  }
}
