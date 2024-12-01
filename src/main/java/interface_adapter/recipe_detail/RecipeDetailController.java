package interface_adapter.recipe_detail;

import java.io.IOException;

import entity.GenericRecipeInterface;
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
     * @throws IOException the IO exception.
     */
    public void execute(GenericRecipeInterface genericRecipe) throws IOException {
        final RecipeDetailInputData recipeDetailInputData = new RecipeDetailInputData(genericRecipe);
        recipeDetailInteractor.execute(recipeDetailInputData);
    }

    /**
     * Back to last view.
     */
    public void backToLastView() {
        recipeDetailInteractor.backToLastView();
    }

}
