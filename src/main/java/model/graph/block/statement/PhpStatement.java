package model.graph.block.statement;

import model.graph.block.PhpBasicBlock;

abstract public class PhpStatement implements Cloneable {
  protected int statementId;
  protected StatementType statementType;
  protected String statementContent;
  protected PhpBasicBlock basicBlock;

  PhpStatement(StatementType type, String code) {
    this.statementType = type;
    this.statementContent = code;
    this.statementId = 0;
  }

  @Override
  public String toString() {
    return "["+ statementId +"] ["+this.statementType.toString() + "]";
//    return "["+this.statementType.toString() + "]";
  }

  @Override
  public PhpStatement clone() throws CloneNotSupportedException {
    PhpStatement phpStatement = (PhpStatement) super.clone();
    phpStatement.statementType = this.statementType;
    phpStatement.statementContent = this.statementContent;
    phpStatement.statementId = this.statementId;
    return phpStatement;
  }

  public StatementType getStatementType() {
    return statementType;
  }

  public String getStatementContent() {
    return statementContent;
  }

  public PhpBasicBlock getBasicBlock() {
    return basicBlock;
  }

  public void setBasicBlock(PhpBasicBlock basicBlock) {
    this.basicBlock = basicBlock;
  }

  public int getStatementId() {
    return statementId;
  }

  public void setStatementId(int statementId) {
    this.statementId = statementId;
  }
}
