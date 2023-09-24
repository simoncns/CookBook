package shoppinglist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import data.Ingredient;
import data.Meal;
import data.Recipe;
import tools.Conversions;
import tools.Volume;

/**
 * Class representing a shopping list for one meal.
 * 
 * @author Nick Simoncelli
 * @version 1.0
 *
 */
public class ShoppingListMeal implements Serializable
{
  private static final long serialVersionUID = 1L;
  private static String sl = "Shopping List";
  private List<Recipe> recipes;
  private Meal meal;
  private List<Ingredient> shoppingListItems;
  private String toStringFormat = "-%s (%s %s)";
  private int people;

  /**
   * Constructor for ShoppingListMeal given the recipes.
   * 
   * @param recipes
   *          recipes in the meal
   */
  public ShoppingListMeal(final List<Recipe> recipes)
  {
    this.people = 1;
    this.recipes = recipes;
    this.meal = new Meal(sl);
    for (Recipe recipe : recipes)
    {
      meal.addRecipe(recipe);
      if (recipe.getAmount() > people)
      {
        people = recipe.getAmount();
      }
    }
    shoppingListItems = meal.getMealIngredients();
  }

  /**
   * Getter for the recipes.
   * 
   * @return recipes recipes in the meal
   */
  public List<Recipe> getRecipes()
  {
    return recipes;
  }

  /**
   * People getter.
   * 
   * @return people amount being cooked for
   */
  public int getPeople()
  {
    return people;
  }

  /**
   * Getter for the meal.
   * 
   * @return meal Meal object
   */
  public Meal getMeal()
  {
    return meal;
  }

  /**
   * ToString method for the shoppingList.
   * 
   * @return String toString representation
   */
  public String toString()
  {
    shoppingListItems.clear();
    shoppingListItems = meal.getMealIngredients();
    String result = "";
    List<String> items = new ArrayList<>();
    for (Ingredient item : shoppingListItems)
    {
      items.add(String.format(toStringFormat, item.getName().toLowerCase(),
          Math.ceil(Double.valueOf(item.getAmount() * getPeople())), item.getUnit()));
    }
    Collections.sort(items);
    for (String item : items)
    {
      result += item + "\n";
    }
    return result;
  }

  /**
   * toString print helper.
   * 
   * @return List<String> List of ingredients for printing
   */
  public List<String> toStringPrintHelp()
  {
    shoppingListItems.clear();
    shoppingListItems = meal.getMealIngredients();
    List<String> items = new ArrayList<>();
    for (Ingredient item : shoppingListItems)
    {
      items.add(String.format(toStringFormat, item.getName().toLowerCase(),
          Math.ceil(Double.valueOf(item.getAmount() * getPeople())), item.getUnit()));
    }
    Collections.sort(items);
    return items;
  }

}
