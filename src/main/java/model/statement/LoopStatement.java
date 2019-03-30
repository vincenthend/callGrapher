package model.statement;

public class LoopStatement extends PhpStatement {

  public LoopStatement(String code) {
    super(StatementType.LOOP, code);
  }
}
