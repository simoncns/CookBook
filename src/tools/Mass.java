package tools;

/**
 * Enum for representing Mass.
 * 
 * @author Stephen Watson
 *
 */
public enum Mass
{
  // enum fields in grams
  DRAMS(1.771845, "drams"), OUNCES(28.34952, "ounces"), POUNDS(453.59232, "pounds"), GRAMS(1.0,
      "grams");

  private double grams; 
  private String name;

  private Mass(final double grams, final String name)
  {
    this.grams = grams;
    this.name = name;
  }

  /**
   * Gets the grams.
   * 
   * @return double
   */
  public double getGrams()
  {
    return grams;
  }

  /**
   * Gets the name.
   * 
   * @return String
   */
  public String getName()
  {
    return name;
  }

  /**
   * Creates a Mass from a string. 
   * 
   * @param string
   * @return Mass
   */
  public static Mass fromString(final String string)
  {
    for (Mass unit : values())
    {
      if (unit.getName().toLowerCase().equals(string.toLowerCase()))
        return unit;
    }
    return null;
  }
}
