package model.graph.similarity;

import model.graph.ControlFlowGraph;
import model.graph.statement.PhpStatement;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SimilarityTable {
  private float[][] similarityMatrix;
  private Map<PhpStatement, Integer> oldStatementMap;
  private Map<Integer, PhpStatement> oldStatementId;
  private Map<PhpStatement, Integer> newStatementMap;
  private Map<Integer, PhpStatement> newStatementId;
  private int nbOldVertex;
  private int nbNewVertex;

  public SimilarityTable(ControlFlowGraph cfgOld, ControlFlowGraph cfgNew) {
    this.oldStatementMap = new LinkedHashMap<>();
    this.newStatementMap = new LinkedHashMap<>();
    this.oldStatementId = new LinkedHashMap<>();
    this.newStatementId = new LinkedHashMap<>();

    // Map matrix ID and block
    int n = 0;
    for(PhpStatement statement: cfgOld.getGraph().vertexSet()){
      oldStatementMap.put(statement,n);
      oldStatementId.put(n,statement);
      n++;
    }
    n = 0;
    for(PhpStatement statement : cfgNew.getGraph().vertexSet()){
      newStatementMap.put(statement,n);
      newStatementId.put(n,statement);
      n++;
    }

    this.nbOldVertex = cfgOld.getGraph().vertexSet().size();
    this.nbNewVertex = cfgNew.getGraph().vertexSet().size();
    this.similarityMatrix = new float[nbOldVertex][nbNewVertex];
    for (int i = 0; i < nbOldVertex; i++) {
      for (int j = 0; j < nbNewVertex; j++) {
        this.similarityMatrix[i][j] = 0;
      }
    }
  }

  public void setSimilarity(PhpStatement blockOld, PhpStatement blockNew, float similarity) {
    int idxOld = oldStatementMap.getOrDefault(blockOld, -1);
    int idxNew = newStatementMap.getOrDefault(blockNew, -1);
    if (idxOld != -1 && idxNew != -1) {
      // Set similarity value
      similarityMatrix[idxOld][idxNew] = similarity;
    }
  }

  public float getSimilarity(PhpStatement blockOld, PhpStatement blockNew) {
    int idxOld = oldStatementMap.getOrDefault(blockOld, -1);
    int idxNew = newStatementMap.getOrDefault(blockNew, -1);
    if (idxOld != -1 && idxNew != -1) {
      // Set similarity value
      return similarityMatrix[idxOld][idxNew];
    } else {
      return -1;
    }
  }

  public Queue<StatementSimilarity> getSortedSimilarity(){
    PriorityQueue<StatementSimilarity> similarityData = new PriorityQueue<>((o1, o2) -> {
      if(o1.getSimilarity() >= o2.getSimilarity()){
        return -1;
      } else {
        return 1;
      }
    });
    for (int i = 0; i < nbOldVertex; i++) {
      for (int j = 0; j < nbNewVertex; j++) {
        similarityData.add(new StatementSimilarity(oldStatementId.get(i), newStatementId.get(j),similarityMatrix[i][j]));
      }
    }
    return similarityData;
  }
}
