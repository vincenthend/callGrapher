package scanner;

import model.graph.ControlFlowGraph;
import util.FlowGraphMatcher;

import java.util.concurrent.Callable;

public class ScannerTask implements Callable<Float>{
  private ControlFlowGraph jobGraph;
  private ControlFlowGraph modelGraph;

  public ScannerTask(ControlFlowGraph jobGraph, ControlFlowGraph modelGraph) {
    this.jobGraph = jobGraph;
    this.modelGraph = modelGraph;
  }

  @Override
  public Float call() throws Exception {
    Float returnValue;
    FlowGraphMatcher matcher = new FlowGraphMatcher(jobGraph, modelGraph);
    try {
      returnValue = matcher.countGraphSimilarity();
    } catch (Exception e){
      returnValue = -1f;
    }
    return returnValue;
  }
}
