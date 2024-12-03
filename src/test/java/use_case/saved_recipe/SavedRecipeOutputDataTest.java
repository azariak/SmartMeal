package use_case.saved_recipe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SavedRecipeOutputDataTest {

    @Test
    void testConstructorAndGetters_ValidInput() {
        String expectedRecipeName = "Pasta";
        boolean expectedUseCaseFailed = false;
        SavedRecipeOutputData outputData = new SavedRecipeOutputData(expectedRecipeName, expectedUseCaseFailed);
        assertEquals(expectedRecipeName, outputData.getRecipeName(), "Recipe name should match the input.");
        assertFalse(outputData.isUseCaseFailed(), "Use case should not have failed.");
    }

    @Test
    void testConstructorAndGetters_NullRecipeName() {
        String expectedRecipeName = null;
        boolean expectedUseCaseFailed = true;
        SavedRecipeOutputData outputData = new SavedRecipeOutputData(expectedRecipeName, expectedUseCaseFailed);
        assertNull(outputData.getRecipeName(), "Recipe name should be null.");
        assertTrue(outputData.isUseCaseFailed(), "Use case should have failed.");
    }

    @Test
    void testConstructorAndGetters_EmptyRecipeName() {
        String expectedRecipeName = "";
        boolean expectedUseCaseFailed = true;
        SavedRecipeOutputData outputData = new SavedRecipeOutputData(expectedRecipeName, expectedUseCaseFailed);
        assertEquals(expectedRecipeName, outputData.getRecipeName(), "Recipe name should be an empty string.");
        assertTrue(outputData.isUseCaseFailed(), "Use case should have failed.");
    }

    @Test
    void testConstructorAndGetters_UseCaseFailedFalse() {
        String expectedRecipeName = "Lasagna";
        boolean expectedUseCaseFailed = false;
        SavedRecipeOutputData outputData = new SavedRecipeOutputData(expectedRecipeName, expectedUseCaseFailed);
        assertEquals(expectedRecipeName, outputData.getRecipeName(), "Recipe name should match the input.");
        assertFalse(outputData.isUseCaseFailed(), "Use case should not have failed.");
    }
}
