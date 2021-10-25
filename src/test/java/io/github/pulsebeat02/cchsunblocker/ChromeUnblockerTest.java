package io.github.pulsebeat02.cchsunblocker;

import com.dd.plist.PropertyListFormatException;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.ChromePreferences;
import io.github.pulsebeat02.cchsunblocker.plist.safety.BackupTask;
import java.io.IOException;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public final class ChromeUnblockerTest {

  public static void main(String[] args)
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException, InterruptedException {
    new BackupTask();
    final ChromePreferences preferences = new ChromePreferences();
    preferences.setInstallBlackList(new String[]{});
    preferences.setInstallForceList(new String[]{});
    preferences.save();
  }

}
