package use_case.result;

/**
 * The input boundary for the result use case.
 */
public interface ResultInputBoundary {

    /**
     * Execute a api call.
     * @param inputData the input data.
     */
    void execute(ResultInputData inputData);


    /**
     * Back to last view.
     * @param previsousViewName the name of the previous view.
     */
    void backToLastView(String previsousViewName);
}
