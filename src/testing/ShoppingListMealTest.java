// CHECKSTYLE:OFF

package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import data.Ingredient;
import data.Recipe;
import data.Step;
import data.Utensil;
import shoppinglist.ShoppingListMeal;
import shoppinglist.ShoppingListRecipe;

class ShoppingListMealTest
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
    ingredients.add(new Ingredient("0.33", "cup", "butter"));
    ingredients.add(new Ingredient("0.33", "teaspoon", "butter"));
    ingredients.add(new Ingredient("0.33", "cup", "brown sugar"));
    ingredients.add(new Ingredient("3", "individual", "bananas" , "sliced"));
    ingredients.add(new Ingredient("2", "tablespoon", "creme de cacao"));
    ingredients.add(new Ingredient("0.33", "cup", "rum"));
    ingredients.add(new Ingredient("2", "cup", "ice creme", "vanilla"));
    ingredients.add(new Ingredient("0.25", "teaspoon", "cinnamon", "ground"));

    return ingredients;
  }

  // Steps for BananaFoster
  private List<Step> constructSteps()
  {
    List<Ingredient> ingredients = constructIngredients();
    List<Utensil> utensil = constructUtensils();
    List<Step> steps = new ArrayList<>();

    steps.add(new Step("put", ingredients.get(0).getName(), utensil.get(0).getName()));
    steps.add(new Step("melt", utensil.get(0).getName(), utensil.get(0).getName()));
    steps.add(new Step("put", ingredients.get(1).getName(), utensil.get(0).getName()));
    steps.add(new Step("put", ingredients.get(2).getName(), utensil.get(0).getName()));
    steps.add(new Step("simmer", utensil.get(0).getName(), utensil.get(0).getName(), "for 2 minutes"));
    steps.add(new Step("put", ingredients.get(6).getName(), utensil.get(0).getName()));
    steps.add(new Step("put", ingredients.get(4).getName(), utensil.get(0).getName()));
    steps.add(new Step("put", utensil.get(0).getName(), utensil.get(0).getName()));
    steps.add(new Step("heat", ingredients.get(4).getName(), utensil.get(1).getName(), "until it almost simmers"));
    steps.add(new Step("ignite", ingredients.get(4).getName(), utensil.get(1).getName()));
    steps.add(new Step("put", utensil.get(1).getName(), utensil.get(2).getName()));
    steps.add(new Step("put", ingredients.get(5).getName(), utensil.get(2).getName()));

    return steps;
  }

  @Test
  void constructorTest()
  {
    Recipe r1 = new Recipe("Recipe1", 5, constructIngredients(), constructUtensils(),
        constructSteps());
    Recipe r2 = new Recipe("Recipe2", 5, constructIngredients(), constructUtensils(),
        constructSteps());
    List<Recipe> recipes = new ArrayList<>();
    recipes.add(r1);
    recipes.add(r2);
    ShoppingListMeal meal = new ShoppingListMeal(recipes);
    assertEquals(5, meal.getPeople());
    meal.toString();
    meal.toStringPrintHelp();
  }

  @Test
  void getterTest()
  {
    Recipe r1 = new Recipe("Recipe1", 5, constructIngredients(), constructUtensils(),
        constructSteps());
    Recipe r2 = new Recipe("Recipe2", 5, constructIngredients(), constructUtensils(),
        constructSteps());
    List<Recipe> recipes = new ArrayList<>();
    recipes.add(r1);
    recipes.add(r2);
    ShoppingListMeal meal = new ShoppingListMeal(recipes);
    meal.getMeal();
    meal.getRecipes();
  }
  

}

//CHECKSTYLE:ON