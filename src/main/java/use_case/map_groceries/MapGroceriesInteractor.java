package use_case.map_groceries;

import java.io.IOException;

/**
 * The Map Groceries use case interactor.
 * Handles logic process for mapping a recipes ingredients to a grocery list.
 */
public class MapGroceriesInteractor implements MapGroceriesInputBoundary {

    private final MapGroceriesDataAccessInterface mapGroceriesDataAccess;
    private final MapGroceriesOutputBoundary mapGroceriesPresenter;

    public MapGroceriesInteractor(MapGroceriesDataAccessInterface mapGroceriesDataAccess,
                                  MapGroceriesOutputBoundary mapGroceriesPresenter) {
        this.mapGroceriesDataAccess = mapGroceriesDataAccess;
        this.mapGroceriesPresenter = mapGroceriesPresenter;
    }

    @Override
    public void execute(MapGroceriesInputData mapGroceriesInputData) throws IOException {
        final String id = mapGroceriesInputData.getID();

        final MapGroceriesOutputData mapGroceriesOutputData =
                new MapGroceriesOutputData(this.mapGroceriesDataAccess.getRecipeGroceryList(id));
        mapGroceriesPresenter.prepareGroceriesView(mapGroceriesOutputData);
    }

    @Override
    public void backToLastView() {
        mapGroceriesPresenter.goToLastView();
    }

}
