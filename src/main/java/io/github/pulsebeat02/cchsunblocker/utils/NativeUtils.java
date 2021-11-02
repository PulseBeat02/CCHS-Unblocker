package io.github.pulsebeat02.cchsunblocker.utils;

import io.github.pulsebeat02.cchsunblocker.locale.Locale;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public final class NativeUtils {

  private NativeUtils() {
  }

  public static String executeDirectCommand(final String cmd)
      throws IOException, InterruptedException {
    final Process process = constructProcess(cmd);
    final StringBuilder builder = new StringBuilder();
    try (final BufferedReader br = new BufferedReader(
        new InputStreamReader(process.getInputStream()))) {
      String line;
      while ((line = br.readLine()) != null) {
        builder.append(line).append("\n");
      }
    }
    return builder.toString();
  }

  public static void executeCommand(final String... cmd) throws IOException, InterruptedException {
    Process process = constructBuilder(cmd).start();
    process.waitFor();
  }

  private static Process constructProcess(final String cmd) throws IOException {
    return Runtime.getRuntime().exec(cmd);
  }

  private static ProcessBuilder constructBuilder(final String... cmd) {
    return new ProcessBuilder().command(cmd);
  }

  private static boolean sudoersAuditError(final Process process) throws IOException {
    try (final BufferedReader br = new BufferedReader(
        new InputStreamReader(process.getInputStream()))) {
      final String line = br.readLine();
      return line != null && line.equals(Locale.ERR_SUDOERS_AUDIT);
    }
  }
}
