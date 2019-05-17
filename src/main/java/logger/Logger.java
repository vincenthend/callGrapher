package logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class Logger {
  private static final DateFormat df = new SimpleDateFormat("hh:mm:ss");
  private static Formatter formatter = new Formatter() {
    @Override
    public String format(LogRecord record) {
      StringBuilder sb = new StringBuilder();
      sb.append("[");
      sb.append(df.format(new Date(record.getMillis())));
      sb.append("] ");
      sb.append("[");
      sb.append(Thread.currentThread().getId());
      sb.append(" - ");
      sb.append(record.getLevel());
      sb.append("] ");
      sb.append(record.getMessage());
      sb.append('\n');
      return "["+ Thread.currentThread().getId()+" - "+record.getLevel()+"] " + record.getMessage() + "\n";
    }
  };

  public static void info(String message) {
    java.util.logging.Logger logger = java.util.logging.Logger.getAnonymousLogger();
    logger.setUseParentHandlers(false);

    ConsoleHandler handler = new ConsoleHandler();
    handler.setFormatter(formatter);

    logger.addHandler(handler);
    logger.info(message);
  }

  public static void error(String message) {
    java.util.logging.Logger logger = java.util.logging.Logger.getAnonymousLogger();
    logger.setUseParentHandlers(false);

    ConsoleHandler handler = new ConsoleHandler();
    handler.setFormatter(formatter);

    logger.addHandler(handler);
    logger.severe(message);
  }
}
