// CHECKSTYLE:OFF

package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import data.Ingredient;
import data.Recipe;
import data.Step;
import data.Utensil;

class RecipeTest
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
//  private List<Utensil> constructUtensils2()
//  {
//    List<Utensil> utensils = new ArrayList<>();
//   
//    utensils.add(new Utensil("pot", "large"));
//    utensils.add(new Utensil("saucepan", "medium"));
//    utensils.add(new Utensil("casserole", "1-quart"));
//    utensils.add(new Utensil("strainer"));
//
//    return utensils;
//  }

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
//  private List<Ingredient> constructIngredients2()
//  {
//    List<Ingredient> ingredients = new ArrayList<>();
//    
//    ingredients.add(new Ingredient("1", "cup", "macaroni", "dried elbow"));
//    ingredients.add(new Ingredient("1", "tablespoon", "butter"));
//    ingredients.add(new Ingredient("0.25", "cup", "onion", "chopped"));
//    ingredients.add(new Ingredient("1", "tablespoon", "flour", "allpurpose"));
//    ingredients.add(new Ingredient("1", "pinch", "pepper", "black"));
//    ingredients.add(new Ingredient("1.25", "cup", "milk"));
//    ingredients.add(new Ingredient("1.5", "cup", "American cheese", "shredded"));
//    ingredients.add(new Ingredient("1", null, "tomato", "sliced medium"));
//    
//
//    return ingredients;
//  }

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

  @Test
  void getNameTest()
  {
    Recipe recipe = new Recipe("Test", 10, constructIngredients1(), constructUtensils1(),
        constructSteps1());
    assertEquals("Test", recipe.getName());
  }

  @Test
  void getAmountTest()
  {
    Recipe recipe = new Recipe("Test", 10, constructIngredients1(), constructUtensils1(),
        constructSteps1());
    assertEquals(10, recipe.getAmount());
  }

  @Test
  void getIngredientsTest()
  {
    Recipe recipe = new Recipe("Test", 10, constructIngredients1(), constructUtensils1(),
        constructSteps1());

    List<Ingredient> ingredients = recipe.getIngredient();
    assertEquals("0.33 cup butter", ingredients.get(0).toString());
    assertEquals("0.33 cup brown sugar", ingredients.get(1).toString());
    assertEquals("3 individual (sliced ripe) bananas", ingredients.get(2).toString());
    assertEquals("2 tablespoon creme de cacao", ingredients.get(3).toString());
    assertEquals("0.25 cup rum", ingredients.get(4).toString());
    assertEquals("2 cup (vanilla) ice cream", ingredients.get(5).toString());
    assertEquals("0.25 teaspoon (ground) cinnamon", ingredients.get(6).toString());
  }

  @Test
  void getUtensilsTest()
  {
    Recipe recipe = new Recipe("Test", 10, constructIngredients1(), constructUtensils1(),
        constructSteps1());

    List<Utensil> utensils = recipe.getUtensils();

    assertEquals("skillet (large)", utensils.get(0).toString());
    assertEquals("saucepan", utensils.get(1).toString());
    assertEquals("plate", utensils.get(2).toString());

    assertEquals("skillet (large)", utensils.get(0).toString());
    assertEquals("saucepan", utensils.get(1).toString());
    assertEquals("plate", utensils.get(2).toString());
  }
 
  @Test
  void getStepsTest()
  {
    Recipe recipe = new Recipe("Test", 10, constructIngredients1(), constructUtensils1(),
        constructSteps1());

    List<Step> steps = recipe.getSteps();

    for (Step step : steps)
    {
      System.out.println(step.toString());
    }

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
  }
}

//CHECKSTYLE:ON
