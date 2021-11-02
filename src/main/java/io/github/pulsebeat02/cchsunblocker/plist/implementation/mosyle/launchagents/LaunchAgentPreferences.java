package io.github.pulsebeat02.cchsunblocker.plist.implementation.mosyle.launchagents;

import io.github.pulsebeat02.cchsunblocker.plist.PList;
import java.nio.file.Path;

public abstract class LaunchAgentPreferences extends PList {

  private static final String LABEL;
  private static final String PROGRAM_ARGUMENTS;
  private static final String RUN_AT_LOAD;

  static {
    LABEL = "Label";
    PROGRAM_ARGUMENTS = "ProgramArguments";
    RUN_AT_LOAD = "RunAtLoad";
  }

  public LaunchAgentPreferences(final Path file, final String console) {
    super(file, console);
  }

  public String getLabel() {
    return getDictionary().get(LABEL).toJavaObject(String.class);
  }

  public void setLabel(final String label) {
    getDictionary().put(LABEL, label);
  }

  public String[] getProgramArguments() {
    return getDictionary().get(PROGRAM_ARGUMENTS).toJavaObject(String[].class);
  }

  public void setProgramArguments(final String[] arguments) {
    getDictionary().put(PROGRAM_ARGUMENTS, arguments);
  }

  public boolean getRunAtLoad() {
    return getDictionary().get(RUN_AT_LOAD).toJavaObject(boolean.class);
  }

  public void setRunAtLoad(final boolean run) {
    getDictionary().put(RUN_AT_LOAD, run);
  }
}
