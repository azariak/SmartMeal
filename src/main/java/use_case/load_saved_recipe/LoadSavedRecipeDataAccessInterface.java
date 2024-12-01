package use_case.load_saved_recipe;

import entity.AdvancedRecipeInterface;
import org.json.JSONObject;

/**
 * DAO for the Load Saved Recipe Use Case.
 */
public interface LoadSavedRecipeDataAccessInterface {

    /**
     * Search the recipe.
     * @param recipe the user to save
     */
    void search(AdvancedRecipeInterface recipe);

    /**
     * Returns the saved recipe with the given recipe name.
     * @param ingredient the recipe to look up
     * @return the recipe with the given recipe name
     */
    AdvancedRecipeInterface get(String ingredient);

    /**
     * Returns the user with the given username.
     * @param recipeJson the recipe to look up
     * @param fileName the file name.
     */
    void readJson(JSONObject recipeJson, String fileName);

}
