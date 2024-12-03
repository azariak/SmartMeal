package use_case.recipe_detail;

import data_access.RecipeDetailDataAccessObject;
import entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

class RecipeDetailInteractorTest {

    private RecipeDetailInteractor interactor;
    private RecipeDetailOutputBoundary mockPresenter;
    private GenericRecipeFactoryInterface mockFactory;
    private RecipeDetailDataAccessObject mockDataAccess;
    private RecipeDetailInputData inputData;
    private GenericRecipeInterface mockGenericRecipeInterface;

    @BeforeEach
    void setUp() {
        mockPresenter = mock(RecipeDetailOutputBoundary.class);
        mockFactory = mock(GenericRecipeFactoryInterface.class);
        mockDataAccess = mock(RecipeDetailDataAccessObject.class);

        interactor = new RecipeDetailInteractor(mockPresenter, mockFactory, mockDataAccess);

        mockGenericRecipeInterface = mock(GenericRecipe.class);
        when(mockGenericRecipeInterface.getName()).thenReturn("Pancakes");
        when(mockGenericRecipeInterface.getId()).thenReturn("1234");

        inputData = new RecipeDetailInputData(mockGenericRecipeInterface);
    }

    @AfterEach
    void tearDown() {
        interactor = null;
        mockPresenter = null;
        mockFactory = null;
        mockDataAccess = null;
        inputData = null;
        mockGenericRecipeInterface = null;
    }

    @Test
    void execute() throws IOException {
        // Mock data for data access methods
        ArrayList<Integer> ingredientIds = new ArrayList<>();
        ingredientIds.add(1);
        ingredientIds.add(2);

        ArrayList<String> ingredientNames = new ArrayList<>();
        ingredientNames.add("Flour");
        ingredientNames.add("Sugar");

        ArrayList<String> ingredientQuantities = new ArrayList<>();
        ingredientQuantities.add("2 cups");
        ingredientQuantities.add("1 cup");

        String instructions = "Mix all ingredients and cook.";

        // Mock responses
        when(mockDataAccess.getIngredientIds(mockGenericRecipeInterface)).thenReturn(ingredientIds);
        when(mockDataAccess.getIngredientsNames(ingredientIds)).thenReturn(ingredientNames);
        when(mockDataAccess.getQuantities(mockGenericRecipeInterface)).thenReturn(ingredientQuantities);
        when(mockDataAccess.getInstructions(mockGenericRecipeInterface)).thenReturn(instructions);

        AdvancedRecipeInterface mockAdvancedRecipeInterface = mock(AdvancedRecipe.class);
        when(mockFactory.createAdvancedRecipe(
                "Pancakes",
                "1234",
                ingredientNames,
                ingredientQuantities,
                instructions)).thenReturn(mockAdvancedRecipeInterface);

        interactor.execute(inputData);

        verify(mockPresenter).prepareSuccessView(any(RecipeDetailOutputData.class));
    }

    @Test
    void backToLastView() {
        interactor.backToLastView();
        verify(mockPresenter).backToLastView();
    }

//    @Test
//    void goToGroceryView() {
//        interactor.goToGroceryView();
//        verify(mockPresenter, never()).prepareSuccessView(any());
//    }
}
