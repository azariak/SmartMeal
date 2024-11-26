package use_case.ingredient_substitutions;

/**
 * The input boundary for the ingredient substitutes use case.
 */
public interface SubstitutesInputBoundary {

    /**
     * Executes the Recipe Detail Use Case.
     * @param substitutesInputData is the input data.
     */
    void execute(SubstitutesInputData substitutesInputData);
}