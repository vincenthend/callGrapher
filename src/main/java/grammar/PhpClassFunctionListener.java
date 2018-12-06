package grammar;

import grammar.PhpParser;
import grammar.PhpParserBaseListener;
import model.Function;
import model.ProjectData;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.misc.Interval;

public class PhpClassFunctionListener extends PhpParserBaseListener {
  public ProjectData projectData;
  public CharStream charStream;

  public PhpClassFunctionListener(ProjectData projectData, CharStream charStream) {
    this.projectData = projectData;
    this.charStream = charStream;
  }

  @Override
  public void exitClassStatement(PhpParser.ClassStatementContext ctx) {
    super.exitClassStatement(ctx);
    // Method declaration
    if(ctx.Function() != null){
      String className = ((PhpParser.ClassDeclarationContext)ctx.parent).identifier().getText();
      String functionName = ctx.identifier().getText();
      Interval interval = new Interval (ctx.methodBody().start.getStartIndex(), ctx.methodBody().stop.getStopIndex());
      String code = charStream.getText(interval);
      Function function = new Function(functionName, className, code);
      projectData.add(function);
    }
  }

  @Override
  public void exitFunctionDeclaration(PhpParser.FunctionDeclarationContext ctx) {
    super.exitFunctionDeclaration(ctx);
    String functionName = ctx.identifier().getText();
    Interval interval = new Interval (ctx.blockStatement().start.getStartIndex(), ctx.blockStatement().stop.getStopIndex());
    String code = charStream.getText(interval);
    Function function = new Function(functionName, null, code);
    projectData.add(function);
  }
}
