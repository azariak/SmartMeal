package use_case.result;

/**
 * The output boundary for the result use case.
 */
public interface ResultOutputBoundary {

    /**
     * Prepare the recipe detail view.
     * @param resultOutputData the result out put data.
     */
    void prepareRecipeDetailView(ResultOutputData resultOutputData);


    /**
     * Back to last view.
     * @param previousViewName the name of the last view.
     */
    void backToLastView(String previousViewName);
}
