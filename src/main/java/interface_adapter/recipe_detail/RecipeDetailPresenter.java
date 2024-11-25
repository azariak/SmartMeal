package interface_adapter.recipe_detail;

import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.LoggedInState;
import interface_adapter.login.LoginState;
import use_case.login.LoginOutputData;
import use_case.recipe_detail.RecipeDetailOutputBoundary;
import use_case.recipe_detail.RecipeDetailOutputData;

/**
 * The presenter for the Recipe Detail use case.
 */
public class RecipeDetailPresenter implements RecipeDetailOutputBoundary {

    private final RecipeDetailViewModel recipeDetailViewModel;
    private final ViewManagerModel viewManagerModel;

    public RecipeDetailPresenter(RecipeDetailViewModel recipeDetailViewModel, ViewManagerModel viewManagerModel) {
        this.recipeDetailViewModel = recipeDetailViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RecipeDetailOutputData outputData) {
        final RecipeDetailState recipeDetailState = recipeDetailViewModel.getState();
        recipeDetailState.setIngredients(outputData.getTemporaryAdvancedRecipe().getIngredientNames());
        recipeDetailState.setquantities(outputData.getTemporaryAdvancedRecipe().getIngredientQuantities());
        recipeDetailState.setRecipName(outputData.getTemporaryAdvancedRecipe().getRecipeName());
        recipeDetailState.setInstructions(outputData.getTemporaryAdvancedRecipe().getInstructions());
        this.recipeDetailViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errormessage) {

    }
}
