// CHECKSTYLE:OFF

package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import data.Ingredient;
import data.Meal;
import data.Recipe;
import data.Step;
import data.Utensil;

class MealTest
{

  private List<Utensil> constructUtensils()
  {
    List<Utensil> utensils = new ArrayList<>();
    utensils.add(new Utensil("skillet", "large"));
    utensils.add(new Utensil("sausepan", ""));
    utensils.add(new Utensil("sausepan", ""));

    return utensils;
  }

  private List<Ingredient> constructIngredients()
  {
    List<Ingredient> ingredients = new ArrayList<>();
    ingredients.add(new Ingredient("butter", "", "0.33", "cup"));
    ingredients.add(new Ingredient("brown sugar", "", "0.33", "cup"));
    ingredients.add(new Ingredient("bananas", "sliced", "3", "individual"));
    ingredients.add(new Ingredient("creme de cacao", "", "2", "tablespoon"));
    ingredients.add(new Ingredient("rum", "", "0.33", "cup"));
    ingredients.add(new Ingredient("ice creme", "vanilla", "2", "cup"));
    ingredients.add(new Ingredient("cinnamon", "ground", "0.25", "teaspoon"));

    return ingredients;
  }

  // Steps for BananaFoster
  private List<Step> constructSteps()
  {
    List<Ingredient> ingredients = constructIngredients();
    List<Utensil> utensil = constructUtensils();
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
  void testGetName()
  {	  
	  Meal example1 = new Meal("test");
	  assertEquals(example1.getName(), "test");
  }

  @Test
  void testAddRecipe()
  {
	  Recipe recipe1 = new Recipe("Test", 10, constructIngredients(), constructUtensils(),
			  constructSteps());
	  
	  // testing the get recipes function by default
	  Meal example1 = new Meal("test");
	  example1.addRecipe(recipe1);
	  assertEquals(example1.getRecipes().get(0), recipe1);
  }

  @Test
  void testRemoveRecipe()
  {
	  Recipe recipe1 = new Recipe("Test", 10, constructIngredients(), constructUtensils(),
		        constructSteps());
	  
	  Meal example = new Meal("test");
	  example.addRecipe(recipe1);
	  assertEquals(example.getRecipes().get(0), recipe1);
	  
	  example.removeRecipe(0);
	  List<Recipe> emptylist = new ArrayList<>();
	  assertEquals(example.getRecipes(), emptylist);
  }

  @Test
  void testGetMealIngredients()
  {
    Recipe recipe1 = new Recipe("Test", 10, constructIngredients(), constructUtensils(),
        constructSteps());

    Recipe recipe2 = new Recipe("Test", 10, constructIngredients(), constructUtensils(),
        constructSteps());

    Meal meal = new Meal("test");
    meal.addRecipe(recipe1);
    meal.addRecipe(recipe2);
  }

}

//CHECKSTYLE:ON