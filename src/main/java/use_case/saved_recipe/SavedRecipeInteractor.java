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
        final String recipeName = savedrecipeInputData.getRecipeName();
        final String recipeCalories = savedrecipeInputData.getRecipeCalories();
        final String recipeDescription = savedrecipeInputData.getRecipeDescription();
        final String recipeIngredients = savedrecipeInputData.getRecipeIngredients();
        final String recipeNutririon = savedrecipeInputData.getRecipeNutririon();
        savedRecipePresenter.prepareResultView(recipeName, recipeCalories, recipeDescription, recipeIngredients,
                recipeNutririon);
    }

    @Override
    public void switchToResultView() {
        savedRecipePresenter.switchToResultView();
    }
}
