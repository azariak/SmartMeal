package interface_adapter.ingredient_substitutions;

import use_case.ingredient_substitutions.SubstitutesInputBoundary;
import use_case.ingredient_substitutions.SubstitutesInputData;

/**
 * A controller for the substitutes use case.
 */
public class SubstitutesController {

    private final SubstitutesInputBoundary substitutesInteractor;

    public SubstitutesController(SubstitutesInputBoundary substitutesInteractor) {
        this.substitutesInteractor = substitutesInteractor;
    }

    /**
     * Executes the ingredient substitutions use case.
     * @param ingredientName is the name of the ingredient the user wants to find substitutes for.
     */
    public void execute(String ingredientName) {
        final SubstitutesInputData substitutesInputData = new SubstitutesInputData(ingredientName);
        substitutesInteractor.execute(substitutesInputData);
    }

    /**
     * Back to last view.
     */
    public void backTolastView() {
        substitutesInteractor.backToLastView();
    }
}
