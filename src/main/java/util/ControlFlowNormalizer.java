package util;

import model.ProjectData;
import model.graph.ControlFlowEdge;
import model.graph.ControlFlowGraph;
import model.graph.block.statement.*;
import model.php.PhpFunction;
import org.jgrapht.Graphs;
import org.jgrapht.graph.EdgeReversedGraph;

import java.util.*;

public class ControlFlowNormalizer {
  private Map<String, Set<String>> currentVariableList;
  private PhpFunction currentFunction;
  private ProjectData projectData;
  private ControlFlowGraph cfg;

  public ControlFlowNormalizer(PhpFunction function, ProjectData projectData) {
    this(function, new HashMap<String, Set<String>>(), projectData);
  }

  public ControlFlowNormalizer(PhpFunction function, Map<String, Set<String>> variableList, ProjectData projectData) {
    this.currentVariableList = variableList;
    this.currentFunction = function;
    this.projectData = projectData;
    this.cfg = currentFunction.getControlFlowGraph();
    if (currentFunction.getClassName() != null) {
      Set<String> varType = new HashSet<String>();
      varType.add(currentFunction.getClassName());
      currentVariableList.put("$this", varType);
    }
  }

  /**
   * Normalizes a function by tracking assignment.
   *
   * @return Set of possible return value
   */
  public Set<String> normalize() {
    Set<String> returnType = new HashSet<>();

    ControlFlowGraphDominators cfgd = new ControlFlowGraphDominators(cfg);
    Iterator<PhpStatement> iterator = cfgd.iterator();
    while (iterator.hasNext()) {
      PhpStatement statement = iterator.next();
      if (statement.getStatementType() == StatementType.FUNCTION_CALL) {
        normalizeFunctionCall(statement);
      } else if (statement.getStatementType() == StatementType.RETURN) {
        ReturnStatement returnStatement = (ReturnStatement) statement;
        if (returnStatement.getReturnedVar() != null && getVariableType(returnStatement.getReturnedVar()) != null) {
          returnType.addAll(getVariableType(returnStatement.getReturnedVar()));
        }
      }
    }
    return returnType;
  }

  private void populateAssignment(PhpStatement funcCall){
    EdgeReversedGraph<PhpStatement, ControlFlowEdge> graph = new EdgeReversedGraph<PhpStatement, ControlFlowEdge>(cfg.getGraph());
    ControlFlowDepthFirstIterator iterator = new ControlFlowDepthFirstIterator(graph, funcCall);
    while (iterator.hasNext()) {
      PhpStatement statement = iterator.next();
      if (statement.getStatementType() == StatementType.ASSIGNMENT) {
        AssignmentStatement assignment = (AssignmentStatement) statement;
        Stack<String> assignedTypeStack = new Stack<>();
        Stack<String> finishedTypeStack = new Stack<>();
        assignedTypeStack.push(assignment.getAssignedType());

        while (!assignedTypeStack.isEmpty()) {
          String assignedType = assignedTypeStack.pop();
          if (assignedType.startsWith("$")) {
            Set<String> varTypes = getVariableType(assignedType);
            if (varTypes != null) {
              assignedTypeStack.addAll(varTypes);
            }
          } else {
            finishedTypeStack.push(assignedType);
          }
        }
        addVariableType(assignment.getAssignedVariable(), finishedTypeStack);
      }
    }
  }

