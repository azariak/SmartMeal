package use_case.ranked;

import entity.GenericRecipeInterface;

/**
 * Output data for ranked use case.
 */
public class RankedOutputData {
    private final GenericRecipeInterface genericRecipe;

    public RankedOutputData(GenericRecipeInterface genericRecipe) {
        this.genericRecipe = genericRecipe;
    }

    public GenericRecipeInterface getGenericRecipe() {
        return genericRecipe;
    }
}
