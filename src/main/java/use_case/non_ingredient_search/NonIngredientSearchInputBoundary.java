package use_case.non_ingredient_search;

/**
 * Defines the input boundary for non ingredient search use cases.
 * <p>
 * The NonIngredientSearchInputBoundary provides a process for implementing
 * non-ingredient search operations.
 * </p>
 */
public interface NonIngredientSearchInputBoundary {
    /**
     * Executes the non ingredient search use case.
     * @param nonIngredientSearchInputData -> Yhe input data
     */
    void execute(NonIngredientSearchInputData nonIngredientSearchInputData);

    void switchToResultView();
}
