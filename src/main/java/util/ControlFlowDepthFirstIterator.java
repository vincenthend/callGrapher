package util;

import model.graph.ControlFlowGraph;
import model.graph.block.statement.PhpStatement;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class ControlFlowDepthFirstIterator implements Iterator<PhpStatement> {
  private Graph<PhpStatement, DefaultEdge> controlFlowGraph;
  private Set<PhpStatement> seenVertex;
  private Stack<PhpStatement> statementStack;
  private Stack<Integer> intersectionStack;
  private PhpStatement currentStatement;
  private int intersectionSize;


  public ControlFlowDepthFirstIterator(ControlFlowGraph cfg) {
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
    List<PhpStatement> succList = Graphs.successorListOf(controlFlowGraph, currentStatement);
    for (PhpStatement succStatement : succList) {
      if (!seenVertex.contains(succStatement)) {
        statementStack.push(succStatement);
      }
    }
    seenVertex.addAll(succList);
  }

  @Override
  public PhpStatement next() {
    currentStatement = statementStack.pop();
    System.out.print("DFS : "+currentStatement);
    intersectionSize = updateIntersectionSize();
    if (intersectionSize > 1) {
      intersectionStack.push(intersectionSize);
    }

    // Prevent generation on unfinished branches
    if (!isEndOfBranch()) {
      generateStatementSet();
    } else {
      int size = intersectionStack.pop();
      if (size > 1) {
        intersectionStack.push(size - 1);
      } else {
        generateStatementSet();
      }
    }

    System.out.println(" - stack : "+statementStack);
    System.out.println("Intersection : "+intersectionStack);

    return currentStatement;
  }

  public boolean isEndOfBranch() {
    return currentStatement.isEndOfBranch();
  }

  private int updateIntersectionSize() {
    int nbIntersection = 0;
    List<PhpStatement> succList = Graphs.successorListOf(controlFlowGraph, currentStatement);
    for (PhpStatement succStatement : succList) {
      if (!seenVertex.contains(succStatement)) {
        nbIntersection += 1;
      }
    }
    return nbIntersection;
  }

  public int getIntersectionSize() {
    return intersectionSize;
  }

  public PhpStatement peek(){
    return statementStack.peek();
  }
}
