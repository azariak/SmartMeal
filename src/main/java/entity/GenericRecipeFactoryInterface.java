package entity;

import java.util.ArrayList;

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

    /**
     * Creates a new Temporary Advanced Recipe
     * @param recipeName the name of the new recipe.
     * @param ingredientNames the names of the ingredients for the recipe.
     * @param ingredientQuantities the quantities of the ingredients for the recipe.
     * @param instructions the instructions for the recipe.
     * @return the new recipe.
     */
    TemporaryAdvancedRecipe createTemporaryAdvancedRecipe(String recipeName,
                                                          ArrayList<String> ingredientNames,
                                                          ArrayList<String> ingredientQuantities,
                                                          String instructions);
}
