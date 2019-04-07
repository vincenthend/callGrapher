import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxRectangle;
import logger.Logger;
import model.graph.ControlFlowGraph;
import model.graph.block.statement.PhpStatement;
import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.io.ComponentNameProvider;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.GraphExporter;
import org.w3c.dom.Document;

import javax.imageio.ImageIO;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Exports Control Flow Graph to file format
 */
public class ControlFlowExporter {

  public static void exportPNG(ControlFlowGraph cfg, String path) {
    //Save Image
    Logger.info("Exporting graph, please wait...");
    JGraphXAdapter<PhpStatement, DefaultEdge> jgxAdapter = new JGraphXAdapter<>(cfg.getGraph());
    mxGraphComponent mxcomp = new mxGraphComponent(jgxAdapter);

    jgxAdapter.getStylesheet().getDefaultEdgeStyle().put(mxConstants.STYLE_NOLABEL, "1");
    mxHierarchicalLayout layout = new mxHierarchicalLayout(jgxAdapter);
    layout.execute(jgxAdapter.getDefaultParent());

    mxRectangle graphBound = mxcomp.getGraph().getGraphBounds();
    double maxWidth = 5000;
    double maxHeight = 5000;
    try {
      // Clipping and exporting
      int y_cell = 0;
      double graphY = 0;
      while (graphY < graphBound.getHeight()) {
        int x_cell = 0;
        double graphX = 0;
        while (graphX < graphBound.getWidth()) {
          mxRectangle clipRect = new mxRectangle(graphX, graphY, maxWidth, maxHeight);
          BufferedImage image = mxCellRenderer.createBufferedImage(mxcomp.getGraph(), null, 1, Color.WHITE, true, clipRect);
          ImageIO.write(image, "PNG", new File(path + "graph_" + x_cell + "_" + y_cell + ".png"));

          graphX += maxWidth;
          x_cell += 1;
        }
        graphY += maxHeight;
        y_cell += 1;
      }
      Logger.info("Graph exported succesfully");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void exportSVG(ControlFlowGraph cfg, String path) {
    Logger.info("Exporting graph, please wait...");
    JGraphXAdapter<PhpStatement, DefaultEdge> jgxAdapter = new JGraphXAdapter<>(cfg.getGraph());
    mxGraphComponent mxcomp = new mxGraphComponent(jgxAdapter);

    jgxAdapter.getStylesheet().getDefaultEdgeStyle().put(mxConstants.STYLE_NOLABEL, "1");
    mxHierarchicalLayout layout = new mxHierarchicalLayout(jgxAdapter);
    layout.execute(jgxAdapter.getDefaultParent());
    try {
      Document doc = mxCellRenderer.createSvgDocument(mxcomp.getGraph(), null, 1, Color.WHITE, null);
      DOMSource domSource = new DOMSource(doc);
      FileWriter fileWriter = new FileWriter(new File(path + "graph.svg"));
      StreamResult streamResult = new StreamResult(fileWriter);

      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      transformer.transform(domSource, streamResult);

      Logger.info("Graph exported succesfully");
    } catch (Exception e){
      e.printStackTrace();
    }
  }

  public static void exportDot(ControlFlowGraph cfg, String path) {
    //Save Image
    Logger.info("Exporting graph, please wait...");
    Graph<PhpStatement, DefaultEdge> graph = cfg.getGraph();
    ComponentNameProvider<PhpStatement> vertexIdProvider = new ComponentNameProvider<PhpStatement>() {
      @Override
      public String getName(PhpStatement p) {
        return p.toString().replaceAll("\\s", "");
      }
    };
    ComponentNameProvider<PhpStatement> vertexLabelProvider = new ComponentNameProvider<PhpStatement>() {
      @Override
      public String getName(PhpStatement phpStatement) {
        return phpStatement.toString();
      }
    };
    GraphExporter<PhpStatement, DefaultEdge> exporter = new DOTExporter<>(vertexIdProvider, vertexLabelProvider, null);
    try {
      FileWriter fileWriter = new FileWriter(new File(path + "graph.dot"));
      exporter.exportGraph(graph, fileWriter);
      Logger.info("Graph exported succesfully");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
