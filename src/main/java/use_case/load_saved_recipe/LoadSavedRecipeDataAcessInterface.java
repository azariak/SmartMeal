package use_case.load_saved_recipe;

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

}
