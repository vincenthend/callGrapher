package scanner;

import analyzer.AbstractionAnalyzer;
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
import java.util.HashMap;
import java.util.Map;

public class DiffTask implements Runnable {
  private DiffJobData diffJobData;
  private int maxDepth;
  private static Map<String, Object> resourceLock = new HashMap<>();

  public DiffTask(DiffJobData diffJobData, int maxDepth) {
    if (diffJobData.getFileList().isEmpty()
      || diffJobData.getRoot() == null
      || diffJobData.getShownFunction() == null
      || diffJobData.getUnvulHash() == null
      || diffJobData.getVulHash() == null) {
      throw new IllegalArgumentException("Incomplete job data");
    } else {
      this.diffJobData = diffJobData;
      this.maxDepth = maxDepth;
      resourceLock.put(diffJobData.getRoot(), new Object());
    }
  }

  @Override
  public void run() {
    Logger.info("Job "+diffJobData.getId()+" assigned to TID "+Thread.currentThread().getId());
    try {
      diffCommit();
    } catch (IOException e) {
      Logger.error("IOException occured");
    } catch (InterruptedException e) {
      Logger.error("InterruptedException occured");
      Thread.currentThread().interrupt();
    }
  }

  private ControlFlowGraph checkoutAndAnalyze(String root, String hash) throws IOException, InterruptedException {
    ControlFlowGraphAnalyzer analyzer = new ControlFlowGraphAnalyzer();
    synchronized (resourceLock.get(root)) {
      ProcessBuilder builder = new ProcessBuilder("git", "checkout", "-f", hash.trim());
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

      analyzer.analyzeControlFlowGraph(diffJobData.getFileList());
    }

    for (String removedFunc : diffJobData.getUnnormalizedFunction()) {
      analyzer.getProjectData().getFunctionMap().remove(removedFunc);
      analyzer.getProjectData().getNormalizedFunction(removedFunc);
    }
    analyzer.normalizeFunction(diffJobData.getShownFunction(), maxDepth);
    PhpFunction oldFunc = analyzer.getProjectData().getNormalizedFunction(diffJobData.getShownFunction());

    if (oldFunc != null) {
      return analyzer.getProjectData().getNormalizedFunction(diffJobData.getShownFunction()).getControlFlowGraph();
    } else {
      return null;
    }
  }

  void diffCommit() throws IOException, InterruptedException {
    //
    // Analyze vulnerable code
    //
    Logger.info("Root is set to " + diffJobData.getRoot());
    Logger.info("Checkout to vulnerable commit " + diffJobData.getVulHash());
    ControlFlowGraph cfgOld = checkoutAndAnalyze(diffJobData.getRoot(), diffJobData.getVulHash());
    diffJobData.setOldGraph(cfgOld);

    //
    // Analyze non vulnerable code
    //
    Logger.info("Checkout to unvulnerable commit " + diffJobData.getUnvulHash());
    ControlFlowGraph cfgNew = checkoutAndAnalyze(diffJobData.getRoot(), diffJobData.getUnvulHash());
    diffJobData.setNewGraph(cfgNew);


    ControlFlowGraphDiff diffOld = new ControlFlowGraphDiff(cfgOld, cfgNew);
    ControlFlowBlockGraph diffBlockOld;
    if (!diffJobData.getJobOptions().isAnnotateDiff()) {
      diffBlockOld = diffOld.diffGraph();
    } else {
      diffBlockOld = diffOld.diffGraphAnnotate();
    }

    ControlFlowGraphDiff diffNew = new ControlFlowGraphDiff(cfgNew, cfgOld);
    ControlFlowBlockGraph diffBlockNew;
    if (!diffJobData.getJobOptions().isAnnotateDiff()) {
      diffBlockNew = diffNew.diffGraph();
    } else {
      diffBlockNew = diffNew.diffGraphAnnotate();
    }

    // Abstracting function
    ControlFlowGraph cfgDiffOld = new ControlFlowGraphTranslator().translateToFlowGraph(diffBlockOld);
    ControlFlowGraph cfgDiffNew = new ControlFlowGraphTranslator().translateToFlowGraph(diffBlockNew);
    diffJobData.setDiffGraphOld(cfgDiffOld);
    diffJobData.setDiffGraphNew(cfgDiffNew);
    Logger.info("Abstracting function");

    AbstractionAnalyzer.analyze(cfgDiffOld);
    AbstractionAnalyzer.analyze(cfgDiffNew);
    AbstractionAnalyzer.analyze(cfgOld);
    AbstractionAnalyzer.analyze(cfgNew);

    //
    // UI Shown
    //
    showGraph();

    //
    //  Export Image
    //
    String fileName = String.format("%03d", diffJobData.getId());
    String exportPath = diffJobData.getJobOptions().getExportPath();
    ControlFlowExporter.exportObject(cfgDiffOld, exportPath, fileName + "_model_vuln");
    ControlFlowExporter.exportObject(cfgDiffNew, exportPath, fileName + "_model_fixed");

    String exportFormat = diffJobData.getJobOptions().getExportFormat();
    if(exportFormat.equals("obj")) {
      if (cfgOld != null) {
        ControlFlowExporter.exportGVImage(cfgOld.getGraph(), exportPath, fileName + "-graphVul", exportFormat);
        ControlFlowExporter.exportDot(cfgOld.getGraph(), exportPath, fileName + "-graphVul");
      }
      if (cfgNew != null) {
        ControlFlowExporter.exportGVImage(cfgNew.getGraph(), exportPath, fileName + "-graphNonvul", exportFormat);
        ControlFlowExporter.exportDot(cfgNew.getGraph(), exportPath, fileName + "-graphNonvul");
      }
      ControlFlowExporter.exportGVImage(cfgDiffOld.getGraph(), exportPath, fileName + "-graphDiffOld", exportFormat);
      ControlFlowExporter.exportDot(cfgDiffOld.getGraph(), exportPath, fileName + "-graphDiffOld");
      ControlFlowExporter.exportGVImage(cfgDiffNew.getGraph(), exportPath, fileName + "-graphDiffNew", exportFormat);
      ControlFlowExporter.exportDot(cfgDiffNew.getGraph(), exportPath, fileName + "-graphDiffNew");
    }
  }

  private void showGraph(){
    GraphView view;
    switch (diffJobData.getJobOptions().getShownInterface()) {
      case "old":
        view = new GraphView(diffJobData.getOldGraph());
        break;
      case "new":
        view = new GraphView(diffJobData.getNewGraph());
        break;
      case "diff":
        view = new GraphView(diffJobData.getDiffGraphOld());
        break;
      case "oldDom":
        view = new GraphView(new ControlFlowGraphDominators(diffJobData.getOldGraph()));
        break;
      case "newDom":
        view = new GraphView(new ControlFlowGraphDominators(diffJobData.getNewGraph()));
        break;
      case "oldBlock":
        view = new GraphView(diffJobData.getOldGraph().getFlowBlockGraph());
        break;
      case "newBlock":
        view = new GraphView(diffJobData.getNewGraph().getFlowBlockGraph());
        break;
      case "diffBlock":
        view = new GraphView(diffJobData.getDiffGraphOld().getFlowBlockGraph());
        break;
      default:
        view = null;
    }
    if (view != null) {
      view.show();
    }
  }
}
