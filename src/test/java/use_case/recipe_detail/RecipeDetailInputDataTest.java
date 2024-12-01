package use_case.recipe_detail;

import entity.GenericRecipe;
import entity.GenericRecipeInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeDetailInputDataTest {

    private RecipeDetailInputData recipeDetailInputData;
    private GenericRecipeInterface genericRecipeInterface;

    @BeforeEach
    void setUp() throws IOException {
        String name = "Pancakes";
        String id = "5678";
        genericRecipeInterface = new GenericRecipe(name, id);
        recipeDetailInputData = new RecipeDetailInputData(genericRecipeInterface);
    }

    @AfterEach
    void tearDown() {
        recipeDetailInputData = null;
        genericRecipeInterface = null;
    }

    @Test
    void getGenericRecipe() {
        GenericRecipeInterface retrievedRecipe = recipeDetailInputData.getGenericRecipe();
        assertEquals("Pancakes", retrievedRecipe.getName());
        assertEquals("5678", retrievedRecipe.getId());
    }
}
