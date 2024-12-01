package entity;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Factory for creating recipes.
 */
public interface GenericRecipeFactoryInterface {

    /**
     * Creates a new Generic Recipe.
     * @param name the name of the new recipe.
     * @param id the id of the new recipe.
     * @throws IOException an exception to catch.
     * @return a new GenericRecipe object.
     */
    GenericRecipeInterface createGenericRecipe(String name, String id) throws IOException;

    /**
     * Creates a new Advanced Recipe.
     * @param name the name of the new recipe.
     * @param id the id of the new recipe.
     * @param ingredientNames an arraylist of the ingredient names.
     * @param ingredientQuantities an arraylist of the ingredient quantities.
     * @param instructions a String of instructions.
     * @throws IOException an IO exception.
     * @return the new recipe.
     */
    AdvancedRecipeInterface createAdvancedRecipe(String name,
                                                 String id,
                                                 ArrayList<String> ingredientNames,
                                                 ArrayList<String> ingredientQuantities,
                                                 String instructions) throws IOException;
}
