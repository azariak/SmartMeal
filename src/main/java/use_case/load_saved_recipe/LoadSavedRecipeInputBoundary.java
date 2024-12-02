package use_case.load_saved_recipe;

import entity.AdvancedRecipeInterface;

import java.util.List;

/**
 * Input Boundary for actions which are related to Loading Saved Recipes.
 */
public interface LoadSavedRecipeInputBoundary {

    /**
     * Executes the load saved recipe use case.
     * @param loadsavedrecipeInputData the input data
     */
    void execute(LoadSavedRecipeInputData loadsavedrecipeInputData);

    /**
     * Switch to result view.
     */
    void switchToResultView();

    /**
     * Back to last view.
     */
    void backToLastView();

    /**
     * Get all Recipes.
     */
    List<AdvancedRecipeInterface> getAllRecipes();
}
