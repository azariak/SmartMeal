package use_case.ingredient_substitutions;

/**
 * The output boundary for the ingredient substitutes use case.
 */
public interface SubstitutesOutputBoundary {
    /**
     * Prepares the success view for the ingredient substitutes Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(SubstitutesOutputData outputData);

    /**
     * Back to last view.
     */
    void backToLastView();
}
