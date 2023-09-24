package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import data.*;
import information.*;


class MealSearcherTest
{

  @Test
  void test()
  {

    List<Ingredient> ingredients = new ArrayList<>();
    ingredients.add(new Ingredient("butter", "", "butter", "cup"));
    ingredients.add(new Ingredient("brown sugar", "", "brown sugar", "cup"));
    ingredients.add(new Ingredient("bananas", "sliced", "bananas", "individual"));
    ingredients.add(new Ingredient("creme de cacao", "", "creme de cacao", "tablespoon"));
    ingredients.add(new Ingredient("ru", "", "ru", "cup"));
    ingredients.add(new Ingredient("ice creme", "vanilla", "ice cream", "cup"));
    ingredients.add(new Ingredient("cinnamon", "ground", "cinnamon", "teaspoon"));

    List<Ingredient> ingredients1 = new ArrayList<>();
    ingredients1.add(new Ingredient("butte", "", "butte", "cup"));
    ingredients1.add(new Ingredient("cream", "", "cream", "cup"));
    ingredients1.add(new Ingredient("ice cream", "sliced", "ice cream", "individual"));
    ingredients1.add(new Ingredient("rum", "", "rum", "tablespoon"));
    ingredients1.add(new Ingredient("not yummy", "", "not yummy", "cup"));
    ingredients1.add(new Ingredient("ice creme", "vanilla", "ice creme", "cup"));
    ingredients1.add(new Ingredient("cinnamon", "ground", "cinnamon", "teaspoon"));

    List<Utensil> utensil = new ArrayList<>();
    utensil.add(new Utensil("skillet", "large"));
    utensil.add(new Utensil("saucepan", ""));
    utensil.add(new Utensil("plate", ""));

    List<Step> steps = new ArrayList<>();
    steps.add(new Step("put", "on", "utensil", "d"));

    List<String> requiredIngredients = new ArrayList<>();
    requiredIngredients.add("butter");
    requiredIngredients.add("rum");

    List<String> requiredIngredients2 = new ArrayList<>();
    requiredIngredients2.add("bucket");
    requiredIngredients2.add("chum");

    List<String> excludedIngredients = new ArrayList<>();
    excludedIngredients.add("exclude");
    // excludedIngredients.add("yellow fever");
    List<String> excludedIngredients1 = new ArrayList<>();
    excludedIngredients.add("yellow fever");

    Meal meal = new Meal("Test");
    meal.addRecipe(new Recipe("Bananas Foster", 1, ingredients, utensil, steps));
    meal.addRecipe(new Recipe("Weird food", 1, ingredients1, utensil, steps));

    List<Meal> meals = new ArrayList<>();
    meals.add(meal);

    List<Ingredient> ingredients2 = new ArrayList<>();
    ingredients2.add(new Ingredient("dsa", "", "dsa", "cup"));
    ingredients2.add(new Ingredient("brown sugar", "", "brown sugar", "cup"));
    ingredients2.add(new Ingredient("exclude", "sliced", "exclude", "individual"));
    ingredients2.add(new Ingredient("rum", "", "2", "tablespoon"));

    List<Ingredient> ingredients3 = new ArrayList<>();
    ingredients3.add(new Ingredient("Butter", "", "Butter", "cup"));
    ingredients3.add(new Ingredient("cream", "", "cream", "cup"));
    ingredients3.add(new Ingredient("exclude", "sliced", "rum", "individual"));
    ingredients3.add(new Ingredient("rum", "", "butter", "tablespoon"));

    Meal meal1 = new Meal("Test");
    meal1.addRecipe(new Recipe("Funky foster", 1, ingredients2, utensil, steps));
    meal1.addRecipe(new Recipe("funky food", 1, ingredients3, utensil, steps));
    meals.add(meal1);

    //System.out.println(MealSearcher.searchMeals(requiredIngredients, excludedIngredients, meals).get(0).getName());

    // Testing to see if excluded ingredients and required ingredients work
    assertEquals(1,
        MealSearcher.searchMeals(requiredIngredients, excludedIngredients, meals).size());

    System.out.println(
        MealSearcher.searchMeals(requiredIngredients, excludedIngredients, meals).toString());

    assertEquals("Weird food",
        MealSearcher.searchMeals(requiredIngredients, excludedIngredients, meals).get(0).getRecipes().get(1).getName());

    
    // Testing to see if no required ingredients exist
    assertEquals(0,
        MealSearcher.searchMeals(requiredIngredients2, excludedIngredients, meals).size());
    
    //Testing to see if multiple meals are added
    assertEquals(2,
            MealSearcher.searchMeals(requiredIngredients, excludedIngredients1, meals).size());
  }
  

}