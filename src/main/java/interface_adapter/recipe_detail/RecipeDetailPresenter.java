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
        recipeDetailState.setRecipeName(outputData.getAdvancedRecipe().getRecipeName());
        recipeDetailState.setIngredients(outputData.getAdvancedRecipe().getIngredientNames());
        recipeDetailState.setQuantities(outputData.getAdvancedRecipe().getIngredientQuantities());
        recipeDetailState.setInstructions(outputData.getAdvancedRecipe().getInstructions());
    }

    @Override
    public void backToLastView() {
        this.viewManagerModel.setState(this.viewManagerModel.getPreviousViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}

