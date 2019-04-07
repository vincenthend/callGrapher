package util;

import model.graph.block.PhpBasicBlock;
import model.graph.ControlFlowBlockGraph;
import model.graph.block.statement.PhpStatement;

public class ControlFlowBlockGraphFactory {
  private ControlFlowBlockGraph blockGraph;
  private PhpBasicBlock lastBlock;

  public ControlFlowBlockGraphFactory(){
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
    System.out.println("close");
    PhpBasicBlock returnedBlock = lastBlock;
    lastBlock = null;

    return returnedBlock;
  }

  /**
   * Opens a new basic block connected to the rootBlock.
   * @param rootBlock root basic block connected to the new block
   * @return the opened block
   */
  public void openBlock(PhpBasicBlock rootBlock){
    System.out.println("open");
    lastBlock = new PhpBasicBlock();
    blockGraph.getGraph().addVertex(lastBlock);
    blockGraph.getGraph().addEdge(rootBlock, lastBlock);
  }

  /**
   * Opens a new basic block connected to the rootBlock.
   * @param rootBlocks root basic block connected to the new block
   * @return the opened block
   */
  public void openBlock(Iterable<PhpBasicBlock> rootBlocks){
    System.out.println("open");
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
  public ControlFlowBlockGraph build() {
    return blockGraph;
  }
}
