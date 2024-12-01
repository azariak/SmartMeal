package use_case.load_saved_recipe;

import entity.GenericRecipeInterface;

/**
 * Output Data for the load saved recipe Use Case.
 */
public class LoadSavedRecipeOutputData {

    private final GenericRecipeInterface recipeId;
    private final GenericRecipeInterface recipeName;
    private final boolean useCaseFailed;

    /**
     * Constructor to initialize LoadSavedRecipeOutputData with a recipe ID and name.
     *
     * @param recipeId   the unique identifier for the recipe.
     * @param recipeName the name of the recipe.
     * @param useCaseFailed when failed.
     */
    public LoadSavedRecipeOutputData(GenericRecipeInterface recipeId,
                                     GenericRecipeInterface recipeName, boolean useCaseFailed) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Retrieves the ID of the recipe.
     *
     * @return the recipe ID as a String.
     */
    public GenericRecipeInterface getRecipeId() {
        return recipeId;
    }

    /**
     * Retrieves the name of the recipe.
     *
     * @return the recipe name as a String.
     */
    public GenericRecipeInterface getRecipeName() {
        return recipeName;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
