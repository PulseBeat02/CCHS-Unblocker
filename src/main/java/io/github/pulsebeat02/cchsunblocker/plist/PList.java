package io.github.pulsebeat02.cchsunblocker.plist;

import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListFormatException;
import com.dd.plist.PropertyListParser;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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

  @Override
  public void save() throws IOException, InterruptedException {
    final String xml = dictionary.toXMLPropertyList();
    final String absolutePath = file.toAbsolutePath().toString();
    executeCommand("sudo", "-S", "rm", "-rf", absolutePath);
    createWriterFile(xml);
    executeCommand("sudo", "-S", "plutil", "-convert", "binary1", absolutePath);
  }

  private void createWriterFile(final String contents) throws IOException {
    Files.deleteIfExists(file);
    Files.createFile(file);
    Files.writeString(file, contents);
  }

  private void executeCommand(final String... command) throws IOException, InterruptedException {
    final ProcessBuilder builder = new ProcessBuilder(command).inheritIO();
    final Process process = builder.start();
    final OutputStream stream = process.getOutputStream();
    stream.write("%s\n".formatted("").getBytes(StandardCharsets.UTF_8));
    stream.flush();
    stream.close();
    process.waitFor();
  }
}
