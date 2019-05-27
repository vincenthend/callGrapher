package main;

import analyzer.ControlFlowGraphAnalyzer;
import model.DiffJobData;
import model.JobData;
import model.graph.ControlFlowGraph;
import scanner.VulnerabilityScanner;
import util.ControlFlowExporter;
import util.builder.ControlFlowGraphTranslator;
import view.GraphView;

import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    // Generate Model
//    VulnerabilityScanner.generateModel();

    // Scan Files
    JobData jobData = new JobData(1);
    jobData.setRoot("../repo/testrepo/");
    jobData.addFileList("index.php");
    jobData.setShownFunction("index.php::main");

    VulnerabilityScanner.predictVulnerable(jobData);


    // SINGULAR DEBUG
//    jobList.get(0).getDiffJobOptions().setShownInterface("diff");
//    new DiffTask(jobList.get(0), 1).diffCommit();

    // DEBUG GUI
//    drawGraph(jobList.get(0));

    // DEBUG PREDICTOR
//    System.out.println(PhpFunctionPredictor.predictFunctionType(new PhpFunction("array_key_exists",null,"",null)));
//    System.out.println(PhpFunctionPredictor.predictFunctionType(new PhpFunction("array_key_exists",null,"",null)));

//     DEBUG
//    DiffJobData diffJobData = new DiffJobData(1);
//    diffJobData.setRoot("./testfile/");
//    diffJobData.setShownFunction("ModuleChangePassword::compile");
//    diffJobData.addFileList("file4.php");
//    diffJobData.setUnvulHash("123");
//    diffJobData.setVulHash("123");
//    drawGraph(diffJobData);
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
