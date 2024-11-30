package interface_adapter.map_groceries;

import use_case.login.LoginInputData;
import use_case.map_groceries.MapGroceriesInputBoundary;
import use_case.map_groceries.MapGroceriesInputData;

import java.io.IOException;

/**
 * The login controller for the Map Groceries use case.
 */
public class MapGroceriesController {

    private final MapGroceriesInputBoundary mapGroceriesUseCaseInteractor;

    public MapGroceriesController(MapGroceriesInputBoundary mapGroceriesUseCaseInteractor) {
        this.mapGroceriesUseCaseInteractor = mapGroceriesUseCaseInteractor;
    }

    /**
     * Executes the Map Groceries use case.
     * @param id The recipe id.
     * @throws IOException in case api call fails.
     */
    public void execute(String id) throws IOException {
        final MapGroceriesInputData mapGroceriesInputData = new MapGroceriesInputData(id);

        mapGroceriesUseCaseInteractor.execute(mapGroceriesInputData);
    }

    /**
     * Switch to last view.
     */
    public void backToLastView() {
        mapGroceriesUseCaseInteractor.backToLastView();
    }
}
