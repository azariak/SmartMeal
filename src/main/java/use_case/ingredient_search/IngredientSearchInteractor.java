package use_case.ingredient_search;

import api_adaptors.ApiSearchInputAdaptor;
import api_adaptors.IngredientSearchInputAdaptor;
/**
 * Handles the core logic for searching recipes by ingredients.
 *
 * <p>
 * The IngredientSearchInteractor class implements the ingredient search use case. It processes
 * the input data, performs the search logic, and coordinates with necessary components such as
 * data repositories and output boundaries to produce results. This class is part of the business
 * logic layer and ensures the application logic for ingredient-based recipe searches is executed.
 * </p>
 */

public class IngredientSearchInteractor implements IngredientSearchInputBoundary {

    private final IngredientSearchOutputBoundary ingredientSearchPresenter;
    private final ApiSearchInputAdaptor ingredientSearchInputAdaptor;

    public IngredientSearchInteractor(IngredientSearchDataAccessInterface ingredientSearchDataAccessObject,
                                      IngredientSearchOutputBoundary ingredientSearchOutputBoundary) {

        this.ingredientSearchPresenter = ingredientSearchOutputBoundary;
        this.ingredientSearchInputAdaptor = new IngredientSearchInputAdaptor(ingredientSearchDataAccessObject);
    }

    @Override
    public void execute(IngredientSearchInputData ingredientSearchInputData) {
        ingredientSearchInputAdaptor.inputToApiCall(ingredientSearchInputData.getIngredients());
    }

    @Override
    public void switchToResultView() {
        ingredientSearchPresenter.switchToDemoResultView();
    }
}
