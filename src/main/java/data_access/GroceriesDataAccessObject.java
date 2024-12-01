package data_access;

import java.io.IOException;

import entity.GroceryList;
import org.json.JSONObject;
import use_case.map_groceries.MapGroceriesDataAccessInterface;

import java.util.ArrayList;

/**
 * The data access object for the Map Groceries use case.
 */
public class GroceriesDataAccessObject implements MapGroceriesDataAccessInterface {
    private final ApiAccessKeyManagerInterface accessKeyManagerInterface;

    public GroceriesDataAccessObject(ApiAccessKeyManagerInterface accessKeyManagerInterface) {
        this.accessKeyManagerInterface = accessKeyManagerInterface;
    }

    @Override
    public GroceryList getRecipeGroceryList(String id) throws IOException {

        final String apiRecipeName = RecipeIDToServings.getInfo(id, accessKeyManagerInterface).get(1);
        final ArrayList<String> apiIngredientResult = RecipeIDToIngredients.getFullIngredients(id, accessKeyManagerInterface);
        final String apiServingsResult = RecipeIDToServings.getInfo(id, accessKeyManagerInterface).get(0);

        final String apiGroceriesInput = "{ \"ingredients\": " + apiIngredientResult.toString() + ", \"servings\": "
                + apiServingsResult + " }";

        final ArrayList<JSONObject> apiGroceriesResult = IngredientsToGroceries.getGroceries(apiGroceriesInput, accessKeyManagerInterface);
        return new GroceryList(id, apiRecipeName, apiGroceriesResult);

    }

}
