package tools;

/**
 * Enum for representing Volume.
 * 
 * @author Stephen
 *
 */
public enum Volume
{

  // enum fields in mL
  TABLESPOON(14.7867648, "tablespoon"), CUP(236.58824, "cup"), FLUIDOUNCE(29.57353,
      "fluidounce"), TEASPOON(4.9289216, "teaspoon"), PINCH(0.3080576, "pinch"), PINT(473.17628,
          "pint"), QUART(946.35296,
              "quart"), GALLON(3785.41184, "gallon"), MILLILITER(1.0, "milliliter");

  private double milliliters;
  private String name;

  /**
   * Constructs a Volume.
   * 
   * @param milliliters
   * @param name
   */
  private Volume(final double milliliters, final String name)
  {
    this.milliliters = milliliters;
    this.name = name;
  }

  /**
   * Gets the milliliters.
   * 
   * @return double
   */
  public double getMilliliters()
  {
    return milliliters;
  }

  /**
   * Gets the name.
   * 
   * @return String.
   */
  public String getName()
  {
    return name;
  }

  /**
   * Creates a Volume from a String.
   * 
   * @param string
   * @return Volume
   */
  public static Volume fromString(final String string)
  {
    for (Volume unit : values())
    {
      if (unit.getName().toLowerCase().equals(string.toLowerCase()))
        return unit;
    }
    return null;

  }

}
