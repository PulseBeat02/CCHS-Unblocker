package io.github.pulsebeat02.cchsunblocker.plist.implementation.mosyle;

import io.github.pulsebeat02.cchsunblocker.locale.Locale;
import io.github.pulsebeat02.cchsunblocker.locale.PathLocale;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.RestApiPreferences;

public final class MosyleConfigPreferences extends RestApiPreferences {

  public MosyleConfigPreferences() {
    super(PathLocale.MOSYLE_CONFIG, Locale.FINISHED_MOSYLE_EDITS);
  }
}
