package use_case.ingredient_search;

public interface IngredientSearchInputBoundary {
    /**
     * Executes the ingredient search use case.
     * @param ingredientSearchInputData the input data
     */
    void execute(IngredientSearchInputData ingredientSearchInputData);

    void switchToResultView();
}
