package io.github.pulsebeat02.cchsunblocker.plist.implementation;

import io.github.pulsebeat02.cchsunblocker.plist.PList;
import java.nio.file.Path;

public abstract class RestApiPreferences extends PList {

  public RestApiPreferences(final Path file, final String console) {
    super(file, console);
  }

  private static final String PAYLOAD_UUID;
  private static final String CREATION_DATE;
  private static final String REST_API_TOKEN;
  private static final String REST_API_URL;

  static {
    PAYLOAD_UUID = "PayloadUUID";
    CREATION_DATE = "creation_date";
    REST_API_TOKEN = "rest_api_token";
    REST_API_URL = "rest_api_url";
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
