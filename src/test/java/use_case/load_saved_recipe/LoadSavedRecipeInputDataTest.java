package use_case.load_saved_recipe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoadSavedRecipeInputDataTest {

    @Test
    void testConstructorAndGetters() {
        String recipe1 = "Pasta";
        String recipe2 = "Soup";
        String recipe3 = "Salad";
        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData(recipe1, recipe2, recipe3);
        assertEquals(recipe1, inputData.getRecipe1());
        assertEquals(recipe2, inputData.getRecipe2());
        assertEquals(recipe3, inputData.getRecipe3());
    }

    @Test
    void testEmptyStrings() {
        String recipe1 = "";
        String recipe2 = "";
        String recipe3 = "";
        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData(recipe1, recipe2, recipe3);
        assertEquals(recipe1, inputData.getRecipe1());
        assertEquals(recipe2, inputData.getRecipe2());
        assertEquals(recipe3, inputData.getRecipe3());
    }

    @Test
    void testNullValues() {
        String recipe1 = null;
        String recipe2 = null;
        String recipe3 = null;

        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData(recipe1, recipe2, recipe3);

        assertEquals(recipe1, inputData.getRecipe1());
        assertEquals(recipe2, inputData.getRecipe2());
        assertEquals(recipe3, inputData.getRecipe3());
    }

    @Test
    void testLongStrings() {
        String recipe1 = "A".repeat(1000);
        String recipe2 = "B".repeat(1000);
        String recipe3 = "C".repeat(1000);

        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData(recipe1, recipe2, recipe3);

        assertEquals(recipe1, inputData.getRecipe1());
        assertEquals(recipe2, inputData.getRecipe2());
        assertEquals(recipe3, inputData.getRecipe3());
    }
}
