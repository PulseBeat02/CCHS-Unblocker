package io.github.pulsebeat02.cchsunblocker.backup;

import io.github.pulsebeat02.cchsunblocker.locale.PathLocale;
import io.github.pulsebeat02.cchsunblocker.utils.FileUtils;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public final class BackupTask {

  private final Path backup;
  private final Path launchAgents;

  public BackupTask() throws IOException {
    backup = PathLocale.BACKUP_PLIST;
    launchAgents = backup.resolve("LaunchAgents");
    FileUtils.createFoldersIfNotExists(backup);
    FileUtils.createFoldersIfNotExists(launchAgents);
    copyFiles();
  }

  private void copyFiles() throws IOException {
    if (isEmpty(backup)) {
      copyFolder(PathLocale.BASE_PREF, backup);
    }
    if (isEmpty(launchAgents)) {
      copyFolder(PathLocale.LAUNCH_AGENTS, launchAgents);
    }
  }

  private boolean isEmpty(final Path dir) throws IOException {
    try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(dir)) {
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
