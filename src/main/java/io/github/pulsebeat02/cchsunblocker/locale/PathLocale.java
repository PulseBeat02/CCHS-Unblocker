package io.github.pulsebeat02.cchsunblocker.locale;

import java.nio.file.Path;

public interface PathLocale {

  String USER = System.getProperty("user.name");
  String USER_HOME = System.getProperty("user.home");

  Path USER_DOCUMENTS = Path.of("/Users/").resolve(USER).resolve("Documents");
  Path UNBLOCKER_FOLDER = USER_DOCUMENTS.resolve("cchs-unblocker");
  Path BACKUP_PLIST = UNBLOCKER_FOLDER.resolve("backup-%s".formatted(USER));
  Path LAUNCH_AGENTS = Path.of("/Library/LaunchAgents/");

  Path BASE_PREF = Path.of("/Library/Managed Preferences/");
  Path BASE_USER_PREF = BASE_PREF.resolve(USER);

  Path CHROME_PREF = BASE_USER_PREF.resolve("com.google.Chrome.plist");
  Path GAME_TREATMENT = BASE_PREF.resolve("com.mosyle.macos.applist.11.plist");
  Path GAMES = BASE_PREF.resolve("com.mosyle.macos.config.plist");
  Path VPN_TREATMENT = BASE_PREF.resolve("com.mosyle.macos.applist.10.plist");

  Path MOSYLE_AUTH = BASE_PREF.resolve("com.mosyle.macos.auth.plist");
  Path MOSYLE_CONFIG = BASE_PREF.resolve("com.mosyle.macos.config.plist");
  Path MOSYLE_CLIENT_CONFIG = BASE_PREF.resolve("com.mosyle.macos.config.client.plist");

  Path MOSYLE_AUTH_BOOT = LAUNCH_AGENTS.resolve("com.mosyle.auth.app.launchd.plist");
  Path MOSYLE_MANAGER_NOTIFICATION_BOOT = LAUNCH_AGENTS.resolve(
      "com.mosyle.macos.manager.notification.plist");
  Path MOSYLE_MDM_BOOT = LAUNCH_AGENTS.resolve("com.mosyle.macos.mdm.agent.plist");
  Path MOSYLE_CENTER_NOTIFICATION_BOOT = LAUNCH_AGENTS.resolve(
      "com.mosyle.notification.center.app.launchd.plist");
}
