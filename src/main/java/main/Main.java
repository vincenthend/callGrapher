package main;

import analyzer.ControlFlowGraphAnalyzer;
import model.graph.ControlFlowGraph;
import model.job.DiffJobData;
import model.job.JobData;
import scanner.VulnerabilityScanner;
import util.ControlFlowExporter;
import util.builder.ControlFlowGraphTranslator;
import view.GraphView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    // Generate Model
    if (args[0].equals("-g") || args[0].equals("--generate")) {
      List<Integer> jobSelection = new ArrayList<>();
      if(args.length > 1){
        String[] jobSelArg = args[1].split(",");
        for(String job : jobSelArg) {
          jobSelection.add(Integer.valueOf(job));
        }
      } else {
        jobSelection.addAll(Arrays.asList(new Integer[]{0, 1, 3, 5, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 32, 33, 34, 36, 37, 38, 39, 41, 42, 43, 44, 46, 47, 48, 49, 50, 51, 52, 53, 54, 56, 57, 58, 59, 60, 61, 62, 66, 67}));
//        jobSelection.addAll(Arrays.asList(new Integer[]{0,1,3,5,8,10,11,12,13,14,15,16}));
//        jobSelection.addAll(Arrays.asList(new Integer[]{0,1,3,5,8,13,14,15,16,17,18,20,21,22,23,24,25,31,32,33,34,36,37,38}));
//        jobSelection.addAll(Arrays.asList(new Integer[]{11}));
      }
      VulnerabilityScanner.generateModel("../job.csv", jobSelection);
    } else if (args[0].equals("-s") || args[0].equals("--scan")) {

      if(args.length == 4) {
        JobData jobData = new JobData(1);
        jobData.setRoot(args[1]);
        String[] fileList = args[2].split("#");
        for(String file : fileList) {
          jobData.addFileList(file);
        }
        jobData.setShownFunction(args[3]);
        VulnerabilityScanner.predictVulnerable(jobData);
      } else {
        throw new IllegalArgumentException("Argument for scan \"-scan <root> <file1#file2> <function>");
      }
    }
  }

  public static void drawGraph(DiffJobData diffJobData) {
    // Parameters
    List<String> pathOld = diffJobData.getFileList();
    String shownFunction = diffJobData.getShownFunction();

    ControlFlowGraphAnalyzer analyzerOld = new ControlFlowGraphAnalyzer();
    analyzerOld.analyzeControlFlowGraph(pathOld);
    for (String removedFunc : diffJobData.getUnnormalizedFunction()) {
      analyzerOld.getProjectData().getFunctionMap().remove(removedFunc);
      analyzerOld.getProjectData().getNormalizedFunction(removedFunc);
    }
    analyzerOld.normalizeFunction(shownFunction, 0);
    ControlFlowGraph cfgOld = analyzerOld.getProjectData().getNormalizedFunction(shownFunction).getControlFlowGraph();

//    Logger.info("Abstracting function");
//    AbstractionAnalyzer.analyze(cfgOld);

//    GraphView view = new GraphView(cfgOld);
//    GraphView view = new GraphView(new ControlFlowGraphDominators(cfgOld));
    GraphView view = new GraphView(new ControlFlowGraphTranslator().translateToBlockGraph(cfgOld));
    view.show();

    String fileName = String.format("%03d", diffJobData.getId());
    String exportPath = diffJobData.getJobOptions().getExportPath();
    String exportFormat = diffJobData.getJobOptions().getExportFormat();
    ControlFlowExporter.exportGVImage(cfgOld.getGraph(), exportPath, fileName + "-graphVul", exportFormat);
  }
}
