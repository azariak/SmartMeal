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

    @Override
    public GroceryList getRecipeGroceryList(String id) throws IOException {
        final String apiRecipeName = new RecipeIDToServings().getInfo(id).get(1);
        final ArrayList<String> apiIngredientResult = new RecipeIDToIngredients().getFullIngredients(id);
        final String apiServingsResult = new RecipeIDToServings().getInfo(id).get(0);

        final String apiGroceriesInput = "{ \"ingredients\": " + apiIngredientResult.toString() + ", \"servings\": "
                + apiServingsResult + " }";

        final ArrayList<JSONObject> apiGroceriesResult = new IngredientsToGroceries().getGroceries(apiGroceriesInput);
        final GroceryList groceryList = new GroceryList(id, apiRecipeName, apiGroceriesResult);

        return groceryList;
    }

}
