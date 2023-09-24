package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import data.Ingredient;
import data.Recipe;

class IngredientTest
{
 
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
  
  @Test
  void getAmountTest()
  {
    List<Ingredient> ingredients = null;
    
    ingredients = constructIngredients1();
    assertEquals(0.33, ingredients.get(0).getAmount());
    assertEquals(0.33, ingredients.get(1).getAmount());
    assertEquals(3, ingredients.get(2).getAmount());
    assertEquals(2, ingredients.get(3).getAmount());
    assertEquals(0.25, ingredients.get(4).getAmount());
    assertEquals(2, ingredients.get(5).getAmount());
    assertEquals(0.25, ingredients.get(6).getAmount());
    
    ingredients = constructIngredients2();
    assertEquals(1, ingredients.get(0).getAmount());
    assertEquals(1, ingredients.get(1).getAmount());
    assertEquals(0.25, ingredients.get(2).getAmount());
    assertEquals(1, ingredients.get(3).getAmount());
    assertEquals(1, ingredients.get(4).getAmount());
    assertEquals(1.25, ingredients.get(5).getAmount());
    assertEquals(1.5, ingredients.get(6).getAmount());
    assertEquals(1, ingredients.get(7).getAmount());
    
    ingredients = constructIngredients3();
    assertEquals(1, ingredients.get(0).getAmount());
    assertEquals(3, ingredients.get(1).getAmount());
    assertEquals(1, ingredients.get(2).getAmount());
    assertEquals(1, ingredients.get(3).getAmount());
    assertEquals(0.5, ingredients.get(4).getAmount());
    assertEquals(0.1, ingredients.get(5).getAmount());
    assertEquals(2, ingredients.get(6).getAmount());
  }
  
  @Test
  void addAmountTest()
  {
    List<Ingredient> ingredients = null;
    
    ingredients = constructIngredients1();
    
    for(Ingredient item: ingredients)
    {
      item.addAmount(1);
    }
    
    assertEquals(1.33, ingredients.get(0).getAmount());
    assertEquals(1.33, ingredients.get(1).getAmount());
    assertEquals(4, ingredients.get(2).getAmount());
    assertEquals(3, ingredients.get(3).getAmount());
    assertEquals(1.25, ingredients.get(4).getAmount());
    assertEquals(3, ingredients.get(5).getAmount());
    assertEquals(1.25, ingredients.get(6).getAmount());
    
    ingredients = constructIngredients2();
    
    for(Ingredient item: ingredients)
    {
      item.addAmount(0.5);
    }
    
    assertEquals(1.5, ingredients.get(0).getAmount());
    assertEquals(1.5, ingredients.get(1).getAmount());
    assertEquals(0.75, ingredients.get(2).getAmount());
    assertEquals(1.5, ingredients.get(3).getAmount());
    assertEquals(1.5, ingredients.get(4).getAmount());
    assertEquals(1.75, ingredients.get(5).getAmount());
    assertEquals(2, ingredients.get(6).getAmount());
    assertEquals(1.5, ingredients.get(7).getAmount());
    
    ingredients = constructIngredients3();
    
    for(Ingredient item: ingredients)
    {
      item.addAmount(0.01);
    }
    assertEquals(1.01, ingredients.get(0).getAmount());
    assertEquals(3.01, ingredients.get(1).getAmount());
    assertEquals(1.01, ingredients.get(2).getAmount());
    assertEquals(1.01, ingredients.get(3).getAmount());
    assertEquals(0.51, ingredients.get(4).getAmount());
    assertEquals(0.11, ingredients.get(5).getAmount());
    assertEquals(2.01, ingredients.get(6).getAmount());
  }
  

  @Test
  void getNameTest()
  {
    List<Ingredient> ingredients = null;
    
    ingredients = constructIngredients1();
    assertEquals("butter", ingredients.get(0).getName());
    assertEquals("brown sugar", ingredients.get(1).getName());
    assertEquals("bananas", ingredients.get(2).getName());
    assertEquals("creme de cacao", ingredients.get(3).getName());
    assertEquals("rum", ingredients.get(4).getName());
    assertEquals("ice cream", ingredients.get(5).getName());
    assertEquals("cinnamon", ingredients.get(6).getName());
    
    ingredients = constructIngredients2();
    assertEquals("macaroni", ingredients.get(0).getName());
    assertEquals("butter", ingredients.get(1).getName());
    assertEquals("onion", ingredients.get(2).getName());
    assertEquals("flour", ingredients.get(3).getName());
    assertEquals("pepper", ingredients.get(4).getName());
    assertEquals("milk", ingredients.get(5).getName());
    assertEquals("American cheese", ingredients.get(6).getName());
    assertEquals("tomato", ingredients.get(7).getName());
    
    ingredients = constructIngredients3();
    assertEquals("egg", ingredients.get(0).getName());
    assertEquals("milk", ingredients.get(1).getName());
    assertEquals("saltinecrackers", ingredients.get(2).getName());
    assertEquals("thyme", ingredients.get(3).getName());
    assertEquals("paprika", ingredients.get(4).getName());
    assertEquals("pepper", ingredients.get(5).getName());
    assertEquals("chicken", ingredients.get(6).getName());
  }

