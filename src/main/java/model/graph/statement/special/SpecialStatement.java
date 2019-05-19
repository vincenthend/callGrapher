package model.graph.statement.special;

import model.graph.statement.PhpStatement;
import model.graph.statement.StatementType;

public abstract class SpecialStatement extends PhpStatement {
  protected PhpStatement originalStatement;

  public SpecialStatement(String code) {
    super(StatementType.SPECIAL, code);
  }

  public SpecialStatement(SpecialStatement s){
    super(s);
  }

  public PhpStatement getOriginalStatement() {
    return originalStatement;
  }

  public void setOriginalStatement(PhpStatement originalStatement) {
    this.originalStatement = originalStatement;
  }
}
