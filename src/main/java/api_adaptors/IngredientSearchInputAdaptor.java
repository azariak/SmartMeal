package api_adaptors;

import java.util.ArrayList;
import java.util.Map;

import use_case.ingredient_search.IngredientSearchDataAccessInterface;

/**
 * The adaptor that converts ingredient search output to api call.
 */
public class IngredientSearchInputAdaptor implements ApiSearchInputAdaptor {
    private final IngredientSearchDataAccessInterface ingredientSearchDataAccessObject;

    public IngredientSearchInputAdaptor(IngredientSearchDataAccessInterface ingredientSearchDataAccessObject) {
        this.ingredientSearchDataAccessObject = ingredientSearchDataAccessObject;
    }

    @Override
    public void inputToApiCall(ArrayList<String> ingredients) {

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
        final Map<String, String> responseID = ingredientSearchDataAccessObject.excuteSearch(ingredients);
        System.out.println(responseID);
        
    }

}
