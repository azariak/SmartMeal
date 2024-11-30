package use_case.ingredient_search;

import data_access.IngredientSearchDataAccessObject;
import entity.GenericRecipe;
import entity.GenericRecipeFactoryInterface;
import entity.GenericResult;
import entity.GenericResultFactory;
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
    private GenericResult mockGenericResult;
    private GenericRecipe mockGenericRecipe;
    private IngredientSearchInputData mockSearchInput;
    private Map<String, String> searchOutputMap;
    private IngredientSearchOutputData mockOutputData;
    private ArrayList<GenericRecipe> mockRecipeList;

    @BeforeEach
    void setUp() {
        mockPresenter = mock(IngredientSearchOutputBoundary.class);
        mockResultFactory = mock(GenericResultFactory.class);
        mockRecipeFactory = mock(GenericRecipeFactoryInterface.class);
        mockDataAccess = mock(IngredientSearchDataAccessObject.class);

        interactor = new IngredientSearchInteractor(mockPresenter, mockResultFactory, mockRecipeFactory, mockDataAccess);

        mockGenericResult = mock(GenericResult.class);
        mockGenericRecipe = mock(GenericRecipe.class);
        when(mockGenericRecipe.getName()).thenReturn("name");
        when(mockGenericRecipe.getId()).thenReturn("id");

        mockSearchInput = mock(IngredientSearchInputData.class);
        when(mockSearchInput.getIngredients()).thenReturn("ingredient1,ingredient2");

        searchOutputMap = new HashMap<>();
        searchOutputMap.put("name", "id");
        mockOutputData = mock(IngredientSearchOutputData.class);

        mockRecipeList = new ArrayList<>();
        mockRecipeList.add(mockGenericRecipe);
    }

    @AfterEach
    void tearDown() {
        mockPresenter = null;
        mockResultFactory = null;
        mockDataAccess = null;
        interactor = null;
        mockGenericResult = null;
        mockSearchInput = null;
        searchOutputMap = null;
        mockRecipeList = null;
    }

    @Test
    void execute() throws IOException {
        when(mockDataAccess.excuteSearch(mockSearchInput.getIngredients())).thenReturn(searchOutputMap);
        when(mockRecipeFactory.createGenericRecipe("name", "id")).thenReturn(mockGenericRecipe);
        when(mockResultFactory.createGenericResult(mockRecipeList)).thenReturn(mockGenericResult);

        // Execute the interactor method
        interactor.execute(mockSearchInput);

        // Capture the output data passed to the presenter
        ArgumentCaptor<IngredientSearchOutputData> captor = ArgumentCaptor.forClass(IngredientSearchOutputData.class);
        verify(mockPresenter).prepareSuccessView(captor.capture());

        IngredientSearchOutputData capturedData = captor.getValue();

        // Validate the captured data
        assertNotNull(capturedData);
        assertEquals(mockGenericResult, capturedData.getResult());

        // Verify factory calls
        verify(mockRecipeFactory).createGenericRecipe("name", "id");
        verify(mockResultFactory).createGenericResult(mockRecipeList);

        // Verify data access method was called
        verify(mockDataAccess).excuteSearch(mockSearchInput.getIngredients());

    }
}
