package use_case.map_groceries;

//  import data_access.GroceriesDataAccessObject;
import entity.GroceryList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * The DAO for MapGroceries use case.
 */
public interface MapGroceriesDataAccessInterface {
    /**
     * Given a recipe id, get the grocery list for that recipe.
     * @param id is the recipes' id.
     * @return the grocery list in the form of a GroceryList entity.
     * @throws IOException if API call fails.
     */

    GroceryList getRecipeGroceryList(String id) throws IOException;
}
