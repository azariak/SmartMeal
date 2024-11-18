package use_case.non_ingredient_search;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * The Input Data for the non ingredient search use case.
 * (Ingredients to exclude)
 */

public class NonIngredientSearchInputData {

    private final ArrayList<String> nonIngredients;

    public NonIngredientSearchInputData(ArrayList<String> nonIngredients) {
        this.nonIngredients = nonIngredients;
    }

    public ArrayList<String> getNonIngredients() {
        return nonIngredients;
    }
}
