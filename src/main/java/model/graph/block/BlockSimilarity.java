package model.graph.block;

import model.graph.ControlFlowBlockGraph;
import org.jgrapht.alg.util.Pair;

import java.util.LinkedHashMap;
import java.util.Map;

public class BlockSimilarity {
  private PhpBasicBlock oldBlock;
  private PhpBasicBlock newBlock;
  private float similarity;

  public BlockSimilarity(PhpBasicBlock oldBlock, PhpBasicBlock newBlock, float similarity) {
    this.oldBlock = oldBlock;
    this.newBlock = newBlock;
    this.similarity = similarity;
  }

  public PhpBasicBlock getOldBlock() {
    return oldBlock;
  }

  public PhpBasicBlock getNewBlock() {
    return newBlock;
  }

  public float getSimilarity() {
    return similarity;
  }
}
