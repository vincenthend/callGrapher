package model;

import model.graph.ControlFlowGraph;

public class DiffJobData extends JobData {
  private String vulHash;
  private String unvulHash;
  private ControlFlowGraph oldGraph;
  private ControlFlowGraph newGraph;
  private ControlFlowGraph diffGraphOld;
  private ControlFlowGraph diffGraphNew;

  public DiffJobData(int id) {
    super(id);
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

  public ControlFlowGraph getDiffGraphOld() {
    return diffGraphOld;
  }

  public void setDiffGraphOld(ControlFlowGraph diffGraph) {
    this.diffGraphOld = diffGraph;
  }

  public ControlFlowGraph getDiffGraphNew() {
    return diffGraphNew;
  }

  public void setDiffGraphNew(ControlFlowGraph diffGraphNew) {
    this.diffGraphNew = diffGraphNew;
  }

  public ControlFlowGraph getOldGraph() {
    return oldGraph;
  }

  public void setOldGraph(ControlFlowGraph oldGraph) {
    this.oldGraph = oldGraph;
  }

  public ControlFlowGraph getNewGraph() {
    return newGraph;
  }

  public void setNewGraph(ControlFlowGraph newGraph) {
    this.newGraph = newGraph;
  }
}
