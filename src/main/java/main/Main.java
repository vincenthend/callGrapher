package main;

import analyzer.ControlFlowGraphAnalyzer;
import logger.Logger;
import model.graph.ControlFlowBlockGraph;
import model.graph.ControlFlowGraph;
import model.php.PhpFunction;
import util.ControlFlowExporter;
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
    String root = "../repo/phpmyadmin/";
    String[] hash = new String[2];
    hash[0] = "63b7f6c0a94af5d7402c4f198846dc0c066f5413"; // Vulnerable Hash
    hash[1] = "5e108a340f3eac6b6c488439343b6c1a7454787c"; // Unvulnerable Hash

    List<String> file = new LinkedList<>();
    file.add(root + "libraries/core.lib.php");

    List<String> shownFunction = new LinkedList<>();
    shownFunction.add("PMA_safeUnserialize");

    String[] options = new String[5]; // [View, ExportFormat, ExportPath, ID, Annotate]
    options[0] = "diff";
    options[1] = "svg";
    options[2] = "D:/cfg/";
    options[3] = "09";
    options[4] = null;

    diffCommit(root, hash, file, shownFunction, options);
//    diffGraph();
//    drawGraph();
  }

  public static void diffCommit(String root, String[] hash, List<String> fileList, List<String> shownFunction, String[] options) throws IOException, InterruptedException {
    if (hash.length != 2 || options.length != 5) {
      throw new IllegalArgumentException("Didn't supply required hash or options");
    }
    String vulHash = hash[0];
    String unvulHash = hash[1];

    //
    // Analyze vulnerable code
    //
    Logger.info("Root is set to" + root);
    Logger.info("Checkout to vulnerable commit " + vulHash);
    ProcessBuilder builder = new ProcessBuilder("git", "checkout", vulHash);
    builder.directory(new File(root));
    builder.start().waitFor();

    ControlFlowGraphAnalyzer analyzerOld = new ControlFlowGraphAnalyzer();
    analyzerOld.analyzeControlFlowGraph(fileList);
    analyzerOld.normalizeFunction(shownFunction);

    PhpFunction oldFunc = analyzerOld.getProjectData().getNormalizedFunction(shownFunction.get(0));
    ControlFlowGraph cfgOld = null;
    if (oldFunc != null) {
      cfgOld = analyzerOld.getProjectData().getNormalizedFunction(shownFunction.get(0)).getControlFlowGraph();
    }

    //
    // Analyze non vulnerable code
    //
    Logger.info("Checkout to unvulnerable commit " + unvulHash);
    builder = new ProcessBuilder("git", "checkout", unvulHash);
    builder.directory(new File(root));
    builder.start().waitFor();

    ControlFlowGraphAnalyzer analyzerNew = new ControlFlowGraphAnalyzer();
    analyzerNew.analyzeControlFlowGraph(fileList);
    analyzerNew.normalizeFunction(shownFunction);
    PhpFunction newFunc = analyzerNew.getProjectData().getNormalizedFunction(shownFunction.get(0));
    ControlFlowGraph cfgNew = null;
    if (newFunc != null) {
      cfgNew = analyzerNew.getProjectData().getNormalizedFunction(shownFunction.get(0)).getControlFlowGraph();
    }

    ControlFlowGraphDiff diff = new ControlFlowGraphDiff();
    ControlFlowBlockGraph diffGraph;
    if (options[4] == null) {
      diffGraph = diff.diffGraph(cfgOld, cfgNew);
    } else {
      diffGraph = diff.diffGraphAnnotate(cfgOld, cfgNew);
    }

    //
    // UI Shown
    //
    GraphView view;
    switch (options[0]) {
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
    String fileName = options[3] + "-";
    if(cfgOld != null) {
      ControlFlowExporter.exportGVImage(cfgOld.getGraph(), options[2], fileName + "graphVul", options[1]);
    }
    if(cfgNew != null) {
      ControlFlowExporter.exportGVImage(cfgNew.getGraph(), options[2], fileName + "graphNonvul", options[1]);
    }
    ControlFlowExporter.exportGVImage(new ControlFlowGraphTranslator().translateToFlowGraph(diffGraph).getGraph(), options[2], fileName + "graphDiff", options[1]);
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
