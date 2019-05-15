package model;

import java.util.LinkedList;
import java.util.List;

public class DiffJobData {
  private int id;
  private String root;
  private String vulHash;
  private String unvulHash;
  private List<String> fileList;
  private String shownFunction;
  private DiffJobOptions diffJobOptions;

  public DiffJobData(int id) {
    this.id = id;
    fileList = new LinkedList<>();
    diffJobOptions = new DiffJobOptions();
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

  public String getVulHash() {
    return vulHash;
  }

  public void setVulHash(String vulHash) {
    this.vulHash = vulHash;
  }

  public String getUnvulHash() {
    return unvulHash;
  }

  public void setUnvulHash(String unvulHash) {
    this.unvulHash = unvulHash;
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

  public DiffJobOptions getDiffJobOptions() {
    return diffJobOptions;
  }

  public class DiffJobOptions {
    private String shownInterface;
    private String exportFormat;
    private String exportPath;
    private boolean annotateDiff;

    public DiffJobOptions() {
      shownInterface = "diff";
      exportFormat = "svg";
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
