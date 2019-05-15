package util.iterator;

import model.graph.statement.PhpStatement;
import org.jgrapht.graph.DefaultEdge;
import util.builder.ControlFlowGraphDominators;

import java.util.*;

public class ControlFlowDominatorIterator implements Iterator<PhpStatement> {
  private ControlFlowGraphDominators dominatorGraph;
  private PhpStatement currentStatement;
  private Deque<PhpStatement> statementStack;
  private Set<PhpStatement> seenVertex;

  public ControlFlowDominatorIterator(ControlFlowGraphDominators cfgd, PhpStatement root) {
    this.dominatorGraph = cfgd;
    this.currentStatement = null;
    this.statementStack = new ArrayDeque<>();
    this.seenVertex = new HashSet<>();

    statementStack.push(root);
    seenVertex.add(root);
  }

  @Override
  public boolean hasNext() {
    return !statementStack.isEmpty();
  }

  private void generateStatementSet() {
    Set<DefaultEdge> succList = dominatorGraph.getTree().outgoingEdgesOf(currentStatement);
    PriorityQueue<PhpStatement> newStatement = new PriorityQueue<>((o1, o2) -> {
      int id1 = o1.getStatementId();
      int id2 = o2.getStatementId();

      if(id1 < id2){
        return 1;
      } else {
        return -1;
      }
    });

    for(DefaultEdge edge : succList) {
      PhpStatement statement = dominatorGraph.getTree().getEdgeTarget(edge);
      if(!seenVertex.contains(statement)){
        newStatement.add(statement);
        seenVertex.add(statement);
      }
    }

    Iterator<PhpStatement> stIterator = newStatement.iterator();
    while(stIterator.hasNext()) {
      statementStack.push(stIterator.next());
    }
  }

  @Override
  public PhpStatement next() {
    currentStatement = statementStack.pop();
    generateStatementSet();
    return currentStatement;
  }

  public PhpStatement peek() {
    if(hasNext()){
      return statementStack.peek();
    } else {
      return null;
    }
  }
}
