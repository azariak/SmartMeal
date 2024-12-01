package use_case.recipe_detail;

import java.io.IOException;

/**
 * Input Boundary for actions which are related to seeing Recipe Detail information.
 */
public interface RecipeDetailInputBoundary {

    /**
     * Executes the Recipe Detail Use Case.
     * @param recipeDetailInputData the input data.
     * @throws IOException the IOException.
     */
    void execute(RecipeDetailInputData recipeDetailInputData) throws IOException;

    /**
     * Back to last view.
     */
    void backToLastView();

    /**
     * Switch to map groceries view.
     */
    void goToGroceryView();

}
