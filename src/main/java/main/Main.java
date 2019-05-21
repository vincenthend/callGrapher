package main;

import analyzer.ControlFlowGraphAnalyzer;
import logger.Logger;
import model.DiffJobData;
import model.graph.ControlFlowGraph;
import model.php.PhpFunction;
import predictor.PhpFunctionPredictor;
import util.ControlFlowExporter;
import util.DiffJobDataLoader;
import util.FlowGraphMatcher;
import util.builder.ControlFlowGraphTranslator;
import util.diff.ControlFlowGraphDiff;
import view.GraphView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

  public static void main(String[] args) throws Exception {
    Integer[] jobSelection = {0,1,3,4,5,6,8,10,11,12};
    List<DiffJobData> jobList = DiffJobDataLoader.loadCSV("D:\\cfg\\job.csv", jobSelection);
    Logger.info("Found " + jobList.size() + " job(s)");

    List<Future<?>> futures = new ArrayList<>();
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    for (DiffJobData diffJobData : jobList) {
      Logger.info("Starting job with ID : " + diffJobData.getId());
      futures.add(executorService.submit(new DiffJob(diffJobData, 1)));
    }
    executorService.shutdown();
    for(Future<?> future : futures) {
      future.get();
    }

//    // Scoring
    Logger.info("Testing for Vulnerability");
    StringBuilder sb = new StringBuilder();
    for(DiffJobData job : jobList){
      for(DiffJobData testCase : jobList){
        FlowGraphMatcher matcher = new FlowGraphMatcher(testCase.getDiffGraph(),job.getOldGraph());
        sb.append(matcher.countGraphSimilarity());
        if(jobList.get(jobList.size()-1) != testCase){
          sb.append("\t");
        }
      }
      sb.append("\n");
    }
    Logger.info(sb.toString());


    // SINGULAR DEBUG
//    jobList.get(0).getDiffJobOptions().setShownInterface("diff");
//    new DiffJob(jobList.get(0), 1).diffCommit();

    // DEBUG GUI
//    drawGraph(jobList.get(0));

    // DEBUG PREDICTOR
//    System.out.println(PhpFunctionPredictor.predictFunctionType(new PhpFunction("array_key_exists",null,"",null)));
//    System.out.println(PhpFunctionPredictor.predictFunctionType(new PhpFunction("array_key_exists",null,"",null)));

//     DEBUG
//    DiffJobData diffJobData = new DiffJobData(1);
//    diffJobData.setRoot("./testfile/");
//    diffJobData.setShownFunction("ModuleChangePassword::compile");
//    diffJobData.addFileList("file4.php");
//    diffJobData.setUnvulHash("123");
//    diffJobData.setVulHash("123");
//    drawGraph(diffJobData);
  }

  public static void drawGraph(DiffJobData diffJobData) {
    // Parameters
    List<String> pathOld = diffJobData.getFileList();
    String shownFunction = diffJobData.getShownFunction();

    ControlFlowGraphAnalyzer analyzerOld = new ControlFlowGraphAnalyzer();
    analyzerOld.analyzeControlFlowGraph(pathOld);
    for(String removedFunc : diffJobData.getUnnormalizedFunction()){
      analyzerOld.getProjectData().getFunctionMap().remove(removedFunc);
      analyzerOld.getProjectData().getNormalizedFunction(removedFunc);
    }
    analyzerOld.normalizeFunction(shownFunction, 0);
    ControlFlowGraph cfgOld = analyzerOld.getProjectData().getNormalizedFunction(shownFunction).getControlFlowGraph();

//    GraphView view = new GraphView(cfgOld);
//    GraphView view = new GraphView(new ControlFlowGraphDominators(cfgOld));
    GraphView view = new GraphView(new ControlFlowGraphTranslator().translateToBlockGraph(cfgOld));
    view.show();

    String fileName = String.format("%03d", diffJobData.getId());
    String exportPath = diffJobData.getDiffJobOptions().getExportPath();
    String exportFormat = diffJobData.getDiffJobOptions().getExportFormat();
    ControlFlowExporter.exportGVImage(cfgOld.getGraph(), exportPath, fileName + "-graphVul",exportFormat);
  }
}
