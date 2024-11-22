package entity;

/**
 * Factory for creating recipes.
 */
public interface GenericRecipeFactoryInterface {
    /**
     * Creates a new Generic Recipe.
     * @param name the name of the new recipe
     * @param id the id of the new recipe
     * @return the new recipe
     */
    GenericRecipe createGenericRecipe(String name, String id);

    /**
     * Creates a new Advanced Recipe.
     * @param name the name of the new recipe
     * @param id the id of the new recipe
     * @return the new recipe
     */
    AdvancedRecipe createAdvancedRecipe(String name, String id);
}
