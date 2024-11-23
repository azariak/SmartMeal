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
    private final IngredientSearchViewModel ingredientSearchViewModel;
    private final ViewManagerModel viewManagerModel;
    private final ResultViewModel resultViewModel;
    // TODO: Subject to change, refactor later.

    public IngredientSearchPresenter(ViewManagerModel viewManagerModel,
                          IngredientSearchViewModel ingredientSearchViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.ingredientSearchViewModel = ingredientSearchViewModel;
        this.resultViewModel = new ResultViewModel();

    }

    @Override
    public void prepareSuccessView(IngredientSearchOutputData outputData) {

        final ResultViewState resultViewState = resultViewModel.getState();
        resultViewState.setResult(outputData.getResult());
        this.resultViewModel.setState(resultViewState);
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

    /**
     * Prepare the demo result view.
     * @param ingredient1 ingredient1
     * @param ingredient2 ingredient2
     * @param ingredient3 ingredient3
     */
    public void prepareDemoResultView(String ingredient1, String ingredient2, String ingredient3) {
        final IngredientSearchState ingredientSearchState = ingredientSearchViewModel.getState();

        ingredientSearchState.setIngredient1(ingredient1);
        ingredientSearchState.setIngredient2(ingredient2);
        ingredientSearchState.setIngredient3(ingredient3);

        this.viewManagerModel.setState(resultViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void switchToDemoResultView() {
        viewManagerModel.setState(resultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
