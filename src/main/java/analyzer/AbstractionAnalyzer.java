package analyzer;

import model.ProjectData;
import model.graph.ControlFlowGraph;
import model.graph.statement.AssignmentStatement;
import model.graph.statement.PhpStatement;
import model.graph.statement.special.SpecialStatement;
import model.php.PhpFunction;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;
import predictor.PhpStatementPredictor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AbstractionAnalyzer {
  private ProjectData projectData;

  public AbstractionAnalyzer(ProjectData projectData) {
    this.projectData = projectData;
  }

  public void analyze(PhpFunction function) {
    if (function.getControlFlowGraph().getFirstVertex() != null) {
      ControlFlowGraph cfg = function.getControlFlowGraph();
      DepthFirstIterator<PhpStatement, DefaultEdge> iterator = new DepthFirstIterator<>(cfg.getGraph());
      List<SpecialStatement> changeList = new ArrayList<>();
      List<PhpStatement> assignmentList = new ArrayList<>();
      while(iterator.hasNext()){
        PhpStatementPredictor predictor = new PhpStatementPredictor(cfg);
        PhpStatement statement = iterator.next();
        SpecialStatement specialStatement = predictor.predictStatement(statement);
        if(specialStatement != null){
          changeList.add(specialStatement);
        }
        if(statement instanceof AssignmentStatement){
          assignmentList.add(statement);
        }
      }

      for(PhpStatement statement : assignmentList){
        cfg.removeStatement(statement);
      }

      for(SpecialStatement statement : changeList) {
        cfg.replaceStatement(statement.getOriginalStatement(), statement);
      }
    }
  }

  public void analyzeAll() {
    Set<PhpFunction> funcSet = new TreeSet<>(projectData.getFunctionMap().values());
    for (PhpFunction f : funcSet) {
      analyze(f);
    }
  }
}
