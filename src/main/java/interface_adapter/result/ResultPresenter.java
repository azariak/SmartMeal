package interface_adapter.result;

import interface_adapter.ViewManagerModel;
import interface_adapter.recipe_detail.RecipeDetailState;
import interface_adapter.recipe_detail.RecipeDetailViewModel;
import use_case.result.ResultOutputBoundary;
import use_case.result.ResultOutputData;

public class ResultPresenter implements ResultOutputBoundary {
    private final RecipeDetailViewModel recipeDetailViewModel;
    private final ViewManagerModel viewManagerModel;

    public ResultPresenter(RecipeDetailViewModel recipeDetailViewModel, ViewManagerModel viewManagerModel) {
        this.recipeDetailViewModel = recipeDetailViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareRecipeDetailView(ResultOutputData resultOutputData) {
        final RecipeDetailState recipeDetailState = RecipeDetailViewModel.getState();
        recipeDetailState.setRecipe(resultOutputData.getRecipe());
        this.recipeDetailViewModel.setState(recipeDetailState);
        this.recipeDetailViewModel.firePropertyChanged();

        this.viewManagerModel.setState(recipeDetailViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
