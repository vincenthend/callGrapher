import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import logger.Logger;
import model.ControlFlowGraph;
import org.jgrapht.ext.JGraphXAdapter;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    // Parameters
    String path = "..\\phpmyadmin\\db_central_columns.php";
//     String path = ".\\testfile\\file4.php";
    boolean normalizeFunc = true;
    List<String> shownFunction = new LinkedList<>();
    shownFunction.add("NavigationTree::groupNode");

    ControlFlowGraph cfg = CallGraphAnalyzer.analyzeCallGraph(path, normalizeFunc, shownFunction);

    Logger.info("Drawing graphs");
    JFrame jFrame = new JFrame();
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    jFrame.setSize(400, 320);
    JGraphXAdapter jgxAdapter = new JGraphXAdapter(cfg.getGraph());
    mxGraphComponent mxcomp = new mxGraphComponent(jgxAdapter);

    jgxAdapter.getStylesheet().getDefaultEdgeStyle().put(mxConstants.STYLE_NOLABEL, "1");
    mxHierarchicalLayout layout = new mxHierarchicalLayout(jgxAdapter);
    layout.execute(jgxAdapter.getDefaultParent());
    jFrame.getContentPane().add(mxcomp);
    jFrame.setVisible(true);

    ControlFlowExporter.exportSVG(cfg, "D:\\");
  }
}
