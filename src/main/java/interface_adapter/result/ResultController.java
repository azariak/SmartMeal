package interface_adapter.result;

import entity.GenericRecipe;
import use_case.result.ResultInputBoundary;
import use_case.result.ResultInputData;

/**
 * The controller for result use case.
 */
public class ResultController {
    private final ResultInputBoundary resultUseCaseInteractor;

    public ResultController(ResultInputBoundary resultUseCaseInteractor) {
        this.resultUseCaseInteractor = resultUseCaseInteractor;
    }

    /**
     * Executes the second api search for recipe details.
     * @param recipe the recipe to search.
     */
    public void execute(GenericRecipe recipe) {
        final ResultInputData resultInputData = new ResultInputData(recipe);

        resultUseCaseInteractor.execute(resultInputData);
    }

    /**
     * Back to last view.
     */
    public void backTolastView() {
        resultUseCaseInteractor.backToLastView();
    }
}
