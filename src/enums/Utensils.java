package enums;
/**
 * Enum for representing Utensils.
 * 
 * @author Stephen Watson
 *
 */
public enum Utensils 
{
	COOK("Cook"),
	GRILL("Grill"),
	BROIL("Broil"),
	BARBECUE("Barbecue"),
	GRATIN("Gratin"),
	STIRFRY("Stir-fry"),
	BAKE("Bake"),
	ROAST("Roast"),
	STEW("Stew"),
	CARAMELIZE("Caramelize"),
	STEAM("Steam"),
	SAUTE("Saute"),
	TOAST("Toast"),
	MICROWAVE("Microwave"),
	SIMMER("Simmer"),
	SCRAMBLE("Scramble"),
	ADD("Add"),
	SLICE("Slice"),
	DRAIN("Drain"),
	DICE("Dice"),
	POUR("Pour"),
	PUT("Put"),
	MIX("Mix"),
	CHOP("Chop"),
	COMBINE("Combine");
	
	private String actionName;
	
	/**
	 * Constructor for Utensil.
	 * 
	 * @param names
	 */
	private Utensils(final String names) 
	{
		this.actionName = names;
	}
	
	/**
	 * Gets the name of the Utensil.
	 * 
	 * @return String
	 */
	public String getName() 
	{
		return this.actionName;
	}
}
