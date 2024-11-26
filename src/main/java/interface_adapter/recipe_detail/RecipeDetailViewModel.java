package interface_adapter.recipe_detail;

import interface_adapter.ViewModel;

/**
 * ViewModel for the RecipeDetailView.
 * Encapsulates the data required to render the RecipeDetailView.
 */
public class RecipeDetailViewModel extends ViewModel<RecipeDetailState> {
    public RecipeDetailViewModel() {
        super("Recipe Detail");
        setState(new RecipeDetailState());
    }

}
