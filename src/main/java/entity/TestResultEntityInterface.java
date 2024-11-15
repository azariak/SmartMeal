package entity;

import java.util.ArrayList;
import java.util.Map;

/**
 * A test of result entity.
 */
public interface TestResultEntityInterface {

    /**
     * Get name.
     * @return name
     */
    String getName();

    /**
     * Get image.
     * @return string of url
     */
    String getImage();

    /**
     * Get properties.
     * @return get properties of the recipe as a map
     */
    Map<String, String> getProperties();

    /**
     * Get ingredients.
     * @return A arraylist of ingredient name.
     */
    ArrayList<String> getIngredients();

    /**
     * Get ingredient amount.
     * @return A map of ingredient names for amount
     */
    Map<String, String> getIngredientAmount();

    /**
     * Get the steps of recipe.
     * @return Arraylist of steps for the recipe, with the first step at index 0.
     */
    ArrayList<String> getSteps();

}
