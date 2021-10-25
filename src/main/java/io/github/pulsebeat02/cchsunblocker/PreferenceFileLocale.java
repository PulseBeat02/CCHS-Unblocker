package io.github.pulsebeat02.cchsunblocker;

import java.nio.file.Path;

public final class PreferenceFileLocale {

  public static final String USER = System.getProperty("user.name");
  public static final Path BASE_PREF = Path.of("/library/Managed Preferences/");
  public static final Path BASE_USER_PREF = BASE_PREF.resolve(USER);
  public static final Path BACKUP_PATH = Path.of("/Users/").resolve(USER).resolve("Documents")
      .resolve("backup");

  public static final Path CHROME_PREF = BASE_USER_PREF.resolve("com.google.Chrome.plist");
  public static final Path GAME_TREATMENT = BASE_PREF.resolve("com.mosyle.macos.applist.11.plist");
  public static final Path GAMES = BASE_PREF.resolve("com.mosyle.macos.config.plist");
  public static final Path VPN_TREATMENT = BASE_PREF.resolve("com.mosyle.macos.applist.10.plist");
}
