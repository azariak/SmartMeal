package use_case.recipe_detail;

import entity.GenericRecipeInterface;

/**
 * The input data for the Recipe Detail use case.
 */
public class RecipeDetailInputData {

    private final GenericRecipeInterface genericRecipe;

    public RecipeDetailInputData(GenericRecipeInterface genericRecipe) {
        this.genericRecipe = genericRecipe;
    }

    public GenericRecipeInterface getGenericRecipe() {
        return genericRecipe;
    }
}
