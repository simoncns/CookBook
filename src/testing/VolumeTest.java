package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tools.Volume;

class VolumeTest {

	@Test
	void test() {
		Volume example;
		example = Volume.CUP;
		
		//testing get milliliters method
		assertEquals(example.getMilliliters(), 236.58824);
		
		// testing get name method
		assertEquals(example.getName(), "cup");
		
		// testing from string method
		assertEquals(example.fromString("yo"), null);
		assertEquals(example.fromString("Cup"), Volume.CUP);
	}

}
