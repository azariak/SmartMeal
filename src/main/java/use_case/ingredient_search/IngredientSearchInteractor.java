package use_case.ingredient_search;

import data_access.InMemoryUserDataAccessObject;
/**
 * Handles the core logic for searching recipes by ingredients.
 * <p>
 * The IngredientSearchInteractor class implements the ingredient search use case. It processes
 * the input data, performs the search logic, and coordinates with necessary components such as
 * data repositories and output boundaries to produce results. This class is part of the business
 * logic layer and ensures the application logic for ingredient-based recipe searches is executed.
 * </p>
 */

public class IngredientSearchInteractor implements IngredientSearchInputBoundary {
    private final InMemoryUserDataAccessObject ingredientSearchDataAccessObject;
    private final IngredientSearchOutputBoundary ingredientSearchPresenter;

    public IngredientSearchInteractor(InMemoryUserDataAccessObject ingredientSearchDataAccessObject,
                                      IngredientSearchOutputBoundary ingredientSearchOutputBoundary) {

        this.ingredientSearchDataAccessObject = ingredientSearchDataAccessObject;
        this.ingredientSearchPresenter = ingredientSearchOutputBoundary;
    }

    @Override
    public void execute(IngredientSearchInputData ingredientSearchInputData) {
        ingredientSearchPresenter.prepareApiCall(ingredientSearchInputData);
    }

    @Override
    public void switchToResultView() {
        ingredientSearchPresenter.switchToDemoResultView();
    }
}
