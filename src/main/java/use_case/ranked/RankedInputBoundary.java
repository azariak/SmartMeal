package use_case.ranked;

/**
 * The input boundary for the result use case.
 */
public interface RankedInputBoundary {

    /**
     * Execute a api call.
     * @param inputData the input data.
     */
    void execute(RankedInputData inputData);

    /**
     * Back to last view.
     */
    void backToLastView();

    /**
     * Update star ratings.
     * @param recipeId The recipe ID.
     * @param starRating the star rating.
     */
    void updateStarRating(String recipeId, int starRating);
}
