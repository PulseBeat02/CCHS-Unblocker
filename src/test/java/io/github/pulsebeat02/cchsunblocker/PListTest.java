package io.github.pulsebeat02.cchsunblocker;

import io.github.pulsebeat02.cchsunblocker.plist.implementation.mosyle.launchagents.MosyleManagerNotificationPreferences;
import java.util.Map;

public final class PListTest {

  public static void main(String[] args) {
    final MosyleManagerNotificationPreferences preferences = new MosyleManagerNotificationPreferences();
    System.out.println(preferences.getKeepAlive());
    preferences.setKeepAlive(Map.of());
    System.out.println(preferences.getKeepAlive());
  }

}
