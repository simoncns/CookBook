package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tools.Mass;

class MassTest {

	@Test
	void test() {
		Mass example1;
		example1 = Mass.GRAMS;
		
		//testing get grams method
		assertEquals(example1.getGrams(), 1.0);
		
		// testing getname function
		assertEquals(example1.getName(), "grams");
		
		// testing from string
		assertEquals(example1.fromString("yo"), null);
		assertEquals(example1.fromString("Grams"), Mass.GRAMS);
	}

}
