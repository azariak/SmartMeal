package use_case.recipe_detail;

import entity.AdvancedRecipe;

/**
 * Output data for the Recipe Detail use case.
 */
public class RecipeDetailOutputData {
    private final AdvancedRecipe advancedRecipe;

    public RecipeDetailOutputData(AdvancedRecipe advancedRecipe) {
        this.advancedRecipe = advancedRecipe;
    }

    public AdvancedRecipe getAdvancedRecipe() {
        return advancedRecipe;
    }
}
