package interface_adapter.map_groceries;

import interface_adapter.ViewManagerModel;
import use_case.map_groceries.MapGroceriesOutputBoundary;
import use_case.map_groceries.MapGroceriesOutputData;

/**
 * The presenter for the map groceries use case.
 */
public class MapGroceriesPresenter implements MapGroceriesOutputBoundary {

    private final MapGroceriesViewModel mapGroceriesViewModel;
    private final ViewManagerModel viewManagerModel;

    public MapGroceriesPresenter(MapGroceriesViewModel mapGroceriesViewModel,
                                 ViewManagerModel viewManagerModel) {
        this.mapGroceriesViewModel = mapGroceriesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareGroceriesView(MapGroceriesOutputData mapGroceriesOutputData) {
        final MapGroceriesState mapGroceriesState = mapGroceriesViewModel.getState();
        mapGroceriesState.setRecipeName(mapGroceriesOutputData.getRecipeName());
        mapGroceriesState.setGroceries(mapGroceriesOutputData.getGroceryList());
        System.out.println(mapGroceriesOutputData.getGroceryList());

        this.mapGroceriesViewModel.setState(mapGroceriesState);
        this.mapGroceriesViewModel.firePropertyChanged();

        this.viewManagerModel.switchView(mapGroceriesViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    // @Override
    // public void goToNoGroceriesFoundView(String errormessage) {

    // }

    @Override
    public void goToLastView() {
        this.viewManagerModel.setState(this.viewManagerModel.getPreviousViewName());
        this.viewManagerModel.switchView(viewManagerModel.getPreviousViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
