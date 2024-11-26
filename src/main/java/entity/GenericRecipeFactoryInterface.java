package entity;

import use_case.saved_recipe.SavedRecipeDataAcessInterface;

import java.io.IOException;

/**
 * Factory for creating recipes.
 */
public interface GenericRecipeFactoryInterface {
    GenericRecipe createGenericRecipe(String name, String id, SavedRecipeDataAcessInterface recipeSaver) throws IOException;

    /**
     * Creates a new Generic Recipe.
     * @param name the name of the new recipe
     * @param id the id of the new recipe
     * @return the new recipe
     */
    GenericRecipe createGenericRecipe(String name, String id) throws IOException;

    /**
     * Creates a new Advanced Recipe.
     * @param name the name of the new recipe
     * @param id the id of the new recipe
     * @return the new recipe
     */
    AdvancedRecipe createAdvancedRecipe(String name, String id);
}
