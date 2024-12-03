package use_case.load_saved_recipe;

import entity.AdvancedRecipeInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LoadSavedRecipeInteractorTest {

    @Mock
    private LoadSavedRecipeDataAccessInterface mockRecipeDataAccess;

    @Mock
    private LoadSavedRecipeOutputBoundary mockPresenter;

    private LoadSavedRecipeInteractor interactor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        interactor = new LoadSavedRecipeInteractor(mockRecipeDataAccess, mockPresenter);
    }

    @Test
    void testExecute() {
        // Arrange
        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData("Recipe1", "Recipe2", "Recipe3");

        // Act
        interactor.execute(inputData);

        // Assert
        verify(mockPresenter, times(1))
                .prepareResultView("Recipe1", "Recipe2", "Recipe3");
        verifyNoInteractions(mockRecipeDataAccess);
    }

    @Test
    void testSwitchToResultView() {

        interactor.switchToResultView();

        verify(mockPresenter, times(1)).switchToResultView();
        verifyNoInteractions(mockRecipeDataAccess);
    }

    @Test
    void testBackToLastView() {
        interactor.backToLastView();

        verify(mockPresenter, times(1)).backToLastView();
        verifyNoInteractions(mockRecipeDataAccess);
    }

    @Test
    void testGetAllRecipes() {
        // Arrange
        AdvancedRecipeInterface recipe1 = mock(AdvancedRecipeInterface.class);
        AdvancedRecipeInterface recipe2 = mock(AdvancedRecipeInterface.class);
        List<AdvancedRecipeInterface> mockRecipes = Arrays.asList(recipe1, recipe2);
        when(mockRecipeDataAccess.getAllRecipes()).thenReturn(mockRecipes);

        // Act
        List<AdvancedRecipeInterface> recipes = interactor.getAllRecipes();

        // Assert
        verify(mockRecipeDataAccess, times(1)).getAllRecipes();
        assertEquals(mockRecipes, recipes);
    }

    @Test
    void testGetAllRecipesWithNoRecipes() {
        // Arrange
        when(mockRecipeDataAccess.getAllRecipes()).thenReturn(Collections.emptyList());

        // Act
        List<AdvancedRecipeInterface> recipes = interactor.getAllRecipes();

        // Assert
        verify(mockRecipeDataAccess, times(1)).getAllRecipes();
        assertEquals(0, recipes.size());
    }
}
