package util.builder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import logger.Logger;
import model.graph.ControlFlowBlockGraph;
import model.graph.ControlFlowGraph;
import model.graph.statement.block.PhpBasicBlock;
import model.graph.statement.PhpStatement;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;
import util.iterator.ControlFlowDominatorIterator;

public class ControlFlowGraphTranslator {

  /**
   * Translate a CFG into a CFBlockGraph.
   * @return result of translations
   */
  public ControlFlowBlockGraph translateToBlockGraph(ControlFlowGraph cfg) {
    if(cfg.getFlowBlockGraph() == null) {
      Logger.info("Translating to block graph");
      ControlFlowGraphDominators dominators = new ControlFlowGraphDominators(cfg);
      ControlFlowBlockGraphBuilder blockGraphFactory = new ControlFlowBlockGraphBuilder();
      ControlFlowDominatorIterator iterator = dominators.iterator();

      while (iterator.hasNext()) {
        PhpStatement statement = iterator.next();
        blockGraphFactory.addStatement(statement);
        if (dominators.getTree().outgoingEdgesOf(statement).size() != 1) {
          blockGraphFactory.closeBlock();
          if (iterator.peek() != null) {
            // Get next basic block
            Iterator<DefaultEdge> edgeIterator = cfg.getGraph().incomingEdgesOf(iterator.peek()).iterator();
            List<PhpBasicBlock> parentBlocks = new ArrayList<>();
            while (edgeIterator.hasNext()) {
              PhpStatement p = cfg.getGraph().getEdgeSource(edgeIterator.next());
              if (p.getBasicBlock() != null) {
                parentBlocks.add(p.getBasicBlock());
              }
            }
            blockGraphFactory.openBlock(parentBlocks);
          }
        }

        // Check if child has basic block
        for (DefaultEdge controlFlowEdge : cfg.getGraph().outgoingEdgesOf(statement)) {
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

      cfg.setFlowBlockGraph(blockGraphFactory.getBlockGraph());
      blockGraphFactory.getBlockGraph().setFlowGraph(cfg);
      return blockGraphFactory.getBlockGraph();
    } else {
      return cfg.getFlowBlockGraph();
    }
  }

  public ControlFlowGraph translateToFlowGraph(ControlFlowBlockGraph cfbg){
    if(cfbg.getFlowGraph() == null) {
      ControlFlowGraph cfg = new ControlFlowGraph();

      // Add all node
      Set<PhpBasicBlock> vertexSet = cfbg.getGraph().vertexSet();
      Iterator<PhpBasicBlock> vertexIterator = vertexSet.iterator();
      while (vertexIterator.hasNext()) {
        PhpBasicBlock block = vertexIterator.next();
        Iterator<PhpStatement> statementIterator = block.getBlockStatements().listIterator();
        while (statementIterator.hasNext()) {
          cfg.getGraph().addVertex(statementIterator.next());
        }
      }

      // Connect every node
      DepthFirstIterator<PhpBasicBlock, DefaultEdge> dfs = new DepthFirstIterator<>(cfbg.getGraph());
      while (dfs.hasNext()) {
        PhpBasicBlock block = dfs.next();

        Iterator<PhpStatement> statementIterator = block.getBlockStatements().listIterator();
        PhpStatement statement = statementIterator.next();
        while (statementIterator.hasNext()) {
          PhpStatement oldStatement = statement;
          statement = statementIterator.next();
          cfg.getGraph().addEdge(oldStatement, statement);
        }
        // Handle first and last statement
        // Connect to prev blocks last statement
        List<PhpBasicBlock> prevBlockList = Graphs.predecessorListOf(cfbg.getGraph(), block);
        for (PhpBasicBlock prevBlock : prevBlockList) {
          cfg.getGraph().addEdge(prevBlock.getBlockStatements().getLast(), block.getBlockStatements().getFirst());
        }
        List<PhpBasicBlock> nextBlockList = Graphs.successorListOf(cfbg.getGraph(), block);
        for (PhpBasicBlock nextBlock : nextBlockList) {
          cfg.getGraph().addEdge(block.getBlockStatements().getLast(), nextBlock.getBlockStatements().getFirst());
        }
      }

      cfg.setFlowBlockGraph(cfbg);
      cfbg.setFlowGraph(cfg);
      return cfg;
    } else {
      return cfbg.getFlowGraph();
    }
  }
}
