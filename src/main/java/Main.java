import analyzer.FileAnalyzer;
import analyzer.FunctionAnalyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  private static List<File> listFilesForFolder(final File file) {
    List<File> l = new ArrayList<File>();
    if(file.isDirectory()){
      File[] files = file.listFiles();
      if(files != null) {
        for (final File fileEntry : files) {
          l.addAll(listFilesForFolder((fileEntry)));
        }
      }
    } else {
      if(file.getName().endsWith("php")) {
        l.add(file);
      }
    }
    return l;
  }

  public static void main(String[] args){
    String path = "E:\\ITB Stuff\\Tugas Akhir\\phpMyAdmin-4.6.3-english\\libraries\\central_columns.lib.php";
    FileAnalyzer fileAnalyzer = new FileAnalyzer();

    File file = new File(path);
    List<File> fileList = listFilesForFolder(file);
    for(File filePath : fileList) {
      System.out.println("Analyzing "+filePath);
      try {
        fileAnalyzer.analyze(filePath);
      } catch (IOException e) {
        System.out.printf("File %s not found", filePath.getAbsolutePath());
      }
    }
    System.out.println("==== Method list ====");
    System.out.println(fileAnalyzer.getProjectData().toString());

    System.out.println("==== Call list ====");
    FunctionAnalyzer functionAnalyzer = new FunctionAnalyzer(fileAnalyzer.getProjectData());
    functionAnalyzer.analyzeAll();
  }
}
