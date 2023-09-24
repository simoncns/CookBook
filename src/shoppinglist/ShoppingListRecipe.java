package shoppinglist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import data.Ingredient;
import data.Recipe;
import tools.Conversions;
import tools.Measurements;
import tools.Volume;

/**
 * Class representing a shopping list for one recipe.
 * 
 * @author Nick Simoncelli
 * @version 1.0
 *
 */
public class ShoppingListRecipe implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Recipe recipe;
  private List<Ingredient> shoppingListItems;
  private String toStringFormat = "-%s (%s %s)";

  /**
   * Empty constructor for a ShoppingListRecipe.
   */
  public ShoppingListRecipe()
  {
    this.recipe = null;
    this.shoppingListItems = new ArrayList<>();
  }

  /**
   * Constructor for ShoppingListRecipe given the recipe.
   * 
   * @param recipe
   */
  public ShoppingListRecipe(final Recipe recipe)
  {
    this.recipe = recipe;
    this.shoppingListItems = new ArrayList<>();
    shoppingListString();
  }

  /**
   * Recipe getter.
   * 
   * @return recipe recipe information
   */
  public Recipe getRecipe()
  {
    return recipe;
  }

  /**
   * People getter.
   * 
   * @return people amount being cooked for
   */
  public int getPeople()
  {
    return recipe.getAmount();
  }

  /**
   * ShoppingListItems getter.
   * 
   * @return shoppingListItems List of items
   */
  public List<Ingredient> getShoppingListItems()
  {
    return shoppingListItems;
  }

  /**
   * Name getter.
   * 
   * @return title name of recipe
   */
  public String getName()
  {
    return recipe.getName();
  }

  /**
   * Method to form shoppingListItems from recipe.
   */
  public void shoppingListString()
  {
    if (recipe != null)
    {
      shoppingListItems.clear();
      for (Ingredient ingredient : recipe.getIngredient())
      {
        shoppingListItems.add(ingredient);
      }
    }
  }

  /**
   * ToString method for the shoppingList.
   * 
   * @return String toString representation
   */
  public String toString()
  {
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
   * ToString method for the shoppingListRecipe.
   * 
   * @return List<String> List of ingredients to be printed
   */
  public List<String> toStringPrintHelp()
  {
    List<String> items = new ArrayList<>();
    for (Ingredient item : shoppingListItems)
    {
      items.add(String.format(toStringFormat, item.getName().toLowerCase(),
          Double.valueOf(Math.ceil(item.getAmount() * getPeople())), item.getUnit()));
    }
    Collections.sort(items);
    return items;
  }

}
