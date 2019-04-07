package util;

import logger.Logger;
import model.graph.ControlFlowBlockGraph;
import model.graph.ControlFlowGraph;
import model.graph.block.PhpBasicBlock;
import model.graph.block.statement.PhpStatement;
import org.jgrapht.Graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ControlFlowGraphTranslator {
  /**
   * Translate a CFG into a CFBlockGraph.
   * @param cfg CFG to be translated
   * @return result of translations
   */
  public ControlFlowBlockGraph translate(ControlFlowGraph cfg) {
    ControlFlowBlockGraphFactory blockGraphFactory = new ControlFlowBlockGraphFactory();
    ControlFlowDIYIterator iterator = new ControlFlowDIYIterator(cfg);

    Logger.info("Translating to block graph");
    PhpBasicBlock closedBlock = null;
    while (iterator.hasNext()) {
      PhpStatement statement = iterator.next();
      System.out.println(statement + " : " + iterator.getBranchSize() + " end : " + iterator.isEndOfBranch());
      blockGraphFactory.addStatement(statement);

      // Handle branching
      int intersectionSize = iterator.getBranchSize();
      if (intersectionSize > 1) {
        closedBlock = blockGraphFactory.closeBlock();
        blockGraphFactory.openBlock(closedBlock);
      }

      // Close block and open a new block based from parent's basic block
      if (iterator.isEndOfBranch()) {
        blockGraphFactory.closeBlock();
        System.out.println("is End of Branch " + statement);
        if(iterator.hasNext() && blockGraphFactory.isClosed()) {
          blockGraphFactory.openBlock(collectParentBasicBlock(cfg, iterator.peek()));
        }
      }

      // If statement's child got a basic block
      Set<PhpBasicBlock> childBasicBlock = collectChildBasicBlock(cfg, statement);
      if (childBasicBlock.size() != 0) {
        System.out.println("child has basic block " + statement);
        if(!blockGraphFactory.isClosed()) {
          if(!blockGraphFactory.isEmptyBlock()) {
            closedBlock = blockGraphFactory.closeBlock();
          }
        }
        blockGraphFactory.connectBasicBlock(statement.getBasicBlock(), childBasicBlock);
        if (iterator.hasNext() && blockGraphFactory.isClosed()) {
          blockGraphFactory.openBlock(closedBlock);
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
