package interface_adapter.ingredient_search;

import java.io.IOException;
import java.util.ArrayList;

import use_case.ingredient_search.IngredientSearchInputBoundary;
import use_case.ingredient_search.IngredientSearchInputData;

/**
 * The controller for ingredient search use case.
 */
public class IngredientSearchController {

    private final IngredientSearchInputBoundary ingredientSearchUseCaseInteractor;

    public IngredientSearchController(IngredientSearchInputBoundary ingredientSearchUseCaseInteractor) {
        this.ingredientSearchUseCaseInteractor = ingredientSearchUseCaseInteractor;
    }

    /**
     * Executes the ingredient search use Case.
     *
     * @param ingredients a arraylist of ingredients in strings
     */
    public void execute(ArrayList<String> ingredients) throws IOException {
        final IngredientSearchInputData ingredientSearchInputData = new IngredientSearchInputData(
                ingredients);

        ingredientSearchUseCaseInteractor.execute(ingredientSearchInputData);
    }

    /**
     * Executes the "switch to result" Use Case.
     */
    public void switchToResultView() {
        ingredientSearchUseCaseInteractor.switchToResultView();
    }
}
