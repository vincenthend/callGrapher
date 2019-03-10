package grammar;

import logger.Logger;
import model.PhpClass;
import model.PhpFunction;
import model.ProjectData;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.misc.Interval;

import java.util.LinkedList;


/**
 * PhpClass PhpClassFunctionListener listens for ANTLR event and add what had been found
 * into project data (PhpClass, PhpFunction, Attribute)
 */
public class PhpClassFunctionListener extends PhpParserBaseListener {
  private ProjectData projectData;
  private CharStream charStream;

  public PhpClassFunctionListener(ProjectData projectData, CharStream charStream) {
    this.projectData = projectData;
    this.charStream = charStream;
  }

  @Override
  public void exitClassStatement(PhpParser.ClassStatementContext ctx) {
    super.exitClassStatement(ctx);

    String className = ((PhpParser.ClassDeclarationContext)ctx.parent).identifier().getText();
    PhpClass c = projectData.getClass(className);
    if(c == null){
      c = new PhpClass(className);
      projectData.addClass(c);
    }
    if(ctx.Function() != null){ // Method declaration
      // Get PhpFunction data
      String functionName = ctx.identifier().getText();
      Interval interval = new Interval (ctx.methodBody().start.getStartIndex(), ctx.methodBody().stop.getStopIndex());
      String code = charStream.getText(interval);

      // Add function to project data
      PhpFunction function = new PhpFunction(functionName, className, code);
      projectData.addFunction(function);
      c.getFunctionMap().put(functionName,function);

      Logger.info("Function Member "+function.getCalledName()+" found");
    } else if(ctx.variableInitializer().size() != 0){
      for(PhpParser.VariableInitializerContext varContext : ctx.variableInitializer()){
        c.getAttributeMap().put(varContext.getText(),new LinkedList<>());

        Logger.info("Attribute Member "+className+"::"+varContext.getText()+" found");
      }
    }
  }

  @Override
  public void exitFunctionDeclaration(PhpParser.FunctionDeclarationContext ctx) {
    super.exitFunctionDeclaration(ctx);

    // Get PhpFunction data
    String functionName = ctx.identifier().getText();
    Interval interval = new Interval (ctx.blockStatement().start.getStartIndex(), ctx.blockStatement().stop.getStopIndex());
    String code = charStream.getText(interval);

    // Add function to project data
    PhpFunction function = new PhpFunction(functionName, null, code);
    projectData.addFunction(function);

    Logger.info("PhpFunction "+function.getCalledName()+" found");
  }
}
