package use_case.ingredient_search;

import entity.Result;

/**
 * Output Data for the ingredient search Use Case.
 */
public class IngredientSearchOutputData {
    private final Result result;
    private final boolean useCaseFailed;

    public IngredientSearchOutputData(Result result, Boolean useCaseFailed) {
        this.result = result;
        this.useCaseFailed = useCaseFailed;
    }

    public Result getResult() {
        return result;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
