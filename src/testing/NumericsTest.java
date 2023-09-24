package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tools.Numerics;

class NumericsTest {

	@Test
	void test() {
		Numerics example = new Numerics();
		
		// testing double value of method
		assertEquals(Numerics.doubleValueOf("33"), 33.0);
		assertEquals(Numerics.doubleValueOf("-2"), null);
		assertEquals(Numerics.doubleValueOf("yo"), null);
		
		//testing integer value of
		assertEquals(Numerics.integerValueOf("3"), 3);
		assertEquals(Numerics.integerValueOf("yo"), null);
		assertEquals(Numerics.integerValueOf("-1"), null);
	}

}
