package use_case.result;

import entity.GenericRecipeInterface;

/**
 * Input data for result use case.
 */
public class ResultInputData {
    private final GenericRecipeInterface recipe;

    public ResultInputData(GenericRecipeInterface recipe) {
        this.recipe = recipe;

    }

    public GenericRecipeInterface getRecipe() {
        return recipe;
    }

}

