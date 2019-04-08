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
    path.add("./testfile/file1.php");
    path.add("./testfile/file2.php");
    path.add("./testfile/file3.php");
//    path.add("./testfile/file4.php");

    boolean normalizeFunc = true;
    List<String> shownFunction = new LinkedList<>();
//    shownFunction.add("NavigationTree::groupNode");
    shownFunction.add("UserController::showProfile");
//    shownFunction.add("SQLConnector::runQuery");

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
//    ControlFlowBlockGraph cfbg = blockGraph;
    Logger.info("Drawing graphs");
    JFrame jFrame = new JFrame();
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    jFrame.setSize(400, 320);
//    JGraphXAdapter jgxAdapter = new JGraphXAdapter(cfgd.getTree());
    JGraphXAdapter jgxAdapter = new JGraphXAdapter(cfg.getGraph());
//    JGraphXAdapter jgxAdapter = new JGraphXAdapter(cfbg.getGraph());

    jgxAdapter.getStylesheet().getDefaultEdgeStyle().put(mxConstants.STYLE_NOLABEL, "1");
    mxGraphComponent mxcomp = new mxGraphComponent(jgxAdapter);

    mxHierarchicalLayout layout = new mxHierarchicalLayout(jgxAdapter);

    layout.execute(jgxAdapter.getDefaultParent());
    jFrame.getContentPane().add(mxcomp);
    jFrame.setVisible(true);

    ControlFlowExporter.exportSVG(cfg, "D:\\");
  }
}
