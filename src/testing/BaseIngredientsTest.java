// CHECKSTYLE:OFF

package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.Ingredients;

class BaseIngredientsTest {

	@Test
	void test() {
		Ingredients example1;
		example1 = Ingredients.ALCOHOL;
		
		// testing basic getters for a ingredient enum
		assertEquals("Alcohol", example1.getName());
		assertEquals(275, example1.getCaloriegram());
		assertEquals(.79, example1.getDensity());
		assertEquals(example1, Ingredients.fromCode("ALCoHOL"));
		assertEquals(null, Ingredients.fromCode(""));
		
		
	} 

}
 
//CHECKSTYLE:ON