package interface_adapter.ingredient_substitutions;

import use_case.ingredient_substitutions.SubstitutesInputBoundary;
import use_case.ingredient_substitutions.SubstitutesInputData;

/**
 * A controller for the substitutes use case.
 */
public class SubstitutesController {

    private final SubstitutesInputBoundary substitutesinteractor;

    public SubstitutesController(SubstitutesInputBoundary substitutesinteractor) {
        this.substitutesinteractor = substitutesinteractor;
    }

    /**
     * Executes the ingredient substitutions use case.
     * @param ingredientName is the name of the ingredient the user wants to find substitutes for.
     */
    public void execute(String ingredientName) {
        final SubstitutesInputData substitutesInputData = new SubstitutesInputData(ingredientName);
        substitutesinteractor.execute(substitutesInputData);
    }
}
