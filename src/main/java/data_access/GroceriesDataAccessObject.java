package data_access;

import java.io.IOException;

import entity.GroceryList;
import org.json.JSONObject;
import use_case.map_groceries.MapGroceriesDataAccessInterface;

import java.util.ArrayList;

/**
 * The data access object for the Map Groceries use case.
 */
/* public class GroceriesDataAccessObject implements MapGroceriesDataAccessInterface {

    @Override
    public GroceryList getRecipeGroceryList(String id) throws IOException {
        final ArrayList<JSONObject> apiIngredientResult = new RecipeIDToIngredients().getFullIngredients(id);
        final GroceryList groceryList = new GroceryList(id, );
    }

} */
