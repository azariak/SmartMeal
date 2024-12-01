package entity;

import java.util.ArrayList;

/**
 * The representation of a result in our program.
 */
public interface Result {

    /**
     * Add an array of recipe entities to result.
     * @param recipeToAdd recipe array.
     */
    void addRecipe(ArrayList<GenericRecipe> recipeToAdd);

    /**
     * Get the list of GenericRecipe store in this result entity.
     * @return an arraylist of recipe.
     */
    ArrayList<GenericRecipe> getRecipes();
}
