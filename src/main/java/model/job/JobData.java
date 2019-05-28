package model.job;

import model.graph.ControlFlowGraph;

import java.util.LinkedList;
import java.util.List;

public class JobData {
  private int id;
  private String root;
  private List<String> fileList;
  private String shownFunction;
  private List<String> unnormalizedFunction;
  private JobOptions diffJobOptions;

  public JobData(int id) {
    this.id = id;
    fileList = new LinkedList<>();
    diffJobOptions = new JobOptions();
    unnormalizedFunction = new LinkedList<>();
  }

  public int getId() {
    return id;
  }

  public String getRoot() {
    return root;
  }

  public void setRoot(String root) {
    if(root.endsWith("/") || root.endsWith("\\")){
      this.root = root;
    } else {
      this.root = root + "/";
    }
  }

  public List<String> getFileList() {
    return fileList;
  }

  public void addFileList(String fileList) {
    this.fileList.add(root + fileList);
  }

  public String getShownFunction() {
    return shownFunction;
  }

  public void setShownFunction(String shownFunction) {
    this.shownFunction = shownFunction;
  }

  public JobOptions getJobOptions() {
    return diffJobOptions;
  }

  public void addUnnormalizedFunction(String functionName) {
    this.unnormalizedFunction.add(functionName);
  }

  public List<String> getUnnormalizedFunction() {
    return unnormalizedFunction;
  }

  public class JobOptions {
    private String shownInterface;
    private String exportFormat;
    private String exportPath;
    private boolean annotateDiff;

    public JobOptions() {
      shownInterface = "diff";
      exportFormat = "obj";
      exportPath = "./";
      annotateDiff = false;
    }

    public String getShownInterface() {
      return shownInterface;
    }

    public void setShownInterface(String shownInterface) {
      this.shownInterface = shownInterface;
    }

    public String getExportFormat() {
      return exportFormat;
    }

    public void setExportFormat(String exportFormat) {
      this.exportFormat = exportFormat;
    }

    public String getExportPath() {
      return exportPath;
    }

    public void setExportPath(String exportPath) {
      this.exportPath = exportPath;
    }

    public boolean isAnnotateDiff() {
      return annotateDiff;
    }

    public void setAnnotateDiff(boolean annotateDiff) {
      this.annotateDiff = annotateDiff;
    }
  }
}
