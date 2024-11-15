package interface_adapter.load_saved_recipe;

import interface_adapter.ViewModel;

/**
 * The View Model for the Load Saved Recipe View.
 */
public class LoadSavedRecipeViewModel extends ViewModel<LoadSavedRecipeState> {

    public LoadSavedRecipeViewModel() {
        super("Saved Recipes");
        setState(new LoadSavedRecipeState());
    }
}
