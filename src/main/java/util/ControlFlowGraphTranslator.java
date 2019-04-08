package util;

import logger.Logger;
import model.graph.ControlFlowBlockGraph;
import model.graph.ControlFlowEdge;
import model.graph.ControlFlowGraph;
import model.graph.block.PhpBasicBlock;
import model.graph.block.statement.PhpStatement;
import org.jgrapht.Graphs;
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
            parentBlocks.add(p.getBasicBlock());
          }

          blockGraphFactory.openBlock(parentBlocks);
        }
      }

      // Check if child has basic block
      Iterator<ControlFlowEdge> edgeIterator = cfg.getGraph().outgoingEdgesOf(statement).iterator();
      while(edgeIterator.hasNext()){
        PhpStatement p = cfg.getGraph().getEdgeTarget(edgeIterator.next());
        if(p.getBasicBlock() != null){
          blockGraphFactory.connectBasicBlock(blockGraphFactory.getLastBlock(), p.getBasicBlock());
        }
      }
    }
    return blockGraphFactory.build();
  }

  /**
   * Lists all of parent's basic blocks.
   * @param cfg ControlFlowGraph containing statement
   * @param statement statement to be inspected
   * @return Set of parent's basic blocks
   */
  private Set<PhpBasicBlock> collectParentBasicBlock(ControlFlowGraph cfg, PhpStatement statement) {
    List<PhpStatement> predList = Graphs.predecessorListOf(cfg.getGraph(), statement);
    Set<PhpBasicBlock> predBasicBlock = new HashSet<>();
    for (PhpStatement succ : predList) {
      if (succ.getBasicBlock() != null) {
        predBasicBlock.add(succ.getBasicBlock());
      }
    }
    return predBasicBlock;
  }

  /**
   * Lists all of child's basic blocks.
   * @param cfg ControlFlowGraph containing statement
   * @param statement statement to be inspected
   * @return Set of child's basic blocks
   */
  private Set<PhpBasicBlock> collectChildBasicBlock(ControlFlowGraph cfg, PhpStatement statement) {
    List<PhpStatement> succList = Graphs.successorListOf(cfg.getGraph(), statement);
    Set<PhpBasicBlock> succBasicBlock = new HashSet<>();
    for (PhpStatement succ : succList) {
      if (succ.getBasicBlock() != null) {
        succBasicBlock.add(succ.getBasicBlock());
      }
    }
    return succBasicBlock;
  }
}
