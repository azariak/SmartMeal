package api_adaptors;

/**
 * The Boundary for result view input.
 */
public interface ResultApiAdaptorBoundary {
    /**
     *  Prepares the result view with eligible data input.
     */
    void prepareSucessResultView();

    /**
     * Prepares the result view when error occurs.
     */
    void prepareFailureResultView();

}
