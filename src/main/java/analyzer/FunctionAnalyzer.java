package analyzer;

import grammar.PhpLexer;
import grammar.PhpMethodParserVisitor;
import grammar.PhpParser;
import logger.Logger;
import model.PhpFunction;
import model.ProjectData;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class FunctionAnalyzer {
  private ProjectData projectData;

  public FunctionAnalyzer(ProjectData projectData) {
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
      function.setGraph(visitor.visit(tree));
    }
  }

  public void analyzeAll() {
    Set<PhpFunction> funcSet = new TreeSet<PhpFunction>(projectData.getFunctionMap().values());
    Iterator<PhpFunction> iterator = funcSet.iterator();
    while (iterator.hasNext()) {
      PhpFunction f = iterator.next();
      analyze(f);
      projectData.appendControlFlowGraph(f.getGraph());
    }
  }
}
