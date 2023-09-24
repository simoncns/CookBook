package data;

import java.io.Serializable;
import java.util.List;

/**
 * Recipe Characterization includes a name and the number of people it serves.
 * 
 * @author Stephen Watson.
 * 
 * @version V1.1
 *
 */
public class Recipe implements Serializable
{
  private static final long serialVersionUID = 1L;

  
  private String name;
  private int amount;
  private List<Ingredient> ingredients;
  private List<Utensil> utensils;
  private List<Step> steps;

  /**
   * Constructs Recipe object with no embedded ingredients.
   * 
   * @param name String representation of name of recipe
   * @param amount Int amount recipe serves
   * @param ingredients List of ingredients in recipe
   * @param utensils List of utensils in recipe
   * @param steps List of steps in recipe
   */
  public Recipe(final String name, final int amount, final List<Ingredient> ingredients,
      final List<Utensil> utensils, final List<Step> steps)
  {
    this.name = name;
    this.amount = amount;
    this.ingredients = ingredients;
    this.utensils = utensils;
    this.steps = steps;
  }

  /**
   * Gets the name of the recipe.
   * 
   * @return String name of recipe
   */
  public String getName()
  {
    return name;
  }

  /**
   * Gets the amount of people this recipe can serve.
   * 
   * @return amount amount of people
   */
  public int getAmount()
  {
    return amount;
  }

  /**
   * Gets the list of all ingredients.
   * 
   * @return List List of ingredients
   */
  public List<Ingredient> getIngredient()
  {
    return this.ingredients;
  }

  /**
   * Gets the list of all utensils.
   * 
   * @return List List of utensils
   */
  public List<Utensil> getUtensils()
  {
    return utensils;
  }

  /**
   * Gets the list of all steps.
   * 
   * @return steps List of steps
   */
  public List<Step> getSteps()
  {
    return steps;
  }
}
