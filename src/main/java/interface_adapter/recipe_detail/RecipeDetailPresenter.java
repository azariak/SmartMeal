package interface_adapter.recipe_detail;

import interface_adapter.ViewManagerModel;
import interface_adapter.ingredient_substitutions.SubstitutesState;
import interface_adapter.ingredient_substitutions.SubstitutesViewModel;
import use_case.recipe_detail.RecipeDetailOutputBoundary;
import use_case.recipe_detail.RecipeDetailOutputData;

/**
 * The presenter for the Recipe Detail use case.
 */
public class RecipeDetailPresenter implements RecipeDetailOutputBoundary {

    private final RecipeDetailViewModel recipeDetailViewModel;
    private final SubstitutesViewModel substitutesViewModel;
    private final ViewManagerModel viewManagerModel;

    public RecipeDetailPresenter(RecipeDetailViewModel recipeDetailViewModel,
                                 SubstitutesViewModel substitutesViewModel,
                                 ViewManagerModel viewManagerModel) {
        this.recipeDetailViewModel = recipeDetailViewModel;
        this.substitutesViewModel = substitutesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RecipeDetailOutputData outputData) {
        final RecipeDetailState recipeDetailState = recipeDetailViewModel.getState();
        recipeDetailState.setIngredients(outputData.getTemporaryAdvancedRecipe().getIngredientNames());
        recipeDetailState.setQuantities(outputData.getTemporaryAdvancedRecipe().getIngredientQuantities());
        recipeDetailState.setRecipeName(outputData.getTemporaryAdvancedRecipe().getRecipeName());
        recipeDetailState.setInstructions(outputData.getTemporaryAdvancedRecipe().getInstructions());

        final SubstitutesState substitutesState = substitutesViewModel.getState();
        substitutesState.setIngredientName();
    }

    @Override
    public void backToLastView() {
        this.viewManagerModel.setState(this.viewManagerModel.getPreviousViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}

