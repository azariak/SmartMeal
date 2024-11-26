package interface_adapter.recipe_detail;

import interface_adapter.ViewManagerModel;
import use_case.recipe_detail.RecipeDetailOutputBoundary;
import use_case.recipe_detail.RecipeDetailOutputData;

/**
 * The presenter for the Recipe Detail use case.
 */
public class RecipeDetailPresenter implements RecipeDetailOutputBoundary {

    private final RecipeDetailViewModel recipeDetailViewModel;
    private final ViewManagerModel viewManagerModel;

    public RecipeDetailPresenter(RecipeDetailViewModel recipeDetailViewModel,
                                 ViewManagerModel viewManagerModel) {
        this.recipeDetailViewModel = recipeDetailViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RecipeDetailOutputData outputData) {
        final RecipeDetailState recipeDetailState = recipeDetailViewModel.getState();
        recipeDetailState.setIngredients(outputData.getTemporaryAdvancedRecipe().getIngredientNames());
        recipeDetailState.setQuantities(outputData.getTemporaryAdvancedRecipe().getIngredientQuantities());
        recipeDetailState.setRecipeName(outputData.getTemporaryAdvancedRecipe().getRecipeName());
        recipeDetailState.setInstructions(outputData.getTemporaryAdvancedRecipe().getInstructions());
        this.recipeDetailViewModel.setState(recipeDetailState);
        this.recipeDetailViewModel.firePropertyChanged();

        this.viewManagerModel.setState(recipeDetailViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}

