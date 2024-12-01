package data_access;

import java.util.List;

import entity.AdvancedRecipe;
import use_case.load_saved_recipe.LoadSavedRecipeDataAccessInterface;

/**
 * The DAO for reading the saved recipes in JSON.
 */
public class ReadJson implements LoadSavedRecipeDataAccessInterface {

    @Override
    public void search(AdvancedRecipe recipe) {

    }

    @Override
    public AdvancedRecipe get(String ingredient) {
        return null;
    }

    @Override
    public List<AdvancedRecipe> getAllRecipes() {
        return List.of();
    }

}
