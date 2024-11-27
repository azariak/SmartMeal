package use_case.ranked;

import entity.GenericRecipe;

/**
 * Output data for ranked use case.
 */
public class RankedOutputData {
    private final GenericRecipe genericRecipe;
    public RankedOutputData(GenericRecipe genericRecipe) {
        this.genericRecipe = genericRecipe;
    }

    public GenericRecipe getGenericRecipe() {
        return genericRecipe;
    }
}
