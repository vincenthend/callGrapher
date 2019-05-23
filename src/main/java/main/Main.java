package main;

import analyzer.AbstractionAnalyzer;
import analyzer.ControlFlowGraphAnalyzer;
import logger.Logger;
import model.DiffJobData;
import model.graph.ControlFlowGraph;
import util.ControlFlowExporter;
import util.DiffJobDataLoader;
import util.FlowGraphMatcher;
import util.builder.ControlFlowGraphTranslator;
import view.GraphView;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args) throws Exception {
//    Integer[] jobSelection = {0,1,3,4,5,6,8,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,27,31,32,33,34,36,37,38,39,41,42,43,44,45,46,47,48,49,50,51,52,53,54,56,57,58,59,60,61,62,66,67};
    Integer[] jobSelection = {0,1,3,5,8,13,14,15,16,17,18,20,21,22,23,24,25,31,32,33,34,36,37,38};
//    Integer[] jobSelection = {20,38};
    List<DiffJobData> jobList = DiffJobDataLoader.loadCSV("D:\\cfg\\job.csv", jobSelection);
    Logger.info("Found " + jobList.size() + " job(s)");

    ExecutorService executorService = Executors.newFixedThreadPool(4);
    for (DiffJobData diffJobData : jobList) {
      Logger.info("Starting job with ID : " + diffJobData.getId());
      executorService.submit(new DiffJob(diffJobData, 1));
    }
    executorService.shutdown();
    while(!executorService.isTerminated()){
      //wait
    }

    // Scoring
    Logger.info("Testing for Vulnerability");
    StringBuilder sb = new StringBuilder();
    for (DiffJobData job : jobList) {
      for (DiffJobData testCase : jobList) {
        FlowGraphMatcher matcher = new FlowGraphMatcher(job.getNewGraph(),testCase.getDiffGraphOld());
        try {
          sb.append(matcher.countGraphSimilarity());
        } catch (Exception e){
          sb.append(-1);
        }
        if (jobList.get(jobList.size() - 1) != testCase) {
          sb.append("\t");
        }
      }
      sb.append("\n");
    }
    Logger.info(sb.toString());

    Logger.info("Testing for Vulnerability");
    sb = new StringBuilder();
    for (DiffJobData job : jobList) {
      for (DiffJobData testCase : jobList) {
        FlowGraphMatcher matcher = new FlowGraphMatcher(job.getNewGraph(),testCase.getDiffGraphNew());
        try {
          sb.append(matcher.countGraphSimilarity());
        } catch (Exception e){
          sb.append(-1);
        }
        if (jobList.get(jobList.size() - 1) != testCase) {
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
    for (String removedFunc : diffJobData.getUnnormalizedFunction()) {
      analyzerOld.getProjectData().getFunctionMap().remove(removedFunc);
      analyzerOld.getProjectData().getNormalizedFunction(removedFunc);
    }
    analyzerOld.normalizeFunction(shownFunction, 0);
    ControlFlowGraph cfgOld = analyzerOld.getProjectData().getNormalizedFunction(shownFunction).getControlFlowGraph();

//    Logger.info("Abstracting function");
//    AbstractionAnalyzer.analyze(cfgOld);

//    GraphView view = new GraphView(cfgOld);
//    GraphView view = new GraphView(new ControlFlowGraphDominators(cfgOld));
    GraphView view = new GraphView(new ControlFlowGraphTranslator().translateToBlockGraph(cfgOld));
    view.show();

    String fileName = String.format("%03d", diffJobData.getId());
    String exportPath = diffJobData.getDiffJobOptions().getExportPath();
    String exportFormat = diffJobData.getDiffJobOptions().getExportFormat();
    ControlFlowExporter.exportGVImage(cfgOld.getGraph(), exportPath, fileName + "-graphVul", exportFormat);
  }
}
