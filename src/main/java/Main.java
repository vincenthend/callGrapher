import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxStylesheet;
import logger.Logger;
import model.graph.ControlFlowBlockGraph;
import model.graph.ControlFlowGraph;
import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;
import util.ControlFlowGraphDominators;
import util.ControlFlowGraphTranslator;
import view.GraphView;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    // Parameters
    List<String> path = new LinkedList<>();
//    path.add("../phpmyadmin/libraries/classes/Navigation/NavigationTree.php");
//    path.add("../phpmyadmin/libraries/classes/Navigation/Nodes/Node.php");
//    path.add("../phpmyadmin/libraries/classes/Navigation/Nodes/NodeDatabase.php");
//    path.add("../phpmyadmin/libraries/classes/Navigation/Nodes/NodeTable.php");
//    path.add("../phpmyadmin/libraries/classes/Navigation/Nodes/NodeTableContainer.php");
//    path.add("../phpmyadmin/libraries/classes/Navigation/Nodes/NodeViewContainer.php");
//    path.add("../phpmyadmin/libraries/classes/RecentFavoriteTable.php");
//    path.add("../phpmyadmin/libraries/classes/Response.php");
//    path.add("../phpmyadmin/libraries/classes/Util.php");
//    path.add("../phpmyadmin/libraries/classes/Url.php");
//    path.add("./testfile/file1.php");
//    path.add("./testfile/file2.php");
//    path.add("./testfile/file3.php");
    path.add("./testfile/file4.php");

    boolean normalizeFunc = true;
    List<String> shownFunction = new LinkedList<>();
//    shownFunction.add("NavigationTree::groupNode");
//    shownFunction.add("UserController::showProfile");
    shownFunction.add("SQLConnector::runQuery");

    ControlFlowGraphAnalyzer analyzer = new ControlFlowGraphAnalyzer();
    analyzer.analyzeControlFlowGraph(path);
    if (normalizeFunc) {
      analyzer.normalizeFunction(shownFunction);
    }
    ControlFlowGraphDominators cfgd = new ControlFlowGraphDominators(analyzer.getProjectData().getFunction(shownFunction.get(0)).getControlFlowGraph());


    // Translate to block graph
//    ControlFlowGraphTranslator translator = new ControlFlowGraphTranslator(analyzer.getProjectData().getNormalizedFunction((shownFunction.get(0))).getControlFlowGraph());
//    ControlFlowBlockGraph blockGraph = translator.translate();

    ControlFlowGraph cfg = analyzer.getCombinedControlFlowGraph(shownFunction);
    GraphView view = new GraphView(cfg);
    view.show();

    ControlFlowExporter.exportSVG(cfg, "D:\\");
  }
}
