package predictor;

import predictor.type.PredictedVariableContent;
import predictor.type.PredictedVariableType;

import java.util.*;

public class PhpVariablePredictor {
  private PhpVariablePredictor() {
  }

  public static List<PredictedVariableContent> predictVariableContent(List<String> variables) {
    Iterator<String> iterator = variables.iterator();
    List<PredictedVariableContent> predictedContent = new ArrayList<>();
    while (iterator.hasNext()) {
      predictedContent.add(predictVariableContent(iterator.next()));
    }
    Collections.sort(predictedContent, Comparator.comparing(Enum::toString));
    return predictedContent;
  }

  public static PredictedVariableContent predictVariableContent(String variables) {
    if (variables.startsWith("$") || variables.startsWith("\"") || variables.startsWith("\'")) {
      if (Arrays.stream(PredictorDataStore.VARIABLE_CONTENT_TOKEN).parallel().anyMatch(variables::contains)) {
        return PredictedVariableContent.TOKEN;
      } else if (Arrays.stream(PredictorDataStore.VARIABLE_CONTENT_USER_DATA).parallel().anyMatch(variables::contains)) {
        return PredictedVariableContent.USER_DATA;
      } else if (Arrays.stream(PredictorDataStore.VARIABLE_CONTENT_USER_ROLE).parallel().anyMatch(variables::contains)) {
        return PredictedVariableContent.USER_ROLE;
      } else if (Arrays.stream(PredictorDataStore.VARIABLE_CONTENT_USER_ROLE_NEG).parallel().anyMatch(variables::contains)) {
        return PredictedVariableContent.USER_ROLE_NEG;
      } else if (Arrays.stream(PredictorDataStore.VARIABLE_CONTENT_USER_ROLE_POS).parallel().anyMatch(variables::contains)) {
        return PredictedVariableContent.USER_ROLE_POS;
      }
    }
    return PredictedVariableContent.OTHER;
  }

  public static PredictedVariableType predictVariableType(List<String> variables) {
    Iterator<String> iterator = variables.iterator();
    boolean foundInput = false;
    while (iterator.hasNext() && !foundInput) {
      if (predictVariableType(iterator.next()) == PredictedVariableType.INPUT) {
        foundInput = true;
      }
    }
    if (foundInput) {
      return PredictedVariableType.INPUT;
    } else {
      return PredictedVariableType.DEFINED;
    }
  }

  public static PredictedVariableType predictVariableType(String variables) {
    if (variables.startsWith("$") && Arrays.stream(PredictorDataStore.VARIABLE_TYPE_INPUT).parallel().anyMatch(variables::contains)) {
      return PredictedVariableType.INPUT;
    }
    return PredictedVariableType.DEFINED;
  }
}
