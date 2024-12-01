package use_case.result;

import entity.GenericRecipeInterface;

/**
 * Output data for result use case.
 */
public class ResultOutputData {
    private final GenericRecipeInterface genericRecipe;

    public ResultOutputData(GenericRecipeInterface genericRecipe) {
        this.genericRecipe = genericRecipe;
    }

    public GenericRecipeInterface getGenericRecipe() {
        return genericRecipe;
    }
}
