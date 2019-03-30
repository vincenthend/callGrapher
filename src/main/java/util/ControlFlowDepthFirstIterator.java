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

    intersectionSize = intersectionSize();
    if(intersectionSize > 1){
      intersectionStack.push(intersectionSize);
    }

    // Prevent generation on unfinished branches
    if(!isEndOfBranch()) {
      generateStatementSet();
    } else {
      int size = intersectionStack.pop();
      if(size > 1){
        intersectionStack.push(size - 1);
      } else {
        generateStatementSet();
      }
    }

    System.out.println(currentStatement);
    System.out.println("Stack : "+statementStack);
    System.out.println("Int : "+intersectionSize);
    System.out.println("IntStack : "+intersectionStack);
    return currentStatement;
  }

  public boolean isEndOfBranch() {
    List<PhpStatement> succ = Graphs.successorListOf(controlFlowGraph, currentStatement);
    return succ.size() == 1 && Graphs.predecessorListOf(controlFlowGraph, succ.get(0)).size() > 1 && !seenVertex.containsAll(succ);
  }

  private int intersectionSize() {
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

  public int peekIntersectionStack(){
    return intersectionStack.peek();
  }
}
