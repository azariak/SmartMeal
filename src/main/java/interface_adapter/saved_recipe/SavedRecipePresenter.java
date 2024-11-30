package interface_adapter.saved_recipe;

import interface_adapter.ViewManagerModel;
import interface_adapter.load_saved_recipe.LoadSavedRecipeViewModel;
import interface_adapter.result.ResultViewModel;
import use_case.saved_recipe.SavedRecipeOutputBoundary;
import use_case.saved_recipe.SavedRecipeOutputData;

/**
 * The Presenter for the Saved Recipe Use Case.
 */
public class SavedRecipePresenter implements SavedRecipeOutputBoundary {

    private final LoadSavedRecipeViewModel loadSavedRecipeViewModel;
    private final ViewManagerModel viewManagerModel;
    private final ResultViewModel resultViewModel;

    public SavedRecipePresenter(ViewManagerModel viewManagerModel,
                                    LoadSavedRecipeViewModel loadSavedRecipeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loadSavedRecipeViewModel = loadSavedRecipeViewModel;
        this.resultViewModel = new ResultViewModel();

    }

    @Override
    public void prepareSuccessView(SavedRecipeOutputData outputData) {

    }

    @Override
    public void prepareFailView(String errorMessage) {

    }

    @Override
    public void prepareResultView(String recipeName, String recipeCalories, String recipeDescription,
                                  String recipeIngredients, String recipeNutrition) {

    }

    @Override
    public void switchToResultView() {

    }
}
