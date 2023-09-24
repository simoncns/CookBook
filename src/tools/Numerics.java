package tools;

/**
 * Numerics class, used for converting strings into a usable format for the KIlowbites application.
 * 
 * @author Stephen
 *
 */
public class Numerics
{
  /**
   * Converts a String to is appropriate Double representation. Returns null if fails to convert or
   * number is less than or equal to 0.0.
   * 
   * @param number
   * @return Double
   */
  public static Double doubleValueOf(final String number)
  {
    Double value;
    try
    {
      value = Double.parseDouble(number);
      if (value <= 0.0)
      {
        value = null;
      }
    }
    catch (NumberFormatException e)
    {
      value = null;
    }
    return value;
  }

  /**
   * Converts a String to is appropriate Integer representation. Returns null if fails to convert or
   * number is less than or equal to 0.
   * 
   * @param number
   * @return Integer
   */
  public static Integer integerValueOf(final String number)
  {
    Integer value;
    try
    {
      value = Integer.parseInt(number);
      if (value <= 0)
      {
        value = null;
      }
    }
    catch (NumberFormatException e)
    {
      value = null;
    }
    return value;
  }
}
