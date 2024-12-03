package use_case.load_saved_recipe;

import entity.GenericRecipeInterface;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class LoadSavedRecipeOutputDataTest {

    @Test
    void testConstructorAndGetters_SuccessCase() {
        // Arrange
        GenericRecipeInterface mockRecipeId = mock(GenericRecipeInterface.class);
        GenericRecipeInterface mockRecipeName = mock(GenericRecipeInterface.class);
        boolean useCaseFailed = false;

        // Act
        LoadSavedRecipeOutputData outputData =
                new LoadSavedRecipeOutputData(mockRecipeId, mockRecipeName, useCaseFailed);

        // Assert
        assertEquals(mockRecipeId, outputData.getRecipeId());
        assertEquals(mockRecipeName, outputData.getRecipeName());
        assertFalse(outputData.isUseCaseFailed());
    }

    @Test
    void testConstructorAndGetters_FailureCase() {
        // Arrange
        GenericRecipeInterface mockRecipeId = mock(GenericRecipeInterface.class);
        GenericRecipeInterface mockRecipeName = mock(GenericRecipeInterface.class);
        boolean useCaseFailed = true;

        // Act
        LoadSavedRecipeOutputData outputData =
                new LoadSavedRecipeOutputData(mockRecipeId, mockRecipeName, useCaseFailed);

        // Assert
        assertEquals(mockRecipeId, outputData.getRecipeId());
        assertEquals(mockRecipeName, outputData.getRecipeName());
        assertTrue(outputData.isUseCaseFailed());
    }

    @Test
    void testConstructorWithNullValues() {
        // Arrange
        GenericRecipeInterface recipeId = null;
        GenericRecipeInterface recipeName = null;
        boolean useCaseFailed = false;

        // Act
        LoadSavedRecipeOutputData outputData =
                new LoadSavedRecipeOutputData(recipeId, recipeName, useCaseFailed);

        // Assert
        assertNull(outputData.getRecipeId());
        assertNull(outputData.getRecipeName());
        assertFalse(outputData.isUseCaseFailed());
    }
}
