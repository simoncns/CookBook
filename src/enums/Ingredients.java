package enums;

/**
 * Emum for supported ingredients.
 * 
 * @author Aidan
 *
 */
public enum Ingredients
{
  ALCOHOL ("Alcohol", 275, .79),
  ALMOND ("Almond", 601, .46),
  AMERICANCHEESE("American Cheese", 440, .34),
  APPLE("Apple", 44, .56),
  APPLEJUICE("Apple Juice", 48, 1.04),
  BANANA("Banana", 65, .56),
  BEAN("Bean", 130, .77),
  BEEF("Beef", 280, 1.05),
  BLACKBERRY("Blackberry", 25, .53),
  BLACKPEPPER("Black pepper", 255, 1.01),
  BREAD("Bread", 240, .42),
  BROCOLLI("Brocolli", 32, .37),
  BROWNSUGAR("Brown Sugar", 380, 1.5),
  BUTTER("Butter", 750, .91),
  CABBAGE("Cabbage", 28, .36),
  CARROT("Carrot", 41, .64),
  CASHEW("Cashew", 553, .5),
  CAULIFLOWER("Cauliflower", 25, .27),
  CELERY("Celery", 14, .61),
  CHEDDARCHEESE("Chedder cheese", 440, .34),
  CHERRY("Cherry", 50, 1.02),
  CHICKEN("Chicken", 200, 1.04),
  CHOCOLATE("Chocolate", 500, 1.33),
  CINNAMON("Cinnamon", 261, .45), 
  COD("Cod", 100, .58),
  CORN("Corn", 130, .72),
  CORNFLAKE("Cornflake", 370, .12),
  COTTAGECHEESE("Cottage Cheese", 98, .96),
  CRAB("Crab", 110, .61),
  CREMEDECACAO("Creme de cacao", 275, .79),
  CUCUMBER("Cucumber", 10, .67),
  EGG("Egg", 150, .6),
  FLOUR("Flour", 364, .45),
  GARLIC("Garlic", 111, .32),
  GRAPEFRUIT("Grapefruit", 32, .33),
  GRAPE("Grape", 62, .37),
  GRAPEJUICE("Grape Juice", 60, 1.04),
  GREENBEAN("Green bean", 31, .53),
  HADDOCK("Haddock", 110, .58),
  HAM("Ham", 240, 1.4),
  HONEY("Honey", 280, 1.5),
  ICECREAM("Ice cream", 180, .55),
  KIDNEYBEAN("Kidney bean", 333, .79),
  LAMB("Lamb", 200, 1.3),
  LEMON("Lemon", 29, .77),
  LENTIL("Lentil", 116, .85),
  LETTUCE("Lettuce", 15, .06),
  MACARONI("Macaroni", 371, 1.31),
  MILK("Milk", 70, 1.04),
  MUSHROOM("Mushroom", 15, 1.17),
  OIL("Oil", 900, .88),
  OLIVE("Olive", 80, .65),
  ONION("Onion", 22, .74),
  ORANGE("Orange", 30, .77),
  PAPRIKA("Paprika", 282, .46),
  PASTA("Pasta", 371, 1.31),
  PEACH("Peach", 30, .61),
  PEANUT("Peanut", 567, .53),
  PEAR("Pear", 16, .61),
  PEAS("Peas", 148, .73),
  PEPPER("Pepper", 20, .51),
  PINEAPPLE("Pineapple", 40, .54),
  PLUM("Plum", 39, .58),
  PORK("Pork", 290, .7),
  RUM("Rum", 275, .79),
  SALMON("Salmon", 180, .58),
  SALT("Salt", 0, 1.38),
  SALTINECRACKERS("Saltine Crackers", 421, .43),
  SPAGHETTI("Spaghetti", 371, 1.31),
  SPINACH("Spinach", 8, .08),
  STRAWBERRIES("Strawberries", 30, .58),
  SUGAR("Sugar", 400, .95),
  SWEETPOTATO("Sweet Potato", 86, .65),
  SYRUP("Syrup", 260, 1.38),
  THYME("Thyme", 101, .46),
  TOMATO("Tomato", 20, .67),
  WINE("Wine", 83, .99);

  private String name;
  private int caloriepergram;
  private double gramsmilli;

  /**
   * Constructs a base ingredient.
   * 
   * @param name
   *          name of ingredient
   * @param caloriepergram
   *          shows calorie per 100 gram of ingredient
   * @param gramsmilli
   */
  private Ingredients(final String name, final int caloriepergram, final double gramsmilli)
  {
    this.name = name;
    this.caloriepergram = caloriepergram;
    this.gramsmilli = gramsmilli;
  }

  /**
   * Basic getter for the name of a ingredient.
   * 
   * @return the name of the ingredient
   */

  public String getName()
  {
    return this.name;
  }

  /**
   * Basic getter for the calorie for 100 gram amount.
   * 
   * @return the calorie count for a ingredient
   */

  public int getCaloriegram()
  {
    return this.caloriepergram;
  }

  /**
   * Gets the density.
   * 
   * @return double
   */
  public double getDensity()
  {
    return this.gramsmilli;
  }

  /**
   * Gets the Ingredient from the ingredient name.
   * 
   * @param code
   * @return Ingredient
   */
  public static Ingredients fromCode(final String code)
  {
    for (Ingredients i : values())
    {
      if (code.toString().toLowerCase().equals(i.toString().toLowerCase()))
        return i;
    }
    return null;
  }

}
