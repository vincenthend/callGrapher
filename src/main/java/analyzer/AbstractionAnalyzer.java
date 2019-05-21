package analyzer;

import model.graph.ControlFlowGraph;
import model.graph.statement.AssignmentStatement;
import model.graph.statement.PhpStatement;
import model.graph.statement.special.SpecialStatement;
import model.graph.statement.special.ValidationStatement;
import org.jgrapht.graph.DefaultEdge;
import predictor.PhpStatementPredictor;

import java.util.*;

public class AbstractionAnalyzer {

  private AbstractionAnalyzer() {
  }

  public static void analyze(ControlFlowGraph cfg) {
    List<PhpStatement> vertexList = new ArrayList<>(cfg.getGraph().vertexSet());
    Map<PhpStatement, SpecialStatement> changeList = new HashMap<>();
    Set<PhpStatement> assignmentList = new HashSet<>();
    for (int i = 0; i < vertexList.size(); i++) {
      PhpStatementPredictor predictor = new PhpStatementPredictor(cfg);
      PhpStatement statement = vertexList.get(i);
      SpecialStatement specialStatement = predictor.predictStatement(statement);
      if (specialStatement != null) {
        changeList.put(statement, specialStatement);
      }
      if (statement instanceof AssignmentStatement) {
        assignmentList.add(statement);
      }
    }

    for (PhpStatement statement : assignmentList) {
      cfg.removeStatement(statement);
    }

    for (Map.Entry<PhpStatement, SpecialStatement> entry : changeList.entrySet()) {
      cfg.replaceStatement(entry.getKey(), entry.getValue());
    }
  }
}
