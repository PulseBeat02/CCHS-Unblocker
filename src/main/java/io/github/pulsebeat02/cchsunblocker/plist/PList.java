package io.github.pulsebeat02.cchsunblocker.plist;

import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListFormatException;
import com.dd.plist.PropertyListParser;
import io.github.pulsebeat02.cchsunblocker.locale.PathLocale;
import io.github.pulsebeat02.cchsunblocker.utils.FileUtils;
import io.github.pulsebeat02.cchsunblocker.utils.NativeUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class PList implements PListHolder {

  private static final String XML;
  private static final String BINARY;

  static {
    XML = "xml1";
    BINARY = "binary1";
  }

  private final Path file;
  private final Path temp;
  private final Path script;
  private final NSDictionary dictionary;
  private final String sudo;
  private final String console;

  public PList(final Path file, final String console)
      throws PropertyListFormatException, IOException, ParseException, ParserConfigurationException, SAXException {
    this.file = file.toAbsolutePath();
    this.dictionary = (NSDictionary) PropertyListParser.parse(file.toFile());
    this.sudo = "sudo -S <<< \"%s\"";
    final Path folder = PathLocale.UNBLOCKER_FOLDER;
    FileUtils.createFoldersIfNotExists(folder);
    final String name = FileUtils.getFileNameWithoutExtension(file);
    this.temp = folder.resolve("%s.plist".formatted(name));
    this.script = folder.resolve("%s.sh".formatted(name));
    this.console = console;
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
  public void save(final String passcode) {
    try {
      changePermissions(passcode, file.toString());
      delay(); // ensure that previous task has completed
      createContents(passcode, true);
      delay();
      createTempFile(dictionary.toXMLPropertyList());
      delay();
      modifyFile(passcode);
      delay();
      createContents(passcode, false);
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(console);
  }

  @Override
  public String getFinishedConsoleMessage() {
    return console;
  }

  private void createTempFile(final String xml) throws IOException {
    FileUtils.createFileIfNotExists(temp);
    Files.writeString(temp, xml);
  }

  private void createContents(final String passcode, final boolean xml)
      throws IOException, InterruptedException {
    final String cmd = ("%s plutil -convert %%s \"%%s\"".formatted(sudo)).formatted(
        passcode,
        xml ? XML : BINARY,
        file
    );
    createScript(cmd);
    final String path = script.toString();
    changePermissions(passcode, path);
    executeScript(path);
  }

  private void changePermissions(final String passcode, final String script)
      throws IOException, InterruptedException {
    NativeUtils.executeCommand("/bin/sh", "-c",
        ("%s chmod 777 \"%%s\"".formatted(sudo)).formatted(passcode, script));
  }

  private void executeScript(final String script) throws IOException, InterruptedException {
    NativeUtils.executeCommand("sh", script);
  }

  private void modifyFile(final String passcode) throws IOException, InterruptedException {
    NativeUtils.executeCommand("/bin/sh", "-c",
        ("%s cat \"%%s\" > \"%%s\"".formatted(sudo)).formatted(passcode,
            temp, file));
  }

  private void createScript(final String cmd) throws IOException {
    FileUtils.createFileWithContents(script, cmd);
  }

  private void delay() throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(500L);
  }
}
