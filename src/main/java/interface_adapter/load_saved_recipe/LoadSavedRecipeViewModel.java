package interface_adapter.load_saved_recipe;

import java.beans.PropertyChangeSupport;
import java.util.List;

import data_access.FileRecipeSaver;
import entity.AdvancedRecipeInterface;
import entity.GenericRecipeInterface;
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
    public void saveRecipe(AdvancedRecipeInterface recipe) {
        fileRecipeSaver.save(recipe);
    }

    /**
     * Loads a recipe with the given ID and name.
     * @param id The ID of the recipe.
     */
    public GenericRecipeInterface loadRecipe(String id) {
        return fileRecipeSaver.load(id);
    }

    public List<String> getRecipeList() {
        return null;
    }

}
