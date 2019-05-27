package model.graph.statement;

import model.graph.statement.block.PhpBasicBlock;
import java.io.Serializable;

abstract public class PhpStatement implements Serializable {
  private int statementId;
  private StatementType statementType;
  private String statementContent;
  transient private PhpBasicBlock basicBlock;

  public PhpStatement(StatementType type, String code) {
    this.statementType = type;
    this.statementContent = code;
    this.statementId = 0;
  }

  public PhpStatement(PhpStatement phpStatement) {
    this.statementType = phpStatement.statementType;
    this.statementId = phpStatement.statementId;
    this.statementContent = phpStatement.statementContent;
  }

  public abstract PhpStatement cloneObject();

  @Override
  public String toString() {
//    return "["+ statementId +"] ["+this.statementType.toString() + "]";
    return "[" + this.statementType.toString() + "]";
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

  public float similarTo(PhpStatement statement) {
    return toString().equals(statement.toString()) ? 1 : 0;
  }
}
