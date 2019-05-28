package model.graph.statement.special;

import model.graph.statement.FunctionCallStatement;
import model.graph.statement.PhpStatement;
import org.apache.commons.lang3.StringUtils;

public class DbQueryStatement extends SpecialStatement {
  public enum QueryType {
    CREATE,
    RETRIEVE,
    UPDATE,
    DELETE
  }

  private QueryType queryType;
  private FunctionCallStatement functionCallStatement;

  public DbQueryStatement(String query, FunctionCallStatement statement) {
    super(query);
    String[] result = query.split(" ");
    if (result.length > 0) {
      String type = StringUtils.upperCase(result[0]);
      if (type.contains("DELETE") || type.contains("DROP")) {
        queryType = QueryType.DELETE;
      } else if (type.contains("UPDATE")) {
        queryType = QueryType.UPDATE;
      } else if (type.contains("CREATE") || type.contains("INSERT")) {
        queryType = QueryType.CREATE;
      } else {
        queryType = QueryType.RETRIEVE;
      }
    }
    functionCallStatement = statement;
  }

  public DbQueryStatement(DbQueryStatement d) {
    super(d.getStatementContent());
    queryType = d.queryType;
    functionCallStatement = (FunctionCallStatement) d.functionCallStatement.cloneObject();
  }

  @Override
  public PhpStatement cloneObject() {
    return new DbQueryStatement(this);
  }

  @Override
  public String toString() {
    return "[QUERY] " + queryType;
  }
}
