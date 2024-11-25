package entity;

import java.util.ArrayList;

/**
 * A temporary representation of a recipe in our program.
 */
public interface TemporaryAdvancedRecipeInterface {

    /**
     * A method that returns the recipe name.
     * @return the name of the recipe.
     */
    String getRecipeName();

    /**
     * A method that returns an arraylist of the ingredient names.
     * @return an arraylist of the ingredient names.
     */
    ArrayList<String> getIngredientNames();

    /**
     * A method that returns an arraylist of the ingredient quantities.
     * @return an arraylist of the ingredient quantities.
     */
    ArrayList<String> getIngredientQuantities();

    /**
     * A method that returns a String of the Recipe instructions.
     * @return a String of the recipe instructions.
     */
    String getInstructions();
}