  @Test
  void getUnitTest()
  {
    List<Ingredient> ingredients = null;
    
    ingredients = constructIngredients1();
    assertEquals("cup", ingredients.get(0).getUnit());
    assertEquals("cup", ingredients.get(1).getUnit());
    assertEquals("individual", ingredients.get(2).getUnit());
    assertEquals("tablespoon", ingredients.get(3).getUnit());
    assertEquals("cup", ingredients.get(4).getUnit());
    assertEquals("cup", ingredients.get(5).getUnit());
    assertEquals("teaspoon", ingredients.get(6).getUnit());
    
    ingredients = constructIngredients2();
    assertEquals("cup", ingredients.get(0).getUnit());
    assertEquals("tablespoon", ingredients.get(1).getUnit());
    assertEquals("cup", ingredients.get(2).getUnit());
    assertEquals("tablespoon", ingredients.get(3).getUnit());
    assertEquals("pinch", ingredients.get(4).getUnit());
    assertEquals("cup", ingredients.get(5).getUnit());
    assertEquals("cup", ingredients.get(6).getUnit());
    assertEquals(null, ingredients.get(7).getUnit());
    
    ingredients = constructIngredients3();
    assertEquals("individual", ingredients.get(0).getUnit());
    assertEquals("tablespoon", ingredients.get(1).getUnit());
    assertEquals("cup", ingredients.get(2).getUnit());
    assertEquals("teaspoon", ingredients.get(3).getUnit());
    assertEquals("teaspoon", ingredients.get(4).getUnit());
    assertEquals("teaspoon", ingredients.get(5).getUnit());
    assertEquals("pounds", ingredients.get(6).getUnit());
  }

  @Test
  void toStringTest()
  {
    List<Ingredient> ingredients = null;
    
    ingredients = constructIngredients1();
    
    assertEquals("0.33 cup butter", ingredients.get(0).toString());
    assertEquals("0.33 cup brown sugar", ingredients.get(1).toString());
    assertEquals("3 individual (sliced ripe) bananas", ingredients.get(2).toString());
    assertEquals("2 tablespoon creme de cacao", ingredients.get(3).toString());
    assertEquals("0.25 cup rum", ingredients.get(4).toString());
    assertEquals("2 cup (vanilla) ice cream", ingredients.get(5).toString());
    assertEquals("0.25 teaspoon (ground) cinnamon", ingredients.get(6).toString());
    
    ingredients = constructIngredients2();
    assertEquals("1 cup (dried elbow) macaroni", ingredients.get(0).toString());
    assertEquals("1 tablespoon butter", ingredients.get(1).toString());
    assertEquals("0.25 cup (chopped) onion", ingredients.get(2).toString());
    assertEquals("1 tablespoon (allpurpose) flour", ingredients.get(3).toString());
    assertEquals("1 pinch (black) pepper", ingredients.get(4).toString());
    assertEquals("1.25 cup milk", ingredients.get(5).toString());
    assertEquals("1.5 cup (shredded) American cheese", ingredients.get(6).toString());
    assertEquals("1 (sliced medium) tomato", ingredients.get(7).toString());
    
    ingredients = constructIngredients3();
    assertEquals("1 individual (beaten) egg", ingredients.get(0).toString());
    assertEquals("3 tablespoon milk", ingredients.get(1).toString());
    assertEquals("1 cup (finlycrushed) saltinecrackers", ingredients.get(2).toString());
    assertEquals("1 teaspoon (driedcrushed) thyme", ingredients.get(3).toString());
    assertEquals("0.5 teaspoon paprika", ingredients.get(4).toString());
    assertEquals("0.1 teaspoon (black) pepper", ingredients.get(5).toString());
    assertEquals("2 pounds (pieces; skinned, rinsed and dried) chicken", ingredients.get(6).toString());
    
    Ingredient ingredient = new Ingredient("10", null, "apples"); 
    assertEquals("10 apples", ingredient.toString());
  }
  
  @Test
  void compareToTest()
  {
    List<Ingredient> ingredients = null;
    
    ingredients = constructIngredients1();
    
    assertEquals(3, ingredients.get(0).compareTo(ingredients.get(1)));
    assertEquals(-16, ingredients.get(1).compareTo(ingredients.get(4)));
    assertEquals(0, ingredients.get(5).compareTo(ingredients.get(5)));

    
  }
  
  @Test
  void calorieTest()
  {
    List<Ingredient> ingredients = null;
    
    ingredients = constructIngredients1();
    
    ingredients.get(0).setCalorie(1);
    ingredients.get(1).setCalorie(100);
    ingredients.get(2).setCalorie(1000);
    
    assertEquals(1, ingredients.get(0).getCalorie());
    assertEquals(100, ingredients.get(1).getCalorie());
    assertEquals(1000, ingredients.get(2).getCalorie());
  }
  
  @Test 
  void densityTest()
  {
    List<Ingredient> ingredients = null;
    
    ingredients = constructIngredients1();
    
    ingredients.get(0).setDensity(1.);
    ingredients.get(1).setDensity(100.0);
    ingredients.get(2).setDensity(1000.0);
    
    assertEquals(1.0, ingredients.get(0).getDensity());
    assertEquals(100.0, ingredients.get(1).getDensity());
    assertEquals(1000.0, ingredients.get(2).getDensity());
  }
  
  @Test
  void embeddedRecipeTest()
  {
    List<Ingredient> ingredients = null;
    
    ingredients = constructIngredients1();
    
    
    Recipe recipe = new Recipe("Test Recipe", 1, null, null, null);
    
    ingredients.get(0).setRecipe(recipe);
    
    assertEquals(null, ingredients.get(0).getRecipe().getIngredient());
    assertEquals(null, ingredients.get(0).getRecipe().getUtensils());
    assertEquals(null, ingredients.get(0).getRecipe().getSteps());
  }
}
