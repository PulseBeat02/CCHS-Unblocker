package io.github.pulsebeat02.cchsunblocker.plist;

import com.dd.plist.NSDictionary;
import java.nio.file.Path;

public interface PListHolder {

  Path getFilePath();

  NSDictionary getDictionary();

  void save(final String passcode);

}
