package io.github.pulsebeat02.cchsunblocker.plist.implementation;

import com.dd.plist.PropertyListFormatException;
import io.github.pulsebeat02.cchsunblocker.locale.PathLocale;
import java.io.IOException;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public final class VPNTreatmentPreferences extends AppPreferences {

  public VPNTreatmentPreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    super(PathLocale.VPN_TREATMENT);
  }
}
