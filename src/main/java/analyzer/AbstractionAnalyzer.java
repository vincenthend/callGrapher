package analyzer;

import model.graph.ControlFlowGraph;
import model.graph.statement.AssignmentStatement;
import model.graph.statement.PhpStatement;
import model.graph.statement.special.SpecialStatement;
import predictor.PhpStatementPredictor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AbstractionAnalyzer {

  private AbstractionAnalyzer() {
  }

  public static void analyze(ControlFlowGraph cfg) {
    List<PhpStatement> vertexList = new ArrayList<>(cfg.getGraph().vertexSet());
    List<SpecialStatement> changeList = new ArrayList<>();
    List<PhpStatement> assignmentList = new ArrayList<>();
    for (int i = 0; i < vertexList.size(); i++) {
      PhpStatementPredictor predictor = new PhpStatementPredictor(cfg);
      PhpStatement statement = vertexList.get(i);
      SpecialStatement specialStatement = predictor.predictStatement(statement);
      if (specialStatement != null) {
        changeList.add(specialStatement);
      }
//      if (statement instanceof AssignmentStatement) {
//        assignmentList.add(statement);
//      }
    }

//    for (PhpStatement statement : assignmentList) {
//      cfg.removeStatement(statement);
//    }

    for (SpecialStatement statement : changeList) {
      cfg.replaceStatement(statement.getOriginalStatement(), statement);
    }
  }
}
