package interface_adapter.load_saved_recipe;

import use_case.load_saved_recipe.LoadSavedRecipeInputBoundary;
import use_case.load_saved_recipe.LoadSavedRecipeInputData;

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
     */
    public void loadRecipes(String recipe1, String recipe2, String recipe3) {

    }

    /**
     * Delete the saved recipes.
     */

//    public boolean deleteRecipe(String recipeName) {
//        // Call the use case or repository to delete the recipe
//        return viewModel.getRecipeRepository().delete(recipeName);
//    }
}
