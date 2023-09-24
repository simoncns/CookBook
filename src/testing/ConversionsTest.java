// CHECKSTYLE:OFF

package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.Ingredients;
import tools.Conversions;
import tools.Mass;
import tools.Volume;

class ConversionsTest
{

  @Test
  void testPoundToO()
  {

    Conversions con = new Conversions();
    
    
    assertEquals("0.0 pounds", Conversions.convert(0.0, Mass.GRAMS, Mass.POUNDS));
    assertEquals("1.2 pounds", Conversions.convert(3, Volume.CUP, Mass.POUNDS, Ingredients.ALCOHOL));
    assertEquals("7.3 cup", Conversions.convert(3, Mass.POUNDS, Volume.CUP, Ingredients.ALCOHOL));
    assertEquals("3.0 cup", Conversions.convert(3, Volume.CUP, Volume.CUP));
    assertEquals("560.7", Conversions.cepll(3.0, Volume.CUP, Mass.GRAMS, Ingredients.ALCOHOL));
    assertEquals("3.0", Conversions.cepll(3.0, Mass.GRAMS, Mass.GRAMS));
    Conversions.convert(2, Mass.POUNDS, Mass.OUNCES);
    Conversions.convert(2, Mass.OUNCES, Mass.OUNCES);
    Conversions.convert(2, Mass.OUNCES, Mass.GRAMS);
    Conversions.convert(2, Mass.POUNDS, Mass.GRAMS);
    Conversions.convert(3, Volume.CUP, Volume.FLUIDOUNCE);
    Conversions.convert(3, Volume.FLUIDOUNCE, Volume.CUP);
    Conversions.convert(3, Volume.GALLON, Volume.CUP);
    Conversions.convert(3, Volume.PINCH, Volume.PINCH);
    Conversions.convert(3, Volume.PINT, Volume.QUART);
    
  }

}

// CHECKSTYLE:ON
