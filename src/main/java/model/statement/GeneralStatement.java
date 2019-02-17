package model.statement;

public class GeneralStatement extends PhpStatement {
  public GeneralStatement(String code) {
    super(StatementType.GENERAL, code);
  }
}
