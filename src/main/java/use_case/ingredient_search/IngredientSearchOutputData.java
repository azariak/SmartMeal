package use_case.ingredient_search;

import entity.GenericResult;

/**
 * Output Data for the ingredient search Use Case.
 */
public class IngredientSearchOutputData {
    private final GenericResult result;
    private final boolean useCaseFailed;

    public IngredientSearchOutputData(GenericResult result, Boolean useCaseFailed) {
        this.result = result;
        this.useCaseFailed = useCaseFailed;
    }

    public GenericResult getResult() {
        return result;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
