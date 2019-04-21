package util;

import grammar.PhpParser.ChainExpressionContext;
import model.ProjectData;

import java.util.HashMap;
import java.util.Map;

public final class PhpAssignedTypeIdentifier {
  /**
   * Identify an assigned object.
   * @param assigned assigned object.
   * @return type of object or variable name if it's a variable
   */
  public static String identify(String assigned){
    // Possible values are : Object, Other
    if(assigned.startsWith("\"") || assigned.startsWith("'") || Character.isDigit(assigned.charAt(0))){
      return "String ";
    } else if(assigned.startsWith("[")){
      return "Array";
    } else {
      return assigned;
    }
  }
}
