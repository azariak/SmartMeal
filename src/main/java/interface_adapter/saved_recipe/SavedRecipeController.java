package interface_adapter.saved_recipe;

import use_case.saved_recipe.SavedRecipeInputBoundary;
import use_case.saved_recipe.SavedRecipeInputData;

/**
 * The controller for the Saved Recipe Use Case.
 */
public class SavedRecipeController {
    private final SavedRecipeInputBoundary savedRecipeUseCaseInteractor;

    public SavedRecipeController(SavedRecipeInputBoundary savedRecipeUseCaseInteractor) {
        this.savedRecipeUseCaseInteractor = savedRecipeUseCaseInteractor;
    }
    /**
     * Executes the Login Use Case.
     * @param recipeName the username of the user logging in
     * @param recipeDescription the password of the user logging in
     * @param recipeNutririon the nutrition of the recipe.
     * @param recipeIngredients the ingrediants of the recipe.
     * @param recipeCalories the calories of the recipe.
     */

    public void execute(String recipeName, String recipeDescription, String recipeNutririon, String recipeIngredients,
                        String recipeCalories) {
        final SavedRecipeInputData savedRecipeInputData = new SavedRecipeInputData(recipeName, recipeDescription,
                recipeNutririon, recipeIngredients, recipeCalories);

        savedRecipeUseCaseInteractor.execute(savedRecipeInputData);
    }

}
