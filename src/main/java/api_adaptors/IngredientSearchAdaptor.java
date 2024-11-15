package api_adaptors;

import java.util.ArrayList;
import java.util.Map;

import data_access.IngredientsToRecipeID;

/**
 * The adaptor that converts ingredient search output to api call.
 */
public class IngredientSearchAdaptor implements IngredientSearchAdaptorBoundary {
    @Override
    public void ingredientSearchToApiCall(String ingredient1, String ingredient2, String ingredient3) {

        final ArrayList<String> ingredientsArray = new ArrayList<>();

        if (!"".equals(ingredient1)) {
            ingredientsArray.add(ingredient1);
        }
        if (!"".equals(ingredient2)) {
            ingredientsArray.add(ingredient2);
        }
        if (!"".equals(ingredient3)) {
            ingredientsArray.add(ingredient3);
        }

        final String output = String.join(",", ingredientsArray);
        System.out.println(output);

        excuteApiCall(output);
    }

    @Override
    public void excuteApiCall(String ingredients) {
        final Map<String, Integer> responseID = IngredientsToRecipeID.ingredientsToRecipeID(ingredients);
        System.out.println(responseID);
        
    }

}
