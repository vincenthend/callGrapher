package analyzer;

import logger.Logger;
import model.graph.ControlFlowGraph;
import model.php.PhpFunction;
import model.ProjectData;
import org.jgrapht.Graphs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ControlFlowGraphAnalyzer {
  private boolean normalized = false;
  private ProjectData projectData;

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

  public void analyzeControlFlowGraph(String folder){
    List<String> filePaths = new LinkedList<>();
    filePaths.add(folder);
    analyzeControlFlowGraph(filePaths);
  }

  //TODO : Refactor this function
  public void analyzeControlFlowGraph(List<String> filePaths){
    projectData = new ProjectData();
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
    System.out.println();

    // Create control flow graph for all functions
    Logger.info("Generating control flow graph");
    FlowAnalyzer flowAnalyzer = new FlowAnalyzer(projectData);
    flowAnalyzer.analyzeAll();

    // Reduce function if empty
    Map<String, PhpFunction> functionMap = projectData.getFunctionMap();
    List<String> removeList = new ArrayList<>();
    for(Map.Entry<String, PhpFunction> functionEntry : functionMap.entrySet()){
      if(functionEntry.getValue().getControlFlowGraph().getFirstVertex() == null){
        Logger.info("Function "+functionEntry.getValue().getCalledName()+" is empty, removing...");
        removeList.add(functionEntry.getValue().getCalledName());
      }
    }
    for(String removeItem : removeList) {
      projectData.getFunctionMap().remove(removeItem);
    }
  }

  /**
   * Normalize control flow graph to replace all function call with function's CFG.
   * @param functionList function to be normalized, null to normalize all.
   */
  public void normalizeFunction(List<String> functionList){
    normalized = true;
    // Normalize functions
    Logger.info("Normalizing functions");
    if(!functionList.isEmpty()) {
      projectData.normalizeFunctions(functionList);
    } else {
      projectData.normalizeFunctions();
    }
  }

  // TODO : Deprecate later
  /**
   * Append list of functions to get combined control graph for display.
   * @param shownFunction functions to be shown
   * @return list of functions to be shown
   */
  public ControlFlowGraph getCombinedControlFlowGraph(List<String> shownFunction){
    // Append graph for viewing
    ControlFlowGraph cfg;
    if(shownFunction.isEmpty()) {
      if(normalized) {
        cfg = projectData.getCombinedNormalizedControlFlowGraph();
      } else {
        cfg = projectData.getCombinedControlFlowGraph();
      }
    } else {
      cfg = new ControlFlowGraph();
      for (String functionName: shownFunction) {
        PhpFunction phpFunction;
        if(normalized) {
          phpFunction = projectData.getNormalizedFunction(functionName);
        } else {
          phpFunction = projectData.getFunction(functionName);
        }
        Graphs.addGraph(cfg.getGraph(), phpFunction.getControlFlowGraph().getGraph());
      }
    }

    return cfg;
  }

  public ProjectData getProjectData() {
    return projectData;
  }
}
