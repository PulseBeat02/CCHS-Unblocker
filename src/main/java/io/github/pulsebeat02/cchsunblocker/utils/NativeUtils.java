package io.github.pulsebeat02.cchsunblocker.utils;

import io.github.pulsebeat02.cchsunblocker.locale.Locale;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class NativeUtils {

  private NativeUtils() {
  }

  public static void executeDirectCommand(final String cmd)
      throws IOException, InterruptedException {
    Process process = constructProcess(cmd);
    while (sudoersAuditError(process)) {
      process = constructProcess(cmd);
    }
    process.waitFor();
  }

  public static void executeCommand(final String... cmd) throws IOException, InterruptedException {
    Process process = constructBuilder(cmd).start();
    while (sudoersAuditError(process)) {
      process = constructBuilder(cmd).start();
    }
    process.waitFor();
  }

  private static Process constructProcess(final String cmd) throws IOException {
    return Runtime.getRuntime().exec(cmd);
  }

  private static ProcessBuilder constructBuilder(final String... cmd) {
    return new ProcessBuilder().command(cmd);
  }

  private static boolean sudoersAuditError(final Process process) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
    String line;
    while ((line = br.readLine()) != null) {
      if (line.equals(Locale.ERR_SUDOERS_AUDIT)) {
        return true;
      }
    }
    return false;
  }
}
