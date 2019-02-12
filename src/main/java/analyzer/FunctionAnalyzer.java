package analyzer;

import grammar.PhpLexer;
import grammar.PhpMethodParserVisitor;
import grammar.PhpParser;
import model.Function;
import model.ProjectData;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class FunctionAnalyzer {
  private ProjectData projectData;

  public FunctionAnalyzer(ProjectData projectData) {
    this.projectData = projectData;
  }

  public void analyze(Function function) {
    if (function.code != null) {
      PhpMethodParserVisitor visitor = new PhpMethodParserVisitor();

      // Read parser
      String input = "<?php " + function.code + "?>";
      CharStream cs = CharStreams.fromString(input);

      // Tokenize and build parse tree
      PhpLexer lexer = new PhpLexer(cs);
      PhpParser parser = new PhpParser(new CommonTokenStream(lexer));
      ParseTree tree = parser.htmlDocument();
      visitor.visit(tree);

      try {
        parser.htmlDocument();
      } catch (Exception e) {
        System.out.println("[ERROR] " + e);
      }
    }
  }

  public void analyzeAll() {
//    Set<Function> funcSet = new TreeSet<Function>(projectData.getControlFlowGraph().getGraph().vertexSet());
//    Iterator<Function> iterator = funcSet.iterator();
//    while(iterator.hasNext()) {
//      analyze(iterator.next());
//    }
  }
}
