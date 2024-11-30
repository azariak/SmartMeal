package interface_adapter.back;

import interface_adapter.ViewManagerModel;
import use_case.back.BackOutputBoundary;

/**
 * The presenter for the back use case.
 */
public class BackPresenter implements BackOutputBoundary {
    private final ViewManagerModel viewManagerModel;

    public BackPresenter(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void backToLastView() {
        this.viewManagerModel.setState(this.viewManagerModel.getPreviousViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
