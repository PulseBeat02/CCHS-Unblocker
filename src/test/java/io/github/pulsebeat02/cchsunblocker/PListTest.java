package io.github.pulsebeat02.cchsunblocker;

import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListFormatException;
import com.dd.plist.PropertyListParser;
import io.github.pulsebeat02.cchsunblocker.locale.PathLocale;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.ChromePreferences;
import java.io.IOException;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public final class PListTest {

  public static void main(String[] args)
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    System.out.println(((NSDictionary) PropertyListParser.parse(PathLocale.MOSYLE_CLIENT_CONFIG.toFile())).toXMLPropertyList());
  }

}
