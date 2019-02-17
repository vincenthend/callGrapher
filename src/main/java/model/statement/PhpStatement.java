package model.statement;

abstract public class PhpStatement {
  private StatementType statementType;
  private String statementContent;

  public PhpStatement(StatementType type, String code) {
    this.statementType = type;
    this.statementContent = code;
  }

  public StatementType getStatementType() {
    return statementType;
  }

  public String getStatementContent() {
    return statementContent;
  }

  @Override
  public String toString() {
    return this.statementType.toString() + ":::" + this.statementContent;
  }
}
