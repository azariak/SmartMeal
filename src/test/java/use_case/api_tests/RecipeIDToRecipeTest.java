package use_case.api_tests;

import data_access.RecipeIDToRecipe;
import org.junit.jupiter.api.Test;

import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.HashMap;
import java.util.Map;

public class RecipeIDToRecipeTest {
    @Test
    void successTest() {
        String recipe = RecipeIDToRecipe.recipeIDToRecipe("638369");
        System.out.println(recipe);
    }
}
