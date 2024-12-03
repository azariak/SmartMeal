package use_case.saved_recipe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SavedRecipeInputDataTest {

    @Test
    void testConstructorAndGetters_ValidInput() {
        String expectedName = "Pasta";
        String expectedDescription = "A delicious pasta recipe.";
        String expectedNutrition = "200 calories per serving.";
        String expectedIngredients = "Flour, Eggs, Water.";
        String expectedCalories = "200";
        SavedRecipeInputData inputData = new SavedRecipeInputData(
                expectedName, expectedDescription, expectedNutrition, expectedIngredients, expectedCalories
        );

        assertEquals(expectedName, inputData.getRecipeName());
        assertEquals(expectedDescription, inputData.getRecipeDescription());
        assertEquals(expectedNutrition, inputData.getRecipeNutrition());
        assertEquals(expectedIngredients, inputData.getRecipeIngredients());
        assertEquals(expectedCalories, inputData.getRecipeCalories());
    }

    @Test
    void testSetters_UpdateValues() {
        SavedRecipeInputData inputData = new SavedRecipeInputData(
                "Original Name", "Original Description", "Original Nutrition", "Original Ingredients", "100"
        );

        inputData.setRecipeName("Updated Name");
        inputData.setRecipeDescription("Updated Description");
        inputData.setRecipeNutrition("Updated Nutrition");
        inputData.setRecipeIngredients("Updated Ingredients");
        inputData.setRecipeCalories("300");

        assertEquals("Updated Name", inputData.getRecipeName());
        assertEquals("Updated Description", inputData.getRecipeDescription());
        assertEquals("Updated Nutrition", inputData.getRecipeNutrition());
        assertEquals("Updated Ingredients", inputData.getRecipeIngredients());
        assertEquals("300", inputData.getRecipeCalories());
    }

    @Test
    void testConstructorWithEmptyValues() {
        SavedRecipeInputData inputData = new SavedRecipeInputData("", "", "", "", "");

        assertEquals("", inputData.getRecipeName());
        assertEquals("", inputData.getRecipeDescription());
        assertEquals("", inputData.getRecipeNutrition());
        assertEquals("", inputData.getRecipeIngredients());
        assertEquals("", inputData.getRecipeCalories());
    }

    @Test
    void testConstructorWithNullValues() {
        SavedRecipeInputData inputData = new SavedRecipeInputData(null, null, null, null, null);

        assertNull(inputData.getRecipeName());
        assertNull(inputData.getRecipeDescription());
        assertNull(inputData.getRecipeNutrition());
        assertNull(inputData.getRecipeIngredients());
        assertNull(inputData.getRecipeCalories());
    }
}

