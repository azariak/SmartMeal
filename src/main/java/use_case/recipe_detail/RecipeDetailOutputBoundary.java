package use_case.recipe_detail;

/**
 * The OutputBoundary for the Recipe Detail use case.
 */
public interface RecipeDetailOutputBoundary {
    /**
     * Prepares the success view for the Recipe Detail Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(RecipeDetailOutputData outputData);

    /**
     * Back to last view.
     */
    void backToLastView();
}
