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

    public MapGroceriesInteractor(MapGroceriesOutputBoundary mapGroceriesPresenter,
                                  GroceryList groceryList) {
        this.mapGroceriesPresenter = mapGroceriesPresenter;
        this.groceryList = groceryList;
    }

    @Override
    public void execute(MapGroceriesInputData mapGroceriesInputData) {

    }


}
