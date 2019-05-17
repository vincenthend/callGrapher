package util.builder;

import java.util.*;
import java.util.Map.Entry;

import logger.Logger;
import model.ProjectData;
import model.graph.ControlFlowGraph;
import model.graph.statement.AssignmentStatement;
import model.graph.statement.FunctionCallStatement;
import model.graph.statement.PhpStatement;
import model.graph.statement.ReturnStatement;
import model.graph.statement.StatementType;
import model.php.PhpClass;
import model.php.PhpFunction;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.EdgeReversedGraph;
import util.iterator.ControlFlowDepthFirstIterator;

public class ControlFlowNormalizer {
  private ProjectData projectData;
  private static int space = 0;
  public ControlFlowNormalizer(ProjectData projectData) {
    this.projectData = projectData;
  }

  /**
   * Normalizes a function defined in the constructor by tracking assignment.
   *
   * @return Set of possible return value
   */
  public Set<String> normalize(PhpFunction function) {
    return normalize(function, new HashMap<>());
  }

  public Set<String> normalize(PhpFunction currentFunction, Map<String, Set<String>> functionVar){
    Map<String, Set<String>> varList = functionVar;
    Set<String> returnType = new HashSet<>();

    if(currentFunction.getClassName() != null && !currentFunction.getFunctionName().equals("__construct")){
      // Normalize class constructor
      if(!projectData.getClass(currentFunction.getClassName()).isConstructorNorm()) {
        normalizeConstructor(projectData.getClass(currentFunction.getClassName()));
      }
      mergeVariableMap(varList, projectData.getClass(currentFunction.getClassName()).getAttributeMap());
    }
    addVariableType(varList,"$this", currentFunction.getClassName());
    ControlFlowGraphDominators cfgd = new ControlFlowGraphDominators(currentFunction.getControlFlowGraph());
    Iterator<PhpStatement> iterator = cfgd.iterator();
    while (iterator.hasNext()) {
      PhpStatement statement = iterator.next();
      if (statement.getStatementType() == StatementType.FUNCTION_CALL) {
        // If function call is found, normalize statement and merge the return type to current
        varList = normalizeFunctionCall(currentFunction, varList, statement);
      } else if (statement.getStatementType() == StatementType.RETURN) {
        // If return is found, take note of the returned type
        ReturnStatement returnStatement = (ReturnStatement) statement;
        if (returnStatement.getReturnedVar() != null && getVariableType(varList, returnStatement.getReturnedVar()) != null) {
          returnType.addAll(getVariableType(varList, returnStatement.getReturnedVar()));
        }
      }
    }
    return returnType;
  }

  private void normalizeConstructor(PhpClass c){
    System.out.println(c.getClassName());
    Map<String, Set<String>> varMap = c.getAttributeMap();

    String classConstructor = c.getClassName() + "::__construct";
    PhpFunction constructorFunction = projectData.getFunctionMap().get(classConstructor);

    // Add constructor parameters
    if(constructorFunction != null) {
      if(constructorFunction.getParameters() != null) {
        for (Entry<String, String> entry : constructorFunction.getParameters().entrySet()) {
          // If parameter has typehint
          if(entry.getKey() != null) {
            Set<String> type = new HashSet();
            type.add(entry.getValue());
            varMap.put(entry.getKey(), type);
          }
        }
      }

      ControlFlowGraphDominators cfgd = new ControlFlowGraphDominators(
          constructorFunction.getControlFlowGraph());
      Iterator<PhpStatement> iterator = cfgd.iterator();
      while (iterator.hasNext()) {
        PhpStatement statement = iterator.next();
        if (statement.getStatementType() == StatementType.FUNCTION_CALL) {
          // If function call is found, normalize statement and merge the return type to current
          varMap = normalizeFunctionCall(constructorFunction, varMap, statement);
        } else if(statement.getStatementType() == StatementType.ASSIGNMENT){
          AssignmentStatement assignment = (AssignmentStatement) statement;
          Deque<String> assignedTypeStack = new ArrayDeque<>();
          Deque<String> finishedTypeStack = new ArrayDeque<>();
          if(assignment.getAssignedType() != null) {
            assignedTypeStack.push(assignment.getAssignedType());
          }
            // Handle chain call
          while (!assignedTypeStack.isEmpty()) {
            String assignedType = assignedTypeStack.pop();
            if(assignedType != null) {
              if (assignedType.startsWith("$")) {
                Set<String> varTypes = getVariableType(varMap, assignedType);
                if (varTypes != null) {
                  assignedTypeStack.addAll(varTypes);
                }
              } else {
                finishedTypeStack.push(assignedType);
              }
            }
          }
          // Add it to the stack
          addVariableType(varMap, assignment.getAssignedVariable(), finishedTypeStack);
        }
      }
      c.setAttributeMap(varMap);
    }
    c.setConstructorNorm(true);
  }

