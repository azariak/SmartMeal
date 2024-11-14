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

    /**
     * Temp code for demo.
     * @param ingredient1 1
     * @param ingredient2 2
     * @param ingredient3 3
     */
    void prepareDemoResultView(String ingredient1, String ingredient2, String ingredient3);

    void switchToDemoResultView();
    /**
     * Prepare for the api call.
     * @param ingredient1 ingredient input 1
     * @param ingredient2 ingredient input 2
     * @param ingredient3 ingredient input 3
     */
    void prepareApiCall(String ingredient1, String ingredient2, String ingredient3);
}
