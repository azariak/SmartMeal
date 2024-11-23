package use_case.ingredient_search;

import entity.GenericResult;

/**
 * Output Data for the ingredient search Use Case.
 */
public class IngredientSearchOutputData implements IngredientSearchOutputBoundary {
    private final GenericResult result;
    private final boolean useCaseFailed;

    public IngredientSearchOutputData(GenericResult result, Boolean useCaseFailed) {
        this.result = result;
        this.useCaseFailed = useCaseFailed;
    }

    @Override
    public void prepareSuccessView(IngredientSearchOutputData outputData) {

    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
