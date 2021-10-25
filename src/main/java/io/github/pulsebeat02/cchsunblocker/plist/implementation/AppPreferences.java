package io.github.pulsebeat02.cchsunblocker.plist.implementation;

import com.dd.plist.PropertyListFormatException;
import io.github.pulsebeat02.cchsunblocker.plist.PList;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class AppPreferences extends PList {

  public AppPreferences(final Path path)
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    super(path);
  }

  public void setPayloadUUID(final String payloadUUID) {
    getDictionary().put("PayloadUUID", payloadUUID);
  }

  public String getPayloadUUID() {
    return getDictionary().get("PayloadUUID").toJavaObject(String.class);
  }

  public void setHash(final String hash) {
    getDictionary().put("Hash", hash);
  }

  public String getHash() {
    return getDictionary().get("Hash").toJavaObject(String.class);
  }

  public void setAppConfiguration(final String configuration) {
    getDictionary().put("Configuration", configuration);
  }

  public String getAppConfiguration() {
    return getDictionary().get("Configuration").toJavaObject(String.class);
  }

  public void setCreationDate(final long epoch) {
    getDictionary().put("CreationDate", epoch);
  }

  public long getCreationDate() {
    return Long.parseLong(getDictionary().get("CreationDate").toJavaObject(String.class));
  }
}
