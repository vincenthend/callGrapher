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
    Iterator<PhpStatement> iterator = cfg.getGraph().vertexSet().iterator();
    List<SpecialStatement> changeList = new ArrayList<>();
    List<PhpStatement> assignmentList = new ArrayList<>();
    while (iterator.hasNext()) {
      PhpStatementPredictor predictor = new PhpStatementPredictor(cfg);
      PhpStatement statement = iterator.next();
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
