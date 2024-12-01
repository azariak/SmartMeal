package use_case.ingredient_search;

import data_access.IngredientSearchDataAccessObject;
import entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IngredientSearchInteractorTest {

    private IngredientSearchInteractor interactor;
    private IngredientSearchOutputBoundary mockPresenter;
    private GenericRecipeFactoryInterface mockRecipeFactory;
    private GenericResultFactory mockResultFactory;
    private IngredientSearchDataAccessObject mockDataAccess;
    private Result mockResult;
    private GenericRecipeInterface mockGenericRecipe;
    private IngredientSearchInputData mockSearchInput;
    private Map<String, String> searchOutputMap;
    private ArrayList<GenericRecipeInterface> mockRecipeList;

    @BeforeEach
    void setUp() {
        mockPresenter = mock(IngredientSearchOutputBoundary.class);
        mockResultFactory = mock(GenericResultFactory.class);
        mockRecipeFactory = mock(GenericRecipeFactoryInterface.class);
        mockDataAccess = mock(IngredientSearchDataAccessObject.class);

        interactor = new IngredientSearchInteractor(mockPresenter, mockResultFactory, mockRecipeFactory, mockDataAccess);

        mockResult = mock(GenericResult.class);
        mockGenericRecipe = mock(GenericRecipe.class);
        when(mockGenericRecipe.getName()).thenReturn("name");
        when(mockGenericRecipe.getId()).thenReturn("id");

        mockSearchInput = mock(IngredientSearchInputData.class);
        when(mockSearchInput.getIngredients()).thenReturn("ingredient1,ingredient2");

        searchOutputMap = new HashMap<>();
        searchOutputMap.put("name", "id");

        mockRecipeList = new ArrayList<>();
        mockRecipeList.add(mockGenericRecipe);
    }

    @AfterEach
    void tearDown() {
        mockPresenter = null;
        mockResultFactory = null;
        mockDataAccess = null;
        interactor = null;
        mockResult = null;
        mockSearchInput = null;
        searchOutputMap = null;
        mockRecipeList = null;
    }

    @Test
    void execute() throws IOException {
        when(mockDataAccess.excuteSearch(mockSearchInput.getIngredients())).thenReturn(searchOutputMap);
        when(mockRecipeFactory.createGenericRecipe("name", "id")).thenReturn(mockGenericRecipe);
        when(mockResultFactory.createResult(mockRecipeList)).thenReturn(mockResult);

        // Execute the interactor method
        interactor.execute(mockSearchInput);

        // Capture the output data passed to the presenter
        ArgumentCaptor<IngredientSearchOutputData> captor = ArgumentCaptor.forClass(IngredientSearchOutputData.class);
        verify(mockPresenter).prepareSuccessView(captor.capture());

        IngredientSearchOutputData capturedData = captor.getValue();

        // Validate the captured data
        assertNotNull(capturedData);
        assertEquals(mockResult, capturedData.getResult());

        // Verify factory calls
        verify(mockRecipeFactory).createGenericRecipe("name", "id");
        verify(mockResultFactory).createResult(mockRecipeList);

        // Verify data access method was called
        verify(mockDataAccess).excuteSearch(mockSearchInput.getIngredients());

    }
}
