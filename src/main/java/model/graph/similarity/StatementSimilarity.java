package model.graph.similarity;

import model.graph.statement.PhpStatement;
import model.graph.statement.block.PhpBasicBlock;

public class StatementSimilarity {
  private PhpStatement oldBlock;
  private PhpStatement newBlock;
  private float similarity;

  public StatementSimilarity(PhpStatement oldBlock, PhpStatement newBlock, float similarity) {
    this.oldBlock = oldBlock;
    this.newBlock = newBlock;
    this.similarity = similarity;
  }

  public PhpStatement getOldBlock() {
    return oldBlock;
  }

  public PhpStatement getNewBlock() {
    return newBlock;
  }

  public float getSimilarity() {
    return similarity;
  }
}
