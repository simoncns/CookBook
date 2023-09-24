// CHECKSTYLE:OFF

package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import data.Ingredient;
import data.Step;
import data.Utensil;

class StepTest
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

  // Based on BananasFoster recipe. 
  private List<Ingredient> constructIngredients1()
  {
    List<Ingredient> ingredients = new ArrayList<>();
    
    ingredients.add(new Ingredient("0.33", "cup", "butter"));
    ingredients.add(new Ingredient("0.33", "cup", "brown sugar"));
    ingredients.add(new Ingredient("3", "individual", "bananas", "sliced ripe"));
    ingredients.add(new Ingredient("2", "tablespoon", "creme de cacao"));
    ingredients.add(new Ingredient("0.25", "cup", "rum"));
    ingredients.add(new Ingredient("2", "cup", "ice cream", "vanilla"));
    ingredients.add(new Ingredient("0.25", "teaspoon", "cinnamon", "ground"));

    return ingredients;
  }
  
  // Based on BananasFoster recipe. 
  private List<Ingredient> constructIngredients2()
  {
    List<Ingredient> ingredients = new ArrayList<>();
    
    ingredients.add(new Ingredient("1", "cup", "macaroni", "dried elbow"));
    ingredients.add(new Ingredient("1", "tablespoon", "butter"));
    ingredients.add(new Ingredient("0.25", "cup", "onion", "chopped"));
    ingredients.add(new Ingredient("1", "tablespoon", "flour", "allpurpose"));
    ingredients.add(new Ingredient("1", "pinch", "pepper", "black"));
    ingredients.add(new Ingredient("1.25", "cup", "milk"));
    ingredients.add(new Ingredient("1.5", "cup", "American cheese", "shredded"));
    ingredients.add(new Ingredient("1", null, "tomato", "sliced medium"));
    

    return ingredients;
  }
  
  // Based on BananasFoster recipe. 
  private List<Ingredient> constructIngredients3()
  {
    List<Ingredient> ingredients = new ArrayList<>();
    
    ingredients.add(new Ingredient("1", "individual", "egg", "beaten"));
    ingredients.add(new Ingredient("3", "tablespoon", "milk"));
    ingredients.add(new Ingredient("1", "cup", "saltinecrackers", "finlycrushed"));
    ingredients.add(new Ingredient("1", "teaspoon", "thyme", "driedcrushed"));
    ingredients.add(new Ingredient("0.5", "teaspoon", "paprika"));
    ingredients.add(new Ingredient("0.1", "teaspoon", "pepper", "black"));
    ingredients.add(new Ingredient("2", "pounds", "chicken", "pieces; skinned, rinsed and dried"));

    return ingredients;
  }

  // Steps for BananaFoster
  private List<Step> constructSteps1()
  {
    List<Ingredient> ingredients = constructIngredients1();
    List<Utensil> utensil = constructUtensils1();
    List<Step> steps = new ArrayList<>();

    steps.add(new Step("put", ingredients.get(0).getName(), utensil.get(0).getName()));
    steps.add(new Step("melt", utensil.get(0).getName().toUpperCase(), utensil.get(0).getName()));
    steps.add(new Step("put", ingredients.get(1).getName(), utensil.get(0).getName()));
    steps.add(new Step("put", ingredients.get(2).getName(), utensil.get(0).getName()));
    steps.add(new Step("simmer", utensil.get(0).getName().toUpperCase(), utensil.get(0).getName(), "for 2 minutes"));
    steps.add(new Step("put", ingredients.get(6).getName(), utensil.get(0).getName()));
    steps.add(new Step("put", ingredients.get(4).getName(), utensil.get(0).getName()));
    steps.add(new Step("put", utensil.get(0).getName().toUpperCase(), utensil.get(0).getName()));
    steps.add(new Step("heat", ingredients.get(4).getName(), utensil.get(1).getName(), "until it almost simmers"));
    steps.add(new Step("ignite", ingredients.get(4).getName(), utensil.get(1).getName()));
    steps.add(new Step("put", utensil.get(1).getName().toUpperCase(), utensil.get(2).getName()));
    steps.add(new Step("put", ingredients.get(5).getName(), utensil.get(2).getName()));

    return steps;
  }

  private List<Step> constructSteps2()
  {
    List<Ingredient> ingredients = constructIngredients2();
    List<Utensil> utensil = constructUtensils2();
    List<Step> steps = new ArrayList<>();

    steps.add(new Step("put", ingredients.get(0).getName(), utensil.get(0).getName(), "for 10 minutes"));
    steps.add(new Step("drain", utensil.get(0).getName().toUpperCase(), utensil.get(3).getName()));
    steps.add(new Step("put", ingredients.get(1).getName(), utensil.get(1).getName()));
    steps.add(new Step("put", ingredients.get(2).getName(), utensil.get(1).getName()));
    steps.add(new Step("saute", utensil.get(1).getName().toUpperCase(), utensil.get(1).getName(), "until tender but not brown"));
    steps.add(new Step("put", ingredients.get(3).getName(), utensil.get(1).getName()));
    steps.add(new Step("put", ingredients.get(4).getName(), utensil.get(1).getName()));
    steps.add(new Step("put", ingredients.get(5).getName(), utensil.get(1).getName()));
    steps.add(new Step("simmer", utensil.get(1).getName().toUpperCase(), utensil.get(1).getName(), "until slightly thickend"));
    steps.add(new Step("put", ingredients.get(6).getName(), utensil.get(1).getName()));
    steps.add(new Step("cook", utensil.get(1).getName().toUpperCase(), utensil.get(1).getName()));
    steps.add(new Step("put", utensil.get(3).getName().toUpperCase(), utensil.get(2).getName()));
    steps.add(new Step("put", utensil.get(1).getName().toUpperCase(), utensil.get(2).getName()));
    steps.add(new Step("put", utensil.get(2).getName().toUpperCase(), utensil.get(2).getName(), "at 350 degrees for 25 minutes"));
    steps.add(new Step("put", ingredients.get(7).getName(), utensil.get(2).getName()));

    return steps;
  }

  private List<Step> constructSteps3()
  {
    List<Ingredient> ingredients = constructIngredients3();
    List<Utensil> utensil = constructUtensils3();
    List<Step> steps = new ArrayList<>();

    steps.add(new Step("put", ingredients.get(0).getName(), utensil.get(1).getName()));
    steps.add(new Step("put", ingredients.get(3).getName(), utensil.get(1).getName()));
    steps.add(new Step("put", ingredients.get(2).getName(), utensil.get(0).getName()));
    steps.add(new Step("put", ingredients.get(3).getName(), utensil.get(0).getName()));
    steps.add(new Step("put", ingredients.get(4).getName(), utensil.get(0).getName()));
    steps.add(new Step("put", ingredients.get(5).getName(), utensil.get(0).getName()));
    steps.add(new Step("dip", ingredients.get(6).getName(), utensil.get(1).getName()));
    steps.add(new Step("dip", ingredients.get(6).getName(), utensil.get(0).getName()));
    steps.add(new Step("put", ingredients.get(6).getName(), utensil.get(2).getName()));
    steps.add(new Step("bake", ingredients.get(6).getName(), utensil.get(2).getName(), "375 degrees for 55 minutes"));

    return steps;
  }

  @Test
  void stepCompletedTest()
  {
    List<Step> steps = constructSteps1();

    steps.get(0).setStepCompleted(true);
    steps.get(1).setStepCompleted(true);
    steps.get(2).setStepCompleted(true);
    steps.get(3).setStepCompleted(true);

    for (int i = 0; i < steps.size(); i++)
    {
      if (i < 4)
      {
        assertEquals(true, steps.get(i).isStepCompleted());
      }
      else
      {
        assertEquals(false, steps.get(i).isStepCompleted());
      }
    }
  }

  @Test
  void toStringTest()
  {
    List<Step> steps = null;

    steps = constructSteps1();
    assertEquals("put butter skillet", steps.get(0).toString());
    assertEquals("melt SKILLET skillet", steps.get(1).toString());
    assertEquals("put brown sugar skillet", steps.get(2).toString());
    assertEquals("put bananas skillet", steps.get(3).toString());
    assertEquals("simmer SKILLET skillet for 2 minutes", steps.get(4).toString());
    assertEquals("put cinnamon skillet", steps.get(5).toString());
    assertEquals("put rum skillet", steps.get(6).toString());
    assertEquals("put SKILLET skillet", steps.get(7).toString());
    assertEquals("heat rum saucepan until it almost simmers", steps.get(8).toString());
    assertEquals("ignite rum saucepan", steps.get(9).toString());
    assertEquals("put SAUCEPAN plate", steps.get(10).toString());
    assertEquals("put ice cream plate", steps.get(11).toString());

    steps = constructSteps2();
    assertEquals("put macaroni pot for 10 minutes", steps.get(0).toString());
    assertEquals("drain POT strainer", steps.get(1).toString());
    assertEquals("put butter saucepan", steps.get(2).toString());
    assertEquals("put onion saucepan", steps.get(3).toString());
    assertEquals("saute SAUCEPAN saucepan until tender but not brown", steps.get(4).toString());
    assertEquals("put flour saucepan", steps.get(5).toString());
    assertEquals("put pepper saucepan", steps.get(6).toString());
    assertEquals("put milk saucepan", steps.get(7).toString());
    assertEquals("simmer SAUCEPAN saucepan until slightly thickend", steps.get(8).toString());
    assertEquals("put American cheese saucepan", steps.get(9).toString());
    assertEquals("cook SAUCEPAN saucepan", steps.get(10).toString());
    assertEquals("put STRAINER casserole", steps.get(11).toString());
    assertEquals("put SAUCEPAN casserole", steps.get(12).toString());
    assertEquals("put CASSEROLE casserole at 350 degrees for 25 minutes", steps.get(13).toString());
    assertEquals("put tomato casserole", steps.get(14).toString());

    steps = constructSteps3();
    assertEquals("put egg bowl", steps.get(0).toString());
    assertEquals("put thyme bowl", steps.get(1).toString());
    assertEquals("put saltinecrackers dish", steps.get(2).toString());
    assertEquals("put thyme dish", steps.get(3).toString());
    assertEquals("put paprika dish", steps.get(4).toString());
    assertEquals("put pepper dish", steps.get(5).toString());
    assertEquals("dip chicken bowl", steps.get(6).toString());
    assertEquals("dip chicken dish", steps.get(7).toString());
    assertEquals("put chicken baking pan", steps.get(8).toString());
    assertEquals("bake chicken baking pan 375 degrees for 55 minutes", steps.get(9).toString());
  }
}

//CHECKSTYLE:ON
