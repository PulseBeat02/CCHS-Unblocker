package io.github.pulsebeat02.cchsunblocker.plist.implementation.application;

import io.github.pulsebeat02.cchsunblocker.locale.Locale;
import io.github.pulsebeat02.cchsunblocker.locale.PathLocale;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.AppPreferences;

public final class GameTreatmentPreferences extends AppPreferences {

  public GameTreatmentPreferences() {
    super(PathLocale.GAME_TREATMENT, Locale.FINISHED_GAME_TREATMENT_EDITS);
  }
}
