package use_case.saved_recipe;

import data_access.InMemoryUserDataAccessObject;

/**
 * The Saved recipe Interactor.
 */
public class SavedRecipeInteractor implements SavedRecipeInputBoundary {
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
        final String recipeNutririon = savedrecipeInputData.getRecipeNutrition();
        savedRecipePresenter.prepareResultView(recipeName, recipeCalories, recipeDescription, recipeIngredients,
                recipeNutririon);
    }

    @Override
    public void switchToResultView() {
        savedRecipePresenter.switchToResultView();
    }
}
