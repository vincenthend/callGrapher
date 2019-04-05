package grammar;

import model.ProjectData;

import java.util.HashMap;
import java.util.Map;

public class PhpAssignedTypeVisitor extends PhpParserBaseVisitor<String> {
  public ProjectData projectData;
  public Map<String, String> tempVariableMap;

  public PhpAssignedTypeVisitor(ProjectData projectData) {
    this.projectData = projectData;
    this.tempVariableMap = new HashMap<>();
  }

  @Override
  protected String defaultResult() {
    return "Object";
  }

  @Override
  public String visitMemberAccess(PhpParser.MemberAccessContext ctx) {
    return "$"+ctx.getParent().getText();
  }

  @Override
  public String visitFunctionCallName(PhpParser.FunctionCallNameContext ctx) {
    return "$"+ctx.getText();
  }

  @Override
  public String visitNewExpression(PhpParser.NewExpressionContext ctx) {
    return ctx.newExpr().typeRef().getText();
  }
}
