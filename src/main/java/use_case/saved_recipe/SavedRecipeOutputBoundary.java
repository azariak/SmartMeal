package use_case.saved_recipe;

/**
 * The output boundary for the Saved Recipe Use Case.
 */
public interface SavedRecipeOutputBoundary {
    /**
     * Prepares the success view for the Saved Recipe Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(SavedRecipeOutputData outputData);

    /**
     * Prepares the failure view for the Saved Recipe Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Prepares the failure view for the Load Saved Recipe Use Case.
     * @param recipeName the recipe name.
     * @param recipeCalories the recipe calories.
     * @param recipeDescription the recipe description.
     * @param recipeIngredients the recipe ingredients.
     * @param recipeNutririon the recipe nutrition's.
     */
    void prepareResultView(String recipeName, String recipeCalories, String recipeDescription,
            String recipeIngredients, String recipeNutririon);

    /**
     * Switch to result view.
     */
    void switchToResultView();
}
