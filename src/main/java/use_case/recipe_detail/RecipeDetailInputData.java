package use_case.recipe_detail;

import entity.GenericRecipe;

/**
 * The input data for the Recipe Detail use case.
 */
public class RecipeDetailInputData {

    private final GenericRecipe genericRecipe;

    public RecipeDetailInputData(GenericRecipe genericRecipe) {
        this.genericRecipe = genericRecipe;
    }

    public GenericRecipe getGenericRecipe() {
        return genericRecipe;
    }
}
