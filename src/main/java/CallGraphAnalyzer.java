import analyzer.DeclarationAnalyzer;
import analyzer.FlowAnalyzer;
import logger.Logger;
import model.ControlFlowGraph;
import model.ProjectData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CallGraphAnalyzer {
  private static List<File> listFilesForFolder(final File file) {
    List<File> l = new ArrayList<>();
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

  public static ControlFlowGraph analyzeCallGraph(String folder, boolean normalizeFunction){
    List<String> filePaths = new LinkedList<String>();
    filePaths.add(folder);
    return analyzeCallGraph(filePaths, normalizeFunction, null);
  }

  public static ControlFlowGraph analyzeCallGraph(String folder, boolean normalizeFunction, String shownFunction){
    List<String> filePaths = new LinkedList<String>();
    filePaths.add(folder);
    return analyzeCallGraph(filePaths, normalizeFunction, shownFunction);
  }

  public static ControlFlowGraph analyzeCallGraph(List<String> filePaths, boolean normalizeFunction){
    return analyzeCallGraph(filePaths, normalizeFunction, null);
  }

  public static ControlFlowGraph analyzeCallGraph(List<String> filePaths, boolean normalizeFunction, String shownFunction){
    ProjectData projectData = new ProjectData();
    DeclarationAnalyzer declarationAnalyzer = new DeclarationAnalyzer(projectData);
    List<File> fileList = new ArrayList<>();

    // List all functions
    for(String filePath : filePaths) {
      File file = new File(filePath);
      fileList.addAll(listFilesForFolder(file));
    }

    for (File file : fileList) {
      Logger.info("Analyzing " + file);
      try {
        declarationAnalyzer.analyze(file);
      } catch (IOException e) {
        Logger.error("File %s not found " + file.getAbsolutePath());
      }
    }
    System.out.println("==== Method list ====");
    System.out.println(projectData.toString());

    // Create control flow graph for all functions
    Logger.info("Generating control flow graph");
    FlowAnalyzer flowAnalyzer = new FlowAnalyzer(projectData);
    flowAnalyzer.analyzeAll();

    if(normalizeFunction) {
      Logger.info("Normalizing functions");
      projectData.normalizeControlFlowGraph();
    }

    ControlFlowGraph cfg;
    if(shownFunction == null) {
      if(normalizeFunction) {
        cfg = declarationAnalyzer.getProjectData().getCombinedNormalizedControlFlowGraph();
      } else {
        cfg = declarationAnalyzer.getProjectData().getCombinedControlFlowGraph();
      }
    } else {
      cfg = declarationAnalyzer.getProjectData().getFunction(shownFunction).getControlFlowGraph();
    }
    return cfg;
  }
}
