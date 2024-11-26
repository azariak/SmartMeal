package use_case.ingredient_search;

import java.io.IOException;

/**
 * Defines the input boundary for ingredient search use cases.
 * <p>
 * The IngredientSearchInputBoundary interface provides a contract for implementing
 * ingredient search operations, facilitating the communication between the user interface
 * and the application’s business logic for searching recipes by ingredients.
 * </p>
 */
public interface IngredientSearchInputBoundary {
    /**
     * Executes the ingredient search use case.
     * @param ingredientSearchInputData the input data
     */
    void execute(IngredientSearchInputData ingredientSearchInputData) throws IOException;

    void switchToResultView();
}
