package use_case.saved_recipe;

import org.json.JSONObject;

import entity.AdvancedRecipe;

/**
 * DAO for the Saved Recipe Use Case.
 */
public interface SavedRecipeDataAcessInterface {

    /**
     * Saves the user.
     * @param recipe the user to save
     */
    void save(AdvancedRecipe recipe);

    /**
     * Returns the user with the given username.
     * @param ingredient the recipe to look up
     * @return the recipe with the given recipe name
     */
    AdvancedRecipe get(String ingredient);

    /**
     * Returns the user with the given username.
     * @param recipeJson the recipe to look up
     * @param fileName the file name.
     */
    void saveRecipe(JSONObject recipeJson, String fileName);
}

