package use_case.ingredient_substitutions;

/**
 * Output boundary interface for presenting ingredient substitutes.
 */
public interface IngredientToSubstituteOutputBoundary {
    /**
     * Presents the ingredient substitutes to the user.
     *
     * @param outputData The output data containing the substitute information.
     */
    void presentSubstitute(IngredientToSubstituteOutputData outputData);
}
