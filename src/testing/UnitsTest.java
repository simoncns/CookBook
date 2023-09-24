package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.Units;

class UnitsTest
{

  @Test
  void test()
  {
    Units u = Units.CUP;
    assertEquals("Cup", u.getName());
    Units us = Units.GALLON;
  }

}
