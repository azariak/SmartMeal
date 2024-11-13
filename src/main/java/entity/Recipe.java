package entity;

/**
 * The representation of a recipe in our program.
 */
public interface Recipe {
    /**
     * Returns the ingredients of the recipe.
     * @return the username of the user.
     */
    String getingrediants();

    /**
     * Returns the nutrition of the recipe.
     * @return the nutrition of the recipe.
     */
    String getnutrition();

    /**
     * Returns the name of the recipe.
     * @return the name of the recipe.
     */
    String getrecipename();

    /**
     * Returns the cooking time of the recipe.
     * @return the cooking time of the recipe.
     */
    int getcooktime();

    /**
     * Returns a similar recipe to the recipe.
     * @return a similar recipe to the recipe.
     */
    String getsimilarrecipe();

}
