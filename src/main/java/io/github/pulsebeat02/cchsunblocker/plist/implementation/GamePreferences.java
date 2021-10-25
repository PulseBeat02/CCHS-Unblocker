package io.github.pulsebeat02.cchsunblocker.plist.implementation;

import com.dd.plist.PropertyListFormatException;
import io.github.pulsebeat02.cchsunblocker.PreferenceFileLocale;
import io.github.pulsebeat02.cchsunblocker.plist.PList;
import java.io.IOException;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public final class GamePreferences extends PList {

  public GamePreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    super(PreferenceFileLocale.GAMES);
  }

  public void setPayloadUUID(final String payloadUUID) {
    getDictionary().put("PayloadUUID", payloadUUID);
  }

  public String getPayloadUUID() {
    return getDictionary().get("PayloadUUID").toJavaObject(String.class);
  }

  public void setCreationDate(final String payloadUUID) {
    getDictionary().put("creation_date", payloadUUID);
  }

  public String getCreationDate() {
    return getDictionary().get("creation_date").toJavaObject(String.class);
  }

  public void setRestApiToken(final String payloadUUID) {
    getDictionary().put("rest_api_token", payloadUUID);
  }

  public String getRestApiToken() {
    return getDictionary().get("rest_api_token").toJavaObject(String.class);
  }

  public void setRestApiUrl(final String payloadUUID) {
    getDictionary().put("rest_api_url", payloadUUID);
  }

  public String getRestApiUrl() {
    return getDictionary().get("rest_api_url").toJavaObject(String.class);
  }
}
