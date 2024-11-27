package use_case.ranked;

import entity.Ranked;

/**
 * The output boundary for the ranked use case.
 */
public interface RankedOutputBoundary {

    /**
     * Prepare the ranked detail view.
     * @param rankedOutputData the result out put data.
     */
    void prepareRankedDetailView(Ranked rankedOutputData);

    /**
     * Back to last view.
     */
    void backToLastView();
}
