package model.statement;

import sun.invoke.empty.Empty;

public class IgnoredStatement extends PhpStatement {
  public enum IgnoredType{
    STARTBLOCK,
    ENDBLOCK,
    EMPTY,
  }

  private IgnoredType ignoredType;

  public IgnoredStatement(IgnoredType type) {
    super(StatementType.IGNORED, "");
    ignoredType = type;
  }
}
