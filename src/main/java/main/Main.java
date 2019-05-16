package main;

import analyzer.ControlFlowGraphAnalyzer;
import logger.Logger;
import model.DiffJobData;
import model.graph.ControlFlowGraph;
import util.ControlFlowExporter;
import util.DiffJobDataLoader;
import util.builder.ControlFlowGraphTranslator;
import util.diff.ControlFlowGraphDiff;
import view.GraphView;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args) throws Exception {
    List<DiffJobData> jobList = DiffJobDataLoader.loadCSV("D:\\cfg\\job.csv");
    Logger.info("Found " + jobList.size() + " job(s)");

    ExecutorService executorService = Executors.newFixedThreadPool(4);
    for (DiffJobData diffJobData : jobList) {
      Logger.info("Starting job with ID : " + diffJobData.getId());
      executorService.submit(new DiffJob(diffJobData));
    }
    executorService.shutdown();

    // SINGULAR DEBUG
//    new DiffJob(jobList.get(18)).diffCommit();

//    jobList.get(2).getDiffJobOptions().setShownInterface("cfgOld");
//    drawGraph(jobList.get(2));

    // DEBUG
//    DiffJobData diffJobData = new DiffJobData(1);
//    diffJobData.setRoot("./testfile/");
//    diffJobData.setShownFunction("file4.php::main");
//    diffJobData.addFileList("file4.php");
//    diffJobData.setUnvulHash("123");
//    diffJobData.setVulHash("123");
//    drawGraph(diffJobData);
  }

  public static void diffGraph() {
    // Parameters
    List<String> pathOld = new LinkedList<>();
    pathOld.add("./testfile/file4.php");

    List<String> pathNew = new LinkedList<>();
    pathNew.add("./testfile/file5.php");

    List<String> shownFunction = new LinkedList<>();
    shownFunction.add("SQLConnector::runQuery");

    ControlFlowGraphAnalyzer analyzerOld = new ControlFlowGraphAnalyzer();
    analyzerOld.analyzeControlFlowGraph(pathOld);
    analyzerOld.normalizeFunction(shownFunction);
    ControlFlowGraph cfgOld = analyzerOld.getProjectData().getNormalizedFunction(shownFunction.get(0)).getControlFlowGraph();

    ControlFlowGraphAnalyzer analyzerNew = new ControlFlowGraphAnalyzer();
    analyzerNew.analyzeControlFlowGraph(pathNew);
    analyzerNew.normalizeFunction(shownFunction);
    ControlFlowGraph cfgNew = analyzerNew.getProjectData().getNormalizedFunction(shownFunction.get(0)).getControlFlowGraph();

    ControlFlowGraphDiff diff = new ControlFlowGraphDiff();

//    GraphView view = new GraphView(cfgOld);
//    GraphView view = new GraphView(cfgNew);
//    GraphView view = new GraphView(new ControlFlowGraphDominators(cfgOld));
//    GraphView view = new GraphView(new ControlFlowGraphTranslator(cfgOld).translateToBlockGraph());
    GraphView view = new GraphView(diff.diffGraph(cfgOld, cfgNew));
    view.show();

    //util.ControlFlowExporter.exportSVG(cfg, "D:\\");
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
//    analyzerOld.normalizeFunction(shownFunction);
    ControlFlowGraph cfgOld = analyzerOld.getProjectData().getFunction(shownFunction).getControlFlowGraph();

    GraphView view = new GraphView(cfgOld);
//    GraphView view = new GraphView(new ControlFlowGraphDominators(cfgOld));
//    GraphView view = new GraphView(new ControlFlowGraphTranslator().translateToBlockGraph(cfgOld));
    view.show();

//    String fileName = String.format("%03d", diffJobData.getId());
//    String exportPath = diffJobData.getDiffJobOptions().getExportPath();
//    String exportFormat = diffJobData.getDiffJobOptions().getExportFormat();
//    ControlFlowExporter.exportDot(cfgOld.getGraph(), exportPath, fileName + "-graphVul");
  }
}
