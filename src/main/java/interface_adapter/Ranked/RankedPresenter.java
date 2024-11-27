package interface_adapter.Ranked;

import entity.Ranked;
import interface_adapter.ViewManagerModel;
import use_case.ranked.RankedOutputBoundary;
import use_case.ranked.RankedOutputData;

/**
 * The presenter for the ranked use case.
 */
public class RankedPresenter implements RankedOutputBoundary {
    private final RankedViewModel rankedViewModel;
    private final ViewManagerModel viewManagerModel;

    public RankedPresenter(RankedViewModel rankedViewModel, ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
        this.rankedViewModel = rankedViewModel;

    }

    @Override
    public void prepareRecipeRankView(RankedOutputData rankedOutputData) {
        final RankedViewState rankedState = rankedViewModel.getState();
        rankedState.setGenericRecipe(rankedOutputData.getGenericRecipe());
        this.rankedViewModel.setState(rankedState);
        this.rankedViewModel.firePropertyChanged();

        this.viewManagerModel.switchView(rankedViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareRankedDetailView(Ranked rankedOutputData) {

    }

    @Override
    public void backToLastView() {
        this.viewManagerModel.setState(this.viewManagerModel.getPreviousViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
