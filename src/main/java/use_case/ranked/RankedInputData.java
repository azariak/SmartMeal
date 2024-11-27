package use_case.ranked;

import entity.GenericRecipe;

/**
 * Input data for ranked use case.
 */
public class RankedInputData {
    private final GenericRecipe recipe;
    private final String name;

    public RankedInputData(GenericRecipe recipe) {
        this.recipe = recipe;
        this.name = recipe.getName();
    }

    public GenericRecipe getRecipe() {
        return recipe;
    }

    public String getName() {
        return name;
    }
}
