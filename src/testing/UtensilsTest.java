package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.Utensils;

class UtensilsTest
{

  @Test
  void test()
  {
    Utensils a = Utensils.COOK;
    Utensils b = Utensils.GRILL;
    Utensils c = Utensils.BROIL;
    Utensils d = Utensils.BARBECUE;
    Utensils e = Utensils.GRATIN;
    Utensils f = Utensils.STIRFRY;
    Utensils g = Utensils.BAKE;
    Utensils h = Utensils.ROAST;
    Utensils i = Utensils.STEW;
    Utensils j = Utensils.CARAMELIZE;
    Utensils k = Utensils.STEAM;
    Utensils l = Utensils.SAUTE;
    Utensils m = Utensils.TOAST;
    Utensils n = Utensils.MICROWAVE;
    Utensils o = Utensils.SIMMER;
    Utensils p = Utensils.SCRAMBLE;
    Utensils q = Utensils.ADD;
    Utensils r = Utensils.SLICE;
    Utensils s = Utensils.DRAIN;
    Utensils t = Utensils.DICE;
    Utensils u = Utensils.POUR;
    Utensils v = Utensils.PUT;
    Utensils w = Utensils.MIX;
    Utensils x = Utensils.CHOP;
    Utensils y = Utensils.COMBINE;
    assertEquals("Cook", Utensils.COOK.getName());
    assertEquals("Grill", Utensils.GRILL.getName());
    assertEquals("Broil", Utensils.BROIL.getName());
    assertEquals("Barbecue", Utensils.BARBECUE.getName());
    assertEquals("Gratin", Utensils.GRATIN.getName());
    assertEquals("Stir-fry", Utensils.STIRFRY.getName());
    assertEquals("Bake", Utensils.BAKE.getName());
    assertEquals("Roast", Utensils.ROAST.getName());
    assertEquals("Stew", Utensils.STEW.getName());
    assertEquals("Caramelize", Utensils.CARAMELIZE.getName());
    assertEquals("Steam", Utensils.STEAM.getName());
    assertEquals("Saute", Utensils.SAUTE.getName());
    assertEquals("Toast", Utensils.TOAST.getName());
    assertEquals("Microwave", Utensils.MICROWAVE.getName());
    assertEquals("Simmer", Utensils.SIMMER.getName());
    assertEquals("Scramble", Utensils.SCRAMBLE.getName());
    assertEquals("Add", Utensils.ADD.getName());
    assertEquals("Slice", Utensils.SLICE.getName());
    assertEquals("Drain", Utensils.DRAIN.getName());
    assertEquals("Dice", Utensils.DICE.getName());
    assertEquals("Pour", Utensils.POUR.getName());
    assertEquals("Put", Utensils.PUT.getName());
    assertEquals("Mix", Utensils.MIX.getName());
    assertEquals("Chop", Utensils.CHOP.getName());
    assertEquals("Combine", Utensils.COMBINE.getName());
  }

}
