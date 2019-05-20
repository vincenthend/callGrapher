package analyzer;

import logger.Logger;
import model.ProjectData;
import model.php.PhpFunction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ControlFlowGraphAnalyzer {
  private ProjectData projectData;

  // TODO Move this from here
  private List<File> listFilesForFolder(final File file) {
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


  //TODO : Refactor this function
  public void analyzeControlFlowGraph(List<String> filePaths) {
    projectData = new ProjectData();
    DeclarationAnalyzer declarationAnalyzer = new DeclarationAnalyzer(projectData);
    List<File> fileList = new ArrayList<>();

    // List all functions
    for (String filePath : filePaths) {
      File file = new File(filePath);
      fileList.addAll(listFilesForFolder(file));
    }

    for (File file : fileList) {
      Logger.info("Analyzing " + file);
      try {
        declarationAnalyzer.analyze(file);
      } catch (IOException e) {
        Logger.error("File not found: " + file.getAbsolutePath());
      }
    }

    Logger.info("==== Method list ====");
    Logger.info(projectData.toString());
    Logger.info("");

    // Create control flow graph for all functions
    Logger.info("Generating control flow graph");
    FlowAnalyzer flowAnalyzer = new FlowAnalyzer(projectData);
    flowAnalyzer.analyzeAll();

    // Reduce function if empty
    Map<String, PhpFunction> functionMap = projectData.getFunctionMap();
    List<String> removeList = new ArrayList<>();
    for (Map.Entry<String, PhpFunction> functionEntry : functionMap.entrySet()) {
      if (functionEntry.getValue().getControlFlowGraph().getFirstVertex() == null) {
        Logger.info("Function " + functionEntry.getValue().getCalledName() + " is empty, removing...");
        removeList.add(functionEntry.getValue().getCalledName());
      }
    }
    for (String removeItem : removeList) {
      projectData.getFunctionMap().remove(removeItem);
    }
  }

  /**
   * Normalize control flow graph to replace all function call with function's CFG.
   *
   * @param functionName function to be normalized, null to normalize all.
   * @param maxDepth     maximum normalization depth.
   */
  public void normalizeFunction(String functionName, int maxDepth) {
    Logger.info("Normalizing functions");
    projectData.normalizeFunction(functionName, maxDepth);
  }

  public ProjectData getProjectData() {
    return projectData;
  }
}
