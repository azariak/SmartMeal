package interface_adapter.ingredient_search;

import interface_adapter.ViewManagerModel;
import interface_adapter.result.ResultViewModel;
import use_case.ingredient_search.IngredientSearchInputData;
import use_case.ingredient_search.IngredientSearchOutputBoundary;
import use_case.ingredient_search.IngredientSearchOutputData;

public class IngredientSearchPresenter implements IngredientSearchOutputBoundary {
    private final IngredientSearchViewModel ingredientSearchViewModel;
    private final ViewManagerModel viewManagerModel;
    private final ResultViewModel resultViewModel;

    public IngredientSearchPresenter(ViewManagerModel viewManagerModel,
                          IngredientSearchViewModel ingredientSearchViewModel,
                                     ResultViewModel resultViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.ingredientSearchViewModel = ingredientSearchViewModel;
        this.resultViewModel = resultViewModel;

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

    public void execute(IngredientSearchInputData ingredientSearchInputData) {

    }

    @Override
    public void prepareResultView(String ingredient1, String ingredient2, String ingredient3) {
        final IngredientSearchState ingredientSearchState = ingredientSearchViewModel.getState();

        ingredientSearchState.setIngredient1(ingredient1);
        ingredientSearchState.setIngredient2(ingredient2);
        ingredientSearchState.setIngredient3(ingredient3);

        this.ingredientSearchViewModel.setState(ingredientSearchState);
        this.ingredientSearchViewModel.firePropertyChanged();
    }
}
