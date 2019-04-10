package view;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import logger.Logger;
import model.graph.ControlFlowBlockGraph;
import model.graph.ControlFlowGraph;
import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;
import util.ControlFlowGraphDominators;

import javax.swing.*;

public class GraphView {
  private Graph graph;

  public GraphView(ControlFlowGraph cfg) {
    graph = cfg.getGraph();
  }

  public GraphView(ControlFlowBlockGraph cbfg) {
    graph = cbfg.getGraph();
  }

  public GraphView(ControlFlowGraphDominators cfgd) {
    graph = cfgd.getTree();
  }

  public void show() {
    Logger.info("Drawing graphs");
    JFrame jFrame = new JFrame();
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    jFrame.setSize(400, 320);

    JGraphXAdapter jgxAdapter = new JGraphXAdapter(graph);
    jgxAdapter.getStylesheet().getDefaultEdgeStyle().put(mxConstants.STYLE_NOLABEL, "1");
    mxGraphComponent mxcomp = new mxGraphComponent(jgxAdapter);

    mxHierarchicalLayout layout = new mxHierarchicalLayout(jgxAdapter);

    layout.execute(jgxAdapter.getDefaultParent());
    jFrame.getContentPane().add(mxcomp);
    jFrame.setVisible(true);

  }
}
