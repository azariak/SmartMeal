package use_case.load_saved_recipe;

/**
 * Output Data for the load saved recipe Use Case.
 */
public class LoadSavedRecipeOutputData {

    private final String recipeId;
    private final String recipeName;

    /**
     * Constructor to initialize LoadSavedRecipeOutputData with a recipe ID and name.
     *
     * @param recipeId   the unique identifier for the recipe.
     * @param recipeName the name of the recipe.
     */
    public LoadSavedRecipeOutputData(String recipeId, String recipeName) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
    }

    /**
     * Retrieves the ID of the recipe.
     *
     * @return the recipe ID as a String.
     */
    public String getRecipeId() {
        return recipeId;
    }

    /**
     * Retrieves the name of the recipe.
     *
     * @return the recipe name as a String.
     */
    public String getRecipeName() {
        return recipeName;
    }
}
