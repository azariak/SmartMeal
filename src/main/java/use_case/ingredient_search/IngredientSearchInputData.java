package use_case.ingredient_search;

import java.util.ArrayList;

/**
 * The Input Data for the Ingredient search Use Case.
 */
public class IngredientSearchInputData {

    private final String ingredients;

    public IngredientSearchInputData(ArrayList<String> ingredients) {

        final ArrayList<String> ingredientsArray = new ArrayList<>();

        for (String ingredient : ingredients) {
            if (!"".equals(ingredient)) {
                ingredientsArray.add(ingredient);
            }
        }

        final String convertedIngredients = String.join(",", ingredientsArray);

        this.ingredients = convertedIngredients;
    }

    public String getIngredients() {
        return ingredients;
    }
}
