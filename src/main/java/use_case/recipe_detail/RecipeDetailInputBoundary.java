package use_case.recipe_detail;

/**
 * Input Boundary for actions which are related to seeing Recipe Detail information.
 */
public interface RecipeDetailInputBoundary {

    /**
     * Executes the Recipe Detail Use Case.
     * @param recipeDetailInputData the input data.
     */
    void execute(RecipeDetailInputData recipeDetailInputData);

    /**
     * Back to last view.
     */
    void backToLastView();
}
