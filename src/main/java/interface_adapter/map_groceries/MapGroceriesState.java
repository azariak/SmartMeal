package interface_adapter.map_groceries;

import entity.GroceryList;

import java.util.ArrayList;
import java.util.Map;

/**
 * The state for the map groceries view model.
 */
public class MapGroceriesState {
    private String recipeName;
    private String recipeID;
    private ArrayList<Map<String, Object>> groceries = new ArrayList<>();

    /**
     * Sets recipe name to be displayed on map groceries view.
     * @param recipeName The name of the recipe.
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeID(String id) {
        this.recipeID = id;
    }

    public String getRecipeID() {
        return recipeID;
    }

    public void setGroceries(ArrayList<Map<String, Object>> groceries) {
        this.groceries = groceries;
    }

    public ArrayList<Map<String, Object>> getGroceries() {
        return groceries;
    }
}
