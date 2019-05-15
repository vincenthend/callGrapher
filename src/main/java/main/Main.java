package main;

import analyzer.ControlFlowGraphAnalyzer;
import logger.Logger;
import model.DiffJobData;
import model.graph.ControlFlowBlockGraph;
import model.graph.ControlFlowGraph;
import model.php.PhpFunction;
import util.ControlFlowExporter;
import util.DiffJobDataLoader;
import util.builder.ControlFlowGraphDominators;
import util.builder.ControlFlowGraphTranslator;
import util.diff.ControlFlowGraphDiff;
import view.GraphView;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
//    DiffJobData diffJobData = new DiffJobData(9);
//    diffJobData.setRoot("../repo/phpmyadmin/");
//    diffJobData.setVulHash("63b7f6c0a94af5d7402c4f198846dc0c066f5413");
//    diffJobData.setUnvulHash("5e108a340f3eac6b6c488439343b6c1a7454787c");
//    diffJobData.addFileList("libraries/core.lib.php");
//    diffJobData.setShownFunction("PMA_safeUnserialize");
//
//    diffJobData.getDiffJobOptions().setExportPath("D:\\cfg");
    List<DiffJobData> jobList = DiffJobDataLoader.loadCSV("D:\\cfg\\job.csv");
    Logger.info("Found " + jobList.size() + " job(s)");
    for (DiffJobData diffJobData : jobList) {
      Logger.info("Starting job with ID : " + diffJobData.getId());
      diffCommit(diffJobData);
    }
  }

  public static void diffCommit(DiffJobData diffJobData) throws IOException, InterruptedException {
    if (diffJobData.getFileList().isEmpty()
      || diffJobData.getRoot() == null
      || diffJobData.getShownFunction() == null
      || diffJobData.getUnvulHash() == null
      || diffJobData.getVulHash() == null) {
      throw new IllegalArgumentException("Incomplete job data");
    }

    //
    // Analyze vulnerable code
    //
    Logger.info("Root is set to " + diffJobData.getRoot());
    Logger.info("Checkout to vulnerable commit " + diffJobData.getVulHash());
    ProcessBuilder builder = new ProcessBuilder("git", "checkout", diffJobData.getVulHash());
    builder.directory(new File(diffJobData.getRoot()));
    builder.start().waitFor();

    ControlFlowGraphAnalyzer analyzerOld = new ControlFlowGraphAnalyzer();
    analyzerOld.analyzeControlFlowGraph(diffJobData.getFileList());
    analyzerOld.normalizeFunction(diffJobData.getShownFunction());

    PhpFunction oldFunc = analyzerOld.getProjectData().getNormalizedFunction(diffJobData.getShownFunction());
    ControlFlowGraph cfgOld = null;
    if (oldFunc != null) {
      cfgOld = analyzerOld.getProjectData().getNormalizedFunction(diffJobData.getShownFunction()).getControlFlowGraph();
    }

    //
    // Analyze non vulnerable code
    //
    Logger.info("Checkout to unvulnerable commit " + diffJobData.getUnvulHash());
    builder = new ProcessBuilder("git", "checkout", diffJobData.getUnvulHash());
    builder.directory(new File(diffJobData.getRoot()));
    builder.start().waitFor();

    ControlFlowGraphAnalyzer analyzerNew = new ControlFlowGraphAnalyzer();
    analyzerNew.analyzeControlFlowGraph(diffJobData.getFileList());
    analyzerNew.normalizeFunction(diffJobData.getShownFunction());
    PhpFunction newFunc = analyzerNew.getProjectData().getNormalizedFunction(diffJobData.getShownFunction());
    ControlFlowGraph cfgNew = null;
    if (newFunc != null) {
      cfgNew = analyzerNew.getProjectData().getNormalizedFunction(diffJobData.getShownFunction()).getControlFlowGraph();
    }

    ControlFlowGraphDiff diff = new ControlFlowGraphDiff();
    ControlFlowBlockGraph diffGraph;
    if (!diffJobData.getDiffJobOptions().isAnnotateDiff()) {
      diffGraph = diff.diffGraph(cfgOld, cfgNew);
    } else {
      diffGraph = diff.diffGraphAnnotate(cfgOld, cfgNew);
    }

    //
    // UI Shown
    //
    GraphView view;
    switch (diffJobData.getDiffJobOptions().getShownInterface()) {
      case "old":
        view = new GraphView(cfgOld);
        break;
      case "new":
        view = new GraphView(cfgNew);
        break;
      case "diff":
        view = new GraphView(diffGraph);
        break;
      case "oldDom":
        view = new GraphView(new ControlFlowGraphDominators(cfgOld));
        break;
      case "newDom":
        view = new GraphView(new ControlFlowGraphDominators(cfgNew));
        break;
      case "oldBlock":
        view = new GraphView(new ControlFlowGraphTranslator().translateToBlockGraph(cfgOld));
        break;
      case "newBlock":
        view = new GraphView(new ControlFlowGraphTranslator().translateToBlockGraph(cfgNew));
        break;
      default:
        view = null;
    }
    if (view != null) {
      view.show();
    }

    //
    //  Export Image
    //
    String fileName = String.format("%03d", diffJobData.getId());
    String exportPath = diffJobData.getDiffJobOptions().getExportPath();
    String exportFormat = diffJobData.getDiffJobOptions().getExportFormat();
    if (cfgOld != null) {
      ControlFlowExporter.exportGVImage(cfgOld.getGraph(), exportPath, fileName + "-graphVul", exportFormat);
    }
    if (cfgNew != null) {
      ControlFlowExporter.exportGVImage(cfgNew.getGraph(), exportPath, fileName + "-graphNonvul", exportFormat);
    }
    ControlFlowGraph cfgDiff = new ControlFlowGraphTranslator().translateToFlowGraph(diffGraph);
    ControlFlowExporter.exportGVImage(cfgDiff.getGraph(), exportPath, fileName + "-graphDiff", exportFormat);
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

  public static void drawGraph() {
    // Parameters
    List<String> pathOld = new LinkedList<>();
    pathOld.add("./testfile/file4.php");

    List<String> shownFunction = new LinkedList<>();
    shownFunction.add("file4.php::main");

    ControlFlowGraphAnalyzer analyzerOld = new ControlFlowGraphAnalyzer();
    analyzerOld.analyzeControlFlowGraph(pathOld);
    analyzerOld.normalizeFunction(shownFunction);
    ControlFlowGraph cfgOld = analyzerOld.getProjectData().getNormalizedFunction(shownFunction.get(0)).getControlFlowGraph();

    GraphView view = new GraphView(cfgOld);
//    GraphView view = new GraphView(new ControlFlowGraphDominators(cfgOld));
//    GraphView view = new GraphView(new ControlFlowGraphTranslator(cfgOld).translateToBlockGraph());
    view.show();

    //util.ControlFlowExporter.exportSVG(cfg, "D:\\");
  }
}
