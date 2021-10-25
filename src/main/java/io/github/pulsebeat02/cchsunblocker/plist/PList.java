package io.github.pulsebeat02.cchsunblocker.plist;

import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListFormatException;
import com.dd.plist.PropertyListParser;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class PList implements PListHolder {

  private final Path file;
  private final NSDictionary dictionary;

  public PList(final Path file)
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    this.file = file;
    this.dictionary = (NSDictionary) PropertyListParser.parse(file.toFile());
  }

  @Override
  public Path getFilePath() {
    return file;
  }

  @Override
  public NSDictionary getDictionary() {
    return dictionary;
  }
}
