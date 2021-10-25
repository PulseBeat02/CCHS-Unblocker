package io.github.pulsebeat02.cchsunblocker.plist.safety;

import io.github.pulsebeat02.cchsunblocker.PreferenceFileLocale;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public final class BackupTask {

  private final Path backup;

  public BackupTask() throws IOException {
    backup = PreferenceFileLocale.BACKUP_PATH;
    createFolder();
    copyFiles();
  }

  private void createFolder() throws IOException {
    if (Files.notExists(backup)) {
      Files.createDirectories(backup);
    }
  }

  private void copyFiles() throws IOException {
    if (isEmpty()) {
      copyFolder(PreferenceFileLocale.BASE_PREF, backup);
    }
  }

  private boolean isEmpty() throws IOException {
    try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(backup)) {
      return !dirStream.iterator().hasNext();
    }
  }

  public void copyFolder(final Path src, final Path dest) throws IOException {
    try (Stream<Path> stream = Files.walk(src)) {
      stream.forEach(source -> copy(source, dest.resolve(src.relativize(source))));
    }
  }

  private void copy(final Path source, final Path dest) {
    try {
      Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

}
