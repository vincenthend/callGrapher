package analyzer;

import grammar.PhpDeclarationListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import grammar.PhpLexer;
import grammar.PhpParser;
import logger.Logger;
import model.ProjectData;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Analyzes files to find functions or methods listed in the file
 */
public class DeclarationAnalyzer {
  private ProjectData projectData;

  public DeclarationAnalyzer(ProjectData projectData){
    this.projectData = projectData;
  }

  public void analyze(File file) throws IOException {
    //TODO: Refactor this
    BufferedReader bufferedReader = new BufferedReader(new FileReader(file)); //read file
    StringBuilder sb = new StringBuilder();
    String line;
    while((line = bufferedReader.readLine()) != null){
      sb.append(line);
      sb.append("\n");
    }
    bufferedReader.close();
    analyze(sb.toString());
  }

  public void analyze(String fileContent){
    CharStream cs = CharStreams.fromString(fileContent);
    PhpDeclarationListener listener = new PhpDeclarationListener(projectData, cs);

    // Tokenize and build parse tree
    PhpLexer lexer = new PhpLexer(cs);
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    PhpParser parser = new PhpParser(tokens);
    // Serialize object and Schedule
    parser.addParseListener(listener);
    try{
      parser.htmlDocument();
    } catch(Exception e){
      Logger.error(e.getMessage());
    }
  }

  public ProjectData getProjectData() {
    return projectData;
  }

}
