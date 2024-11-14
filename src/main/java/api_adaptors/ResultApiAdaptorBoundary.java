package api_adaptors;

public interface ResultApiAdaptorBoundary {
    /**
     *  Prepares the result view with eligible data input.
     */
    void prepareSucessResultView();

    /**
     * Prepares the result view when error occures.
     */
    void prepareFailureResultView();

}
