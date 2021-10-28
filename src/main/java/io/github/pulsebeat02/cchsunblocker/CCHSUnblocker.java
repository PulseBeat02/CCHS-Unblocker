package io.github.pulsebeat02.cchsunblocker;

import com.dd.plist.PropertyListFormatException;
import io.github.pulsebeat02.cchsunblocker.locale.Locale;
import io.github.pulsebeat02.cchsunblocker.backup.BackupTask;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public final class CCHSUnblocker {

  public static void main(String[] args)
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    new CCHSUnblocker(args); // first argument must be passcode
  }

  private final String[] args;
  private String passcode;

  CCHSUnblocker(final String[] args)
      throws IOException, PropertyListFormatException, ParseException, ParserConfigurationException, SAXException {
    this.args = args;
    checkArgs();
    initialize();
    startTask();
    editConfigurations();
  }

  private void checkArgs() {
    if (args.length == 0) {
      System.out.println(Locale.ERR_ARGS);
      System.exit(0);
    }
    passcode = args[0];
  }

  private void initialize() {
    System.out.println(Locale.RESTART_APPS);
    System.out.println(Locale.NOTICE);
    addShutdownHooks();
    acceptAgreement();
  }

  private void addShutdownHooks() {
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.out.println(Locale.SHUTTING_DOWN);
    }));
  }

  private void acceptAgreement() {
    try (final Scanner scanner = new Scanner(System.in)) {
      final String line = scanner.nextLine();
      if (!line.equals("I agree")) {
        System.exit(0);
      }
      System.out.println(Locale.NEW_LINE);
    }
  }

  private void startTask() throws IOException {
    System.out.println(Locale.STARTED_BACKUP);
    new BackupTask();
    System.out.println(Locale.FINISHED_BACKUP);
  }

  private void editConfigurations()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    System.out.println(Locale.STARTING_EDITS);
    new ManualUnblocker(passcode);
    System.out.println(Locale.FINISHED_EDITS);
  }
}
