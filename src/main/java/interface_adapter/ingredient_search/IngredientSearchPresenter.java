package interface_adapter.ingredient_search;

import api_adaptors.IngredientSearchInputAdaptor;
import interface_adapter.ViewManagerModel;
import interface_adapter.result.ResultViewModel;
import use_case.ingredient_search.IngredientSearchInputData;
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
    private final IngredientSearchInputAdaptor ingredientSearchInputAdaptor;

    public IngredientSearchPresenter(ViewManagerModel viewManagerModel,
                          IngredientSearchViewModel ingredientSearchViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.ingredientSearchViewModel = ingredientSearchViewModel;
        this.resultViewModel = new ResultViewModel();
        this.ingredientSearchInputAdaptor = new IngredientSearchInputAdaptor();

    }

    @Override
    public void prepareSuccessView(IngredientSearchOutputData outputData) {

    }

    /**
     * Temp code for demo.
     *
     * @param error the explanation of the failure
     */
    public void prepareFailView(String error) {
    }

    @Override
    public void prepareDemoResultView(String ingredient1, String ingredient2, String ingredient3) {
        final IngredientSearchState ingredientSearchState = ingredientSearchViewModel.getState();

        ingredientSearchState.setIngredient1(ingredient1);
        ingredientSearchState.setIngredient2(ingredient2);
        ingredientSearchState.setIngredient3(ingredient3);

        this.viewManagerModel.setState(resultViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToDemoResultView() {
        viewManagerModel.setState(resultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareApiCall(IngredientSearchInputData ingredientSearchInputData) {
        ingredientSearchInputAdaptor.inputToApiCall(ingredientSearchInputData.getIngredients()
        );
    }

}
