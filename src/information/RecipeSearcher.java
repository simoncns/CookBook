package information;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import data.Ingredient;
import data.Recipe;

/**
 * Searches for recipes that contain desired ingredients and no undesired ingredients.
 * 
 * @author Luqman Toor
 * 
 * @version 4/1/2023
 *
 */
public class RecipeSearcher
{

  /**
   * Searches for recipes that contain all of the given required ingredients and none of the
   * excluded ingredients.
   * 
   * @param requiredIngredients
   *          List of required ingredients
   * 
   * @param excludedIngredients
   *          List of excluded ingredients
   * @param recipes
   *          Map of recipe names to Recipe objects
   * @return List of recipes that match the search criteria
   */
  public static List<Recipe> searchRecipes(List<String> requiredIngredients,
      List<String> excludedIngredients, Map<String, Recipe> recipes)
  {
    List<Recipe> matchingRecipes = new ArrayList<>();
    for (Recipe recipe : recipes.values())
    {
      boolean containsRequired = true;
      boolean containsExcluded = false;

      // Check if recipe contains all required ingredients
      for (String required : requiredIngredients)
      {
        boolean present = false;
        for (Ingredient ingredient : recipe.getIngredient())
        {
          if (ingredient.getRecipe() != null)
          {
            for (Ingredient embed : ingredient.getRecipe().getIngredient())
            {
              if (embed.getName().equalsIgnoreCase(required))
              {
                present = true;
                break;
              }
            }
          }

          if (ingredient.getName().equalsIgnoreCase(required))
          {
            present = true;
            break;
          }
        }
        if (!present)
        {
          containsRequired = false;
          break;
        }
      }

      // Check if recipe contains any excluded ingredients
      for (String excludedIngredient : excludedIngredients)
      {
        for (Ingredient ingredient : recipe.getIngredient())
        {
          if (ingredient.getRecipe() != null)
          {
            for (Ingredient embed : ingredient.getRecipe().getIngredient())
            {
              if (ingredient.getName().equalsIgnoreCase(excludedIngredient))
              {
                containsExcluded = true;
                break;
              }
            }
          }
          if (ingredient.getName().equalsIgnoreCase(excludedIngredient))
          {
            containsExcluded = true;
            break;
          }
        }
      }

      if (containsRequired && !containsExcluded)
      {
        matchingRecipes.add(recipe);
      }
    }
    return matchingRecipes;
  }
}
