package util;

import model.graph.block.PhpBasicBlock;
import model.graph.ControlFlowBlockGraph;
import model.graph.block.statement.PhpStatement;
import org.jgrapht.graph.DefaultEdge;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ControlFlowBlockGraphBuilder {
  private ControlFlowBlockGraph blockGraph;
  private PhpBasicBlock lastBlock;

  public ControlFlowBlockGraphBuilder(){
    blockGraph = new ControlFlowBlockGraph();
    lastBlock = new PhpBasicBlock();
    blockGraph.getGraph().addVertex(lastBlock);
  }

  /**
   * Adds a statement to the last opened block.
   * @param statement added statement
   */
  public void addStatement(PhpStatement statement) throws IllegalStateException{
    if(lastBlock != null) {
      lastBlock.addStatement(statement);
      statement.setBasicBlock(lastBlock);
    } else {
      throw new IllegalStateException("No basic block is currently opened");
    }
  }

  /**
   * Close a basic block and return the closed block.
   * @return the closed block
   */
  public PhpBasicBlock closeBlock(){
    PhpBasicBlock returnedBlock = lastBlock;
    lastBlock = null;

    return returnedBlock;
  }

  public void splitBlock(PhpBasicBlock block, PhpStatement statement){
    if(blockGraph.getGraph().containsVertex(block)){
      PhpBasicBlock splitBlock = new PhpBasicBlock();

      // Add statements
      int i = block.getBlockStatements().indexOf(statement);
      for(; i<block.getBlockStatements().size(); i++){
        PhpStatement blockStatement = block.getBlockStatements().get(i);
        blockStatement.setBasicBlock(splitBlock);
        splitBlock.addStatement(blockStatement);
        block.getBlockStatements().remove(i);
      }

      // Connect statements
      Set<DefaultEdge> outgoingEdge = blockGraph.getGraph().outgoingEdgesOf(block);
      blockGraph.getGraph().addVertex(splitBlock);
      for(DefaultEdge edge : outgoingEdge){
        blockGraph.getGraph().addEdge(splitBlock, blockGraph.getGraph().getEdgeTarget(edge));
      }

      // Remove outgoing edge
      DefaultEdge[] arr = outgoingEdge.toArray(new DefaultEdge[outgoingEdge.size()]);
      for(DefaultEdge edge : arr){
        blockGraph.getGraph().removeEdge(edge);
      }
      blockGraph.getGraph().addEdge(block, splitBlock);


    }
  }

  /**
   * Opens a new basic block connected to the rootBlock.
   * @param rootBlock root basic block connected to the new block
   * @return the opened block
   */
  public void openBlock(PhpBasicBlock rootBlock){
    lastBlock = new PhpBasicBlock();
    blockGraph.getGraph().addVertex(lastBlock);
    blockGraph.getGraph().addEdge(rootBlock, lastBlock);
  }

  /**
   * Opens a new basic block connected to the rootBlock.
   * @param rootBlocks root basic block connected to the new block
   * @return the opened block
   */
  public void openBlock(List<PhpBasicBlock> rootBlocks){
    lastBlock = new PhpBasicBlock();
    blockGraph.getGraph().addVertex(lastBlock);
    for(PhpBasicBlock block : rootBlocks){
      blockGraph.getGraph().addEdge(block, lastBlock);
    }
  }

  public void connectBasicBlock(PhpBasicBlock rootBlock, Iterable<PhpBasicBlock> blocks){
    for(PhpBasicBlock block : blocks){
      blockGraph.getGraph().addEdge(rootBlock, block);
    }
  }

  public void connectBasicBlock(PhpBasicBlock rootBlock, PhpBasicBlock block){
    blockGraph.getGraph().addEdge(rootBlock, block);
  }

  public PhpBasicBlock getLastBlock() {
    return lastBlock;
  }

  public boolean isClosed(){
    return lastBlock == null;
  }

  public boolean isEmptyBlock(){
    return lastBlock.getBlockStatements().isEmpty();
  }

  /**
   * Return the ControlFlowBlockGraph object that has been built.
   * @return built ControlFlowBlockGraph
   */
  public ControlFlowBlockGraph getBlockGraph() {
    return blockGraph;
  }
}
