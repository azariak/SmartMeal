package use_case.load_saved_recipe;

/**
 * Input Boundary for actions which are related to Loading Saved Recipes.
 */
public interface LoadSavedRecipeInputBoundary {

    /**
     * Executes the load saved recipe use case.
     * @param loadsavedrecipeInputData the input data
     */
    void execute(LoadSavedRecipeInputData loadsavedrecipeInputData);

    void switchToResultView();
}
