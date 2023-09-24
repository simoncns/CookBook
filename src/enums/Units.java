package enums;

/**
 * Class for representing Units.
 * 
 * @author Patrick
 *
 */
public enum Units 
{
	POUND("Pound"),
	OUNCE("Ounce"),
	GRAMS("Grams"),
	DRAMS("Drams"),
	TEASPOON("Teaspoon"),
	TABLESPOON("Tablespoon"),
	FLUIDOUNCE("Fluid Ounce"),
	CUP("Cup"),
	PINT("Pint"),
	QUART("Quart"),
	GALLON("Gallon"),
	PINCH("Pinch");
	
	private String name;
	
	/**
	 * Constructs a Unit.
	 * 
	 * @param name
	 */
	private Units(final String name) 
	{
		this.name = name;
	}
	
	/**
	 * Gets the name of the Unit.
	 * 
	 * @return String
	 */
	public String getName() 
	{
		return this.name;
	}
}
