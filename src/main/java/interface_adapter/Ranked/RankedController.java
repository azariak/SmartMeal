package interface_adapter.Ranked;

import entity.GenericRecipe;
import use_case.ranked.RankedInputBoundary;
import use_case.ranked.RankedInputData;

/**
 * The controller for ranked use case.
 */
public class RankedController {
    private RankedInputBoundary rankedUseCaseInteractor;

    public RankedController(RankedInputBoundary rankedUseCaseInteractor) {
        this.rankedUseCaseInteractor = rankedUseCaseInteractor;
    }

    /**
     * Executes.
     * @param recipe the recipe to search.
     */
    public void execute(GenericRecipe recipe) {
        final RankedInputData resultInputData = new RankedInputData(recipe);

        rankedUseCaseInteractor.execute(resultInputData);
    }

    /**
     * Back to last view.
     */
    public void backTolastView() {
        rankedUseCaseInteractor.backToLastView();
    }
}
