package use_case.ingredient_search;

import data_access.IngredientSearchDataAccessObject;
import entity.GenericRecipe;
import entity.GenericRecipeFactoryInterface;
import entity.GenericResult;
import entity.GenericResultFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    @BeforeEach
    void setUp() {
        mockPresenter = mock(IngredientSearchOutputBoundary.class);
        mockResultFactory = mock(GenericResultFactory.class);
        mockDataAccess = mock(IngredientSearchDataAccessObject.class);

        interactor = new IngredientSearchInteractor(mockPresenter,
                mockResultFactory, mockRecipeFactory, mockDataAccess);

        mockGenericResult = mock(GenericResult.class);
        when(mockGenericRecipe.getName()).thenReturn("name");
        when(mockGenericRecipe.getId()).thenReturn("id");

        mockSearchInput = mock(IngredientSearchInputData.class);

        searchOutputMap = new HashMap<>();
        searchOutputMap.put("name", "id");
        searchOutputMap.put("name2", "id2");
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
    }

    @Test
    void execute() throws IOException {
        ArrayList<GenericRecipe> recipeList = new ArrayList<>();
        recipeList.add(new GenericRecipe("name", "id"));
        recipeList.add(new GenericRecipe("name2", "id2"));

        when(mockDataAccess.excuteSearch(mockSearchInput.getIngredients())).thenReturn(searchOutputMap);

        interactor.execute(mockSearchInput);
        verify(mockPresenter).prepareSuccessView(any(IngredientSearchOutputData.class));
    }

}