package model.graph.block.statement;

import model.graph.block.PhpBasicBlock;

abstract public class PhpStatement implements Cloneable {
  protected StatementType statementType;
  protected String statementContent;
  protected boolean endOfBranch; //TODO Remove this
  protected PhpBasicBlock basicBlock;

  PhpStatement(StatementType type, String code) {
    this.statementType = type;
    this.statementContent = code;
  }

  @Override
  public String toString() {
    return "["+this.statementType.toString() + "]";
  }

  @Override
  public PhpStatement clone() throws CloneNotSupportedException {
    PhpStatement phpStatement = (PhpStatement) super.clone();
    phpStatement.statementType = this.statementType;
    phpStatement.statementContent = this.statementContent;
    return phpStatement;
  }

  public StatementType getStatementType() {
    return statementType;
  }

  public String getStatementContent() {
    return statementContent;
  }

  public boolean isEndOfBranch() {
    return endOfBranch;
  }

  public void setEndOfBranch(boolean endOfBranch) {
    this.endOfBranch = endOfBranch;
  }

  public PhpBasicBlock getBasicBlock() {
    return basicBlock;
  }

  public void setBasicBlock(PhpBasicBlock basicBlock) {
    this.basicBlock = basicBlock;
  }
}
