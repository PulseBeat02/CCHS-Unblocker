package io.github.pulsebeat02.cchsunblocker.plist.implementation;

import com.dd.plist.PropertyListFormatException;
import io.github.pulsebeat02.cchsunblocker.locale.Locale;
import io.github.pulsebeat02.cchsunblocker.locale.PathLocale;
import io.github.pulsebeat02.cchsunblocker.plist.PList;
import java.io.IOException;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public final class ChromePreferences extends PList {

  private static final String DEFAULT_BROWSER_SETTING;
  private static final String DINOSAUR_EASTER_EGG;
  private static final String EDIT_BOOKMARKS;
  private static final String EXTENSION_INSTALL_BLACKLIST;
  private static final String EXTENSION_INSTALL_FORCELIST;

  static {
    DEFAULT_BROWSER_SETTING = "DefaultBrowserSettingEnabled";
    DINOSAUR_EASTER_EGG = "AllowDinosaurEasterEgg";
    EDIT_BOOKMARKS = "EditBookmarksEnabled";
    EXTENSION_INSTALL_BLACKLIST = "ExtensionInstallBlacklist";
    EXTENSION_INSTALL_FORCELIST = "ExtensionInstallForcelist";
  }

  public ChromePreferences()
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    super(PathLocale.CHROME_PREF, Locale.FINISHED_CHROME_CONFIG_EDITS);
  }

  public void setDefaultBrowserSetting(final boolean value) {
    getDictionary().put(DEFAULT_BROWSER_SETTING, value);
  }

  public boolean getDefaultBrowserSetting() {
    return getDictionary().get(DEFAULT_BROWSER_SETTING).toJavaObject(Boolean.class);
  }

  public void setAllowDinosaurEasterEgg(final boolean value) {
    getDictionary().put(DINOSAUR_EASTER_EGG, value);
  }

  public boolean getAllowDinosaurEasterEgg() {
    return getDictionary().get(DINOSAUR_EASTER_EGG).toJavaObject(Boolean.class);
  }


  public void setEditBookmarks(final boolean value) {
    getDictionary().put(EDIT_BOOKMARKS, value);
  }

  public boolean getEditBookmarks() {
    return getDictionary().get(EDIT_BOOKMARKS).toJavaObject(Boolean.class);
  }

  public void setInstallBlackList(final String[] array) {
    getDictionary().put(EXTENSION_INSTALL_BLACKLIST, array);
  }

  public String[] getInstallBlackList() {
    return getDictionary().get(EXTENSION_INSTALL_BLACKLIST).toJavaObject(String[].class);
  }

  public void setInstallForceList(final String[] array) {
    getDictionary().put(EXTENSION_INSTALL_FORCELIST, array);
  }

  public String[] getInstallForceList() {
    return getDictionary().get(EXTENSION_INSTALL_FORCELIST).toJavaObject(String[].class);
  }
}
