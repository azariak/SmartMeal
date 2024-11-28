package use_case.map_groceries;

import java.util.ArrayList;
import java.util.Map;

/**
 * Output Data for the Map Groceries use case.
 */
public class MapGroceriesOutputData {

    private final ArrayList<Map> groceryList;

    public MapGroceriesOutputData(ArrayList<Map> groceryList) {
        this.groceryList = groceryList;
    }

    public ArrayList<Map> getGroceryList() {
        return groceryList;
    }
}
