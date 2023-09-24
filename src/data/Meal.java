package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Meal representation.
 * 
 * @author Stephen Watson
 *
 */
public class Meal implements Serializable
{
  private static final long serialVersionUID = 1L;
  private List<Recipe> recipes;
  private String name;

  /**
   * Constructs a meal object.
   * 
   * @param name
   *          the name of the meal
   */
  public Meal(final String name)
  {
    this.recipes = new ArrayList<>();
    this.name = name;
  }

  /**
   * Basic getter for the list of recipes in the meal.
   * 
   * @return the recipes in the meal
   */
  public List<Recipe> getRecipes()
  {
    return this.recipes;
  }

  /**
   * Basic getter for the name of the meal.
   * 
   * @return returns the name of the meal
   */
  public String getName()
  {
    return this.name;
  }

  /**
   * Add a recipe to the meal.
   * 
   * @param recipe Recipe object
   */

  public void addRecipe(final Recipe recipe)
  {
    recipes.add(recipe);
  }

  /**
   * Remove a recipe from the meal.
   * 
   * @param index index of Recipe
   */
  public void removeRecipe(final int index)
  {
    recipes.remove(index);
  }

  /**
   * Creates a string representation of all the ingredients combined.
   * 
   * @return String String representation of ingredients
   */
  public List<Ingredient> getMealIngredients()
  {
    HashMap<String, Ingredient> mealMap = new HashMap<>();
    for (Recipe item : recipes)
    {
      List<Ingredient> ingredients = item.getIngredient();
      for (Ingredient ingredient : ingredients)
      {
        if (mealMap.containsKey(ingredient.getName()))
        {
          if (mealMap.get(ingredient.getName()).getUnit() != ingredient.getUnit())
          {
            mealMap.put(ingredient.getName() + " ", ingredient);
          }
          else
          {
            mealMap.get(ingredient.getName()).addAmount(ingredient.getAmount());
          }
        }
        else
        {
          mealMap.put(ingredient.getName(), ingredient);
        }
      }
    }
    List<Ingredient> ingredients = new ArrayList<>();

    for (Map.Entry<String, Ingredient> item : mealMap.entrySet())
    {
      ingredients.add(item.getValue());
    }

    return ingredients;
  }
}
