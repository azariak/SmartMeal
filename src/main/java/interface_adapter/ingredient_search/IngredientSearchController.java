package interface_adapter.ingredient_search;

import use_case.ingredient_search.IngredientSearchInputBoundary;
import use_case.ingredient_search.IngredientSearchInputData;

public class IngredientSearchController {

    private final IngredientSearchInputBoundary ingredientSearchUseCaseInteractor;

    public IngredientSearchController(IngredientSearchInputBoundary ingredientSearchUseCaseInteractor) {
        this.ingredientSearchUseCaseInteractor = ingredientSearchUseCaseInteractor;
    }

    /**
     * Executes the Login Use Case.
     * @param ingredient1 ingredient1
     * @param ingredient2 2
     * @param ingredient3 3
     */
    public void execute(String ingredient1, String ingredient2, String ingredient3) {
        final IngredientSearchInputData ingredientSearchInputData = new IngredientSearchInputData(
                ingredient1, ingredient2, ingredient3);

        ingredientSearchUseCaseInteractor.execute(ingredientSearchInputData);
    }

    /**
     * Executes the "switch to LoginView" Use Case.
     */
    public void switchToResultView() {
        ingredientSearchUseCaseInteractor.switchToResultView();
    }
}
