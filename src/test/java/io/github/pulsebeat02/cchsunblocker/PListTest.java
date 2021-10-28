package io.github.pulsebeat02.cchsunblocker;

import com.dd.plist.PropertyListFormatException;
import io.github.pulsebeat02.cchsunblocker.plist.implementation.ChromePreferences;
import java.io.IOException;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public final class PListTest {

  public static void main(String[] args)
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    System.out.println(new ChromePreferences().getDictionary().keySet());
  }

}
