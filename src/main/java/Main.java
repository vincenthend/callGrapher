import java.io.File;
import java.util.LinkedList;
import java.util.List;
import logger.Logger;
import model.graph.ControlFlowBlockGraph;
import model.graph.ControlFlowGraph;
import util.diff.ControlFlowGraphDiff;
import view.GraphView;

public class Main {

  public static void main(String[] args) throws Exception {
    diffCommit();
//    diffGraph();
//    drawGraph();
  }

  public static void diffCommit() throws Exception{
    // Parameters
    String root = "../phpmyadmin/";
    String vulHash = "0c3dfd186c281710516805f97a9875149abeb3ce";
    String unvulHash = "af7c58939155d407233c8c3bf6f2ad3e540f489a";
    List<String> file = new LinkedList<>();
    file.add(root+"libraries/core.lib.php");

    List<String> shownFunction = new LinkedList<>();
    shownFunction.add("PMA_isAllowedDomain");

    Logger.info("Root is set to"+root);
    Logger.info("Checkout to vulnerable commit "+vulHash);
    ProcessBuilder builder = new ProcessBuilder("git","checkout",vulHash);
    builder.directory(new File(root));
    builder.start().waitFor();

    ControlFlowGraphAnalyzer analyzerOld = new ControlFlowGraphAnalyzer();
    analyzerOld.analyzeControlFlowGraph(file);
    analyzerOld.normalizeFunction(shownFunction);
    ControlFlowGraph cfgOld = analyzerOld.getProjectData().getNormalizedFunction(shownFunction.get(0)).getControlFlowGraph();


    Logger.info("Checkout to unvulnerable commit "+unvulHash);
    builder = new ProcessBuilder("git","checkout",unvulHash);
    builder.directory(new File(root));
    builder.start().waitFor();

    ControlFlowGraphAnalyzer analyzerNew = new ControlFlowGraphAnalyzer();
    analyzerNew.analyzeControlFlowGraph(file);
    analyzerNew.normalizeFunction(shownFunction);
    ControlFlowGraph cfgNew = analyzerNew.getProjectData().getNormalizedFunction(shownFunction.get(0)).getControlFlowGraph();

    ControlFlowGraphDiff diff = new ControlFlowGraphDiff();
    ControlFlowBlockGraph diffGraph = diff.diffGraph(cfgOld, cfgNew);

//    GraphView view = new GraphView(cfgOld);
//    GraphView view = new GraphView(cfgNew);
//    GraphView view = new GraphView(new ControlFlowGraphDominators(cfgOld));
//    GraphView view = new GraphView(new ControlFlowGraphTranslator(cfgOld).translate());
    GraphView view = new GraphView(diffGraph);
//    GraphView view = new GraphView(diff.diffGraphAnnotate(cfgOld, cfgNew));
    view.show();

    ControlFlowExporter.exportSVG(cfgOld.getGraph(), "D:\\cfg\\","10-graphVul");
    ControlFlowExporter.exportSVG(cfgNew.getGraph(), "D:\\cfg\\","10-graphNonvul");
    ControlFlowExporter.exportSVG(diffGraph.getGraph(), "D:\\cfg\\","10-graphDiff");
  }

  public static void diffGraph(){
    // Parameters
    List<String> pathOld = new LinkedList<>();
    pathOld.add("./testfile/file4.php");

    List<String> pathNew = new LinkedList<>();
    pathNew.add("./testfile/file5.php");

    boolean normalizeFunc = true;
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
//    GraphView view = new GraphView(new ControlFlowGraphTranslator(cfgOld).translate());
    GraphView view = new GraphView(diff.diffGraph(cfgOld, cfgNew));
    view.show();

    //ControlFlowExporter.exportSVG(cfg, "D:\\");
  }

  public static void drawGraph(){
    // Parameters
    List<String> pathOld = new LinkedList<>();
    pathOld.add("./testfile/file4.php");

    boolean normalizeFunc = true;
    List<String> shownFunction = new LinkedList<>();
    shownFunction.add("file4.php::main");

    ControlFlowGraphAnalyzer analyzerOld = new ControlFlowGraphAnalyzer();
    analyzerOld.analyzeControlFlowGraph(pathOld);
    analyzerOld.normalizeFunction(shownFunction);
    ControlFlowGraph cfgOld = analyzerOld.getProjectData().getNormalizedFunction(shownFunction.get(0)).getControlFlowGraph();

    GraphView view = new GraphView(cfgOld);
//    GraphView view = new GraphView(new ControlFlowGraphDominators(cfgOld));
//    GraphView view = new GraphView(new ControlFlowGraphTranslator(cfgOld).translate());
    view.show();

    //ControlFlowExporter.exportSVG(cfg, "D:\\");
  }
}
