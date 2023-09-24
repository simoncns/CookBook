package languageconversion;

import java.util.ResourceBundle;

/**
 * Resource bundle for getting the Strings from the French properties file.
 * 
 * @author Max Adams
 * @version S2
 */
public class FrenchStrings
{
  private static final String BUNDLE_NAME = "Strings_fr_FR"; // The name of your property file
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

  /**
   * Try catch for returning the resource bundle.
   * 
   * @param key
   * @return String
   */
  public static String getString(final String key)
  {
    try
    {
      return RESOURCE_BUNDLE.getString(key);
    }
    catch (Exception e)
    {
      return '!' + key + '!';
    }
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getTitle()
  {
    return getString("MainWindow.title");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getFileLabel()
  {
    return getString("MainWindow.FileLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getExitLabel()
  {
    return getString("MainWindow.ExitLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getEditLabel()
  {
    return getString("MainWindow.EditLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeLabel()
  {
    return getString("MainWindow.RecipeLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getMealLabel()
  {
    return getString("MainWindow.MealLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getSearchLabel()
  {
    return getString("MainWindow.SearchLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipesLabel()
  {
    return getString("MainWindow.RecipesLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getMealsLabel()
  {
    return getString("MainWindow.MealsLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getViewLabels()
  {
    return getString("MainWindow.ViewLabels");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getShoppingListLabel()
  {
    return getString("MainWindow.ShoppingListLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getProcessLabel()
  {
    return getString("MainWindow.ProcessLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getToolsLabel()
  {
    return getString("MainWindow.ToolsLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getCalorieCalculatorLabel()
  {
    return getString("MainWindow.CalculatorLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getUnitConverterLabel()
  {
    return getString("MainWindow.UnitConverterLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getConfigureLabel()
  {
    return getString("MainWindow.ConfigureLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesLabel()
  {
    return getString("MainWindow.PreferencesLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getShortcutsLabel()
  {
    return getString("MainWindow.ShortcutsLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getHelpLabel()
  {
    return getString("MainWindow.HelpLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getUserGuideLabel()
  {
    return getString("MainWindow.UserGuideLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getUnitConverterTitle()
  {
    return getString("UnitConverter.title");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getUnitConverterLabel1()
  {
    return getString("UnitConverter.label1");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getUnitConverterLabel2()
  {
    return getString("UnitConverter.label2");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getUnitConverterLabel3()
  {
    return getString("UnitConverter.label3");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getUnitConverterLabel4()
  {
    return getString("UnitConverter.label4");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getUnitConverterLabel5()
  {
    return getString("UnitConverter.label5");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getUnitConverterInvalid()
  {
    return getString("UnitConverter.Invalid");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getUnitConverterInvalid2()
  {
    return getString("UnitConverter.Invalid2");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getUnitConverterError()
  {
    return getString("UnitConverter.Error");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getCalorieCalculatorTitle()
  {
    return getString("CalorieCalculator.title");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getCalorieCalculatorLabel1()
  {
    return getString("CalorieCalculator.label1");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getCalorieCalculatorLabel2()
  {
    return getString("CalorieCalculator.label2");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getCalorieCalculatorLabel3()
  {
    return getString("CalorieCalculator.label3");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getCalorieCalculatorLabel4()
  {
    return getString("CalorieCalculator.label4");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getCalorieCalculatorInvalid()
  {
    return getString("CalorieCalculator.Invalid");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getCalorieCalculatorInvalid2()
  {
    return getString("CalorieCalculator.Invalid2");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getCalorieCalculatorError()
  {
    return getString("CalorieCalculator.Error");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getShoppingListViewerTitle()
  {
    return getString("ShoppingListViewer.title");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getShoppingListViewerLabel1()
  {
    return getString("ShoppingListViewer.label1");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getShoppingListViewerBorder()
  {
    return getString("ShoppingListViewer.border");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getShoppingListViewerLoad()
  {
    return getString("ShoppingListViewer.Load");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getShoppingListViewerError()
  {
    return getString("ShoppingListViewer.Error");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getShoppingListViewerload2()
  {
    return getString("ShoppingListViewer.load2");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getShoppingListViewerLError()
  {
    return getString("ShoppingListViewer.LError");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getProcessViewerTitle()
  {
    return getString("ProcessViewer.title");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getProcessViewerBorder()
  {
    return getString("ProcessViewer.border");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getProcessViewerBorder2()
  {
    return getString("ProcessViewer.border2");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getProcessViewerLoad()
  {
    return getString("ProcessViewer.Load");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getProcessViewerError()
  {
    return getString("ProcessViewer.Error");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getProcessViewerdrawString()
  {
    return getString("ProcessViewer.drawString");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getProcessViewerload2()
  {
    return getString("ProcessViewer.load2");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getProcessViewerLError()
  {
    return getString("ProcessViewer.LError");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorTitle()
  {

    return getString("RecipeEditor.title");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorRecipeNameLabel()
  {
    return getString("RecipeEditor.recipeNameLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorRecipeServesLabel()
  {
    return getString("RecipeEditor.recipeServesLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorInnerBorder()
  {
    return getString("RecipeEditor.innerBorder");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorUtensilNameLabel()
  {
    return getString("RecipeEditor.utensilNameLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorUtensilDetailLabel()
  {
    return getString("RecipeEditor.utensilDetailLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorAddButton()
  {
    return getString("RecipeEditor.addButton");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorDeleteButton()
  {
    return getString("RecipeEditor.deleteButton");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorInnerBorder2()
  {

    return getString("RecipeEditor.innerBorder");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorIngredientNameLabel()
  {
    return getString("RecipeEditor.ingredientNameLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorIngredientAmountLabel()
  {
    return getString("RecipeEditor.ingredientAmountLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorIngredientDetailsLabel()
  {
    return getString("RecipeEditor.ingredientDetailsLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorIngredientUnitsLabel()
  {
    return getString("RecipeEditor.ingredientUnitsLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorInnerBorder3()
  {
    return getString("RecipeEditor.innerBorder");

  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorstepsActionLabel()
  {

    return getString("RecipeEditor.stepsActionLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorstepsOnLabel()
  {

    return getString("RecipeEditor.stepsOnLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorstepsUtensilLabel()
  {

    return getString("RecipeEditor.stepsUtensilLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorstepsDetailsLabel()
  {

    return getString("RecipeEditor.stepsDetailLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditoringredientCalorieLabel()
  {

    return getString("RecipeEditor.ingredientCalorieLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditoringredientDensityLabel()
  {

    return getString("RecipeEditor.ingredientDensityLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditoraddEmbedded()
  {

    return getString("RecipeEditor.addEmbedded");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeEditorshowEmbedded()
  {

    return getString("RecipeEditor.showEmbedded");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getingredientframetitle()
  {

    return getString("ingredientframe.title");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getMealEditorTitle()
  {

    return getString("MealEditor.title");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getMealEditorrecipeNameLabel()
  {

    return getString("MealEditor.recipeNameLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getMealEditoraddButton()
  {

    return getString("MealEditor.addButton");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getMealEditordeleteButton()
  {

    return getString("MealEditor.deleteButton");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencestitle()
  {

    return getString("Preferences.title");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesExitLabel()
  {

    return getString("Preferences.ExitLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesRecipeLabel()
  {

    return getString("Preferences.RecipeLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesMealLabel()
  {

    return getString("Preferences.MealLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesRecipesLabel()
  {

    return getString("Preferences.RecipesLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesMealsLabel()
  {

    return getString("Preferences.MealsLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesShoppingListLabel()
  {

    return getString("Preferences.ShoppingListLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesProcessLabel()
  {

    return getString("Preferences.ProcessLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesCalorieCalculatorLabel()
  {

    return getString("Preferences.CalorieCalculatorLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesUnitsConverterLabel()
  {

    return getString("Preferences.UnitsConverterLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesPreferencesLabel()
  {

    return getString("Preferences.PreferencesLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesShortcutsLabel()
  {

    return getString("Preferences.ShortcutsLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesNutritionLabel()
  {

    return getString("Preferences.NutritionLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesAboutLabel()
  {

    return getString("Preferences.AboutLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesUserGuideLabel()
  {

    return getString("Preferences.UserGuideLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesSave()
  {

    return getString("Preferences.Save");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getPreferencesError()
  {

    return getString("Preferences.Error");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getMealSearcherGUItitle()
  {

    return getString("MealSearcherGUI.title");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getMealSearcherGUIrequiredIngredientLabel()
  {

    return getString("MealSearcherGUI.requiredIngredientLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getMealSearcherGUIexcludedIngredientLabel()
  {

    return getString("MealSearcherGUI.excludedIngredientLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getMealSearcherGUIaddButton()
  {

    return getString("MealSearcherGUI.addButton");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getMealSearcherGUITool1()
  {

    return getString("MealSearcherGUI.Tool1");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getMealSearcherGUITool2()
  {

    return getString("MealSearcherGUI.Tool2");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getMealSearcherGUITool3()
  {

    return getString("MealSearcherGUI.Tool3");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeSearcherGUItitle()
  {

    return getString("RecipeSearchGUI.title");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeSearcherGUIrequiredIngredientLabel()
  {

    return getString("RecipeSearchGUI.requiredIngredientLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeSearcherGUIexcludedIngredientLabel()
  {

    return getString("RecipeSearchGUI.excludedIngredientLabel");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeSearcherGUIaddButton()
  {

    return getString("RecipeSearchGUI.addButton");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeSearcherGUITool1()
  {

    return getString("RecipeSearchGUI.Tool1");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeSearcherGUITool2()
  {

    return getString("RecipeSearchGUI.Tool2");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getRecipeSearcherGUITool3()
  {

    return getString("RecipeSearchGUI.Tool3");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getShortcutstitle()
  {

    return getString("Shortcuts.title");
  }

  /**
   * get method for grabbing the associated String value.
   * 
   * @return String
   */
  public static String getShortcutsLabel1()
  {

    return getString("Shortcuts.Label1");
  }

}
