package languageconversion;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Helper class for ResourceBundle.
 * 
 * @author Max Adams and Stephen
 *
 */
public class Language
{

  private static final String ENGLISH = "es";

  /**
   * Helper function for getting the native language bundle.
   * 
   * @return ResourceBundle
   */
  public static ResourceBundle getLanguageBundle()
  {
    Locale userLocale = Locale.getDefault();

    if (userLocale.getLanguage().equals(ENGLISH))
    { // Spanish
      return ResourceBundle.getBundle("languageconversion.Strings_es_ES",
          new Locale(ENGLISH, ENGLISH.toUpperCase()));
    }
    else if (userLocale.getLanguage().equals("fr"))
    { // French
      return ResourceBundle.getBundle("languageconversion.Strings_fr_FR", Locale.FRANCE);
    }
    else
    { // English (default)
      return ResourceBundle.getBundle("languageconversion.Strings_en_US", Locale.US);
    }
  }
}
