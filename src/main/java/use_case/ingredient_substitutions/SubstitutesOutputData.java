package use_case.ingredient_substitutions;

import java.util.ArrayList;

/**
 * The output data for the ingredient substitutes use case.
 */
public class SubstitutesOutputData {
    private final ArrayList<String> ingredientSubstitutes;
    private final boolean useCaseFailed;

    public SubstitutesOutputData(ArrayList<String> ingredientSubstitutes, boolean useCaseFailed) {
        this.ingredientSubstitutes = ingredientSubstitutes;
        this.useCaseFailed = useCaseFailed;
    }

    public ArrayList<String> getIngredientSubstitutes() {
        return ingredientSubstitutes;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
