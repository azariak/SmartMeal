package entity;

import data_access.FileRecipeSaver;

/**
 * The interface for generic recipe entity.
 */
public interface GenericRecipeInterface {

    /**
     * Get recipe name.
     * @return name.
     */
    String getName();

    /**
     * Get recipe ID.
     * @return id.
     */
    String getId();

    /**
     * Save recipes.
     * @param recipeSaver the recipe.
     */
    void save(FileRecipeSaver recipeSaver);
}
