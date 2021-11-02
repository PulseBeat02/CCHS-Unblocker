package io.github.pulsebeat02.cchsunblocker.plist.implementation.mosyle.launchagents;

import java.nio.file.Path;
import java.util.Map;

public abstract class AliveAgentPreferences extends LaunchAgentPreferences {

  private static final String KEEP_ALIVE;

  static {
    KEEP_ALIVE = "KeepAlive";
  }

  public AliveAgentPreferences(final Path file, final String console) {
    super(file, console);
  }

  public Map<String, Object> getKeepAlive() {
    return (Map<String, Object>) getDictionary().get(KEEP_ALIVE).toJavaObject();
  }

  public void setKeepAlive(final Map<String, Object> keepAlive) {
    getDictionary().put(KEEP_ALIVE, keepAlive);
  }
}
