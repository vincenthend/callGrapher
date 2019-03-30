package model.statement;

abstract public class PhpStatement implements Cloneable {
  private StatementType statementType;
  private String statementContent;
  private boolean endOfBranch;

  PhpStatement(StatementType type, String code) {
    this.statementType = type;
    this.statementContent = code;
  }

  @Override
  public String toString() {
    return "["+this.statementType.toString() + "] " + this.statementContent;
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
}
