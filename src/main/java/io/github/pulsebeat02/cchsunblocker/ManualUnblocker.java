package io.github.pulsebeat02.cchsunblocker;

import com.dd.plist.PropertyListFormatException;
import io.github.pulsebeat02.cchsunblocker.plist.PList;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.ChromePreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.GamePreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.GameTreatmentPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.MosyleAuthPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.MosyleClientConfigPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.MosyleConfigPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.VPNTreatmentPreferences;
import java.io.IOException;
import java.text.ParseException;
import java.util.stream.Stream;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public final class ManualUnblocker {

  public ManualUnblocker(final String passcode)
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    Stream.of(getChromeConfiguration(), getGamePreferences(), getGameTreatmentPreferences(),
            getVpnTreatmentPreferences(), getMosyleConfigPreferences(),
            getMosyleClientConfigPreferences(), getMosyleAuthPreferences())
        .forEach(configuration -> configuration.save(passcode));
  }

  private PList getChromeConfiguration()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    final ChromePreferences preferences = new ChromePreferences();
    preferences.setAllowDinosaurEasterEgg(true);
    preferences.setDefaultBrowserSetting(true);
    preferences.setEditBookmarks(true);
    preferences.setInstallBlackList(new String[]{});
    preferences.setInstallForceList(new String[]{});
    return preferences;
  }

  private PList getGamePreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    final GamePreferences preferences = new GamePreferences();
    preferences.setRestApiUrl("");
    preferences.setRestApiToken("");
    return preferences;
  }

  private PList getGameTreatmentPreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    final GameTreatmentPreferences preferences = new GameTreatmentPreferences();
    preferences.setAppConfiguration("");
    return preferences;
  }

  private PList getVpnTreatmentPreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    final VPNTreatmentPreferences preferences = new VPNTreatmentPreferences();
    preferences.setAppConfiguration("");
    return preferences;
  }

  private PList getMosyleConfigPreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    final MosyleConfigPreferences preferences = new MosyleConfigPreferences();
    preferences.setRestApiUrl("");
    preferences.setRestApiToken("");
    return preferences;
  }

  private PList getMosyleClientConfigPreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    final MosyleClientConfigPreferences preferences = new MosyleClientConfigPreferences();
    preferences.setClientDomain("");
    preferences.setClientConfigurationKey("");
    return preferences;
  }

  private PList getMosyleAuthPreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    final MosyleAuthPreferences preferences = new MosyleAuthPreferences();
    preferences.setAppConfiguration("");
    return preferences;
  }
}
