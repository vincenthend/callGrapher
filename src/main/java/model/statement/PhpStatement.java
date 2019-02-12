package model.statement;

public class PhpStatement {
  private StatementType statementType;
  private String statementContent;

  public PhpStatement(String functionName, String className, String code) {
  }

  public StatementType getStatementType() {
    return statementType;
  }

  public String getStatementContent() {
    return statementContent;
  }
}
