import analyzer.FileAnalyzer;
import analyzer.FunctionAnalyzer;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.util.mxConstants;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import logger.Logger;
import model.ControlFlowGraph;
import org.jgrapht.ext.JGraphXAdapter;

public class Main {

  private static List<File> listFilesForFolder(final File file) {
    List<File> l = new ArrayList<File>();
    if (file.isDirectory()) {
      File[] files = file.listFiles();
      if (files != null) {
        for (final File fileEntry : files) {
          l.addAll(listFilesForFolder((fileEntry)));
        }
      }
    } else {
      if (file.getName().endsWith("php")) {
        l.add(file);
      }
    }
    return l;
  }

  public static void main(String[] args) {
    // Parameters
    String path = ".\\testfile\\";
    boolean normalizeFunc = true;
    String shownFunction = null;

    // List all functions
    File file = new File(path);
    List<File> fileList = listFilesForFolder(file);
    FileAnalyzer fileAnalyzer = new FileAnalyzer();
    for (File filePath : fileList) {
      Logger.info("Analyzing " + filePath);
      try {
        fileAnalyzer.analyze(filePath);
      } catch (IOException e) {
        Logger.error("File %s not found " + filePath.getAbsolutePath());
      }
    }
    System.out.println("==== Method list ====");
    System.out.println(fileAnalyzer.getProjectData().toString());

    // Create call graph for all functions
    System.out.println("==== Call list ====");
    FunctionAnalyzer functionAnalyzer = new FunctionAnalyzer(fileAnalyzer.getProjectData());
    functionAnalyzer.analyzeAll();

    ControlFlowGraph cfg;
    if(shownFunction == null) {
      cfg = fileAnalyzer.getProjectData().getControlFlowGraph();
    } else {
      cfg = fileAnalyzer.getProjectData().getFunction(shownFunction).getGraph();
    }


    if(normalizeFunc) {
      Logger.info("Normalizing functions");
      ControlFlowGraph.normalizeFunctionCall(cfg);
    }

    Logger.info("Drawing graphs");
    JFrame jFrame = new JFrame();
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setSize(400, 320);
    JGraphXAdapter jgxAdapter = new JGraphXAdapter(cfg.getGraph());
    mxGraphComponent mxcomp = new mxGraphComponent(jgxAdapter);

    jgxAdapter.getStylesheet().getDefaultEdgeStyle().put(mxConstants.STYLE_NOLABEL, "1");
    mxHierarchicalLayout layout = new mxHierarchicalLayout(jgxAdapter);
    layout.execute(jgxAdapter.getDefaultParent());

    //Save Image
    BufferedImage image = mxCellRenderer
        .createBufferedImage(mxcomp.getGraph(), null, 1, Color.WHITE, true, null);
    try {
      ImageIO.write(image, "PNG", new File("D:\\graph.png"));
    } catch(IOException e) {
      e.printStackTrace();
    }

    jFrame.getContentPane().add(mxcomp);
    jFrame.setVisible(true);
  }
}
