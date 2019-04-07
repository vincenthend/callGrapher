package util.diff;

import model.graph.block.PhpBasicBlock;
import model.graph.ControlFlowBlockGraph;
import model.graph.ControlFlowGraph;
import model.graph.block.statement.PhpStatement;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import util.ControlFlowGraphTranslator;

import java.util.Map;

public class ControlFlowGraphDiff {
  public void diffGraph(ControlFlowGraph g1, ControlFlowGraph g2) {
    ControlFlowGraphTranslator translator = new ControlFlowGraphTranslator();

    ControlFlowBlockGraph b1 = translator.translate(g1);
    ControlFlowBlockGraph b2 = translator.translate(g2);

    BidiMap<PhpBasicBlock, PhpBasicBlock> matchupMatrix = matchBasicBlock(b1, b2);

  }

  private BidiMap<PhpBasicBlock, PhpBasicBlock> matchBasicBlock(ControlFlowBlockGraph b1, ControlFlowBlockGraph b2) {
    return new DualHashBidiMap<>();
  }

  private Graph<PhpStatement, DefaultEdge> diffBlockControlFlowGraph(Map m1, ControlFlowBlockGraph b1, ControlFlowBlockGraph b2) {
    return null;
  }
}
