package model.graph;

import org.jgrapht.graph.DefaultEdge;

import static model.graph.ControlFlowEdge.ControlFlowEdgeType.GENERAL;

public class ControlFlowEdge extends DefaultEdge {
  private ControlFlowEdgeType edgeType;

  public ControlFlowEdge() {
    super();
    edgeType = GENERAL;
  }

  public ControlFlowEdge(ControlFlowEdgeType type) {
    super();
    edgeType = type;
  }

  public ControlFlowEdgeType getEdgeType() {
    return edgeType;
  }

  @Override
  public String toString() {
    return edgeType == GENERAL ? "" : edgeType.toString();
  }

  public enum ControlFlowEdgeType {
    LOOP,
    BRANCH,
    GENERAL,
  }
}
