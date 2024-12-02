package use_case.load_saved_recipe;

import data_access.FileRecipeSaver;
import data_access.InMemoryUserDataAccessObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class LoadSavedRecipeInteractorTest {

    @Test
    void testExecute() {
        // Arrange
        LoadSavedRecipeDataAccessInterface mockDataAccessObject = mock(LoadSavedRecipeDataAccessInterface.class);
        LoadSavedRecipeOutputBoundary mockPresenter = mock(LoadSavedRecipeOutputBoundary.class);

        LoadSavedRecipeInteractor interactor = new LoadSavedRecipeInteractor((FileRecipeSaver) mockDataAccessObject, mockPresenter);
        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData("Recipe1", "Recipe2", "Recipe3");
        interactor.execute(inputData);
        verify(mockPresenter).prepareResultView("Recipe1", "Recipe2", "Recipe3");
        verifyNoInteractions(mockDataAccessObject);
    }

    @Test
    void testSwitchToResultView() {
        LoadSavedRecipeDataAccessInterface mockDataAccessObject = mock(LoadSavedRecipeDataAccessInterface.class);
        LoadSavedRecipeOutputBoundary mockPresenter = mock(LoadSavedRecipeOutputBoundary.class);

        LoadSavedRecipeInteractor interactor = new LoadSavedRecipeInteractor((FileRecipeSaver) mockDataAccessObject, mockPresenter);
        interactor.switchToResultView();
        verify(mockPresenter).switchToResultView();
        verifyNoInteractions(mockDataAccessObject);
    }

    @Test
    void testBackToLastView() {
        LoadSavedRecipeDataAccessInterface mockDataAccessObject = mock(LoadSavedRecipeDataAccessInterface.class);
        LoadSavedRecipeOutputBoundary mockPresenter = mock(LoadSavedRecipeOutputBoundary.class);

        LoadSavedRecipeInteractor interactor = new LoadSavedRecipeInteractor((FileRecipeSaver) mockDataAccessObject, mockPresenter);
        interactor.backToLastView();
        verify(mockPresenter).backToLastView();
        verifyNoInteractions(mockDataAccessObject);
    }
}
