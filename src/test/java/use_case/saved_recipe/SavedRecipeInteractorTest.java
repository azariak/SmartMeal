package use_case.saved_recipe;

import data_access.InMemoryUserDataAccessObject;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class SavedRecipeInteractorTest {

    @Test
    void testExecute_ValidInput() {
        InMemoryUserDataAccessObject mockDataAccessObject = mock(InMemoryUserDataAccessObject.class);
        SavedRecipeOutputBoundary mockPresenter = mock(SavedRecipeOutputBoundary.class);
        SavedRecipeInputData mockInputData = mock(SavedRecipeInputData.class);

        when(mockInputData.getRecipeName()).thenReturn("Pasta");
        when(mockInputData.getRecipeCalories()).thenReturn("400");
        when(mockInputData.getRecipeDescription()).thenReturn("Delicious pasta with tomato sauce");
        when(mockInputData.getRecipeIngredients()).thenReturn("Tomato, Pasta, Garlic");
        when(mockInputData.getRecipeNutrition()).thenReturn("High in Carbs");

        SavedRecipeInteractor interactor = new SavedRecipeInteractor(mockDataAccessObject, mockPresenter);
        interactor.execute(mockInputData);
        verify(mockPresenter).prepareResultView(
                "Pasta",
                "400",
                "Delicious pasta with tomato sauce",
                "Tomato, Pasta, Garlic",
                "High in Carbs"
        );
        verifyNoInteractions(mockDataAccessObject);
    }

    @Test
    void testExecute_NullInput() {
        InMemoryUserDataAccessObject mockDataAccessObject = mock(InMemoryUserDataAccessObject.class);
        SavedRecipeOutputBoundary mockPresenter = mock(SavedRecipeOutputBoundary.class);
        SavedRecipeInputData mockInputData = mock(SavedRecipeInputData.class);

        when(mockInputData.getRecipeName()).thenReturn(null);
        when(mockInputData.getRecipeCalories()).thenReturn(null);
        when(mockInputData.getRecipeDescription()).thenReturn(null);
        when(mockInputData.getRecipeIngredients()).thenReturn(null);
        when(mockInputData.getRecipeNutrition()).thenReturn(null);

        SavedRecipeInteractor interactor = new SavedRecipeInteractor(mockDataAccessObject, mockPresenter);
        interactor.execute(mockInputData);
        verify(mockPresenter).prepareResultView(null, null, null,
                null, null);
        verifyNoInteractions(mockDataAccessObject);
    }

    @Test
    void testSwitchToResultView() {
        InMemoryUserDataAccessObject mockDataAccessObject = mock(InMemoryUserDataAccessObject.class);
        SavedRecipeOutputBoundary mockPresenter = mock(SavedRecipeOutputBoundary.class);

        SavedRecipeInteractor interactor = new SavedRecipeInteractor(mockDataAccessObject, mockPresenter);
        interactor.switchToResultView();
        verify(mockPresenter).switchToResultView();
        verifyNoInteractions(mockDataAccessObject);
    }
}
