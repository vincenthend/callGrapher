package util;

import model.ControlFlowGraph;
import model.statement.AssignmentStatement;
import model.statement.PhpStatement;
import model.statement.StatementType;
import org.jgrapht.Graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public final class ControlFlowNormalizer {
  public static void normalize(ControlFlowGraph cfg) {
    Stack<Map<String, String>> variableListStack;
    Map<String, String> currentVariableList;

    variableListStack = new Stack<>();
    currentVariableList = new HashMap<>();

    ControlFlowDepthFirstIterator iterator = new ControlFlowDepthFirstIterator(cfg);
    while(iterator.hasNext()){
      PhpStatement statement = iterator.next();
      if(statement.getStatementType() == StatementType.ASSIGNMENT){
        AssignmentStatement assignment = (AssignmentStatement) statement;
        currentVariableList.put(assignment.getAssignedVariable(), assignment.getAssignedType());
      } else if (statement.getStatementType() == StatementType.FUNCTION_CALL) {
        // Replace / append function call
      }
      Graphs.successorListOf(cfg.graph, statement);
      iterator.next();
    }
  }
}
