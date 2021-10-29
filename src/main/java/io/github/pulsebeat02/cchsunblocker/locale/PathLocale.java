package io.github.pulsebeat02.cchsunblocker.locale;

import java.nio.file.Path;

public interface PathLocale {

  String USER = System.getProperty("user.name");
  String USER_HOME = System.getProperty("user.home");

  Path USER_DOCUMENTS = Path.of("/Users/").resolve(USER).resolve("Documents");
  Path UNBLOCKER_FOLDER = USER_DOCUMENTS.resolve("cchs-unblocker");
  Path BACKUP_PLIST = UNBLOCKER_FOLDER.resolve("backup-%s".formatted(USER));

  Path BASE_PREF = Path.of("/Library/Managed Preferences/");
  Path BASE_USER_PREF = BASE_PREF.resolve(USER);

  Path CHROME_PREF = BASE_USER_PREF.resolve("com.google.Chrome.plist");
  Path GAME_TREATMENT = BASE_PREF.resolve("com.mosyle.macos.applist.11.plist");
  Path GAMES = BASE_PREF.resolve("com.mosyle.macos.config.plist");
  Path VPN_TREATMENT = BASE_PREF.resolve("com.mosyle.macos.applist.10.plist");

  Path MOSYLE_AUTH = BASE_PREF.resolve("com.mosyle.macos.auth.plist");
  Path MOSYLE_CONFIG = BASE_PREF.resolve("com.mosyle.macos.config.plist");
  Path MOSYLE_CLIENT_CONFIG = BASE_PREF.resolve("com.mosyle.macos.config.client.plist");


}
