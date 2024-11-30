package use_case.recipe_detail;

import entity.AdvancedRecipe;

/**
 * Output data for the Recipe Detail use case.
 */
public class RecipeDetailOutputData {
    private final AdvancedRecipe advancedRecipe;
    private final boolean useCaseFailed;

    public RecipeDetailOutputData(AdvancedRecipe advancedRecipe, boolean useCaseFailed) {
        this.advancedRecipe = advancedRecipe;
        this.useCaseFailed = useCaseFailed;
    }

    public AdvancedRecipe getAdvancedRecipe() {
        return advancedRecipe;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
