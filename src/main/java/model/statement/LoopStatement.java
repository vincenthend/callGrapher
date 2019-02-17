package model.statement;

public class LoopStatement extends PhpStatement {
  private boolean isStart;

  public LoopStatement(String code, boolean isStart) {
    super(StatementType.LOOP, code);
    this.isStart = isStart;
  }
}
