package use_case.map_groceries;

/**
 * Input Boundary for actions related to mapping groceries.
 */
public interface MapGroceriesInputBoundary {

    /**
     * Executes the Map Groceries use case.
     * @param mapGroceriesInputData the input data.
     */

    void execute(MapGroceriesInputData mapGroceriesInputData);
}
