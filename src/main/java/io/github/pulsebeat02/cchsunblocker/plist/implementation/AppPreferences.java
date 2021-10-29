package io.github.pulsebeat02.cchsunblocker.plist.implementation;

import com.dd.plist.PropertyListFormatException;
import io.github.pulsebeat02.cchsunblocker.plist.PList;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public abstract class AppPreferences extends PList {

  private static final String PAYLOAD_UUID;
  private static final String HASH;
  private static final String CONFIGURATION;
  private static final String CREATION_DATE;

  static {
    PAYLOAD_UUID = "PayloadUUID";
    HASH = "Hash";
    CONFIGURATION = "Configuration";
    CREATION_DATE = "CreationDate";
  }

  public AppPreferences(final Path path, final String console)
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    super(path, console);
  }

  public void setPayloadUUID(final String payloadUUID) {
    getDictionary().put(PAYLOAD_UUID, payloadUUID);
  }

  public String getPayloadUUID() {
    return getDictionary().get(PAYLOAD_UUID).toJavaObject(String.class);
  }

  public void setHash(final String hash) {
    getDictionary().put(HASH, hash);
  }

  public String getHash() {
    return getDictionary().get(HASH).toJavaObject(String.class);
  }

  public void setAppConfiguration(final String configuration) {
    getDictionary().put(CONFIGURATION, configuration);
  }

  public String getAppConfiguration() {
    return getDictionary().get(CONFIGURATION).toJavaObject(String.class);
  }

  public void setCreationDate(final long epoch) {
    getDictionary().put(CREATION_DATE, epoch);
  }

  public long getCreationDate() {
    return Long.parseLong(getDictionary().get(CREATION_DATE).toJavaObject(String.class));
  }
}
