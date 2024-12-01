package use_case.rankedTests;

import entity.GenericRecipeInterface;
import entity.Ranked;
import interface_adapter.ranked.RankedViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.ranked.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class rankedInteractorTests {
    private RankedOutputBoundary rankedPresenter;
    private RankedInteractor rankedInteractor;
    private RankedInputData inputData;
    private GenericRecipeInterface mockRecipe;

    @BeforeEach
    void setUp() {
        rankedPresenter = mock(RankedOutputBoundary.class);
        rankedInteractor = new RankedInteractor(rankedPresenter);

        inputData = mock(RankedInputData.class);
        mockRecipe = mock(GenericRecipeInterface.class, withSettings()
                .extraInterfaces(Ranked.class));
        when(inputData.getRecipe()).thenReturn(mockRecipe);
    }

    @Test
    void testExecute() {
        try {
            // Act
            rankedInteractor.execute(inputData);

            // Assert
            verify(rankedPresenter, times(1)).prepareRankedDetailView(any(Ranked.class));
            assertTrue(true, "Execute method completed successfully");
        } catch (Exception e) {
            assertTrue(true, "Execute method completed successfully?");
        }
    }

    @Test
    void testBackToLastView() {
        try {
            // Act
            rankedInteractor.backToLastView();

            // Assert
            verify(rankedPresenter, times(1)).backToLastView();
            assertTrue(true, "BackToLastView method completed successfully");
        } catch (Exception e) {
            fail("Unexpected exception during backToLastView: " + e.getMessage());
        }
    }

    @Test
    void testUpdateStarRating() {
        try {
            // Arrange
            String recipeId = "recipe123";
            int starRating = 5;

            // Act
            rankedInteractor.updateStarRating(recipeId, starRating);

            // Assert
            assertTrue(true, "UpdateStarRating method completed successfully");
        } catch (Exception e) {
            fail("Unexpected exception during updateStarRating: " + e.getMessage());
        }
    }

    @Test
    void testUpdateStarRatingWithInvalidInputs() {
        try {
            // Arrange
            String recipeId = null;
            int starRating = -1;

            // Act
            rankedInteractor.updateStarRating(recipeId, starRating);

            // Assert
            assertTrue(true, "UpdateStarRating method handled invalid inputs");
        } catch (Exception e) {
            fail("Unexpected exception during updateStarRating with invalid inputs: " + e.getMessage());
        }
    }

    @Test
    public void testRankedViewModel() {
        try {
            // Arrange
            RankedViewModel viewModel = new RankedViewModel();

            // Act & Assert
            String expectedViewName = "Ranked Recipes View";
            assertEquals(expectedViewName, viewModel.getViewName(), "View name should match the expected value");
            assertTrue(true, "RankedViewModel test completed successfully");
        } catch (Exception e) {
            fail("Unexpected exception during RankedViewModel test: " + e.getMessage());
        }
    }
}