package analyzer;

import grammar.PhpLexer;
import grammar.PhpMethodParserListener;
import grammar.PhpParser;
import model.Function;
import model.ProjectData;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class FunctionAnalyzer {
  public ProjectData projectData;
  public FunctionAnalyzer(ProjectData projectData) {
    this.projectData = projectData;
  }

  public void analyze(Function function) {
    PhpMethodParserListener listener = new PhpMethodParserListener(function, projectData);

    // Read parser
    String input = "<?php " + function.code + "?>";

    CharStream cs = CharStreams.fromString(input);

    // Tokenize and build parse tree
    PhpLexer lexer = new PhpLexer(cs);
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    PhpParser parser = new PhpParser(tokens);
    // Serialize object and Schedule
    parser.addParseListener(listener);
    try {
      parser.htmlDocument();
    } catch (Exception e) {
      System.out.println("[ERROR] "+e);
    }
  }

  public void analyzeAll(){
    for(Function f : projectData.functionList) {
      analyze(f);
    }
  }
}
