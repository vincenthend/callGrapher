package grammar;

import grammar.PhpParser;
import grammar.PhpParserBaseListener;
import model.Function;
import model.ProjectData;

import java.util.HashMap;
import java.util.Map;

public class PhpMethodParserListener extends PhpParserBaseListener {
  public Function function;
  public ProjectData projectData;
  public Map<String, String> varClass;

  public PhpMethodParserListener(Function function, ProjectData projectData) {
    this.function = function;
    this.projectData = projectData;
    varClass = new HashMap<String, String>();
  }

  @Override
  public void exitAssignmentExpression(PhpParser.AssignmentExpressionContext ctx) {
//    System.out.printf("\nAnalyzing %s\n", ctx.getText());
    String varName = ctx.chain(0).getText();
    if (ctx.expression().getText().startsWith("new")) {
      String className = ((PhpParser.NewExpressionContext) ctx.expression()).newExpr().typeRef().getText();
      if (varClass.containsKey("varName")) {
        varClass.replace(varName, className);
      } else {
        varClass.put(varName, className);
      }
    } else {
      String assignmentVar = ctx.expression().getText().split("=")[0];
      if (varClass.containsKey("varName")) {
        varClass.replace(varName, assignmentVar);
      } else {
        varClass.put(varName, assignmentVar);
      }
    }
  }

  @Override
  public void exitFunctionCall(PhpParser.FunctionCallContext ctx) {
    super.exitFunctionCall(ctx);
//    System.out.printf("\nAnalyzing %s\n", ctx.getText());
    String functionName = ctx.functionCallName().getText();

    //Handle primitive functions
    registerConnection(functionName, null);
  }

  @Override
  public void exitMemberAccess(PhpParser.MemberAccessContext ctx) {
    super.exitMemberAccess(ctx);
    if (ctx.actualArguments() != null) {
//      System.out.printf("\nAnalyzing %s\n", ctx.getText());
      String functionName = ctx.keyedFieldName().getText();
      String callerName = ((PhpParser.ChainContext) ctx.parent).chainBase().getText();
      String className;

      if (callerName.equals("$this")) {
        className = function.className;
      } else {
        className = lookupVariableType(callerName);
      }

      registerConnection(functionName, className);
    }
  }

  @Override
  public void exitNewExpression(PhpParser.NewExpressionContext ctx) {
    super.exitNewExpression(ctx);
    String className = ctx.newExpr().typeRef().getText();
    registerConnection("__construct", className);
  }

  //TODO: Move to Function instead?
  private void registerConnection(String functionName, String className){
    StringBuilder sb = new StringBuilder();
    if(className != null) {
      sb.append(className);
      sb.append("::");
    }
    String calledName = sb.append(functionName).toString();

    Function calledFunction;
    if (!projectData.functionMap.containsKey(calledName)) {
      calledFunction = new Function(functionName, className, "");
      projectData.functionMap.put(calledFunction.getCalledName(), calledFunction);
    } else {
      calledFunction = projectData.functionMap.get(calledName);
    }
    function.connections.add(calledFunction);
    System.out.printf("Connected %s with %s\n", function.getCalledName(), calledFunction.getCalledName());
  }

  private String lookupVariableType(String varName) {
    String type = varClass.get(varName);
    while (type.startsWith("$")) {
      type = varClass.get(type);
    }
    return type;
  }
}
