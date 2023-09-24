package tools;

/**
 * Measurements enum.
 * 
 * @author Patrick dodds
 * @version 4/5/23
 */
public enum Measurements
{

  TEASPOON("teaspoon"), PINCH("pinche"), TABLESPOON("tablespoon"), FLUIDOUNCE(
      "fluidounce"), CUP(
          "cup"), PINT("pint"), QUART("quart"), GALLON("gallon"), MILLILITER("milliliter"),
  DRAMS("drams"), OUNCES("ounces"), POUNDS("pounds"), GRAMS("grams");

  private String str; 

  /**
   * the construcotr.
   * 
   * @param str
   *          name
   */
  private Measurements(final String str)
  {
    this.str = str;

  }

  /**
   * the get string.
   *
   * @return string name
   */
  public String getString()
  {
    return this.str;
  }

  /**
   * from string method. 
   * 
   * @param string
   * @return the measurement type
   */
  public Measurements fromString(final String string)
  {
    for (Measurements i : values())
    {
      if (i.toString().toLowerCase().equals(string.toLowerCase()))
      {
        return i;
      }
    }
    return null;
  }

}
