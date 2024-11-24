package use_case.result;

/**
 * The interactor for the result use case.
 */
public class ResultInteractor implements ResultInputBoundary {
    private final ResultApiDataAccessInterface resultApiDataAccessInterface;
    private final ResultOutputBoundary resultPresenter;

    public ResultInteractor(ResultApiDataAccessInterface resultApiDataAccessInterface,
                            ResultOutputBoundary resultPresenter) {
        this.resultApiDataAccessInterface = resultApiDataAccessInterface;
        this.resultPresenter = resultPresenter;
    }

    /**
     * Execute the api search.
     * @param inputData the input data.
     */
    @Override
    public void execute(ResultInputData inputData) {
    //        resultApiDataAccessInterface.execute(inputData.getRecipe().getId());
    }
}
