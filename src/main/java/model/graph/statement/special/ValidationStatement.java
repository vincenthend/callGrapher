package model.graph.statement.special;

import model.graph.statement.BranchStatement;
import predictor.PhpVariablePredictor;
import predictor.type.PredictedVariableContent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationStatement extends SpecialStatement {
  private boolean inputValidation;
  private Set<PredictedVariableContent> variableTypes;

  public ValidationStatement(BranchStatement b, boolean inputValidation, List<PredictedVariableContent> variableTypes) {
    super(b.getStatementContent());
    this.originalStatement = b;
    this.inputValidation = inputValidation;
    this.variableTypes = new HashSet<>(variableTypes);
  }

  public ValidationStatement(ValidationStatement s) {
    super(s);
    this.originalStatement = s.originalStatement;
    this.inputValidation = s.inputValidation;
    this.variableTypes = s.variableTypes;
  }

  @Override
  public ValidationStatement cloneObject() {
    return new ValidationStatement(this);
  }

  @Override
  public String toString() {
    if(inputValidation){
      return "[INPUT_VALIDATION]" + variableTypes;
    } else {
      return "[VALIDATION]"+variableTypes;
    }
  }
}
