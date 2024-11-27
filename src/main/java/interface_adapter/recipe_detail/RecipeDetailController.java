package interface_adapter.recipe_detail;

import entity.GenericRecipe;
import use_case.recipe_detail.RecipeDetailInputBoundary;
import use_case.recipe_detail.RecipeDetailInputData;

/**
 * The controller for the Recipe Detail use case.
 */
public class RecipeDetailController {

    private final RecipeDetailInputBoundary recipeDetailInteractor;

    public RecipeDetailController(RecipeDetailInputBoundary recipeDetailInteractor) {
        this.recipeDetailInteractor = recipeDetailInteractor;
    }

    /**
     * Executes the Recipe Detail use case.
     * @param genericRecipe is the genericRecipe object of the Recipe the user clicks on.
     */
    public void execute(GenericRecipe genericRecipe) {
        final RecipeDetailInputData recipeDetailInputData = new RecipeDetailInputData(genericRecipe);
        recipeDetailInteractor.execute(recipeDetailInputData);
    }

    /**
     * Back to last view.
     */
    public void backTolastView() {
        recipeDetailInteractor.backToLastView();
    }

}
