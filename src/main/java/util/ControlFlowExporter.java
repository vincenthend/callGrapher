package util;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxRectangle;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.xml.XMLConstants;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import logger.Logger;
import model.graph.ControlFlowGraph;
import model.graph.statement.PhpStatement;
import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.io.ComponentNameProvider;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.GraphExporter;
import org.w3c.dom.Document;

/**
 * Exports Control Flow Graph to file format
 */
public class ControlFlowExporter {
  private ControlFlowExporter(){
  }

  private static String validatePath(String path){
    return path.endsWith("\\") || path.endsWith("/") ? path : path + "/";
  }

  public static void exportPNG(Graph graph, String path) {
    //Save Image
    Logger.info("Exporting graph, please wait...");
    path = validatePath(path);
    JGraphXAdapter<PhpStatement, DefaultEdge> jgxAdapter = new JGraphXAdapter<>(graph);
    mxGraphComponent mxcomp = new mxGraphComponent(jgxAdapter);

    jgxAdapter.getStylesheet().getDefaultEdgeStyle().put(mxConstants.STYLE_NOLABEL, "1");
    mxHierarchicalLayout layout = new mxHierarchicalLayout(jgxAdapter);
    layout.execute(jgxAdapter.getDefaultParent());

    mxRectangle graphBound = mxcomp.getGraph().getGraphBounds();
    double maxWidth = 5000;
    double maxHeight = 5000;
    try {
      // Clipping and exporting
      int yCell = 0;
      double graphY = 0;
      while (graphY < graphBound.getHeight()) {
        int xCell = 0;
        double graphX = 0;
        while (graphX < graphBound.getWidth()) {
          mxRectangle clipRect = new mxRectangle(graphX, graphY, maxWidth, maxHeight);
          BufferedImage image = mxCellRenderer.createBufferedImage(mxcomp.getGraph(), null, 1, Color.WHITE, true, clipRect);
          ImageIO.write(image, "PNG", new File(path + "graph_" + xCell + "_" + yCell + ".png"));

          graphX += maxWidth;
          xCell += 1;
        }
        graphY += maxHeight;
        yCell += 1;
      }
      Logger.info("Graph exported succesfully to "+path);
    } catch (IOException e) {
      Logger.error("Failed to export graph");
    }
  }

  public static void exportSVG(Graph graph, String path, String name) {
    Logger.info("Exporting graph, please wait...");
    path = validatePath(path);
    JGraphXAdapter<PhpStatement, DefaultEdge> jgxAdapter = new JGraphXAdapter<>(graph);
    mxGraphComponent mxcomp = new mxGraphComponent(jgxAdapter);

    jgxAdapter.getStylesheet().getDefaultEdgeStyle().put(mxConstants.STYLE_NOLABEL, "1");
    mxHierarchicalLayout layout = new mxHierarchicalLayout(jgxAdapter);
    layout.execute(jgxAdapter.getDefaultParent());
    try {
      Document doc = mxCellRenderer.createSvgDocument(mxcomp.getGraph(), null, 1, Color.WHITE, null);
      DOMSource domSource = new DOMSource(doc);
      FileWriter fileWriter = new FileWriter(new File(path + name+ ".svg"));
      StreamResult streamResult = new StreamResult(fileWriter);

      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      transformerFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
      Transformer transformer = transformerFactory.newTransformer();
      transformer.transform(domSource, streamResult);
      fileWriter.close();
      Logger.info("Graph exported succesfully to "+path);
    } catch (Exception e){
      Logger.error("Failed to export graph");
    }
  }

  public static void exportGVImage(Graph graph, String path, String name, String format){
    Logger.info("Exporting graph, please wait...");
    path = validatePath(path);
    ComponentNameProvider<Object> vertexIdProvider = p -> p.getClass().getSimpleName()+"xx"+System.identityHashCode(p);
    ComponentNameProvider<Object> vertexLabelProvider = phpStatement -> phpStatement.toString().replace("\\","\\\\").replace("\n","\\n");
    GraphExporter<Object, DefaultEdge> exporter = new DOTExporter<>(vertexIdProvider, vertexLabelProvider, null);
    try {
      ProcessBuilder builder = new ProcessBuilder("dot","-T"+format);
      builder.directory(new File(path));
      builder.redirectOutput(new File(path+name+"."+format));
      Process process = builder.start();

      OutputStream stdin = process.getOutputStream();

      BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(stdin));
      exporter.exportGraph(graph, bufferedWriter);
      Logger.info("Graph exported succesfully to "+path);
    } catch (Exception e) {
      e.printStackTrace();
      Logger.error("Failed to export graph");
    }
  }

  public static void exportDot(Graph graph, String path, String name) {
    //Save Image
    Logger.info("Exporting graph, please wait...");
    path = validatePath(path);
    ComponentNameProvider<Object> vertexIdProvider = p -> p.getClass().getSimpleName()+"xx"+System.identityHashCode(p);
    ComponentNameProvider<Object> vertexLabelProvider = phpStatement -> phpStatement.toString().replace("\\","\\\\").replace("\n","\\n");
    GraphExporter<Object, DefaultEdge> exporter = new DOTExporter<>(vertexIdProvider, vertexLabelProvider, null);
    try {
      FileWriter fileWriter = new FileWriter(new File(path + name +".dot"));
      exporter.exportGraph(graph, fileWriter);
      Logger.info("Graph exported succesfully to "+path);
    } catch (Exception e) {
      Logger.error("Failed to export graph");
    }
  }

  public static void exportObject(ControlFlowGraph graph, String path, String name) {
    //Save Image
    Logger.info("Exporting graph, please wait...");
    try {
      FileOutputStream file = new FileOutputStream(new File(path + name +".cfg"));
      ObjectOutputStream out = new ObjectOutputStream(file);
      out.writeObject(graph);

      out.close();
      file.close();
      Logger.info("Graph exported succesfully to "+path);
    } catch (Exception e) {
      Logger.error("Failed to export graph");
    }
  }
}
