package scanner;

import logger.Logger;
import model.DiffJobData;
import model.graph.ControlFlowGraph;
import util.DiffJobDataLoader;
import util.FlowGraphMatcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
