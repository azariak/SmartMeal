package use_case.result;

import entity.GenericRecipe;

/**
 * Output data for result use case.
 */
public class ResultOutputData {
    private final GenericRecipe genericRecipe;
    public ResultOutputData(GenericRecipe genericRecipe) {
        this.genericRecipe = genericRecipe;
    }

    public GenericRecipe getGenericRecipe() {
        return genericRecipe;
    }
}
