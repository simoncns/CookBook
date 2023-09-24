// CHECKSTYLE:OFF

package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.Ingredient;
import enums.Ingredients;
import tools.CalorieCount;

class CalorieCountTest
{

  @Test
  void testCalorieCount()
  {
	 // for full coverage :)
	 CalorieCount exampleCal = new CalorieCount();
	 
	 // testing calorie count for base ingredients
	 Ingredients example = null;
	 assertEquals(8.25, CalorieCount.calorieCount(Ingredients.ALCOHOL, 3.0));
	 assertEquals(0, CalorieCount.calorieCount(Ingredients.ALCOHOL, 0.0));
	 assertEquals(0, CalorieCount.calorieCount(example, 2.0)); 
	 
	  
	 
	 // testing calorie count for object ingredients
//	 Ingredient example2 = new Ingredient("12", enums.Units.CUP.toString(), "sauce");
//	 Ingredient example3 = new Ingredient("12", enums.Units.CUP.toString(), "Alcohol");
//	 assertEquals(exampleCal.calorieCount(example2, 30.0), 0.0);
//	 assertEquals(exampleCal.calorieCount(example3, 30.0), 0.0);

	 
	 
	 
  }
}
