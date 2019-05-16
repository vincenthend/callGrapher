package logger;

public class Logger {
  public static void info(String message) {
    java.util.logging.Logger.getAnonymousLogger().info(message);
  }

  public static void error(String message) {
    java.util.logging.Logger.getAnonymousLogger().severe(message);
  }
}
