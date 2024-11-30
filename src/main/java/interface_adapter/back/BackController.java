package interface_adapter.back;

import use_case.back.BackInputBoundary;

/**
 * The controller for the back use case.
 */
public class BackController {
    private final BackInputBoundary backInteractor;

    public BackController(BackInputBoundary backInteractor) {
        this.backInteractor = backInteractor;
    }

    /**
     * Back to last view.
     */
    public void backToLastView() {
        backInteractor.backToLastView();
    }
}
