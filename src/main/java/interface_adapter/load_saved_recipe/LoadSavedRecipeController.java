package interface_adapter.load_saved_recipe;

import use_case.load_saved_recipe.LoadSavedRecipeInputBoundary;
import use_case.load_saved_recipe.LoadSavedRecipeInputData;

import java.awt.*;

/**
 * The controller for the Login Use Case.
 */
public class LoadSavedRecipeController {

    private final LoadSavedRecipeInputBoundary loadSavedRecipeUseCaseInteractor;

    public LoadSavedRecipeController(LoadSavedRecipeInputBoundary loadSavedRecipeUseCaseInteractor) {
        this.loadSavedRecipeUseCaseInteractor = loadSavedRecipeUseCaseInteractor;
    }

    /**
     * Executes the Load Saved Recipe Use Case.
     * @param recipe1 recipe1
     * @param recipe2 2
     * @param recipe3 3
     */

    public void execute(String recipe1, String recipe2, String recipe3) {
        final LoadSavedRecipeInputData loadSavedRecipeInputData = new LoadSavedRecipeInputData(
                recipe1, recipe2, recipe3);

        loadSavedRecipeUseCaseInteractor.execute(loadSavedRecipeInputData);
    }
    /**
     * Executes the "switch to LoadSavedRecipe" Use Case.
     */

    public void switchToResultView() {
        loadSavedRecipeUseCaseInteractor.switchToResultView();
    }

    /**
     * Load the saved recipes.
     * @param recipe1 recipe1.
     * @param recipe2 recipe2.
     * @param recipe3 recipe3.
     */
    public void loadRecipes(String recipe1, String recipe2, String recipe3) {
    }

//    /**
//     * Fetches all saved recipes and updates the ViewModel.
//     */
//    public void loadAllSavedRecipes() {
//        final List<String> savedRecipes = loadSavedRecipeUseCaseInteractor.getAllSavedRecipes();
//        // Update the ViewModel (assumes you have a reference to it)
//        // This step may vary depending on your framework.
//        final LoadSavedRecipeViewModel viewModel = loadSavedRecipeUseCaseInteractor.getViewModel();
//        viewModel.setRecipeList(savedRecipes);
//    }

    /**
     * Back button.
     */
    public void backToLastView() {
        loadSavedRecipeUseCaseInteractor.backToLastView();
    }
}
