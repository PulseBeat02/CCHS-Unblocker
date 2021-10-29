package io.github.pulsebeat02.cchsunblocker.plist.implementation;

import com.dd.plist.PropertyListFormatException;
import io.github.pulsebeat02.cchsunblocker.locale.Locale;
import io.github.pulsebeat02.cchsunblocker.locale.PathLocale;
import io.github.pulsebeat02.cchsunblocker.plist.PList;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public final class MosyleClientConfigPreferences extends PList {

  private static final String CLIENT_DOMAIN;
  private static final String CLIENT_CONFIGURATION_KEY;
  private static final String CREATION_DATE;
  private static final String PAYLOAD_UUID;

  static {
    CLIENT_DOMAIN = "client_domain";
    CLIENT_CONFIGURATION_KEY = "client_configuration_key";
    CREATION_DATE = "creation_date";
    PAYLOAD_UUID = "PayloadUUID";
  }

  public MosyleClientConfigPreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    super(PathLocale.MOSYLE_CLIENT_CONFIG, Locale.FINISHED_MOSYLE_CLIENT_EDITS);
  }

  public String getClientDomain() {
    return getDictionary().get(CLIENT_DOMAIN).toJavaObject(String.class);
  }

  public void setClientDomain(final String domain) {
    getDictionary().put(CLIENT_DOMAIN, domain);
  }

  public String getClientConfigurationKey() {
    return getDictionary().get(CLIENT_CONFIGURATION_KEY).toJavaObject(String.class);
  }

  public void setClientConfigurationKey(final String key) {
    getDictionary().put(CLIENT_CONFIGURATION_KEY, key);
  }

  public String getCreationDate() {
    return getDictionary().get(CREATION_DATE).toJavaObject(String.class);
  }

  public void setCreationDate(final String date) {
    getDictionary().put(CREATION_DATE, date);
  }

  public String getPayloadUUID() {
    return getDictionary().get(PAYLOAD_UUID).toJavaObject(String.class);
  }

  public void setPayloadUUID(final String uuid) {
    getDictionary().put(PAYLOAD_UUID, uuid);
  }
}
