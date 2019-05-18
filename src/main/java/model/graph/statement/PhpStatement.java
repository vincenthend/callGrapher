package model.graph.statement;

import model.graph.statement.block.PhpBasicBlock;

abstract public class PhpStatement {
  protected int statementId;
  protected StatementType statementType;
  protected String statementContent;
  protected PhpBasicBlock basicBlock;

  PhpStatement(StatementType type, String code) {
    this.statementType = type;
    this.statementContent = code;
    this.statementId = 0;
  }

  PhpStatement(PhpStatement phpStatement){
    this.statementType = phpStatement.statementType;
    this.statementId = phpStatement.statementId;
    this.statementContent = phpStatement.statementContent;
  }

  public abstract PhpStatement cloneObject();

  @Override
  public String toString() {
//    return "["+ statementId +"] ["+this.statementType.toString() + "]";
    return "["+this.statementType.toString() + "]";
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
