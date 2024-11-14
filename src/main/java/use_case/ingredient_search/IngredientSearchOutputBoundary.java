package use_case.ingredient_search;

/**
 * The boundary for ingredient search output.
 */
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

    /**
     * Switch to demo result view.
     */
    void switchToDemoResultView();

    /**
     * Prepare for the api call.
     * @param ingredientSearchInputData The input data of ingredient search view
     */
    void prepareApiCall(IngredientSearchInputData ingredientSearchInputData);
}
