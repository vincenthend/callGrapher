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
    return super.visitMemberAccess(ctx);
  }

  @Override
  public String visitFunctionCallName(PhpParser.FunctionCallNameContext ctx) {
    //projectData.getFunctionMap().get(ctx.)
    return super.visitFunctionCallName(ctx);
  }

  @Override
  public String visitNewExpression(PhpParser.NewExpressionContext ctx) {
    return ctx.newExpr().typeRef().getText();
  }
}
