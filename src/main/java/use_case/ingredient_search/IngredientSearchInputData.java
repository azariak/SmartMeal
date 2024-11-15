package use_case.ingredient_search;

import java.util.ArrayList;

/**
 * The Input Data for the Ingredient search Use Case.
 */
public class IngredientSearchInputData {

    private final ArrayList<String> ingredients;

    public IngredientSearchInputData(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }
}
