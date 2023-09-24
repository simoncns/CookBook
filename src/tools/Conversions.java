package tools;

import enums.Ingredients;

/**
 * conversion methods.
 * 
 * @author Patrick Dodds
 * @version 4/2/23
 */

public class Conversions
{

  private static final String F = "%.1f";

  /**
   * convert from weight to weight.
   * 
   * @param amount
   * @param ogUnit
   * @param newUnit
   * @return string
   */
  public static String convert(final double amount, final Mass ogUnit, final Mass newUnit)
  {
    double totalGramsToConvert = amount * ogUnit.getGrams();
    double newAmount = totalGramsToConvert / newUnit.getGrams();
    return amountToString(newAmount, newUnit.getName());
  }

  /**
   * convert from volume to volume.
   * 
   * @param amount
   * @param ogUnit
   * @param newUnit
   * @return String
   */
  public static String convert(final double amount, final Volume ogUnit, final Volume newUnit)
  {
    double totalMillilitersToConvert = amount * ogUnit.getMilliliters();
    double newAmount = totalMillilitersToConvert / newUnit.getMilliliters();
    return amountToString(newAmount, newUnit.getName());
  }

  /**
   * convert from weight to volume.
   * 
   * @param amount
   * @param ogUnit
   * @param newUnit
   * @param ingredient
   * @return String
   */
  public static String convert(final double amount, final Mass ogUnit, final Volume newUnit,
      final Ingredients ingredient)
  {
    double totalMillilitersToConvert = (amount * ogUnit.getGrams()) / ingredient.getDensity();
    double newAmount = totalMillilitersToConvert / newUnit.getMilliliters();
    return amountToString(newAmount, newUnit.getName());
  }

  /**
   * convert from volume to weight.
   * 
   * @param amount
   * @param ogUnit
   * @param newUnit
   * @param ingredient
   * @return String
   */
  public static String convert(final double amount, final Volume ogUnit, final Mass newUnit,
      final Ingredients ingredient)
  {
    double totalGramsToConvert = (amount * ogUnit.getMilliliters()) * ingredient.getDensity();

    double newAmount = totalGramsToConvert / newUnit.getGrams();

    return amountToString(newAmount, newUnit.getName());
  }

  /**
   * Converts amount to a string.
   * 
   * @param newAmount
   * @param unitName
   * @return String
   */
  public static String amountToString(final double newAmount, final String unitName)
  {
    return String.format("%.1f %s", newAmount, unitName);
  }

  /**
   * calorie from volume to weight.
   * 
   * @param amount
   * @param ogUnit
   * @param newUnit
   * @param ingredient
   * @return String
   */
  public static String cepll(final Double amount, final Volume ogUnit, final Mass newUnit,
      final Ingredients ingredient)
  {
    double totalGramsToConvert = (amount * ogUnit.getMilliliters()) * ingredient.getDensity();
    double newAmount = totalGramsToConvert / newUnit.getGrams();
    return String.format(F, newAmount);
  }

  /**
   * calorie from weight to weight.
   * 
   * @param amount
   * @param ogUnit
   * @param newUnit
   * @return String
   */
  public static final String cepll(final Double amount, final Mass ogUnit, final Mass newUnit)
  {
    double totalGramsToConvert = amount * ogUnit.getGrams();
    double newAmount = totalGramsToConvert / newUnit.getGrams();
    return String.format(F, newAmount);
  }
}
