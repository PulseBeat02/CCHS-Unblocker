package io.github.pulsebeat02.cchsunblocker.plist.implementation;

import com.dd.plist.PropertyListFormatException;
import io.github.pulsebeat02.cchsunblocker.PreferenceFileLocale;
import io.github.pulsebeat02.cchsunblocker.plist.PList;
import java.io.IOException;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public final class ChromePreferences extends PList {

  public ChromePreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    super(PreferenceFileLocale.CHROME_PREF);
  }

  public void setDefaultBrowserSetting(final boolean value) {
    getDictionary().put("DefaultBrowserSettingEnabled", value);
  }

  public boolean getDefaultBrowserSetting() {
    return getDictionary().get("DefaultBrowserSettingEnabled").toJavaObject(Boolean.class);
  }

  public void setAllowDinosaurEasterEgg(final boolean value) {
    getDictionary().put("AllowDinosaurEasterEgg", value);
  }

  public boolean getAllowDinosaurEasterEgg() {
    return getDictionary().get("AllowDinosaurEasterEgg").toJavaObject(Boolean.class);
  }


  public void setEditBookmarks(final boolean value) {
    getDictionary().put("EditBookmarksEnabled", value);
  }

  public boolean getEditBookmarks() {
    return getDictionary().get("EditBookmarksEnabled").toJavaObject(Boolean.class);
  }

  public void setInstallBlackList(final String[] array) {
    getDictionary().put("ExtensionInstallBlacklist", array);
  }

  public String[] getInstallBlackList() {
    return getDictionary().get("ExtensionInstallBlacklist").toJavaObject(String[].class);
  }

  public void setInstallForceList(final String[] array) {
    getDictionary().put("ExtensionInstallForcelist", array);
  }

  public String[] getInstallForceList() {
    return getDictionary().get("ExtensionInstallForcelist").toJavaObject(String[].class);
  }
}
