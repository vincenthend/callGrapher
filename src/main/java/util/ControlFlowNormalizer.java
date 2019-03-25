package util;

import model.ControlFlowGraph;
import model.PhpFunction;
import model.ProjectData;
import model.statement.AssignmentStatement;
import model.statement.FunctionCallStatement;
import model.statement.PhpStatement;
import model.statement.StatementType;
import org.jgrapht.Graphs;

import java.util.*;

public class ControlFlowNormalizer {
  private Map<String, Set<String>> currentVariableList;
  private Stack<Map<String, Set<String>>> variableListStack;
  private PhpFunction currentFunction;
  private ProjectData projectData;

  public ControlFlowNormalizer(PhpFunction function, ProjectData projectData) {
    this.variableListStack = new Stack<>();
    this.currentVariableList = new HashMap<>();
    this.currentFunction = function;
    this.projectData = projectData;
    if (currentFunction.getClassName() != null) {
      Set<String> varType = new HashSet<String>();
      varType.add(currentFunction.getClassName());
      currentVariableList.put("$this", varType);
    }
  }

  public ControlFlowNormalizer(PhpFunction function, Map<String, Set<String>> variableList, ProjectData projectData) {
    this.variableListStack = new Stack<>();
    this.currentVariableList = variableList;
    this.currentFunction = function;
    this.projectData = projectData;
    if (currentFunction.getClassName() != null) {
      Set<String> varType = new HashSet<String>();
      varType.add(currentFunction.getClassName());
      currentVariableList.put("$this", varType);
    }
  }

  public void normalize() {
    ControlFlowGraph cfg = currentFunction.getControlFlowGraph();
    ControlFlowDepthFirstIterator iterator = new ControlFlowDepthFirstIterator(cfg);
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
      } else if (statement.getStatementType() == StatementType.FUNCTION_CALL) {
        // Replace / append function call
        FunctionCallStatement funcCall = (FunctionCallStatement) statement;
        if (funcCall.getCallerVariable() != null) {
          Set<String> variableType = getVariableType(funcCall.getCallerVariable());
          if (variableType != null) {
            for (String type : variableType) {
              // Find and normalize function
              normalizeFuncCall(type, (FunctionCallStatement) statement, cfg);
            }
          }
        } else {
          normalizeFuncCall(null, (FunctionCallStatement) statement, cfg);
        }
      }

      int intersectionSize = iterator.intersectionSize();
      if (intersectionSize > 1) {
        // Push intersectionSize
        for (int i = 0; i < intersectionSize - 1; i++) {
          variableListStack.push(copyVariableStack(currentVariableList)); //TODO
        }
      }
    }
  }

  private void normalizeFuncCall(String type, FunctionCallStatement statement, ControlFlowGraph cfg) {
    try {
      String functionName;
      PhpFunction f;
      if (statement.getFunction().getClassName() == null) {
        if (type != null) {
          functionName = type + "::" + statement.getFunction().getFunctionName();
        } else {
          functionName = statement.getFunction().getFunctionName();
        }
        f = projectData.getFunction(functionName);
      } else {
        f = projectData.getFunction(statement.getFunction().getCalledName());
      }

      if (f != null && !f.getCalledName().equals(currentFunction.getCalledName())) {
        // Clone and normalize functions
        f = f.clone();
        Map<String, Set<String>> functionVariables = remapVariables(statement, f);
        ControlFlowNormalizer norm = new ControlFlowNormalizer(f, functionVariables, projectData);
        //TODO: Return statement
        norm.normalize();
        ControlFlowGraph funcCfg = f.getControlFlowGraph();

        //Append CFG
        List<PhpStatement> succList = Graphs.successorListOf(cfg.getGraph(), statement);
        for (PhpStatement succ : succList) {
          cfg.getGraph().removeEdge(statement, succ);
        }
        Graphs.addGraph(cfg.getGraph(), funcCfg.getGraph());
        cfg.getGraph().addEdge(statement, funcCfg.firstVertex);
        for (PhpStatement lastVert : funcCfg.lastVertices) {
          for (PhpStatement succ : succList) {
            cfg.getGraph().addEdge(lastVert, succ);
          }
        }
      }
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
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
    Set<String> variableType = null;
    if (currentVariableList.containsKey(variable)) {
      variableType = currentVariableList.get(variable);
    }
    return variableType;
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
          if(paramType != null) {
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
