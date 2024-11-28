package entity;

import java.util.ArrayList;
import java.util.Map;

/**
 * An implementation of the Grocery List object.
 */
public class GroceryList {

    private final String id;
    private final ArrayList<Map> groceries;

    public GroceryList(String id, ArrayList<Map> groceries) {
        this.id = id;
        this.groceries = groceries;
    }

    /**
     * Returns the recipe ID associated with the grocery list.
     * @return The ID of the associated grocery.
     */
    public String returnRecipeID() {
        return this.id;
    }

    /**
     * Returns the grocery products associated with the recipe.
     * @return A list of possible grocery products for each ingredient.
     */
    public ArrayList<Map> returnGroceryList() { return this.groceries; }

}
