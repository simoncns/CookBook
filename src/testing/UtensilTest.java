// CHECKSTYLE:OFF

package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import data.Utensil;

class UtensilTest
{
  
  // Based on BananasFoster recipe.
  private List<Utensil> constructUtensils1()
  {
    List<Utensil> utensils = new ArrayList<>();
    
    utensils.add(new Utensil("skillet", "large"));
    utensils.add(new Utensil("saucepan"));
    utensils.add(new Utensil("plate"));

    return utensils;
  }
  
  // Based on MacaroniAndCheese
  private List<Utensil> constructUtensils2()
  {
    List<Utensil> utensils = new ArrayList<>();
   
    utensils.add(new Utensil("pot", "large"));
    utensils.add(new Utensil("saucepan", "medium"));
    utensils.add(new Utensil("casserole", "1-quart"));
    utensils.add(new Utensil("strainer"));

    return utensils;
  }
  
  // Based on OvenFriedChicken
  private List<Utensil> constructUtensils3()
  {
    List<Utensil> utensils = new ArrayList<>();
    utensils.add(new Utensil("dish", "shallow"));
    utensils.add(new Utensil("bowl", "small"));
    utensils.add(new Utensil("baking pan", "15x10x1 greased"));

    return utensils;
  }
  
  @Test
  void getNameTest()
  {
    List<Utensil> utensils = null;
    
    utensils = constructUtensils1();
    assertEquals("skillet", utensils.get(0).getName());
    assertEquals("saucepan", utensils.get(1).getName());
    assertEquals("plate", utensils.get(2).getName());
    
    utensils = constructUtensils2();
    assertEquals("pot", utensils.get(0).getName());
    assertEquals("saucepan", utensils.get(1).getName());
    assertEquals("casserole", utensils.get(2).getName());
    assertEquals("strainer", utensils.get(3).getName());
    
    utensils = constructUtensils3();
    assertEquals("dish", utensils.get(0).getName());
    assertEquals("bowl", utensils.get(1).getName());
    assertEquals("baking pan", utensils.get(2).getName());
    utensils.get(0).compareTo(utensils.get(1));
   
  }
  
  @Test
  void toStringTest()
  {
    List<Utensil> utensils = null;
    
    utensils = constructUtensils1();
    assertEquals("skillet (large)", utensils.get(0).toString());
    assertEquals("saucepan", utensils.get(1).toString());
    assertEquals("plate", utensils.get(2).toString());
    
    utensils = constructUtensils2();
    assertEquals("pot (large)", utensils.get(0).toString());
    assertEquals("saucepan (medium)", utensils.get(1).toString());
    assertEquals("casserole (1-quart)", utensils.get(2).toString());
    assertEquals("strainer", utensils.get(3).toString());
    
    utensils = constructUtensils3();
    assertEquals("dish (shallow)", utensils.get(0).toString());
    assertEquals("bowl (small)", utensils.get(1).toString());
    assertEquals("baking pan (15x10x1 greased)", utensils.get(2).toString());
  }
}

//CHECKSTYLE:ON