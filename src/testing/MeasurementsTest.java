package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tools.Measurements;

class MeasurementsTest {

	@Test
	void test() {
		Measurements example1;
		example1 = Measurements.CUP;
		
		//testing get string
		assertEquals(example1.getString(), "cup");
		
		//testing from code
		assertEquals(example1.fromString("cup"), Measurements.CUP);
		assertEquals(Measurements.CUP.fromString("banana"), null);
		
		
	}

}
