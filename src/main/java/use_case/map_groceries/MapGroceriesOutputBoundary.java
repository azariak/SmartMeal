package use_case.map_groceries;

/**
 * The output boundary for the Map Groceries use case.
 */
public interface MapGroceriesOutputBoundary {
    /**
     * Prepares the Details view for the Map Groceries use case.
     * @param outputData the output data.
     */
    void prepareGroceriesView(MapGroceriesOutputData outputData);

    /**
     * Prepares the No Groceries Found view for the Map Groceries use case.
     * @param errorMessage the error message to be outputted.
     */
    void goToNoGroceriesFoundView(String errorMessage);
}
