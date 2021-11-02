package io.github.pulsebeat02.cchsunblocker.plist.implementation.mosyle.launchagents;

import io.github.pulsebeat02.cchsunblocker.locale.Locale;
import io.github.pulsebeat02.cchsunblocker.locale.PathLocale;

public final class MosyleManagerNotificationPreferences extends AliveAgentPreferences {

  private static final String LIMIT_LOAD_TO_SESSION_TYPE;

  static {
    LIMIT_LOAD_TO_SESSION_TYPE = "LimitLoadToSessionType";
  }

  public MosyleManagerNotificationPreferences() {
    super(PathLocale.MOSYLE_MANAGER_NOTIFICATION_BOOT,
        Locale.FINISHED_MOSYLE_MANAGER_NOTIFICATION_EDITS);
  }

  public String[] getLimitLoadToSessionType() {
    return getDictionary().get(LIMIT_LOAD_TO_SESSION_TYPE).toJavaObject(String[].class);
  }

  public void setLimitLoadToSessionType(final String[] arr) {
    getDictionary().put(LIMIT_LOAD_TO_SESSION_TYPE, arr);
  }
}
