package data_access;

import entity.AdvancedRecipeInterface;
import org.json.JSONObject;
import java.util.List;

import use_case.load_saved_recipe.LoadSavedRecipeDataAccessInterface;

/**
 * The DAO for reading the saved recipes in JSON.
 */
public class ReadJson implements LoadSavedRecipeDataAccessInterface {

    @Override
    public void search(AdvancedRecipeInterface recipe) {

    }

    @Override
    public AdvancedRecipeInterface get(String ingredient) {
        return null;
    }

    @Override
    public List<AdvancedRecipeInterface> getAllRecipes() {
        return List.of();
    }

}
