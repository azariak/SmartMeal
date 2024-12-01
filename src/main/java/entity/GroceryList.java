package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

/**
 * An implementation of the Grocery List object.
 */
public class GroceryList {

    private final String id;
    private final String recipeName;
    private final ArrayList<Map<String, Object>> groceries;

    public GroceryList(String id, String recipeName, ArrayList<JSONObject> groceries) {
        // Save recipe id.
        this.id = id;
        // Save recipe name.
        this.recipeName = recipeName;
        // Convert the JSONObject provided by the API call to an accessible Array.
        this.groceries = new ArrayList<>();
        for (JSONObject item : groceries) {
            final Map<String, Object> newMap = new HashMap<>();
            final Set<String> keys = item.keySet();
            for (String key : keys) {
                final Object details = item.get(key);
                newMap.put(key, details);
            }
            this.groceries.add(newMap);
        }

    }

    /**
     * Returns the recipe ID associated with the grocery list.
     * @return The ID of the associated grocery.
     */
    public String returnRecipeID() {
        return this.id;
    }

    /** Returns recipe name.
     * @return the recipe name.
     */
    public String returnRecipeName() {
        return this.recipeName;
    }

    /**
     * Returns the grocery products associated with the recipe.
     * @return A list of possible grocery products for each ingredient.
     */
    public ArrayList<Map<String, Object>> returnGroceryList() {
        return this.groceries;
    }

}
