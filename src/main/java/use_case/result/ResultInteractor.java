package use_case.result;

import entity.GenericRecipe;

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
     * @param recipe the recipe to search.
     */
    @Override
    public void execute(GenericRecipe recipe) {
        resultApiDataAccessInterface.execute(recipe.getId());
    }
}
