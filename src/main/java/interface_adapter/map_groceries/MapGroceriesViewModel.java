package interface_adapter.map_groceries;

import interface_adapter.ViewModel;

/**
 * The view model for the map groceries view.
 */
public class MapGroceriesViewModel extends ViewModel<MapGroceriesState> {

    public MapGroceriesViewModel() {
        super("Groceries List for Recipe");
        setState(new MapGroceriesState());
    }
}
