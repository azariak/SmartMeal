package use_case.map_groceries;

import java.util.ArrayList;
import java.util.Map;

import entity.GroceryList;

/**
 * Output Data for the Map Groceries use case.
 */
public class MapGroceriesOutputData {

    private final GroceryList groceryList;

    public MapGroceriesOutputData(GroceryList groceryList) {
        this.groceryList = groceryList;
    }

    public ArrayList<Map<String, Object>> getGroceryList() {
        return groceryList.returnGroceryList();
    }

    public String getRecipeName() {
        return groceryList.returnRecipeName();
    }

    public String getRecipeID() {
        return groceryList.returnRecipeID();
    }
}
