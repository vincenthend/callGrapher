package analyzer;

import grammar.PhpLexer;

import java.util.Set;
import java.util.TreeSet;

import grammar.PhpParser;
import logger.Logger;
import model.ProjectData;
import model.graph.ControlFlowGraph;
import model.php.PhpFunction;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class FlowAnalyzer {
  private ProjectData projectData;

  public FlowAnalyzer(ProjectData projectData) {
    this.projectData = projectData;
  }

  public void analyze(PhpFunction function) {
    if (function.getCode() != null) {
      PhpMethodParserVisitor visitor = new PhpMethodParserVisitor(projectData, projectData.getClass(function.getClassName()));

      // Read parser
      String input = "<?php " + function.getCode() + "?>";
      CharStream cs = CharStreams.fromString(input);

      // Tokenize and build parse tree
      PhpLexer lexer = new PhpLexer(cs);
      PhpParser parser = new PhpParser(new CommonTokenStream(lexer));
      ParseTree tree = parser.htmlDocument();
      try {
        function.setControlFlowGraph(visitor.visit(tree));
      } catch (Exception e){
        Logger.error("Fail to parse "+function);
        e.printStackTrace();
        function.setControlFlowGraph(new ControlFlowGraph());
      }
    }
  }

  public void analyzeAll() {
    Set<PhpFunction> funcSet = new TreeSet<>(projectData.getFunctionMap().values());
    for (PhpFunction f : funcSet) {
      analyze(f);
    }
  }
}
