package api_adaptors;

import java.util.ArrayList;
import java.util.Map;

import data_access.IngredientsToRecipeID;

/**
 * The adaptor that converts ingredient search output to api call.
 */
public class IngredientSearchAdaptor implements IngredientSearchAdaptorBoundary {
    @Override
    public void ingredientSearchToApiCall(ArrayList<String> ingredients) {

        final ArrayList<String> ingredientsArray = new ArrayList<>();

        for (String ingredient : ingredients) {
            if (!"".equals(ingredient)) {
                ingredientsArray.add(ingredient);
            }
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
