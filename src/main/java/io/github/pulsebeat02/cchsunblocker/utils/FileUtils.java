package io.github.pulsebeat02.cchsunblocker.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.regex.Pattern;

public final class FileUtils {

  private static final Pattern FILENAME_PATTERN;

  static {
    FILENAME_PATTERN = Pattern.compile("(?<=.)\\.[^.]+$");
    ;
  }

  private FileUtils() {
  }

  public static boolean createFoldersIfNotExists(final Path path) throws IOException {
    if (Files.notExists(path)) {
      Files.createDirectories(path);
      return true;
    }
    return false;
  }

  public static boolean createFileIfNotExists(final Path path) throws IOException {
    if (Files.notExists(path)) {
      Files.createFile(path);
      return true;
    }
    return false;
  }

  public static Path createFileWithContents(final Path path, final String xml)
      throws IOException {
    createFileIfNotExists(path);
    Files.writeString(path, xml, StandardOpenOption.TRUNCATE_EXISTING);
    return path;
  }

  public static String getFileNameWithoutExtension(final Path file) {
    return FILENAME_PATTERN.matcher(file.getFileName().toString()).replaceAll("");
  }
}
