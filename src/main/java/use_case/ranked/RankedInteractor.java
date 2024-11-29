package use_case.ranked;

import entity.Ranked;

/**
 * The interactor for the ranked use case.
 */
public class RankedInteractor implements RankedInputBoundary {
    private final RankedOutputBoundary rankedPresenter;

    public RankedInteractor(RankedOutputBoundary rankedPresenter) {
        this.rankedPresenter = rankedPresenter;
    }

    /**
     * Execute the recipe detail view.
     * @param inputData the input data.
     */
    @Override
    public void execute(RankedInputData inputData) {
        final RankedOutputData rankedOutputData = new RankedOutputData(inputData.getRecipe());
        rankedPresenter.prepareRankedDetailView((Ranked) rankedOutputData);
    }

    @Override
    public void backToLastView() {
        rankedPresenter.backToLastView();
    }

    @Override
    public void updateStarRating(String recipeId, int starRating) {

    }
}
