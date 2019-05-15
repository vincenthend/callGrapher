package model.graph.statement.block;


import model.graph.statement.PhpStatement;

import java.util.Collection;
import java.util.LinkedList;

public class PhpBasicBlock {
  private boolean changed;
  private LinkedList<PhpStatement> blockStatements;

  public PhpBasicBlock() {
    blockStatements = new LinkedList<>();
    changed = false;
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
    if (changed) {
      sb.append("[CHANGED]");
      sb.append("\n");
    }
    for (PhpStatement statement : blockStatements) {
      sb.append(statement.toString());
      sb.append('\n');
    }
    return sb.toString();
  }

  public void setChanged(boolean changed) {
    this.changed = changed;
  }
}
