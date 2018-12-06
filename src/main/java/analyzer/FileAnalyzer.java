package analyzer;

import grammar.PhpClassFunctionListener;
import grammar.PhpLexer;
import grammar.PhpParser;
import model.ProjectData;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;

public class FileAnalyzer {
  public ProjectData projectData;

  public FileAnalyzer(){
    projectData = new ProjectData();
  }

  public void analyze(File file){
    String input = ""; //read file
    CharStream cs = CharStreams.fromString(input);

    PhpClassFunctionListener listener = new PhpClassFunctionListener(projectData, cs);

    // Tokenize and build parse tree
    PhpLexer lexer = new PhpLexer(cs);
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    PhpParser parser = new PhpParser(tokens);
    // Serialize object and Schedule
    parser.addParseListener(listener);
    try{
      parser.htmlDocument();
    } catch(Exception e){
      System.out.println(e);
    }
  }

  public void analyze(String fileContent){
    CharStream cs = CharStreams.fromString(fileContent);
    PhpClassFunctionListener listener = new PhpClassFunctionListener(projectData, cs);


    // Tokenize and build parse tree
    PhpLexer lexer = new PhpLexer(cs);
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    PhpParser parser = new PhpParser(tokens);
    // Serialize object and Schedule
    parser.addParseListener(listener);
    try{
      parser.htmlDocument();
    } catch(Exception e){
      System.out.println("[ERROR] "+e);
    }
  }

  public ProjectData getProjectData() {
    return projectData;
  }

}
