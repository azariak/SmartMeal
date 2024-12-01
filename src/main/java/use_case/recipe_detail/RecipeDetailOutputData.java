package use_case.recipe_detail;

import entity.AdvancedRecipeInterface;

/**
 * Output data for the Recipe Detail use case.
 */
public class RecipeDetailOutputData {
    private final AdvancedRecipeInterface advancedRecipeInterface;

    public RecipeDetailOutputData(AdvancedRecipeInterface advancedRecipeInterface) {
        this.advancedRecipeInterface = advancedRecipeInterface;
    }

    public AdvancedRecipeInterface getAdvancedRecipe() {
        return advancedRecipeInterface;
    }
}
