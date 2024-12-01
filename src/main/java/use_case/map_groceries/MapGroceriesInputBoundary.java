package use_case.map_groceries;

import java.io.IOException;

/**
 * Input Boundary for actions related to mapping groceries.
 */
public interface MapGroceriesInputBoundary {

    /**
     * Executes the Map Groceries use case.
     * @param mapGroceriesInputData the input data.
     * @throws IOException if API call runs into error.
     */
    void execute(MapGroceriesInputData mapGroceriesInputData) throws IOException;

    /**
     * Go to previous view.
     */
    void backToLastView();
}
