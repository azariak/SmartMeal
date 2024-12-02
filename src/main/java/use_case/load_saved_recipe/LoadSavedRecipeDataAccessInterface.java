package use_case.load_saved_recipe;

import java.util.List;

import entity.AdvancedRecipeInterface;

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
     * Returns all the recipes as a list.
     */
    List<AdvancedRecipeInterface> getAllRecipes();
}
