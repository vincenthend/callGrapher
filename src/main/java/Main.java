import model.graph.ControlFlowGraph;
import util.diff.ControlFlowGraphDiff;
import view.GraphView;

import java.util.LinkedList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    // Parameters
    List<String> pathOld = new LinkedList<>();
    pathOld.add("../phpmyadminvul/libraries/classes/Navigation/NavigationTree.php");
    pathOld.add("../phpmyadminvul/libraries/classes/Navigation/Nodes/Node.php");
    pathOld.add("../phpmyadminvul/libraries/classes/Navigation/Nodes/NodeDatabase.php");
    pathOld.add("../phpmyadminvul/libraries/classes/Navigation/Nodes/NodeTable.php");
    pathOld.add("../phpmyadminvul/libraries/classes/Navigation/Nodes/NodeTableContainer.php");
    pathOld.add("../phpmyadminvul/libraries/classes/Navigation/Nodes/NodeViewContainer.php");
    pathOld.add("../phpmyadminvul/libraries/classes/RecentFavoriteTable.php");
    pathOld.add("../phpmyadminvul/libraries/classes/Response.php");
    pathOld.add("../phpmyadminvul/libraries/classes/Util.php");
    pathOld.add("../phpmyadminvul/libraries/classes/Url.php");

    List<String> pathNew = new LinkedList<>();
    pathNew.add("../phpmyadmin/libraries/classes/Navigation/NavigationTree.php");
    pathNew.add("../phpmyadmin/libraries/classes/Navigation/Nodes/Node.php");
    pathNew.add("../phpmyadmin/libraries/classes/Navigation/Nodes/NodeDatabase.php");
    pathNew.add("../phpmyadmin/libraries/classes/Navigation/Nodes/NodeTable.php");
    pathNew.add("../phpmyadmin/libraries/classes/Navigation/Nodes/NodeTableContainer.php");
    pathNew.add("../phpmyadmin/libraries/classes/Navigation/Nodes/NodeViewContainer.php");
    pathNew.add("../phpmyadmin/libraries/classes/RecentFavoriteTable.php");
    pathNew.add("../phpmyadmin/libraries/classes/Response.php");
    pathNew.add("../phpmyadmin/libraries/classes/Util.php");
    pathNew.add("../phpmyadmin/libraries/classes/Url.php");

    List<String> shownFunction = new LinkedList<>();
//    shownFunction.add("SQLConnector::runQuery");
    shownFunction.add("NavigationTree::groupNode");
//    shownFunction.add("UserController::showProfile");

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
