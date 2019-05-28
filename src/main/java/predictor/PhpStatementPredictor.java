package predictor;

import model.graph.ControlFlowGraph;
import model.graph.statement.*;
import model.graph.statement.special.DbQueryStatement;
import model.graph.statement.special.IncludeStatement;
import model.graph.statement.special.SpecialStatement;
import model.graph.statement.special.ValidationStatement;
import model.php.PhpFunction;
import org.jgrapht.graph.DefaultEdge;
import predictor.type.PredictedFunctionType;
import predictor.type.PredictedVariableContent;
import predictor.type.PredictedVariableType;

import java.util.ArrayList;
import java.util.List;

public class PhpStatementPredictor {
  private ControlFlowGraph cfg;

  public PhpStatementPredictor(ControlFlowGraph cfg) {
    this.cfg = cfg;
  }

  public SpecialStatement predictStatement(PhpStatement statement) {
    SpecialStatement returnStatement = null;
    if (statement instanceof BranchStatement) {
      returnStatement = predictStatement((BranchStatement) statement);
    } else if (statement instanceof ExpressionStatement){
      returnStatement = predictStatement((ExpressionStatement) statement);
    } else if (statement instanceof FunctionCallStatement){
      returnStatement = predictStatement((FunctionCallStatement) statement);
    }
    return returnStatement;
  }

  public SpecialStatement predictStatement(BranchStatement branchStatement) {
    SpecialStatement validationStatement = predictValidation(branchStatement);
    if (validationStatement != null) {
      return validationStatement;
    } else {
      return null;
    }
  }

  public SpecialStatement predictStatement(ExpressionStatement expressionStatement) {
    SpecialStatement includeStatement = predictInclude(expressionStatement);
    if (includeStatement != null) {
      return includeStatement;
    } else {
      return null;
    }
  }

  public SpecialStatement predictStatement(FunctionCallStatement functionCallStatement) {
    SpecialStatement queryStatement = predictQuery(functionCallStatement);
    if (queryStatement != null) {
      return queryStatement;
    } else {
      return null;
    }
  }

  private IncludeStatement predictInclude(ExpressionStatement expressionStatement) {
    if(expressionStatement.getExpressionType().equals("include") ){
      return new IncludeStatement(expressionStatement);
    } else {
      return null;
    }
  }

  private DbQueryStatement predictQuery(FunctionCallStatement functionCall) {
    String functionName = functionCall.getFunction().getFunctionName();
    if(functionName.contains("mysql_query") || functionName.contains("mysqli_query") ){
      return new DbQueryStatement(functionCall.getParameterMap().toString(), functionCall);
    } else {
      return null;
    }
  }

  private ValidationStatement predictValidation(BranchStatement branchStatement) {
    List<PhpStatement> branchConditionStatements = branchStatement.getConditionStatements();
    boolean isValidation = false;
    for (PhpStatement st : branchConditionStatements) {
      if (st instanceof FunctionCallStatement && ((FunctionCallStatement) st).getFunctionType() == PredictedFunctionType.VALIDATION) {
        isValidation = true;
      }
    }
    if (isValidation) {
      boolean isInputVal = false;
      List<PredictedVariableContent> variableTypes = new ArrayList<>();

      for (PhpStatement st : branchConditionStatements) {
        if (st instanceof FunctionCallStatement && ((FunctionCallStatement) st).getFunctionType() == PredictedFunctionType.VALIDATION) {
          FunctionCallStatement f = (FunctionCallStatement) st;
          variableTypes = PhpVariablePredictor.predictVariableContent(f.getParameterMap());
          if (PhpVariablePredictor.predictVariableType(f.getParameterMap()) == PredictedVariableType.INPUT) {
            isInputVal = true;
          }
        }
      }

      List<PhpStatement> removeConditionStatements = new ArrayList<>();
      PhpStatement removeRoot = branchStatement;
      for (int i = 0; i < branchStatement.getConditionStatements().size(); i++) {
        List<DefaultEdge> out = new ArrayList<>(cfg.getGraph().outgoingEdgesOf(removeRoot));
        boolean found = false;
        for (int j = 0; j < out.size(); j++) {
          PhpStatement childStatement = cfg.getGraph().getEdgeTarget(out.get(j));
          if (found == false && childStatement.getStatementType() == StatementType.FUNCTION_CALL && ((FunctionCallStatement) childStatement).getFunctionType() == PredictedFunctionType.VALIDATION) {
            found = true;
            removeRoot = childStatement;
            removeConditionStatements.add(childStatement);
          }
        }
      }
      for(PhpStatement st : removeConditionStatements){
        cfg.removeStatement(st);
      }

      return new ValidationStatement(branchStatement, isInputVal, variableTypes);
    }

    return null;
  }
}
