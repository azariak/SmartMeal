package use_case.ingredient_search;

public interface IngredientSearchOutputBoundary {
    /**
     * Prepares the success view for the Ingredient Search Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(IngredientSearchOutputData outputData);

    /**
     * Prepares the failure view for the Ingredient Search Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
