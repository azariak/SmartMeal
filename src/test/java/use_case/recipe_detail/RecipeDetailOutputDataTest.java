package use_case.recipe_detail;

import entity.AdvancedRecipe;
import entity.AdvancedRecipeInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeDetailOutputDataTest {

    private AdvancedRecipeInterface advancedRecipeInterface;
    private RecipeDetailOutputData recipeDetailOutputData;

    @BeforeEach
    void setUp() throws IOException {
        String name = "Chocolate Cake";
        String id = "1234";
        ArrayList<String> ingredientNames = new ArrayList<>();
        ingredientNames.add("Flour");
        ingredientNames.add("Sugar");
        ingredientNames.add("Cocoa Powder");

        ArrayList<String> ingredientQuantities = new ArrayList<>();
        ingredientQuantities.add("2 cups");
        ingredientQuantities.add("1 cup");
        ingredientQuantities.add("1/2 cup");

        String instructions = "Mix all ingredients and bake for 30 minutes at 350°F.";

        advancedRecipeInterface = new AdvancedRecipe(name, id, ingredientNames, ingredientQuantities, instructions);
        recipeDetailOutputData = new RecipeDetailOutputData(advancedRecipeInterface);
    }

    @AfterEach
    void tearDown() {
        advancedRecipeInterface = null;
        recipeDetailOutputData = null;
    }

    @Test
    void getAdvancedRecipe() {
        AdvancedRecipeInterface retrievedRecipe = recipeDetailOutputData.getAdvancedRecipe();
        assertEquals("Chocolate Cake", retrievedRecipe.getRecipeName());
        assertEquals("1234", retrievedRecipe.getId());
        assertEquals("Mix all ingredients and bake for 30 minutes at 350°F.", retrievedRecipe.getInstructions());
    }
}
