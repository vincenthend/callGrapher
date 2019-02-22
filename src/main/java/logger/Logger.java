package logger;

import java.util.logging.Level;

public class Logger {
  private static java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Logger");

  public static void info(String message){
    System.out.println("[INFO] " + message);
  }

  public static void error(String message){
    System.out.println("[ERROR] " + message);
  }
}
