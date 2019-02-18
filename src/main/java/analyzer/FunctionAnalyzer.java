package analyzer;

import grammar.PhpLexer;
import grammar.PhpMethodParserVisitor;
import grammar.PhpParser;
import model.ControlFlowGraph;
import model.Function;
import model.ProjectData;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jgrapht.Graphs;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class FunctionAnalyzer {
  private ProjectData projectData;

  public FunctionAnalyzer(ProjectData projectData) {
    this.projectData = projectData;
  }

  public void analyze(Function function) {
    if (function.code != null) {
      PhpMethodParserVisitor visitor = new PhpMethodParserVisitor(projectData);

      // Read parser
      String input = "<?php " + function.code + "?>";
      CharStream cs = CharStreams.fromString(input);

      // Tokenize and build parse tree
      PhpLexer lexer = new PhpLexer(cs);
      PhpParser parser = new PhpParser(new CommonTokenStream(lexer));
      ParseTree tree = parser.htmlDocument();
      System.out.println(tree.toStringTree(parser));
      function.graph = visitor.visit(tree);
    }
  }

  public void analyzeAll() {
    Set<Function> funcSet = new TreeSet<Function>(projectData.getFunctionMap().values());
    Iterator<Function> iterator = funcSet.iterator();
    while (iterator.hasNext()) {
      Function f = iterator.next();
      analyze(f);
      projectData.appendControlFlowGraph(f.graph);
    }
  }
}
