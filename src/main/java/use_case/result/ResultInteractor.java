package use_case.result;

/**
 * The interactor for the result use case.
 */
public class ResultInteractor implements ResultInputBoundary {
    private final ResultOutputBoundary resultPresenter;

    public ResultInteractor(ResultOutputBoundary resultPresenter) {
        this.resultPresenter = resultPresenter;
    }

    /**
     * Execute the recipe detail view.
     * @param inputData the input data.
     */
    @Override
    public void execute(ResultInputData inputData) {
        final ResultOutputData resultOutputData = new ResultOutputData(inputData.getRecipe());
        resultPresenter.prepareRecipeDetailView(resultOutputData);
    }

}
