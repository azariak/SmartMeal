package use_case.map_groceries;

/**
 * The Input Data for the Map Groceries Use Case.
 */
public class MapGroceriesInputData {

    private final String id;

    public MapGroceriesInputData(String id) {
        this.id = id;
    }

    String getID() {
        return id;
    }
}
