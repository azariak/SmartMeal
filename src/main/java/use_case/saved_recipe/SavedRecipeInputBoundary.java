package use_case.saved_recipe;

/**
 * Input Boundary for actions which are related to saving a recipe.
 */
public interface SavedRecipeInputBoundary {

    /**
     * Executes the saved recipe use case.
     * @param savedrecipeInputData the input data
     */
    void execute(SavedRecipeInputData savedrecipeInputData);

    void switchToResultView();
}
