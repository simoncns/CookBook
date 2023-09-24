package data;

import java.io.Serializable;

/**
 * Ingredient Class that makes a simple ingredient based on file specifications.
 * 
 * @author BigdaddyAidan
 * @version 3/30/23
 */
public class Ingredient implements Serializable, Comparable<Ingredient>
{
  private static final long serialVersionUID = 1L;
  private String amount;
  private String unit;
  private String name;
  private String details;
  private int calories;
  private double density;
  
  private Recipe recipe;

  /**
   * The default constructor for a ingredient.
   * 
   * @param name name of ingredient
   * @param details details of ingredient
   * @param amount amount of ingredient
   * @param unit unit of measurements used for ingredient
   */
  public Ingredient(final String amount, final String unit, final String name, final String details)
  {
    this.amount = amount;
    this.unit = unit;
    this.name = name;
    this.details = details;
    this.recipe = null;
  }

  /**
   * The default constructor for a ingredient.
   * 
   * @param name name of ingredient
   * @param details details of ingredient
   * @param unit unit of measurements used for ingredient
   */
  public Ingredient(final String amount, final String unit, final String name)
  {
    this.amount = amount;
    this.unit = unit;
    this.name = name;
    this.details = null;
    this.recipe = null;
  }

  /**
   * Gets the amount from the ingredient.
   * 
   * @return returns the double value of amount
   */

  public double getAmount()
  {
    return Double.parseDouble(this.amount);
  }

  /**
   * Adds a specified amount to amount.
   * 
   * @param value add certain amount of people recipe can serve
   */
  public void addAmount(final double value)
  {
    this.amount = Double.toString(getAmount() + value);
  }

  /**
   * Gets the name of the ingredient.
   * 
   * @return returns the name
   */

  public String getName()
  {
    return this.name;
  }

  /**
   * Getter for units of the ingredient.
   * 
   * @return returns the unit
   */
  public String getUnit()
  {
    return this.unit;
  }

  /**
   * Sets the calories.
   * 
   * @param calorie calories of the recipe
   */
  public void setCalorie(final int calorie)
  {
    this.calories = calorie;
  }

  /**
   * Sets the density.
   * 
   * @param density density of the recipe
   */
  public void setDensity(final double density)
  {
    this.density = density;
  }

  /**
   * Gets the Calories.
   * 
   * @return calories calories of the recipe
   */
  public int getCalorie()
  {
    return this.calories;
  }

  /**
   * Gets the density.
   * 
   * @return density recipe density
   */
  public double getDensity()
  {
    return this.density;
  }
  
  /**
   * Sets the embedded recipe in the ingredient.
   * 
   * @param recipe recipe object to be set as
   */
  public void setRecipe(final Recipe recipe)
  {
    this.recipe = recipe;
  }
  
  /**
   * Gets the embedded recipe in the ingredient. 
   * 
   * @return Recipe recipe to be gotten
   */
  public Recipe getRecipe()
  {
    return this.recipe;
  }
  
  
  /**
   * CompareTo override.
   * 
   * @return compared object name
   */
  @Override
  public int compareTo(final Ingredient o)
  {
    return this.name.compareTo(o.getName());
  }
  
  /**
   * The method to represent the ingredient as a string representation.
   * 
   * @return returns the string formatted for ingredients 
   */
  public String toString()
  {
    if (this.details == null && this.unit == null)
    {
      return String.format("%s %s", this.amount, this.name);
    }
    if (this.unit == null)
    {
      return String.format("%s (%s) %s", this.amount, this.details, this.name);
    }
    if (this.details == null)
    {
      return String.format("%s %s %s", this.amount, this.unit, this.name);
    }
    return String.format("%s %s (%s) %s", this.amount, this.unit, this.details, this.name);
  }
}
