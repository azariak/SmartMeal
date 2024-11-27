package interface_adapter.ingredient_search;

import interface_adapter.ViewManagerModel;
import interface_adapter.result.ResultViewModel;
import interface_adapter.result.ResultViewState;
import use_case.ingredient_search.IngredientSearchOutputBoundary;
import use_case.ingredient_search.IngredientSearchOutputData;

/**
 * The presenter for the ingredient search use case.
 */
public class IngredientSearchPresenter implements IngredientSearchOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final ResultViewModel resultViewModel;
    // TODO: Subject to change, refactor later.

    public IngredientSearchPresenter(ViewManagerModel viewManagerModel,
                          IngredientSearchViewModel ingredientSearchViewModel,
                                     ResultViewModel resultViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.resultViewModel = resultViewModel;

    }

    @Override
    public void prepareSuccessView(IngredientSearchOutputData outputData) {

        final ResultViewState resultViewState = resultViewModel.getState();
        resultViewState.setResult(outputData.getResult());
        this.resultViewModel.setState(resultViewState);
        this.resultViewModel.setPrevisousViewName(viewManagerModel.getState());
        this.resultViewModel.firePropertyChanged();

        this.viewManagerModel.setState(resultViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    /**
     * Temp code for demo.
     *
     * @param error the explanation of the failure
     */
    public void prepareFailView(String error) {
    }

}
