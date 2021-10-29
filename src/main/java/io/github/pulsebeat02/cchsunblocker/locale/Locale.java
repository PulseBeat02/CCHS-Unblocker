package io.github.pulsebeat02.cchsunblocker.locale;

public interface Locale {

  String NEW_LINE = System.lineSeparator();

  String RESTART_APPS =
      """
          Make sure to restart applications after applying changes! Applications need to
          reload in order to apply the new configurations.
          """;
  String NOTICE =
      """
          Concord Carlisle High School blocks certain websites on the network and certain
          websites on the client. For websites blocked on the network, the only way to 
          bypass them is to use a VPN client (such as Hoxx VPN). Hoxx VPN is an extension
          for Chrome and Firefox you can use to access websites. However, websites that are
          blocked client side can be fixed. Running this program will unblock all Chrome 
          extensions, as well as restrictions the school has put on for games, websites, etc.
          Please not I am not liable for any legal concerns -- use at your own risk! Source
          code found here: https://github.com/PulseBeat02/CCHS-Unblocker
                    
          This application DOES NOT steal your password or any credentials. You can check
          the source code link above if you want to verify. The reason why the password is
          necessary is because some of these files are secured such that you cannot delete
          or modify them without access. Entering your password in this application will
          allow commands use the password to modify these secured files such that extensions,
          websites, and applications will be unblocked.
                    
          Please note, this application DOES NOT store your password anywhere for secure
          reasons. I care about your security, and you should remain secure.
                    
          Please READ carefully above, as it contains important information. Please enter
          "I agree", case-sensitive, if you agree to use the application.
          """;
  String STARTED_BACKUP =
      """
          Starting backup task... a backup of app configurations can be found in the "cchs-unblocker"
          folder in your Documents folder. Feel free to copy if necessary.
          """;
  String FINISHED_BACKUP =
      """
          Finished backup task!
          """;
  String STARTING_EDITS =
      """
          Starting edits on app configuration files!
          """;
  String FINISHED_CHROME_CONFIG_EDITS =
      """
          Finished Chrome config edits! All extensions, dyno game, etc are now unblocked!
          """;
  String FINISHED_GAME_PREFERENCE_EDITS =
      """
          Finished Game preference config edits! Most game websites/client blocked websites
          should be unblocked now!
          """;
  String FINISHED_GAME_TREATMENT_EDITS =
      """
          Finished Game treatment edits! All video game apps on the appstore are now unblocked!
          """;
  String FINISHED_VPN_TREATMENT_EDITS =
      """
          Finished VPN config edits! All VPN apps on the appstore are now unblocked!
          """;
  String FINISHED_MOSYLE_EDITS =
      """
          Finished Mosyle config edits!
          """;
  String FINISHED_MOSYLE_CLIENT_EDITS =
      """
          Finished Mosyle client config edits!
          """;
  String FINISHED_MOSYLE_AUTH_EDITS =
      """
          Finished Mosyle auth config edits!
          """;
  String FINISHED_EDITS =
      """
          Finished edits on all app configuration files! As a reminder, make sure to restart all
          apps if you would like the configurations to be updated.
          """;
  String SHUTTING_DOWN =
      """
          Shutting down application!
          """;

  String ERR_ARGS =
      """
          Invalid arguments! Must provide at least one argument with the current logged-in user
          password for sudo command access!
          """;
  String ERR_SUDOERS_AUDIT = "sudo: error initializing audit plugin sudoers_audit";
}
