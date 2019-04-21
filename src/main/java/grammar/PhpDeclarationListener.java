package grammar;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

import logger.Logger;
import model.ProjectData;
import model.php.PhpClass;
import model.php.PhpFunction;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.misc.Interval;


/**
 * PhpClass PhpDeclarationListener listens for ANTLR event and add what had been found
 * into project data (PhpClass, PhpFunction, Attribute)
 */
public class PhpDeclarationListener extends PhpParserBaseListener {
  private ProjectData projectData;
  private CharStream charStream;
  private StringBuilder unattachedCode;
  private String filename;

  public PhpDeclarationListener(ProjectData projectData, CharStream charStream, String filename) {
    this.projectData = projectData;
    this.charStream = charStream;
    this.filename = filename;
    this.unattachedCode = new StringBuilder();
  }

  @Override
  public void exitTopStatement(PhpParser.TopStatementContext ctx) {
    if(ctx.statement() != null){
      Interval interval = new Interval(ctx.statement().start.getStartIndex(), ctx.statement().stop.getStopIndex());
      unattachedCode.append(charStream.getText(interval));
    }
  }

  @Override
  public void exitClassStatement(PhpParser.ClassStatementContext ctx) {
    super.exitClassStatement(ctx);

    String className = ((PhpParser.ClassDeclarationContext) ctx.parent).identifier().getText();
    PhpClass c = projectData.getClass(className);
    if(c == null){
      c = new PhpClass(className);
      projectData.addClass(c);
    }
    if(ctx.Function() != null){ // Method declaration
      // Get PhpFunction data
      String functionName = ctx.identifier().getText();
      Interval interval = new Interval(ctx.methodBody().start.getStartIndex(), ctx.methodBody().stop.getStopIndex());
      String code = charStream.getText(interval);

      // Parse parameter
      LinkedHashMap<String, String> parameters = new LinkedHashMap<>();
      for(PhpParser.FormalParameterContext formctx : ctx.formalParameterList().formalParameter()) {
        String varName = formctx.variableInitializer().VarName().getText();
        if(formctx.variableInitializer().constantInititalizer() != null){
          parameters.put(varName, formctx.variableInitializer().constantInititalizer().getText());
        } else if (formctx.typeHint() != null){
          parameters.put(varName, formctx.typeHint().getText());
        } else {
          parameters.put(varName, null);
        }
      }

      // Add function to project data
      PhpFunction function = new PhpFunction(functionName, className, code, parameters);
      projectData.addFunction(function);
      c.getFunctionMap().put(functionName, function);

      Logger.info("Function Member " + function.getCalledName() + " found");
    } else if(ctx.variableInitializer().size() != 0){
      for(PhpParser.VariableInitializerContext varContext : ctx.variableInitializer()) {
        String assignedType = "";
        Set<String> type = new HashSet<>();
        type.add(assignedType);
        c.getAttributeMap().put("$this->"+varContext.VarName().getText(), type);

        Logger.info("Attribute Member " + className + "::" + varContext.getText() + " found, initialized with "+assignedType);
      }
    }
  }

  @Override
  public void exitFunctionDeclaration(PhpParser.FunctionDeclarationContext ctx) {
    super.exitFunctionDeclaration(ctx);

    // Get PhpFunction data
    String functionName = ctx.identifier().getText();
    Interval interval = new Interval(ctx.blockStatement().start.getStartIndex(), ctx.blockStatement().stop.getStopIndex());
    String code = charStream.getText(interval);

    // Parse parameter
    LinkedHashMap<String, String> parameters = new LinkedHashMap<>();
    for(PhpParser.FormalParameterContext formctx : ctx.formalParameterList().formalParameter()) {
      String varName = formctx.variableInitializer().VarName().getText();
      if(formctx.variableInitializer().constantInititalizer() != null){
        parameters.put(varName, formctx.variableInitializer().constantInititalizer().getText());
      } else {
        parameters.put(varName, null);
      }
    }

    // Add function to project data
    PhpFunction function = new PhpFunction(functionName, null, code, parameters);
    projectData.addFunction(function);

    Logger.info("PhpFunction " + function.getCalledName() + " found");
  }

  @Override
  public void exitHtmlDocument(PhpParser.HtmlDocumentContext ctx) {
    Logger.info("Found main function in "+filename);
    if(unattachedCode.toString().length() != 0){
      projectData.addFunction(new PhpFunction(filename+"::main", null, unattachedCode.toString(), null));
    }
  }
}
