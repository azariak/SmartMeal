package use_case.recipe_detail;

import java.util.ArrayList;

import entity.GenericRecipe;

/**
 * The interface for the Recipe Detail data access object.
 */
public interface RecipeDetailDataAccessInterface {

    /**
     * Given a generic recipe with the recipe name and id, get the ingredients for that recipe.
     * @param genericRecipe the generic recipe object with the recipe name and id.
     * @return the ingredients for that recipe as a String.
     */
    ArrayList<Integer> getIngredientIds(GenericRecipe genericRecipe);

    /**
     * Takes an arraylist of ingredient Ids and returns an arraylist of the names of those ingredients.
     * @param ingredientIds is an arraylist of ingredientIDS
     * @return an arraylist of ingredient Names for each ingredient id
     */
    ArrayList<String> getIngredientsNames(ArrayList<Integer> ingredientIds);

    /**
     * Takes in a list of ingredients and gets the quantities for them.
     * @param genericRecipe is the generic recipe object.
     * @return an arraylist of Quantities for each ingredient.
     */
    ArrayList<String> getQuantities(GenericRecipe genericRecipe);

    /**
     * Takes in a Generic Recipe objects and returns the instructions for that recipe.
     * @param genericRecipe the generic recipe object with the recipe name and id.
     * @return the instructions for that recipe as a String.
     */
    String getInstructions(GenericRecipe genericRecipe);

}
