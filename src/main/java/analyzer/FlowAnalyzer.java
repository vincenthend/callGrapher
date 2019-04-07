package analyzer;

import grammar.PhpLexer;
import grammar.PhpMethodParserVisitor;
import grammar.PhpParser;
import logger.Logger;
import model.graph.block.statement.PhpStatement;
import model.php.PhpFunction;
import model.ProjectData;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Set;
import java.util.TreeSet;

public class FlowAnalyzer {
  private ProjectData projectData;

  public FlowAnalyzer(ProjectData projectData) {
    this.projectData = projectData;
  }

  public void analyze(PhpFunction function) {
    if (function.getCode() != null) {
      Logger.info("Visiting " + function.getCalledName());
      PhpMethodParserVisitor visitor = new PhpMethodParserVisitor(projectData, projectData.getClass(function.getClassName()));

      // Read parser
      String input = "<?php " + function.getCode() + "?>";
      CharStream cs = CharStreams.fromString(input);

      // Tokenize and build parse tree
      PhpLexer lexer = new PhpLexer(cs);
      PhpParser parser = new PhpParser(new CommonTokenStream(lexer));
      ParseTree tree = parser.htmlDocument();
      function.setControlFlowGraph(visitor.visit(tree));
      for(PhpStatement statement : function.getControlFlowGraph().getLastVertices()){
        System.out.println(statement);
        statement.setEndOfBranch(true);
      }
    }
  }

  public void analyzeAll() {
    Set<PhpFunction> funcSet = new TreeSet<PhpFunction>(projectData.getFunctionMap().values());
    for (PhpFunction f : funcSet) {
      analyze(f);
    }
  }
}
