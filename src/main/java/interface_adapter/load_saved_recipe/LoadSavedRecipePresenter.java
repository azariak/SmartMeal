package interface_adapter.load_saved_recipe;

import interface_adapter.ViewManagerModel;
import interface_adapter.result.ResultViewModel;
import use_case.load_saved_recipe.LoadSavedRecipeInputData;
import use_case.load_saved_recipe.LoadSavedRecipeOutputBoundary;
import use_case.load_saved_recipe.LoadSavedRecipeOutputData;

/**
 * The Presenter for the Load Saved Recipe Use Case.
 */

public class LoadSavedRecipePresenter implements LoadSavedRecipeOutputBoundary {
    private final LoadSavedRecipeViewModel loadSavedRecipeViewModel;
    private final ViewManagerModel viewManagerModel;
    private final ResultViewModel resultViewModel;

    public LoadSavedRecipePresenter(ViewManagerModel viewManagerModel,
                                     LoadSavedRecipeViewModel loadSavedRecipeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loadSavedRecipeViewModel = loadSavedRecipeViewModel;
        this.resultViewModel = new ResultViewModel();

    }

    @Override
    public void prepareSuccessView(LoadSavedRecipeOutputData outputData) {

    }

    /**
     * Temp code for demo.
     *
     * @param error the explanation of the failure
     */
    public void prepareFailView(String error) {
    }

    public void execute(LoadSavedRecipeInputData loadSavedRecipeInputData) {

    }

    @Override
    public void prepareResultView(String recipe1, String recipe2, String recipe3) {
        final LoadSavedRecipeState loadSavedRecipeState = loadSavedRecipeViewModel.getState();

        loadSavedRecipeState.setRecipe1(recipe1);
        loadSavedRecipeState.setRecipe2(recipe2);
        loadSavedRecipeState.setRecipe3(recipe3);

        this.loadSavedRecipeViewModel.setState(loadSavedRecipeState);
        this.loadSavedRecipeViewModel.firePropertyChanged();

        this.viewManagerModel.setState(resultViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToResultView() {
        viewManagerModel.setState(resultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void backToLastView() {
        this.viewManagerModel.setState(this.viewManagerModel.getPreviousViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
