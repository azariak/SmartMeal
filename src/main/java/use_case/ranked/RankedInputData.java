package use_case.ranked;

import entity.GenericRecipeInterface;

/**
 * Input data for ranked use case.
 */
public class RankedInputData {
    private final GenericRecipeInterface recipe;
    private final String name;

    public RankedInputData(GenericRecipeInterface recipe) {
        this.recipe = recipe;
        this.name = recipe.getName();
    }

    public GenericRecipeInterface getRecipe() {
        return recipe;
    }

    public String getName() {
        return name;
    }
}
