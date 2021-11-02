package io.github.pulsebeat02.cchsunblocker;

import io.github.pulsebeat02.cchsunblocker.backup.BackupTask;
import io.github.pulsebeat02.cchsunblocker.locale.Locale;
import java.io.IOException;
import java.util.Scanner;

public final class CCHSUnblocker {

  public static void main(String[] args) throws IOException {
    new CCHSUnblocker();
  }

  private final Scanner scanner;
  private String passcode;

  CCHSUnblocker() throws IOException {
    this.scanner = new Scanner(System.in);
    initialize();
    enterPasscode();
    startTask();
    editConfigurations();
  }

  private void initialize() {
    addShutdownHooks();
    acceptAgreement();
  }

  private void addShutdownHooks() {
    Runtime.getRuntime()
        .addShutdownHook(new Thread(() -> System.out.println(Locale.SHUTTING_DOWN)));
  }

  private void acceptAgreement() {
    System.out.println(Locale.NOTICE);
    halt();
    checkAgreement();
    System.out.println(Locale.NEW_LINE);
    System.out.println(Locale.RESTART_APPS);
    System.out.println(Locale.NEW_LINE);
  }

  private void checkAgreement() {
    final String line = scanner.nextLine();
    if (!line.equals("I agree")) {
      System.exit(0);
    }
  }

  private void enterPasscode() {
    System.out.println(Locale.ENTER_PASSCODE);
    checkPasscode();
    System.out.println(Locale.NEW_LINE);
    System.out.println(Locale.VALID_PASSCODE);
  }

  private void checkPasscode() {
    halt();
    final String first = scanner.nextLine();
    System.out.println(Locale.NEW_LINE);
    System.out.println(Locale.VERIFY_PASSCODE);
    halt();
    final String second = scanner.nextLine();
    if (!first.equals(second)) {
      System.out.println(Locale.ERR_MISMATCHING_PASSCODES);
      System.exit(0);
    }
    passcode = first;
  }

  private void halt() {
    while (!scanner.hasNextLine()) {
    }
  }

  private void startTask() throws IOException {
    System.out.println(Locale.STARTED_BACKUP);
    new BackupTask();
    System.out.println(Locale.FINISHED_BACKUP);
  }

  private void editConfigurations() {
    System.out.println(Locale.STARTING_EDITS);
    new ManualUnblocker(passcode);
    System.out.println(Locale.FINISHED_EDITS);
  }
}
