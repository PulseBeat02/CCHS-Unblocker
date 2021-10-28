package io.github.pulsebeat02.cchsunblocker;

import com.dd.plist.PropertyListFormatException;
import io.github.pulsebeat02.cchsunblocker.locale.Locale;
import io.github.pulsebeat02.cchsunblocker.plist.PList;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.ChromePreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.GamePreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.GameTreatmentPreferences;
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
            getVpnTreatmentPreferences())
        .forEach(configuration -> configuration.save(passcode));
  }

  private PList getChromeConfiguration()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    final ChromePreferences chromePreferences = new ChromePreferences();
    chromePreferences.setAllowDinosaurEasterEgg(true);
    chromePreferences.setDefaultBrowserSetting(true);
    chromePreferences.setEditBookmarks(true);
    chromePreferences.setInstallBlackList(new String[]{});
    chromePreferences.setInstallForceList(new String[]{});
    System.out.println(Locale.FINISHED_CHROME_CONFIG_EDITS);
    return chromePreferences;
  }

  private PList getGamePreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    final GamePreferences gamePreferences = new GamePreferences();
    gamePreferences.setRestApiUrl("");
    gamePreferences.setRestApiToken("");
    System.out.println(Locale.FINISHED_GAME_PREFERENCE_EDITS);
    return gamePreferences;
  }

  private PList getGameTreatmentPreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    final GameTreatmentPreferences gameTreatmentPreferences = new GameTreatmentPreferences();
    gameTreatmentPreferences.setAppConfiguration("");
    System.out.println(Locale.FINISHED_GAME_TREATMENT_EDITS);
    return gameTreatmentPreferences;
  }

  private PList getVpnTreatmentPreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    final VPNTreatmentPreferences vpnTreatmentPreferences = new VPNTreatmentPreferences();
    vpnTreatmentPreferences.setAppConfiguration("");
    System.out.println(Locale.FINISHED_VPN_TREATMENT_EDITS);
    return vpnTreatmentPreferences;
  }
}
