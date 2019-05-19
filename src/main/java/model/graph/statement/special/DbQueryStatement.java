package model.graph.statement.special;

import org.apache.commons.lang3.StringUtils;

public class DbQueryStatement {
  public enum QueryType {
    CREATE,
    RETRIEVE,
    UPDATE,
    DELETE
  }

  private QueryType queryType;

  public DbQueryStatement(String query) {
    String[] result = query.split(" ");
    if (result.length > 0) {
      String type = StringUtils.upperCase(result[0]);
      if (type.equals("DELETE") || type.equals("DROP")) {
        queryType = QueryType.DELETE;
      } else if (type.equals("UPDATE")) {
        queryType = QueryType.UPDATE;
      } else if (type.equals("CREATE") || type.equals("INSERT")) {
        queryType = QueryType.CREATE;
      } else {
        queryType = QueryType.RETRIEVE;
      }
    }
  }

}
