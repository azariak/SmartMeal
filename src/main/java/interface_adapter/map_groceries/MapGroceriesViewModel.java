package interface_adapter.map_groceries;

import interface_adapter.ViewModel;
import interface_adapter.login.LoginViewModel;

/**
 * The view model for the map groceries view.
 */
public class MapGroceriesViewModel extends ViewModel<MapGroceriesState> {

    public MapGroceriesViewModel() {
        super("Groceries List for Recipe");
        setState(new MapGroceriesState());
    }
}
