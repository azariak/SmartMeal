package use_case.load_saved_recipe;

import interface_adapter.load_saved_recipe.LoadSavedRecipeViewModel;

import java.awt.*;

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

//    /**
//     * Deletes the selected recipe.
//     * @param selectedRecipe the selected recipe.
//     */
//    void deleteRecipe(String selectedRecipe);
//
//    LoadSavedRecipeViewModel getViewModel();
}
