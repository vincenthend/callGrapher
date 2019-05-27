package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderUtil {
  public static List<File> listFilesForFolder(final File file, String extension) {
    List<File> l = new ArrayList<>();
    if (file.isDirectory()) {
      File[] files = file.listFiles();
      if (files != null) {
        for (final File fileEntry : files) {
          l.addAll(listFilesForFolder((fileEntry),extension));
        }
      }
    } else {
      if (file.getName().endsWith(extension)) {
        l.add(file);
      }
    }
    return l;
  }
}
