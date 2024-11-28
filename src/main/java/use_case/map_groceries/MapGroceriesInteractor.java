package use_case.map_groceries;

import java.util.ArrayList;
import java.util.Map;

import entity.AdvancedRecipe;
import entity.GroceryList;

/**
 * The Map Groceries use case interactor.
 * Handles logic process for mapping a recipes ingredients to a grocery list.
 */
public class MapGroceriesInteractor implements MapGroceriesInputBoundary {

    private final MapGroceriesOutputBoundary mapGroceriesPresenter;
    private final GroceryList groceryList;
    private final MapGroceriesDataAccessInterface mapGroceriesDataAccessInterface;

    public MapGroceriesInteractor(MapGroceriesOutputBoundary mapGroceriesPresenter,
                                  GroceryList groceryList,
                                  MapGroceriesDataAccessInterface mapGroceriesDataAccessInterface) {
        this.mapGroceriesPresenter = mapGroceriesPresenter;
        this.groceryList = groceryList;
        this.mapGroceriesDataAccessInterface = mapGroceriesDataAccessInterface;
    }

    @Override
    public void execute(MapGroceriesInputData mapGroceriesInputData) {
        // Recipe id
        final String id = mapGroceriesInputData.getID();
        /* The Grocery List output data.
        final GroceryList groceries =

         */

    }

    @Override
    public void goToGroceryView() {

    }

    @Override
    public void goToLastView() {

    }

}
