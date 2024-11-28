package use_case.load_saved_recipe;

import org.json.JSONObject;

import entity.AdvancedRecipe;

/**
 * DAO for the Load Saved Recipe Use Case.
 */
public interface LoadSavedRecipeDataAcessInterface {

    /**
     * Search the recipe.
     * @param recipe the user to save
     */
    void search(AdvancedRecipe recipe);

    /**
     * Returns the saved recipe with the given recipe name.
     * @param ingredient the recipe to look up
     * @return the recipe with the given recipe name
     */
    AdvancedRecipe get(String ingredient);

    /**
     * Returns the user with the given username.
     * @param recipeJson the recipe to look up
     * @param fileName the file name.
     */
    void readJson(JSONObject recipeJson, String fileName);

}