  public void normalizeFunctionCall(PhpStatement callStatement) {
    // Find assignment before this statement involving the caller variable
    FunctionCallStatement funcCall = (FunctionCallStatement) callStatement;
    Map<String, Set<String>> origVariableMap = copyVariableStack(currentVariableList);
    populateAssignment(funcCall);

    Set<String> possibleTypes = getVariableType(funcCall.getCallerVariable());
    // Replace function call for all type found
    for (String type : possibleTypes) {
      String functionName;
      PhpFunction f;
      if (funcCall.getFunction().getClassName() == null) {
        if (type != null) {
          functionName = type + "::" + funcCall.getFunction().getFunctionName();
        } else {
          functionName = funcCall.getFunction().getFunctionName();
        }
        f = projectData.getFunction(functionName);
      } else {
        f = projectData.getFunction(funcCall.getFunction().getCalledName());
      }

      if (f != null && !f.getCalledName().equals(currentFunction.getCalledName())) {
        // Clone and normalize functions
        try {
          f = f.clone();
          Map<String, Set<String>> functionVariables = remapVariables(funcCall, f);
          ControlFlowNormalizer norm = new ControlFlowNormalizer(f, functionVariables, projectData);

          //Get function return type and add to variable type
          Set<String> functionReturn = norm.normalize();
          if (functionReturn != null) {
            addVariableType(f.getCalledName(), functionReturn);
          }

          ControlFlowGraph funcCfg = f.getControlFlowGraph();

          //Append CFG
          List<PhpStatement> succList = Graphs.successorListOf(cfg.getGraph(), funcCall);
          for (PhpStatement succ : succList) {
            cfg.getGraph().removeEdge(funcCall, succ);
          }
          Graphs.addGraph(cfg.getGraph(), funcCfg.getGraph());
          cfg.getGraph().addEdge(funcCall, funcCfg.getFirstVertex());
          for (PhpStatement lastVert : funcCfg.getLastVertices()) {
            for (PhpStatement succ : succList) {
              cfg.getGraph().addEdge(lastVert, succ);
            }
          }

        } catch (CloneNotSupportedException e) {
          e.printStackTrace();
        }
      }
    }
    currentVariableList = origVariableMap;
  }

  /**
   * Add type of variable to variable list.
   *
   * @param variable designated variable
   * @param type     type name
   */
  private void addVariableType(String variable, String type) {
    Set<String> variableType;
    if (!currentVariableList.containsKey(variable)) {
      variableType = new HashSet<>();
    } else {
      variableType = currentVariableList.get(variable);
    }
    variableType.add(type);
    currentVariableList.put(variable, variableType);
  }

  /**
   * Add type of variable to variable list.
   *
   * @param variable designated variable
   * @param types    type name
   */
  private void addVariableType(String variable, Collection<? extends String> types) {
    Set<String> variableType;
    if (!currentVariableList.containsKey(variable)) {
      variableType = new HashSet<>();
    } else {
      variableType = currentVariableList.get(variable);
    }
    variableType.addAll(types);
    currentVariableList.put(variable, variableType);
  }

  /**
   * Add type of variable to variable list.
   *
   * @param variable designated variable
   * @return list of variable types
   */
  private Set<String> getVariableType(String variable) {
    return currentVariableList.getOrDefault(variable,new HashSet<>());
  }

  /**
   * Remap variables to function parameters
   *
   * @param function designated function
   * @return variable list
   */
  private Map<String, Set<String>> remapVariables(FunctionCallStatement statement, PhpFunction function) {
    Map<String, Set<String>> variableMap = new HashMap<>();
    Map<String, String> parameterDefault = function.getParameters();
    List<String> parameterContent = statement.getParameterMap();

    Iterator<Map.Entry<String, String>> iterator = parameterDefault.entrySet().iterator();
    Iterator<String> contentIterator = parameterContent.iterator();
    // For each function parameters...
    while (iterator.hasNext()) {
      Map.Entry<String, String> entry = iterator.next();
      Set<String> varType = new HashSet<>();
      if (contentIterator.hasNext()) {
        // if variable exists, add it from current var list
        String paramContent = contentIterator.next();
        if (paramContent.startsWith("$")) {
          Set<String> paramType = getVariableType(paramContent);
          if (paramType != null) {
            varType.addAll(paramType);
          }
        } else {
          varType.add(paramContent);
        }
      } else {
        // if variable doesn't exist, add it from default
        varType.add(entry.getValue());
      }
      variableMap.put(entry.getKey(), varType);
    }

    return variableMap;
  }

  private Map<String, Set<String>> copyVariableStack(Map<String, Set<String>> original) {
    Map<String, Set<String>> copy = new HashMap<>();
    for (Map.Entry<String, Set<String>> entry : original.entrySet()) {
      copy.put(entry.getKey(), new HashSet<String>(entry.getValue()));
    }
    return copy;
  }
}
