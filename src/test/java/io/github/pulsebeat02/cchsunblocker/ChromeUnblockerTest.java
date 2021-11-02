package io.github.pulsebeat02.cchsunblocker;

import com.dd.plist.PropertyListFormatException;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.application.ChromePreferences;
import io.github.pulsebeat02.cchsunblocker.backup.BackupTask;
import java.io.IOException;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public final class ChromeUnblockerTest {

  public static void main(final String[] args)
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    new BackupTask();
    final ChromePreferences preferences = new ChromePreferences();
    preferences.setAllowDinosaurEasterEgg(true);
    preferences.setInstallForceList(new String[]{});
    preferences.setInstallBlackList(new String[]{});
    preferences.save(""); // replace quotes with password
  }

}
