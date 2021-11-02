package io.github.pulsebeat02.cchsunblocker;

import io.github.pulsebeat02.cchsunblocker.plist.PList;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.AppPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.RestApiPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.application.ChromePreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.application.GamePreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.application.GameTreatmentPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.application.VPNTreatmentPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.mosyle.MosyleAuthPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.mosyle.MosyleClientConfigPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.mosyle.MosyleConfigPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.mosyle.launchagents.AliveAgentPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.mosyle.launchagents.LaunchAgentPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.mosyle.launchagents.MosyleAuthBootPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.mosyle.launchagents.MosyleCenterNotificationPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.mosyle.launchagents.MosyleMDMBootPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.mosyle.launchagents.MosyleManagerNotificationPreferences;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;

public final class ManualUnblocker {

  public ManualUnblocker(final String passcode) {
    concat(
        concat(of(chromePreferences(), mosyleClientPreferences()), restPreferences()),
        concat(appPreferences(), launchAgentsPreferences()))
        .forEach(configuration -> configuration.save(passcode));
  }

  private PList chromePreferences() {
    final ChromePreferences preferences = new ChromePreferences();
    preferences.setAllowDinosaurEasterEgg(true);
    preferences.setDefaultBrowserSetting(true);
    preferences.setEditBookmarks(true);
    preferences.setInstallBlackList(new String[]{});
    preferences.setInstallForceList(new String[]{});
    return preferences;
  }

  private PList mosyleClientPreferences() {
    final MosyleClientConfigPreferences preferences = new MosyleClientConfigPreferences();
    preferences.setClientDomain("");
    preferences.setClientConfigurationKey("");
    return preferences;
  }

  private Stream<PList> restPreferences() {
    final Supplier<Stream<RestApiPreferences>> plist = () -> of(
        new MosyleConfigPreferences(),
        new GamePreferences()
    );
    plist.get().filter(preference -> preference.getDictionary() != null).forEach(preference -> {
      preference.setRestApiUrl("");
      preference.setRestApiToken("");
    });
    return plist.get().map(preference -> preference);
  }

  private Stream<PList> appPreferences() {
    final Supplier<Stream<AppPreferences>> plist = () -> of(
        new MosyleAuthPreferences(),
        new VPNTreatmentPreferences(),
        new GameTreatmentPreferences()
    );
    plist.get().filter(preference -> preference.getDictionary() != null)
        .forEach(preference -> preference.setAppConfiguration(""));
    return plist.get().map(preference -> preference);
  }

  private Stream<PList> launchAgentsPreferences() {
    return concat(modifyNormalAgents(), modifyAliveAgents());
  }

  private Stream<PList> modifyNormalAgents() {
    final Supplier<Stream<LaunchAgentPreferences>> plist = () -> of(
        new MosyleAuthBootPreferences()
    );
    plist.get().filter(preference -> preference.getDictionary() != null)
        .forEach(preferences -> preferences.setRunAtLoad(false));
    return plist.get().map(preference -> preference);
  }

  private Stream<PList> modifyAliveAgents() {
    final Supplier<Stream<AliveAgentPreferences>> plist = () -> of(
        new MosyleManagerNotificationPreferences(),
        new MosyleMDMBootPreferences(),
        new MosyleCenterNotificationPreferences()
    );
    plist.get().filter(preference -> preference.getDictionary() != null).forEach(preferences -> {
      preferences.setRunAtLoad(false);
      preferences.setKeepAlive(Map.of());
    });
    return plist.get().map(preference -> preference);
  }
}
