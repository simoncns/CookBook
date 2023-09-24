package gui;

import java.awt.Desktop;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * MenuController class that allows the user to select tabs from MainWindow while also redirecting.
 * the user to these tasks
 * 
 * @author Max Adams
 * @version S1
 *
 */
public class MenuController implements ActionListener
{

  private static String FILE = "File";
  private static String EXIT = "Exit";
  private static String EDIT = "Edit";
  private static String MSEARCH = "Meals";
  private static String RSEARCH = "Recipes";
  private static String VIEW = "View";
  private static String TOOLS = "Tools";
  private static String CONFIGURE = "Configure";
  private static String HELP = "Help";
  private static String UNIT_CONVERTER = "Unit Converter";
  private static String CALORIE_CALCULATOR = "Calorie Calculator";
  private static String SHOPPING_LIST_VIEWER = "ShoppingList";
  private static String STEP = "Process";
  private static String RECIPE = "Recipe";
  private static String MEAL = "Meal";
  private static String SHORT_CUTS = "Shortcuts";
  private static String PREFERENCES = "Preferences";
  private static String USER_GUIDE = "User Guide";

  /**
   * MenuController constructor **currently empty**.
   */
  public MenuController()
  {

  }

  @Override
  public void actionPerformed(final ActionEvent evt)
  {
    if (evt.getActionCommand().equals(EXIT))
    {
      System.exit(0);
    }
    if (evt.getActionCommand().equals(UNIT_CONVERTER))
    {
      new UnitConverter();
    }
    if (evt.getActionCommand().equals(CALORIE_CALCULATOR))
    {
      new CalorieCalculator();
    }

    if (evt.getActionCommand().equals(SHOPPING_LIST_VIEWER))
    {
      new ShoppingListViewer();
    }
    if (evt.getActionCommand().equals(STEP))
    {
      new ProcessViewer();
    }
    if (evt.getActionCommand().equals(RECIPE))
    {
      new RecipeEditor();
    }
    if (evt.getActionCommand().equals(MEAL))
    {
      new MealEditor();
    }
    if (evt.getActionCommand().equals(SHORT_CUTS))
    {
      new Shortcuts();
    }

    if (evt.getActionCommand().equals(MSEARCH))
    {
      new MealSearcherGUI();
    }

    if (evt.getActionCommand().equals(PREFERENCES))
    {
      new Preferences();
    }

    if (evt.getActionCommand().equals(RSEARCH))
    {
      new RecipeSearcherGUI();
    }

    if (evt.getActionCommand().equals(USER_GUIDE))
    {
      File f = new File("UserGuide/Kitchintel.html");
      try
      {
        Desktop.getDesktop().open(f);
      }
      catch (IOException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

  }
}
