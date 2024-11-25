package use_case.api_tests;

import data_access.RecipeIDToRecipe;
import org.junit.jupiter.api.Test;

import entity.Ranked;

public class rankedTests {
    @Test
    void successTest() {
        String recipe = RecipeIDToRecipe.recipeIDToRecipe("638369");
        System.out.println(recipe);
    }
}
