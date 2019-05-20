package predictor;

import model.graph.ControlFlowGraph;
import model.graph.statement.BranchStatement;
import model.graph.statement.FunctionCallStatement;
import model.graph.statement.PhpStatement;
import model.graph.statement.special.SpecialStatement;
import model.graph.statement.special.ValidationStatement;
import org.jgrapht.graph.DefaultEdge;
import predictor.type.PredictedFunctionType;
import predictor.type.PredictedVariableContent;
import predictor.type.PredictedVariableType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PhpStatementPredictor {
  private ControlFlowGraph cfg;

  public PhpStatementPredictor(ControlFlowGraph cfg) {
    this.cfg = cfg;
  }

  public SpecialStatement predictStatement(PhpStatement statement) {
    SpecialStatement returnStatement = null;
    if (statement instanceof BranchStatement) {
      returnStatement = predictStatement((BranchStatement) statement);
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

  private ValidationStatement predictValidation(BranchStatement branchStatement) {
    List<PhpStatement> conditionStatements = branchStatement.getConditionStatements();
    boolean isValidation = false;
    for (PhpStatement st : conditionStatements) {
      if (st instanceof FunctionCallStatement && ((FunctionCallStatement) st).getFunctionType() == PredictedFunctionType.VALIDATION) {
        isValidation = true;
      }
    }
    if (isValidation) {
      boolean isInputVal = false;
      List<PredictedVariableContent> variableTypes = new ArrayList<>();

      for (PhpStatement st : conditionStatements) {
        if (st instanceof FunctionCallStatement && ((FunctionCallStatement) st).getFunctionType() == PredictedFunctionType.VALIDATION) {
          FunctionCallStatement f = (FunctionCallStatement) st;
          variableTypes = PhpVariablePredictor.predictVariableContent(f.getParameterMap());
          if (PhpVariablePredictor.predictVariableType(f.getParameterMap()) == PredictedVariableType.INPUT) {
            isInputVal = true;
          }
        }
      }
      for (int i = 0; i < branchStatement.getConditionStatements().size(); i++) {
        List<DefaultEdge> out = new ArrayList<>(cfg.getGraph().outgoingEdgesOf(branchStatement));
        for (int j = 0; j < out.size(); j++) {
          PhpStatement target = cfg.getGraph().getEdgeTarget(out.get(j));
          cfg.removeStatement(target);
        }
      }
      return new ValidationStatement(branchStatement, isInputVal, variableTypes);
    }

    return null;
  }
}
