package use_case.result;

import data_access.IngredientSearchDataAccessObject;
import entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import use_case.ingredient_search.IngredientSearchInputData;
import use_case.ingredient_search.IngredientSearchInteractor;
import use_case.ingredient_search.IngredientSearchOutputBoundary;
import use_case.ingredient_search.IngredientSearchOutputData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class ResultInteractorTest {
    private ResultInteractor interactor;
    private ResultOutputBoundary mockPresenter;
    private GenericRecipeInterface mockGenericRecipe;
    private ResultInputData mockSearchInput;
    private ResultOutputData mockSearchOutput;

    @BeforeEach
    void setUp() {
        mockPresenter = mock(ResultOutputBoundary.class);

        interactor = new ResultInteractor(mockPresenter);

        mockGenericRecipe = mock(GenericRecipe.class);
        when(mockGenericRecipe.getName()).thenReturn("name");
        when(mockGenericRecipe.getId()).thenReturn("id");

        mockSearchInput = mock(ResultInputData.class);
        when(mockSearchInput.getRecipe()).thenReturn(mockGenericRecipe);
    }

    @AfterEach
    void tearDown() {
        mockPresenter = null;

        interactor = null;

        mockGenericRecipe = null;

        mockSearchInput = null;
    }

    @Test
    void execute() {

        // Execute the interactor method
        interactor.execute(mockSearchInput);

        // Capture the output data passed to the presenter
        ArgumentCaptor<ResultOutputData> captor = ArgumentCaptor.forClass(ResultOutputData.class);
        verify(mockPresenter).prepareRecipeDetailView(captor.capture());

        ResultOutputData capturedData = captor.getValue();

        // Validate the captured data
        assertNotNull(capturedData);
        assertEquals(mockGenericRecipe, capturedData.getGenericRecipe());
    }
}