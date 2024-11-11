package use_case.load_saved_recipe;

import entity.Recipe;

/**
 * DAO for the Load Saved Recipe Use Case.
 */
public interface LoadSavedRecipeDataAcessInterface {

    /**
     * Search the recipe.
     * @param recipe the user to save
     */
    void search(Recipe recipe);

    /**
     * Returns the saved recipe with the given recipe name.
     * @param ingredient the username to look up
     * @return the recipe with the given recipe name
     */
    Recipe get(String ingredient);

}
