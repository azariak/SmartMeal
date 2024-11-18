package use_case.saved_recipe;

import data_access.InMemoryUserDataAccessObject;
import use_case.load_saved_recipe.LoadSavedRecipeInputData;
import use_case.load_saved_recipe.LoadSavedRecipeOutputBoundary;

/**
 * The saved recipe Interactor.
 */
public class SavedRecipeInteractor {
    private final InMemoryUserDataAccessObject savedRecipeDataAccessObject;
    private final SavedRecipeOutputBoundary savedRecipePresenter;

    public SavedRecipeInteractor(InMemoryUserDataAccessObject savedRecipeDataAccessObject,
                                     SavedRecipeOutputBoundary savedRecipeOutputBoundary) {

        this.savedRecipeDataAccessObject = savedRecipeDataAccessObject;
        this.savedRecipePresenter = savedRecipeOutputBoundary;
    }

    @Override
    public void execute(SavedRecipeInputData savedrecipeInputData) {
        final String recipe1 = savedrecipeInputData.getRecipe1();
        final String recipe2 = savedrecipeInputData.getRecipe2();
        final String recipe3 = savedrecipeInputData.getRecipe3();
        savedRecipePresenter.prepareResultView(recipe1, recipe2, recipe3);
    }

    @Override
    public void switchToResultView() {
        loadSavedRecipePresenter.switchToResultView();
    }
}
