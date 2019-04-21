package util;

import grammar.PhpParser.ChainExpressionContext;
import model.ProjectData;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PhpAssignedTypeIdentifier {
  /**
   * Identify an assigned object.
   * @param assigned assigned object.
   * @return type of object or variable name if it's a variable
   */
  public static String identify(String assigned){
    // Possible values are : Object, Other
    if(assigned.startsWith("\"") || assigned.startsWith("'") || Character.isDigit(assigned.charAt(0))){
      return "String";
    } else if(assigned.startsWith("[")){
      return "Array";
    } else if(assigned.startsWith("new ")){
      String retval = "Object";
      Pattern p = Pattern.compile("new\\s(.*)\\(", Pattern.MULTILINE);
      Matcher m = p.matcher(assigned);
      while (m.find()) {
        retval = m.group(1);
      }
      return retval;
    } else {
      return assigned;
    }
  }
}
