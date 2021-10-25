package io.github.pulsebeat02.cchsunblocker;

import com.dd.plist.PropertyListFormatException;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.ChromePreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.GamePreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.GameTreatmentPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.VPNTreatmentPreferences;
import java.io.IOException;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public final class ManualUnblocker {

  public ManualUnblocker()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    setChromeConfiguration();
    setGamePreferences();
    setGameTreatmentPreferences();
    setVpnTreatmentPreferences();
  }

  private void setChromeConfiguration()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    final ChromePreferences chromePreferences = new ChromePreferences();
    chromePreferences.setAllowDinosaurEasterEgg(true);
    chromePreferences.setDefaultBrowserSetting(true);
    chromePreferences.setEditBookmarks(true);
    chromePreferences.setInstallBlackList(new String[]{});
    chromePreferences.setInstallForceList(new String[]{});
  }

  private void setGamePreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    final GamePreferences gamePreferences = new GamePreferences();
    gamePreferences.setRestApiUrl("");
    gamePreferences.setRestApiToken("");
  }

  private void setGameTreatmentPreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    final GameTreatmentPreferences gameTreatmentPreferences = new GameTreatmentPreferences();
    gameTreatmentPreferences.setAppConfiguration("");
  }

  private void setVpnTreatmentPreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    final VPNTreatmentPreferences vpnTreatmentPreferences = new VPNTreatmentPreferences();
    vpnTreatmentPreferences.setAppConfiguration("");
  }
}
