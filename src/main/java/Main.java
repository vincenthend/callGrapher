import java.io.File;
import java.util.LinkedList;
import java.util.List;
import logger.Logger;
import model.graph.ControlFlowBlockGraph;
import model.graph.ControlFlowGraph;
import model.php.PhpFunction;
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
    String vulHash = "f67e04987dc1fb3ab6935b20034d64cda3520ff6";
    String unvulHash = "7232271a379396ca1d4b083af051262057003c41";
    List<String> file = new LinkedList<>();
    file.add(root+"libraries/common.inc.php");


    List<String> shownFunction = new LinkedList<>();
    shownFunction.add("common.inc.php::main");

    Logger.info("Root is set to"+root);
    Logger.info("Checkout to vulnerable commit "+vulHash);
    ProcessBuilder builder = new ProcessBuilder("git","checkout",vulHash);
    builder.directory(new File(root));
    builder.start().waitFor();

    ControlFlowGraphAnalyzer analyzerOld = new ControlFlowGraphAnalyzer();
    analyzerOld.analyzeControlFlowGraph(file);
    analyzerOld.normalizeFunction(shownFunction);

    PhpFunction oldFunc = analyzerOld.getProjectData().getNormalizedFunction(shownFunction.get(0));
    ControlFlowGraph cfgOld = null;
    if(oldFunc != null){
     cfgOld = analyzerOld.getProjectData().getNormalizedFunction(shownFunction.get(0)).getControlFlowGraph();
    }

    Logger.info("Checkout to unvulnerable commit "+unvulHash);
    builder = new ProcessBuilder("git","checkout",unvulHash);
    builder.directory(new File(root));
    builder.start().waitFor();

    ControlFlowGraphAnalyzer analyzerNew = new ControlFlowGraphAnalyzer();
    analyzerNew.analyzeControlFlowGraph(file);
    analyzerNew.normalizeFunction(shownFunction);
    PhpFunction newFunc = analyzerNew.getProjectData().getNormalizedFunction(shownFunction.get(0));
    ControlFlowGraph cfgNew = null;
    if(newFunc != null){
      cfgNew = analyzerNew.getProjectData().getNormalizedFunction(shownFunction.get(0)).getControlFlowGraph();
    }

    ControlFlowGraphDiff diff = new ControlFlowGraphDiff();
    ControlFlowBlockGraph diffGraph = diff.diffGraph(cfgOld, cfgNew);
//    ControlFlowBlockGraph diffGraph = diff.diffGraphAnnotate(cfgOld, cfgNew);

//    GraphView view = new GraphView(cfgOld);
//    GraphView view = new GraphView(cfgNew);
//    GraphView view = new GraphView(new ControlFlowGraphDominators(cfgOld));
//    GraphView view = new GraphView(new ControlFlowGraphTranslator(cfgOld).translate());
    GraphView view = new GraphView(diffGraph);
    view.show();

    ControlFlowExporter.exportSVG(cfgOld.getGraph(), "D:\\cfg\\","11a-graphVul");
    ControlFlowExporter.exportSVG(cfgNew.getGraph(), "D:\\cfg\\","11a-graphNonvul");
//    ControlFlowExporter.exportSVG(diffGraph.getGraph(), "D:\\cfg\\","11a-graphDiff");
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
