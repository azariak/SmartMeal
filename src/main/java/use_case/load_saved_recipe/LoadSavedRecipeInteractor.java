package use_case.load_saved_recipe;

import data_access.InMemoryUserDataAccessObject;

/**
 * The Load saved recipe Interactor.
 */
public class LoadSavedRecipeInteractor implements LoadSavedRecipeInputBoundary {

    private final InMemoryUserDataAccessObject loadSavedRecipeDataAccessObject;
    private final LoadSavedRecipeOutputBoundary loadSavedRecipePresenter;

    public LoadSavedRecipeInteractor(InMemoryUserDataAccessObject loadSavedRecipeDataAccessObject,
                                     LoadSavedRecipeOutputBoundary loadSavedRecipeOutputBoundary) {

        this.loadSavedRecipeDataAccessObject = loadSavedRecipeDataAccessObject;
        this.loadSavedRecipePresenter = loadSavedRecipeOutputBoundary;
    }

    @Override
    public void execute(LoadSavedRecipeInputData loadsavedrecipeInputData) {
        final String recipe1 = loadsavedrecipeInputData.getRecipe1();
        final String recipe2 = loadsavedrecipeInputData.getRecipe2();
        final String recipe3 = loadsavedrecipeInputData.getRecipe3();
        loadSavedRecipePresenter.prepareResultView(recipe1, recipe2, recipe3);
    }

    @Override
    public void switchToResultView() {
        loadSavedRecipePresenter.switchToResultView();
    }

    @Override
    public void backToLastView() {
        loadSavedRecipePresenter.backToLastView();
    }
}
