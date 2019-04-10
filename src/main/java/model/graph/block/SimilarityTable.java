package model.graph.block;

import model.graph.ControlFlowBlockGraph;

import java.util.*;

public class SimilarityTable {
  private float[][] similarityMatrix;
  private Map<PhpBasicBlock, Integer> oldBlockMap;
  private Map<Integer, PhpBasicBlock> oldBlockId;
  private Map<PhpBasicBlock, Integer> newBlockMap;
  private Map<PhpBasicBlock, Integer> newBlockId;
  private ControlFlowBlockGraph cfgOld;
  private ControlFlowBlockGraph cfgNew;
  private int nbOldVertex;
  private int nbNewVertex;

  public SimilarityTable(ControlFlowBlockGraph cfgOld, ControlFlowBlockGraph cfgNew) {
    this.oldBlockMap = new LinkedHashMap<>();
    this.newBlockMap = new LinkedHashMap<>();
    this.oldBlockId = new LinkedHashMap<>();
    this.newBlockId = new LinkedHashMap<>();

    this.cfgOld = cfgOld;
    this.cfgNew = cfgNew;

    this.nbOldVertex = cfgOld.getGraph().vertexSet().size();
    this.nbNewVertex = cfgNew.getGraph().vertexSet().size();
    this.similarityMatrix = new float[nbOldVertex][nbNewVertex];
    for (int i = 0; i < nbOldVertex; i++) {
      for (int j = 0; j < nbNewVertex; j++) {
        this.similarityMatrix[i][j] = 0;
      }
    }
  }

  public void setSimilarity(PhpBasicBlock blockOld, PhpBasicBlock blockNew, float similarity) {
    int idxOld = oldBlockMap.getOrDefault(blockOld, -1);
    int idxNew = newBlockMap.getOrDefault(blockNew, -1);
    if (idxOld != -1 && idxNew != -1) {
      // Set similarity value
      similarityMatrix[idxOld][idxNew] = similarity;
    }
  }

  public float getSimilarity(PhpBasicBlock blockOld, PhpBasicBlock blockNew, float similarity) {
    int idxOld = oldBlockMap.getOrDefault(blockOld, -1);
    int idxNew = newBlockMap.getOrDefault(blockNew, -1);
    if (idxOld != -1 && idxNew != -1) {
      // Set similarity value
      return similarityMatrix[idxOld][idxNew];
    } else {
      return -1;
    }
  }

  public Queue<BlockSimilarity> getSortedSimilarity(){
    PriorityQueue<BlockSimilarity> similarityData = new PriorityQueue<>(new Comparator<BlockSimilarity>() {
      @Override
      public int compare(BlockSimilarity o1, BlockSimilarity o2) {
        if(o1.getSimilarity() >= o2.getSimilarity()){
          return -1;
        } else {
          return 1;
        }
      }
    });
    for (int i = 0; i < nbOldVertex; i++) {
      for (int j = 0; j < nbNewVertex; j++) {
        similarityData.add(new BlockSimilarity(oldBlockId.get(i),oldBlockId.get(j),similarityMatrix[i][j]));
      }
    }
    return similarityData;
  }
}
