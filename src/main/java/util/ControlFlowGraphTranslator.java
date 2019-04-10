package util;

import logger.Logger;
import model.graph.ControlFlowBlockGraph;
import model.graph.ControlFlowEdge;
import model.graph.ControlFlowGraph;
import model.graph.block.PhpBasicBlock;
import model.graph.block.statement.PhpStatement;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class ControlFlowGraphTranslator {
  private ControlFlowGraph cfg;
  private ControlFlowGraphDominators dominators;

  public ControlFlowGraphTranslator(ControlFlowGraph cfg) {
    this.cfg = cfg;
    this.dominators = new ControlFlowGraphDominators(cfg);
  }

  /**
   * Translate a CFG into a CFBlockGraph.
   * @return result of translations
   */
  public ControlFlowBlockGraph translate() {
    ControlFlowBlockGraphBuilder blockGraphFactory = new ControlFlowBlockGraphBuilder();
    ControlFlowDominatorIterator iterator = dominators.iterator();

    Logger.info("Translating to block graph");
    while (iterator.hasNext()) {
      PhpStatement statement = iterator.next();
      blockGraphFactory.addStatement(statement);
      if(dominators.getTree().outgoingEdgesOf(statement).size() != 1){
        blockGraphFactory.closeBlock();
        if(iterator.peek() != null){
          // Get next basic block
          Iterator<ControlFlowEdge> edgeIterator = cfg.getGraph().incomingEdgesOf(iterator.peek()).iterator();
          List<PhpBasicBlock> parentBlocks = new ArrayList<>();
          while(edgeIterator.hasNext()){
            PhpStatement p = cfg.getGraph().getEdgeSource(edgeIterator.next());
            if(p.getBasicBlock() != null) {
              parentBlocks.add(p.getBasicBlock());
            }
          }
          blockGraphFactory.openBlock(parentBlocks);
        }
      }

      // Check if child has basic block
      for (ControlFlowEdge controlFlowEdge : cfg.getGraph().outgoingEdgesOf(statement)) {
        PhpStatement connectedStatement = cfg.getGraph().getEdgeTarget(controlFlowEdge);
        if (connectedStatement.getBasicBlock() != null) {
          PhpBasicBlock connectedBlock = connectedStatement.getBasicBlock();
          // If connected in the middle, split block
          if (connectedBlock.getBlockStatements().getFirst() != connectedStatement) {
            blockGraphFactory.splitBlock(connectedBlock, connectedStatement);
          }
          blockGraphFactory.connectBasicBlock(statement.getBasicBlock(), connectedStatement.getBasicBlock());
        }
      }
    }
    return blockGraphFactory.getBlockGraph();
  }
}
