package information;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import data.Ingredient;
import data.Meal;
import data.Recipe;

/**
 * Searches for meals that contain all of the given required ingredients and none of the excluded
 * ingredients. A meal is considered valid if all of its recipes contain the required ingredients
 * and none of the excluded ingredients. The search results are returned as a list of meal names to
 * Meal objects.
 * 
 * @author Luqman Toor
 * 
 * @version 4/1/12
 */
public class MealSearcher
{

  /**
   * Searches for meals that contain all of the given required ingredients and none of the excluded
   * ingredients.
   * 
   * @param requiredIngredients
   *          List of required ingredients
   * @param excludedIngredients
   *          List of excluded ingredients
   * @param meals
   *          list of meal names to Meal objects
   * @return Map of meal names to Meal objects that match the search criteria
   */
  public static List<Meal> searchMeals(List<String> requiredIngredients,
      List<String> excludedIngredients, List<Meal> meals)
  {
    List<Meal> matchingMeals = new ArrayList<>();

    for (Meal meal : meals)
    {
      HashSet<String> foundIngredients = new HashSet<>();
      boolean allRequiredIngredientsFound = false;
      boolean hasExcludedIngredients = false;

      for (Recipe recipe : meal.getRecipes())
      {
        // System.out.println(recipe.getName());

        for (Ingredient ingredient : recipe.getIngredient())
        {
          // System.out.println("ingredient loop");
          String ingredientName = ingredient.getName();
          // System.out.println(ingredientName);
          // System.out.println(requiredIngredients.get(0));
          for (String reqIngredient : requiredIngredients)
          {
            // System.out.println("required ingredient loop");
            // System.out.println(String.format("%s %s", ingredientName, reqIngredient));
            if (reqIngredient.equalsIgnoreCase(ingredientName))
            {
              // System.out.println(ingredientName);
              foundIngredients.add(ingredientName.toLowerCase());
              // System.out.println("found req");
            }
          }
          for (String excIngredient : excludedIngredients)
          {
            if (excIngredient.equalsIgnoreCase(ingredientName))
            {
              // System.out.println(meal.getName());
              // System.out.println(ingredientName);
              hasExcludedIngredients = true;
              // System.out.println("found ex");
            }
          }

        }
      }
      // System.out.println(foundIngredients);
      for (String f : requiredIngredients)
      {
        // System.out.println(f);
        if (foundIngredients.contains(f.toLowerCase()))
        {

          // System.out.println(f);
          // System.out.println(foundIngredients.contains(f));
          allRequiredIngredientsFound = true;
        }
        else
        {
          allRequiredIngredientsFound = false;
        }
      }
      // System.out.println(allRequiredIngredientsFound);
      // System.out.println(allRequiredIngredientsFound && !hasExcludedIngredients);
      if (allRequiredIngredientsFound && !hasExcludedIngredients)
      {
        // System.out.println(meal.getName());
        matchingMeals.add(meal);
      }
    }

    return matchingMeals;
  }
}
