package main;

import analyzer.ControlFlowGraphAnalyzer;
import logger.Logger;
import model.DiffJobData;
import model.graph.ControlFlowBlockGraph;
import model.graph.ControlFlowGraph;
import model.php.PhpFunction;
import util.ControlFlowExporter;
import util.builder.ControlFlowGraphDominators;
import util.builder.ControlFlowGraphTranslator;
import util.diff.ControlFlowGraphDiff;
import view.GraphView;

import java.io.*;

public class DiffJob implements Runnable {
  private DiffJobData diffJobData;

  public DiffJob(DiffJobData diffJobData){
    if (diffJobData.getFileList().isEmpty()
      || diffJobData.getRoot() == null
      || diffJobData.getShownFunction() == null
      || diffJobData.getUnvulHash() == null
      || diffJobData.getVulHash() == null) {
      throw new IllegalArgumentException("Incomplete job data");
    } else {
      this.diffJobData = diffJobData;
    }
  }

  @Override
  public void run() {
    try {
      diffCommit();
    } catch (IOException e) {
      Logger.error("IOException occured");
    } catch (InterruptedException e) {
      Logger.error("InterruptedException occured");
      Thread.currentThread().interrupt();
    }
  }

  private synchronized ControlFlowGraphAnalyzer checkoutAndAnalyze(String hash) throws IOException, InterruptedException {
    ProcessBuilder cleaner = new ProcessBuilder("git", "checkout", ".");
    cleaner.directory(new File(diffJobData.getRoot()));
    cleaner.start().waitFor();

    ProcessBuilder builder = new ProcessBuilder("git", "checkout", hash.trim());
    builder.directory(new File(diffJobData.getRoot()));
    Process p = builder.start();
    InputStream stdout = p.getErrorStream();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stdout));
    StringBuilder stringBuilder = new StringBuilder();
    String line;
    while ((line = bufferedReader.readLine()) != null) {
      stringBuilder.append(line);
    }
    p.waitFor();
    Logger.info(stringBuilder.toString());

    ControlFlowGraphAnalyzer analyzer = new ControlFlowGraphAnalyzer();
    analyzer.analyzeControlFlowGraph(diffJobData.getFileList());
    return analyzer;
  }

  void diffCommit() throws IOException, InterruptedException{
    //
    // Analyze vulnerable code
    //
    Logger.info("Root is set to " + diffJobData.getRoot());
    Logger.info("Checkout to vulnerable commit " + diffJobData.getVulHash());

    ControlFlowGraphAnalyzer analyzerOld = checkoutAndAnalyze(diffJobData.getVulHash());
    for(String removedFunc : diffJobData.getUnnormalizedFunction()){
      analyzerOld.getProjectData().getFunctionMap().remove(removedFunc);
      analyzerOld.getProjectData().getNormalizedFunction(removedFunc);
    }
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
    ControlFlowGraphAnalyzer analyzerNew = checkoutAndAnalyze(diffJobData.getUnvulHash());
    for(String removedFunc : diffJobData.getUnnormalizedFunction()){
      analyzerNew.getProjectData().getFunctionMap().remove(removedFunc);
      analyzerNew.getProjectData().getNormalizedFunction(removedFunc);
    }
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
}
