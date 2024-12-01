package use_case.ingredient_substitutions;

import java.util.ArrayList;

/**
 * The output data for the ingredient substitutes use case.
 */
public class SubstitutesOutputData {
    private final String ingredientName;
    private final ArrayList<String> ingredientSubstitutes;
    private final boolean useCaseFailed;

    public SubstitutesOutputData(String ingredientName, ArrayList<String> ingredientSubs, boolean useCaseFailed) {
        this.ingredientName = ingredientName;
        this.ingredientSubstitutes = ingredientSubs;
        this.useCaseFailed = useCaseFailed;
    }

    public String getIngredientName() {
        return this.ingredientName;
    }

    public ArrayList<String> getIngredientSubstitutes() {
        return ingredientSubstitutes;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
