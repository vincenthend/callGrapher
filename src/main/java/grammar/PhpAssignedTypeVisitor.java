package grammar;

import model.ControlFlowGraph;
import model.Function;
import model.ProjectData;
import model.statement.BranchStatement;
import model.statement.ExpressionStatement;
import model.statement.FunctionCallStatement;
import model.statement.PhpStatement;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
