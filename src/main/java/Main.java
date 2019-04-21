import model.graph.ControlFlowGraph;
import util.diff.ControlFlowGraphDiff;
import view.GraphView;

import java.util.LinkedList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    // Parameters
    List<String> pathOld = new LinkedList<>();
    pathOld.add("../phpmyadminvul/libraries/common.inc.php");
    pathOld.add("../phpmyadminvul/libraries/classes/Navigation/NavigationTree.php");
    pathOld.add("../phpmyadminvul/libraries/Config.php");
    pathOld.add("../phpmyadminvul/libraries/DatabaseInterface.php");
    pathOld.add("../phpmyadminvul/libraries/ErrorHandler.php");
    pathOld.add("../phpmyadminvul/libraries/Message.php");
    pathOld.add("../phpmyadminvul/libraries/plugins/AuthenticationPlugin.php");
    pathOld.add("../phpmyadminvul/libraries/DbList.php");
    pathOld.add("../phpmyadminvul/libraries/ThemeManager.php");
    pathOld.add("../phpmyadminvul/libraries/Tracker.php");
    pathOld.add("../phpmyadminvul/libraries/Response.php");
    pathOld.add("../phpmyadminvul/libraries/TypesMySQL.php");
    pathOld.add("../phpmyadminvul/libraries/Util.php");
    pathOld.add("../phpmyadminvul/libraries/LanguageManager.php");
    pathOld.add("../phpmyadminvul/libraries/Logging.php");

    List<String> pathNew = new LinkedList<>();
    pathNew.add("../phpmyadmin/libraries/common.inc.php");
    pathNew.add("../phpmyadmin/libraries/classes/Navigation/NavigationTree.php");
    pathNew.add("../phpmyadmin/libraries/Config.php");
    pathNew.add("../phpmyadmin/libraries/DatabaseInterface.php");
    pathNew.add("../phpmyadmin/libraries/ErrorHandler.php");
    pathNew.add("../phpmyadmin/libraries/Message.php");
    pathNew.add("../phpmyadmin/libraries/plugins/AuthenticationPlugin.php");
    pathNew.add("../phpmyadmin/libraries/DbList.php");
    pathNew.add("../phpmyadmin/libraries/ThemeManager.php");
    pathNew.add("../phpmyadmin/libraries/Tracker.php");
    pathNew.add("../phpmyadmin/libraries/Response.php");
    pathNew.add("../phpmyadmin/libraries/TypesMySQL.php");
    pathNew.add("../phpmyadmin/libraries/Util.php");
    pathNew.add("../phpmyadmin/libraries/LanguageManager.php");
    pathNew.add("../phpmyadmin/libraries/Logging.php");

    List<String> shownFunction = new LinkedList<>();
//    shownFunction.add("SQLConnector::runQuery");
//    shownFunction.add("NavigationTree::groupNode");
//    shownFunction.add("UserController::showProfile");
    shownFunction.add("common.inc.php::main");

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

    ControlFlowExporter.exportSVG(cfgOld, "D:\\");
  }
}
