package use_case.load_saved_recipe;

import java.util.List;

import entity.AdvancedRecipeInterface;

/**
 * The Load saved recipe Interactor.
 */
public class LoadSavedRecipeInteractor implements LoadSavedRecipeInputBoundary {

    private final LoadSavedRecipeDataAccessInterface recipeDataAccess;
    private final LoadSavedRecipeOutputBoundary loadSavedRecipePresenter;

    public LoadSavedRecipeInteractor(LoadSavedRecipeDataAccessInterface recipeDataAccess,
                                     LoadSavedRecipeOutputBoundary loadSavedRecipeOutputBoundary) {
        this.recipeDataAccess = recipeDataAccess;
        this.loadSavedRecipePresenter = loadSavedRecipeOutputBoundary;
    }

    @Override
    public void execute(LoadSavedRecipeInputData inputData) {
        loadSavedRecipePresenter.prepareResultView(inputData.getRecipe1(), inputData.getRecipe2(),
                inputData.getRecipe3());
    }

    @Override
    public void switchToResultView() {
        loadSavedRecipePresenter.switchToResultView();
    }

    @Override
    public void backToLastView() {
        loadSavedRecipePresenter.backToLastView();
    }

    @Override
    public List<AdvancedRecipeInterface> getAllRecipes() {
        return recipeDataAccess.getAllRecipes();
    }

}
