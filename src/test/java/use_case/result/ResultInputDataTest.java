package use_case.result;

import entity.GenericRecipe;
import entity.GenericRecipeFactory;
import entity.GenericRecipeFactoryInterface;
import entity.GenericRecipeInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ResultInputDataTest {
    private GenericRecipeInterface recipe;
    private final GenericRecipeFactoryInterface recipeFactory = new GenericRecipeFactory();

    @BeforeEach
    void setUp() throws IOException {
        recipe = recipeFactory.createGenericRecipe("name", "id");

    }

    @AfterEach
    void tearDown() {
        recipe = null;
    }

    @Test
    void getRecipe() {
        final ResultInputData resultInputData = new ResultInputData(recipe);

        assertEquals(recipe, resultInputData.getRecipe());
        assertEquals(recipe.getName(), resultInputData.getRecipe().getName());
        assertEquals(recipe.getId(), resultInputData.getRecipe().getId());
    }
}