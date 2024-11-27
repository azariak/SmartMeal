package interface_adapter.Ranked;

import interface_adapter.Ranked.RankedPresenter;

public class RankedController {
    private final RankedPresenter presenter;

    /**
     * Constructor to initialize the controller with a presenter.
     *
     * @param presenter The presenter that handles the logic for ranked features.
     */
    public RankedController(RankedPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Handles the back button click event.
     * Delegates the back navigation logic to the presenter.
     */
    public void onBackButtonClicked() {
        this.presenter.handleBackButton();
    }

    /**
     * Example method for interacting with the presenter.
     * This can be expanded for other functionalities if needed.
     *
     * @param data Some input data to pass to the presenter.
     */
    public void handleSomeAction(String data) {
        presenter.processData(data); // Assuming this is a method in RankedPresenter
    }

}
