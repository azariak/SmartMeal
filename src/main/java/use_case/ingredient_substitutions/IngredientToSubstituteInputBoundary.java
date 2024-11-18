package use_case.ingredient_substitutions;

/**
 * Input boundary interface for retrieving ingredient substitutes.
 */
public interface IngredientToSubstituteInputBoundary {
    /**
     * Retrieves ingredient substitutes based on the provided input data.
     * @param inputData The input data containing the ingredient name.
     */
    void getSubstitute(IngredientToSubstituteInputData inputData);
}
