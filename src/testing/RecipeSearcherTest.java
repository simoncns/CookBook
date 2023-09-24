// CHECKSTYLE:OFF

package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import data.Ingredient;
import data.Recipe;
import data.Step;
import data.Utensil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import information.*;

public class RecipeSearcherTest {

	
    @Test
	void test() {
      RecipeSearcher re = new RecipeSearcher();
    	List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("butter", "", "0.33", "cup"));
        ingredients.add(new Ingredient("brown sugar", "", "0.33", "cup"));
        ingredients.add(new Ingredient("bananas", "sliced", "3", "individual"));
        ingredients.add(new Ingredient("creme de cacao", "", "2", "tablespoon"));
        ingredients.add(new Ingredient("rum", "", "0.33", "cup"));
        ingredients.add(new Ingredient("ice creme", "vanilla", "2", "cup"));
        ingredients.add(new Ingredient("cinnamon", "ground", "0.25", "teaspoon"));
        
    	List<Ingredient> ingredients1 = new ArrayList<>();
        ingredients1.add(new Ingredient("yummy", "", "0.33", "cup"));
        ingredients1.add(new Ingredient("cream", "", "0.33", "cup"));
        ingredients1.add(new Ingredient("ice cream", "sliced", "3", "individual"));
        ingredients1.add(new Ingredient("yellow fever", "", "2", "tablespoon"));
        ingredients1.add(new Ingredient("not yummy", "", "0.33", "cup"));
        ingredients1.add(new Ingredient("ice creme", "vanilla", "2", "cup"));
        ingredients1.add(new Ingredient("cinnamon", "ground", "0.25", "teaspoon"));
        
        List<Utensil> utensil = new ArrayList<>();
        utensil.add(new Utensil("skillet", "large"));
        utensil.add(new Utensil("saucepan", ""));
        utensil.add(new Utensil("plate", ""));
        
        List<Step> steps = new ArrayList<>();
        steps.add(new Step("put", ingredients.get(1).getName(), utensil.get(1).getName(),""));
        
        Map<String,Recipe> recipes = new HashMap<>();
        recipes.put("Bananas Foster", new Recipe("Bananas Foster", 1, ingredients, utensil, steps));
        recipes.put("Weird food", new Recipe("Weird food", 1, ingredients1, utensil, steps));
        
        List<String> requiredIngredients = new ArrayList<>();
        requiredIngredients.add("butter");
        requiredIngredients.add("rum");
        
        List<String> excludedIngredients = new ArrayList<>();
        excludedIngredients.add("exclude");
        excludedIngredients.add("yellow fever");
        
        //Tests if searcher puts valid recipe into new list
        RecipeSearcher.searchRecipes(requiredIngredients, excludedIngredients, recipes);
//        assertEquals("Bananas Foster", RecipeSearcher.searchRecipes(requiredIngredients, excludedIngredients, recipes).get(0).getName());
//        System.out.println();
//        
//        //Tests if searcher removes recipe with excluded ingredient
//        assertEquals(1, RecipeSearcher.searchRecipes(requiredIngredients, excludedIngredients, recipes).size());
//        
//        //Tests if searcher removes recipe that doesn't have required ingredient
//        assertEquals("Bananas Foster", RecipeSearcher.searchRecipes(requiredIngredients, excludedIngredients, recipes).get(0).getName());
	}

}

//CHECKSTYLE:ON