  /**
   * Populate variable map for all assignment statement before this function call.
   * @param funcCall current function call
   * @return variable map
   */
  private Map<String, Set<String>> populateAssignment(PhpFunction function, PhpStatement funcCall) {
    EdgeReversedGraph<PhpStatement, DefaultEdge> graph = new EdgeReversedGraph<>(function.getControlFlowGraph().getGraph());
    Map<String, Set<String>> varMap = new HashMap<>();

    ControlFlowDepthFirstIterator iterator = new ControlFlowDepthFirstIterator(graph, funcCall);
    while (iterator.hasNext()) {
      PhpStatement statement = iterator.next();
      // If found an assignment statement
      if (statement.getStatementType() == StatementType.ASSIGNMENT) {
        AssignmentStatement assignment = (AssignmentStatement) statement;
        Deque<String> assignedTypeStack = new ArrayDeque<>();
        Deque<String> finishedTypeStack = new ArrayDeque<>();
        assignedTypeStack.push(assignment.getAssignedType());

        // Handle chain call
        while (!assignedTypeStack.isEmpty()) {
          String assignedType = assignedTypeStack.pop();
          if (assignedType.startsWith("$")) {
            Set<String> varTypes = getVariableType(varMap, assignedType);
            if (varTypes != null) {
              assignedTypeStack.addAll(varTypes);
            }
          } else {
            finishedTypeStack.push(assignedType);
          }
        }

        // Add it to the stack
        addVariableType(varMap, assignment.getAssignedVariable(), finishedTypeStack);
      }
    }

    return varMap;
  }

