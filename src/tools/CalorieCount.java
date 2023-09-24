package tools;

import enums.Ingredients;

/**
 * calorie count to get the calories of ingredients.
 * 
 * @author Patrick Dodds
 * @version 4/4/23
 * 
 */
public class CalorieCount
{
  /**
   * returns the calorie count.
   * 
   * @param bg
   * @param grams
   * @return double
   */
  public static double calorieCount(final Ingredients bg, final Double grams)
  {
    if (grams == 0 || bg == null)
    {
      return 0;
    }
    double calories = 0;

    for (Ingredients i : Ingredients.values())
    {
      if (i.toString().toLowerCase().equals(bg.toString().toLowerCase()))

      {
        calories = i.getCaloriegram() / 100.0 * grams;
      }
    }
    return calories;
  }

}
