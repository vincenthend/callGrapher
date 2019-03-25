package util;

import model.ControlFlowGraph;
import model.statement.PhpStatement;
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


  public ControlFlowDepthFirstIterator(ControlFlowGraph cfg) {
    this.controlFlowGraph = cfg.graph;
    this.seenVertex = new HashSet<>();
    this.statementStack = new Stack<>();
    this.intersectionStack = new Stack<>();

    statementStack.push(cfg.firstVertex);
    seenVertex.add(cfg.firstVertex);
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

    int size = intersectionSize();
    if(size > 1){
      intersectionStack.push(size);
    }

    // Prevent generation on unfinished branches
    if(!isEndOfBranch()) {
      generateStatementSet();
    } else {
      size = intersectionStack.pop();
      if(size > 1){
        intersectionStack.push(size - 1);
      } else {
        generateStatementSet();
      }
    }
    return currentStatement;
  }

  public boolean isEndOfBranch() {
    List<PhpStatement> pred = Graphs.predecessorListOf(controlFlowGraph, currentStatement);
    return pred.size() == 1 && Graphs.successorListOf(controlFlowGraph, pred.get(0)).size() > 1;
  }

  public int intersectionSize() {
    int nbIntersection = 0;
    List<PhpStatement> succList = Graphs.successorListOf(controlFlowGraph, currentStatement);
    for (PhpStatement succStatement : succList) {
      if (!seenVertex.contains(succStatement)) {
        nbIntersection += 1;
      }
    }
    return nbIntersection;
  }
}
