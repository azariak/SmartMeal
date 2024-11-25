package use_case.recipe_detail;

import entity.TemporaryAdvancedRecipe;

/**
 * Output data for the Recipe Detail use case.
 */
public class RecipeDetailOutputData {
    private final TemporaryAdvancedRecipe temporaryAdvancedRecipe;
    private final boolean useCaseFailed;

    public RecipeDetailOutputData(TemporaryAdvancedRecipe temporaryAdvancedRecipe, boolean useCaseFailed) {
        this.temporaryAdvancedRecipe = temporaryAdvancedRecipe;
        this.useCaseFailed = useCaseFailed;
    }

    public TemporaryAdvancedRecipe getTemporaryAdvancedRecipe() {
        return temporaryAdvancedRecipe;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
