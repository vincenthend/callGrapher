import analyzer.FileAnalyzer;
import analyzer.FunctionAnalyzer;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.ldap.Control;
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
    String path = ".\\testfile\\testfile.php";
    FileAnalyzer fileAnalyzer = new FileAnalyzer();

    // List all functions
    File file = new File(path);
    List<File> fileList = listFilesForFolder(file);
    for (File filePath : fileList) {
      System.out.println("Analyzing " + filePath);
      try {
        fileAnalyzer.analyze(filePath);
      } catch (IOException e) {
        System.out.printf("File %s not found", filePath.getAbsolutePath());
      }
    }
    System.out.println("==== Method list ====");
    System.out.println(fileAnalyzer.getProjectData().toString());

    // Create call graph for all functions
    System.out.println("==== Call list ====");
    FunctionAnalyzer functionAnalyzer = new FunctionAnalyzer(fileAnalyzer.getProjectData());
    functionAnalyzer.analyzeAll();

    JFrame jFrame = new JFrame();
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setSize(400, 320);

    Logger.info("Normalizing functions");
    ControlFlowGraph.normalizeFunctionCall(fileAnalyzer.getProjectData().getControlFlowGraph());
    JGraphXAdapter jgxAdapter = new JGraphXAdapter(fileAnalyzer.getProjectData().getControlFlowGraph().getGraph());
    mxGraphComponent mxcomp = new mxGraphComponent(jgxAdapter);

    jgxAdapter.getStylesheet().getDefaultEdgeStyle().put(mxConstants.STYLE_NOLABEL, "1");
    mxHierarchicalLayout layout = new mxHierarchicalLayout(jgxAdapter);
    layout.execute(jgxAdapter.getDefaultParent());

    jFrame.getContentPane().add(mxcomp);
    jFrame.setVisible(true);
  }
}
