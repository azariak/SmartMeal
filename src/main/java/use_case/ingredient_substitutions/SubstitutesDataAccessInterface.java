package use_case.ingredient_substitutions;

import java.util.ArrayList;

/**
 * The data access interface for the ingredient substitutes use case.
 */
public interface SubstitutesDataAccessInterface {
    /**
     * Given an ingredient name, get the substitute ingredients for that ingredient.
     * @param ingredientName is the name of the ingredient you want to find substitutes for.
     * @return the substitue ingredients for that ingredient as an ArrayList
     */
    ArrayList<String> getIngredientSubstitutes(String ingredientName);
}
