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
     * Prepares the failure view for the Recipe Detail Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
