package io.github.pulsebeat02.cchsunblocker;

import com.dd.plist.PropertyListFormatException;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.ChromePreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.GamePreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.GameTreatmentPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.VPNTreatmentPreferences;
import io.github.pulsebeat02.cchsunblocker.plist.safety.BackupTask;
import java.io.IOException;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public final class CCHSUnblocker {

  public static void main(String[] args)
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    new CCHSUnblocker(args);
  }

  CCHSUnblocker(final String[] args)
      throws IOException, PropertyListFormatException, ParseException, ParserConfigurationException, SAXException {
    System.out.println("Make sure to restart applications after applying changes!");
    startTask();
    editConfigurations();
  }

  private void startTask() throws IOException {
    new BackupTask();
  }

  private void editConfigurations()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    new ManualUnblocker();
  }

}
