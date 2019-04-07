package util;

import model.graph.ControlFlowEdge;
import model.graph.ControlFlowGraph;
import model.graph.block.statement.BranchStatement;
import model.graph.block.statement.PhpStatement;
import model.graph.block.statement.StatementType;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;

import java.util.*;

import static model.graph.ControlFlowEdge.ControlFlowEdgeType.BRANCH;
import static model.graph.block.statement.BranchStatement.BranchStatementType.BRANCH_POINT;

public class ControlFlowDIYIterator implements Iterator<PhpStatement> {
  private Graph<PhpStatement, ControlFlowEdge> controlFlowGraph;
  private Set<PhpStatement> seenVertex;
  private Stack<PhpStatement> statementStack;
  private Stack<Integer> intersectionStack;
  private PhpStatement currentStatement;
  private int branchSize;


  public ControlFlowDIYIterator(ControlFlowGraph cfg) {
    this.controlFlowGraph = cfg.getGraph();
    this.seenVertex = new HashSet<>();
    this.statementStack = new Stack<>();
    this.intersectionStack = new Stack<>();

    statementStack.push(cfg.getFirstVertex());
    seenVertex.add(cfg.getFirstVertex());
  }

  @Override
  public boolean hasNext() {
    return !statementStack.isEmpty();
  }

  private void generateStatementSet() {
//    System.out.print("[[generate]]");
    List<PhpStatement> succList = Graphs.successorListOf(controlFlowGraph, currentStatement);
    for (PhpStatement succStatement : succList) {
      if (currentStatement.getStatementType() == StatementType.BRANCH && ((BranchStatement)currentStatement).getType() == BRANCH_POINT) {
        if (!seenVertex.contains(succStatement) && controlFlowGraph.getEdge(currentStatement, succStatement).getEdgeType() == BRANCH) {
          statementStack.push(succStatement);
          seenVertex.add(succStatement);
        }
      } else {
        if (!seenVertex.contains(succStatement)) {
          statementStack.push(succStatement);
          seenVertex.add(succStatement);
        }
      }
    }
  }

  @Override
  public PhpStatement next() {
    currentStatement = statementStack.pop();
    branchSize = updateBranchSize();
//    System.out.print("DFS : " + currentStatement);
//    System.out.print(" " + isEndOfBranch() + "("+branchSize+") ");
    if (branchSize >= 1) {
      intersectionStack.push(branchSize);
    }

    // Prevent generation on unfinished branches
    if (!isEndOfBranch()) {
      generateStatementSet();
    } else {
      int size = intersectionStack.pop();
//      System.out.print("~"+size+" ");
      if (size > 1) {
        intersectionStack.push(size - 1);
      } else {
        generateStatementSet();
      }
    }

//    System.out.println(" - stack : " + statementStack);
//    System.out.println("Intersection : " + intersectionStack);

    return currentStatement;
  }

  public boolean isEndOfBranch() {
    boolean isEnd;
    List<PhpStatement> succList = Graphs.successorListOf(controlFlowGraph, currentStatement);
    if (succList.size() == 1 && succList.get(0).getStatementType() == StatementType.BRANCH) {
      BranchStatement branchStatement = (BranchStatement) succList.get(0);
      return branchStatement.getType() == BranchStatement.BranchStatementType.BRANCH_END;
    }
    return false;
  }

  private int updateBranchSize() {
    int nbIntersection = 0;
    List<PhpStatement> succList = Graphs.successorListOf(controlFlowGraph, currentStatement);
    for (PhpStatement succStatement : succList) {
      if (controlFlowGraph.getEdge(currentStatement, succStatement).getEdgeType() == BRANCH) {
        nbIntersection += 1;
      }
    }
    return nbIntersection;
  }

  public int getBranchSize() {
    return branchSize;
  }

  public PhpStatement peek() {
    return statementStack.peek();
  }
}
