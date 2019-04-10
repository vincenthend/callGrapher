package model.graph.block;

import model.graph.block.statement.PhpStatement;

import java.util.Collection;
import java.util.LinkedList;

public class PhpBasicBlock {
  private LinkedList<PhpStatement> blockStatements;

  public PhpBasicBlock() {
    blockStatements = new LinkedList<>();
  }

  public void addStatement(PhpStatement statement) {
    blockStatements.add(statement);
  }

  public void addStatement(Collection<? extends PhpStatement> statement) {
    blockStatements.addAll(statement);
  }

  public LinkedList<PhpStatement> getBlockStatements() {
    return blockStatements;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (PhpStatement statement : blockStatements) {
      sb.append(statement.toString());
      sb.append('\n');
    }
    return sb.toString();
  }
}
