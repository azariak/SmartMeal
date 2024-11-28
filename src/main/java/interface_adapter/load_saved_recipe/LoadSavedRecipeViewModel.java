package interface_adapter.load_saved_recipe;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import data_access.FileRecipeSaver;
import entity.AdvancedRecipe;
import entity.GenericRecipe;
import interface_adapter.ViewModel;

/**
 * The View Model for the Load Saved Recipe View.
 */
public class LoadSavedRecipeViewModel extends ViewModel<LoadSavedRecipeState> {
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private final FileRecipeSaver fileRecipeSaver;

    public LoadSavedRecipeViewModel() {
        super("Saved Recipes");
        this.fileRecipeSaver = new FileRecipeSaver();
        setState(new LoadSavedRecipeState());
    }

    /**
     * Saves a recipe with the given ID and name.
     * @param recipe The ID of the recipe.
     */
    public void saveRecipe(AdvancedRecipe recipe) {
        fileRecipeSaver.save(recipe);
    }

    /**
     * Loads a recipe with the given ID and name.
     * @param id The ID of the recipe.
     */
    public GenericRecipe loadRecipe(String id) {
        return fileRecipeSaver.load(id);
    }
}
