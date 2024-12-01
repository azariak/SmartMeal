package use_case.recipe_detail;

import entity.GenericRecipe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeDetailInputDataTest {

    private RecipeDetailInputData recipeDetailInputData;
    private GenericRecipe genericRecipe;

    @BeforeEach
    void setUp() throws IOException {
        String name = "Pancakes";
        String id = "5678";
        genericRecipe = new GenericRecipe(name, id);
        recipeDetailInputData = new RecipeDetailInputData(genericRecipe);
    }

    @AfterEach
    void tearDown() {
        recipeDetailInputData = null;
        genericRecipe = null;
    }

    @Test
    void getGenericRecipe() {
        GenericRecipe retrievedRecipe = recipeDetailInputData.getGenericRecipe();
        assertEquals("Pancakes", retrievedRecipe.getName());
        assertEquals("5678", retrievedRecipe.getId());
    }
}
