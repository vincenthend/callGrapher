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
  private PhpStatement currentStatement;


  public ControlFlowDepthFirstIterator(ControlFlowGraph cfg){
    this.controlFlowGraph = cfg.graph;
    this.seenVertex = new HashSet<>();
    this.statementStack = new Stack<>();

    statementStack.push(cfg.firstVertex);
    seenVertex.add(cfg.firstVertex);
  }

  @Override
  public boolean hasNext() {
    return !statementStack.isEmpty();
  }

  private void generateStatementSet(){
    List<PhpStatement> succList = Graphs.successorListOf(controlFlowGraph, currentStatement);
    for (PhpStatement succStatement : succList){
      if(!seenVertex.contains(succStatement)){
        statementStack.push(succStatement);
      }
    }
    seenVertex.addAll(succList);
  }

  @Override
  public PhpStatement next() {
    currentStatement = statementStack.pop();
    generateStatementSet();
    return currentStatement;
  }

  public boolean isEndOfBranch(){
    List<PhpStatement> succList = Graphs.successorListOf(controlFlowGraph, currentStatement);
    return seenVertex.containsAll(succList);
  }

  public int intersectionSize(){
    int nbIntersection = 0;
    List<PhpStatement> succList = Graphs.successorListOf(controlFlowGraph, currentStatement);
    for (PhpStatement succStatement : succList){
      if(!seenVertex.contains(succStatement)){
        nbIntersection += 1;
      }
    }
    return nbIntersection;
  }
}
