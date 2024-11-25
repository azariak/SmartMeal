package interface_adapter.recipe_detail;

import interface_adapter.ViewManagerModel;
import interface_adapter.result.ResultViewModel;
import interface_adapter.result.ResultViewState;
import use_case.recipe_detail.RecipeDetailOutputBoundary;
import use_case.recipe_detail.RecipeDetailOutputData;

/**
 * The presenter for the Recipe Detail use case.
 */
public class RecipeDetailPresenter implements RecipeDetailOutputBoundary {

    private final ResultViewModel resultViewModel;
    private final RecipeDetailViewModel recipeDetailViewModel;
    private final ViewManagerModel viewManagerModel;

    public RecipeDetailPresenter(ResultViewModel resultViewModel,
                                 RecipeDetailViewModel recipeDetailViewModel,
                                 ViewManagerModel viewManagerModel) {
        this.resultViewModel = resultViewModel;
        this.recipeDetailViewModel = recipeDetailViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RecipeDetailOutputData outputData) {
        final RecipeDetailState recipeDetailState = recipeDetailViewModel.getState();
        recipeDetailState.setIngredients(outputData.getTemporaryAdvancedRecipe().getIngredientNames());
        recipeDetailState.setQuantities(outputData.getTemporaryAdvancedRecipe().getIngredientQuantities());
        recipeDetailState.setRecipName(outputData.getTemporaryAdvancedRecipe().getRecipeName());
        recipeDetailState.setInstructions(outputData.getTemporaryAdvancedRecipe().getInstructions());
        this.recipeDetailViewModel.setState(recipeDetailState);
        this.recipeDetailViewModel.firePropertyChanged();

        this.viewManagerModel.setState(recipeDetailViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errormessage) {
        final ResultViewState resultViewState = resultViewModel.getState();
        // Tell Nachuan to implement this in lab
        // resultViewState.setResultError(errormessage);
        resultViewModel.firePropertyChanged();
    }
}
