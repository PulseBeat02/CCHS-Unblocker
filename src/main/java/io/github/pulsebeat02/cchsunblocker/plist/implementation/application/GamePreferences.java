package io.github.pulsebeat02.cchsunblocker.plist.implementation.application;

import io.github.pulsebeat02.cchsunblocker.locale.Locale;
import io.github.pulsebeat02.cchsunblocker.locale.PathLocale;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.RestApiPreferences;

public final class GamePreferences extends RestApiPreferences {

  public GamePreferences() {
    super(PathLocale.GAMES, Locale.FINISHED_GAME_PREFERENCE_EDITS);
  }
}
