package util;

import model.graph.ControlFlowEdge;
import model.graph.ControlFlowGraph;
import model.graph.block.statement.BranchStatement;
import model.graph.block.statement.PhpStatement;
import model.graph.block.statement.StatementType;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

import static model.graph.ControlFlowEdge.ControlFlowEdgeType.BRANCH;
import static model.graph.block.statement.BranchStatement.BranchStatementType.BRANCH_POINT;

public class ControlFlowDominatorIterator implements Iterator<PhpStatement> {
  private ControlFlowGraphDominators dominatorGraph;
  private PhpStatement currentStatement;
  private Stack<PhpStatement> statementStack;
  private Set<PhpStatement> seenVertex;

  public ControlFlowDominatorIterator(ControlFlowGraphDominators cfgd, PhpStatement root) {
    this.dominatorGraph = cfgd;
    this.currentStatement = null;
    this.statementStack = new Stack<>();
    this.seenVertex = new HashSet<>();

    statementStack.push(root);
    seenVertex.add(root);
  }

  @Override
  public boolean hasNext() {
    return !statementStack.isEmpty();
  }

  private void generateStatementSet(){
    Set<DefaultEdge> succList = dominatorGraph.getTree().outgoingEdgesOf(currentStatement);
    PriorityQueue<PhpStatement> newStatement = new PriorityQueue<>(new Comparator<PhpStatement>() {
      @Override
      public int compare(PhpStatement o1, PhpStatement o2) {
        int id1 = o1.getStatementId();
        int id2 = o2.getStatementId();

        if(id1 < id2){
          return 1;
        } else {
          return -1;
        }
      }
    });

    for(DefaultEdge edge : succList){
      PhpStatement statement = dominatorGraph.getTree().getEdgeTarget(edge);
      if(!seenVertex.contains(statement)) {
        newStatement.add(statement);
        seenVertex.add(statement);
      }
    }

    Iterator<PhpStatement> stIterator = newStatement.iterator();
    while(stIterator.hasNext()){
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
