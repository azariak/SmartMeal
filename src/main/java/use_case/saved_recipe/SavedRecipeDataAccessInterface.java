package use_case.saved_recipe;

import entity.AdvancedRecipeInterface;
import entity.GenericRecipeInterface;
import org.json.JSONObject;

/**
 * DAO for the Saved Recipe Use Case.
 */
public interface SavedRecipeDataAccessInterface {

    /**
     * Saves the user.
     * @param recipe the user to save
     */
    void save(AdvancedRecipeInterface recipe);

    /**
     * Returns the user with the given username.
     * @param ingredient the recipe to look up
     * @return the recipe with the given recipe name
     */
    AdvancedRecipeInterface get(String ingredient);

    /**
     * Returns the user with the given username.
     * @param recipeJson the recipe to look up
     * @param fileName the file name.
     */
    void saveRecipe(JSONObject recipeJson, String fileName);

    /**
     * Returns the recipe with the given id.
     * @param id the recipe to look up
     */
    GenericRecipeInterface load(String id);

    boolean delete(String recipeName);
}

