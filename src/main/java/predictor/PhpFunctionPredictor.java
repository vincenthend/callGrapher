package predictor;

import org.apache.commons.lang3.StringUtils;
import predictor.type.PredictedFunctionType;
import model.php.PhpFunction;

import java.util.Arrays;

public class PhpFunctionPredictor {
  public static PredictedFunctionType predictFunctionType(PhpFunction f){
    String functionName = f.getFunctionName();
    if (Arrays.stream(PredictorDataStore.FUNCTION_BUILTIN).parallel().anyMatch(functionName::equals)) {
      return PredictedFunctionType.BUILT_IN;
    }
    functionName = StringUtils.lowerCase(functionName);
    if (Arrays.stream(PredictorDataStore.FUNCTION_VALIDATION).parallel().anyMatch(functionName::contains)) {
      return PredictedFunctionType.VALIDATION;
    } else if (Arrays.stream(PredictorDataStore.FUNCTION_SESSION_SET).parallel().anyMatch(functionName::contains)) {
      return PredictedFunctionType.SESSION_SET;
    } else if (Arrays.stream(PredictorDataStore.FUNCTION_SESSION_UNSET).parallel().anyMatch(functionName::contains)) {
      return PredictedFunctionType.SESSION_UNSET;
    } else if (Arrays.stream(PredictorDataStore.FUNCTION_DATA_CREATE).parallel().anyMatch(functionName::contains)) {
      return PredictedFunctionType.DATA_CREATE;
    } else if (Arrays.stream(PredictorDataStore.FUNCTION_DATA_DELETE).parallel().anyMatch(functionName::contains)) {
      return PredictedFunctionType.DATA_DELETE;
    } else if (Arrays.stream(PredictorDataStore.FUNCTION_DATA_RETRIEVE).parallel().anyMatch(functionName::contains)) {
      return PredictedFunctionType.DATA_RETRIEVE;
    } else if (Arrays.stream(PredictorDataStore.FUNCTION_DATA_UPDATE).parallel().anyMatch(functionName::contains)) {
      return PredictedFunctionType.DATA_UPDATE;
    }
    return PredictedFunctionType.ACTION;
  }
}