  /**
   * Normalizes a function call statement.
   * @param callStatement
   */
  public Map<String, Set<String>> normalizeFunctionCall(PhpFunction currentFunction, Map<String, Set<String>> previousVarMap, PhpStatement callStatement) {
    // Initialize variable map with constructor defined variables
    FunctionCallStatement funcCall = (FunctionCallStatement) callStatement;
    Map<String, Set<String>> initialVarMap;
    Map<String, Set<String>> returnVarMap;

    initialVarMap = new HashMap<>();
    returnVarMap = new HashMap<>();

    mergeVariableMap(initialVarMap, populateAssignment(currentFunction, funcCall));
    mergeVariableMap(initialVarMap, previousVarMap);
    mergeVariableMap(returnVarMap, previousVarMap);

    // List all possible types
    Set<String> possibleTypes = getVariableType(initialVarMap, funcCall.getCallerVariable());
    List<PhpFunction> functionList = new ArrayList<>();

    // List all possible function for this statement
    // Handle if it has a possible type, if it is a local function, or if the class name has been defined
    for (String type : possibleTypes) {
      PhpFunction f;
      f = projectData.getFunction(type + "::" + funcCall.getFunction().getFunctionName());
      // If f is found and f is not the same function (recursive) add it to functionList
      if (f != null && !f.getCalledName().equals(currentFunction.getCalledName())) {
        functionList.add(f);
      }
    }

    // if function has no class name
    PhpFunction f = projectData.getFunction(funcCall.getFunction().getFunctionName());
    if (f != null && !f.getCalledName().equals(currentFunction.getCalledName())) {
      functionList.add(f);
    }

    // if class name has been found from the start
    if (funcCall.getFunction().getClassName() != null) {
      f = projectData.getFunction(funcCall.getFunction().getCalledName());
      if (f != null && !f.getCalledName().equals(currentFunction.getCalledName())) {
        functionList.add(f);
      }
    }

    // For each possible functions, add the return to variable map,
    if(!functionList.isEmpty()){
      // Remove connection between successor and funccall
      List<PhpStatement> succList = Graphs.successorListOf(currentFunction.getControlFlowGraph().getGraph(), funcCall);
      for (PhpStatement succ : succList) {
        currentFunction.getControlFlowGraph().getGraph().removeEdge(funcCall, succ);
      }

      for (PhpFunction function : functionList) {
        // Clone and normalize functions
        try {
          f = function.clone();
          Map<String, Set<String>> functionVariables = remapVariables(initialVarMap, funcCall, f);

          //Get function return type and add it to variable map
          System.out.println(space+" - Normalize "+f.getCalledName()+" from "+currentFunction.getCalledName());
          space++;
          Set<String> functionReturn = normalize(f, functionVariables);
          space--;
          if (functionReturn != null) {
            addVariableType(returnVarMap, callStatement.getStatementContent(), functionReturn);
          }

          ControlFlowGraph funcCfg = f.getControlFlowGraph();

          //Append CFG to func call and successor
          currentFunction.getControlFlowGraph().appendGraph(funcCall, funcCfg);
          for (PhpStatement lastVert : funcCfg.getLastVertices()) {
            for (PhpStatement succ : succList) {
              currentFunction.getControlFlowGraph().getGraph().addEdge(lastVert, succ);
            }
          }

          // Add last vertices if funccall is the last statement
          if(succList.isEmpty()){
            currentFunction.getControlFlowGraph().getLastVertices().remove(funcCall);
            currentFunction.getControlFlowGraph().getLastVertices().addAll(funcCfg.getLastVertices());
          }
        } catch (CloneNotSupportedException e) {
          Logger.error("Failed to clone");
        }
      }
    }

    return returnVarMap;
  }

  /**
   * Add type of variable to variable list.
   *
   * @param variable designated variable
   * @param type     type name
   */
  private void addVariableType(Map<String, Set<String>> varList, String variable, String type) {
    Set<String> variableType;
    if (!varList.containsKey(variable)) {
      variableType = new HashSet<>();
    } else {
      variableType = varList.get(variable);
    }
    variableType.add(type);
    varList.put(variable, variableType);
  }

  /**
   * Add type of variable to variable list.
   *
   * @param variable designated variable
   * @param types    type name
   */
  private void addVariableType(Map<String, Set<String>> varList, String variable, Collection<? extends String> types) {
    Set<String> variableType;
    if (!varList.containsKey(variable)) {
      variableType = new HashSet<>();
    } else {
      variableType = varList.get(variable);
    }
    variableType.addAll(types);
    varList.put(variable, variableType);
  }

  /**
   * Add type of variable to variable list.
   *
   * @param variable designated variable
   * @return list of variable types
   */
  private Set<String> getVariableType(Map<String, Set<String>> varList, String variable) {
    return varList.getOrDefault(variable, new HashSet<>());
  }

  /**
   * Remap variables to function parameters
   *
   * @param function designated function
   * @return variable list
   */
  private Map<String, Set<String>> remapVariables(Map<String, Set<String>> currentVar, FunctionCallStatement statement, PhpFunction function) {
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
          Set<String> paramType = getVariableType(currentVar, paramContent);
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
      copy.put(entry.getKey(), new HashSet<>(entry.getValue()));
    }
    return copy;
  }

  private void mergeVariableMap(Map<String, Set<String>> m1, Map<String, Set<String>> m2){
    for(Entry<String, Set<String>> variable : m2.entrySet()){
      if(m1.containsKey(variable.getKey())){
        m1.get(variable.getKey()).addAll(variable.getValue());
      } else {
        m1.put(variable.getKey(), variable.getValue());
      }
    }
  }
}
