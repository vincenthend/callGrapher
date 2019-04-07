package util;

import model.graph.ControlFlowEdge;
import model.graph.ControlFlowGraph;
import model.graph.block.statement.PhpStatement;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;

import java.util.*;

public class ControlFlowDepthFirstIterator implements Iterator<PhpStatement> {
  private Graph<PhpStatement, ControlFlowEdge> controlFlowGraph;
  private Set<PhpStatement> seenVertex;
  private Stack<PhpStatement> statementStack;
  private PhpStatement currentStatement;
  private Stack<PhpStatement> parentStack;
  private PhpStatement currentParent;


  public ControlFlowDepthFirstIterator(ControlFlowGraph cfg) {
    this.controlFlowGraph = cfg.getGraph();
    this.seenVertex = new HashSet<>();
    this.statementStack = new Stack<>();
    this.parentStack = new Stack<>();
    this.currentParent = null;

    statementStack.push(cfg.getFirstVertex());
    seenVertex.add(cfg.getFirstVertex());
  }

  @Override
  public boolean hasNext() {
    return !statementStack.isEmpty();
  }

  private int generateStatementSet() {
    int nbGenerated = 0;
    Set<ControlFlowEdge> succList = controlFlowGraph.outgoingEdgesOf(currentStatement);
    for(ControlFlowEdge edge : succList){
      PhpStatement statement = controlFlowGraph.getEdgeTarget(edge);
      if(!seenVertex.contains(statement)) {
        statementStack.push(statement);
        seenVertex.add(statement);
        nbGenerated++;
      }
    }
    return nbGenerated;
  }

  @Override
  public PhpStatement next() {
    currentStatement = statementStack.pop();
    if(!parentStack.isEmpty()){
      currentParent = parentStack.pop();
    }

    int nbChild = generateStatementSet();
    for(int i = 0; i < nbChild; i++){
      parentStack.push(currentStatement);
    }

    return currentStatement;
  }

  public PhpStatement peek() {
    return statementStack.peek();
  }

  public PhpStatement getParent() {
    return currentParent;
  }
}
