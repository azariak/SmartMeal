package use_case.ranked;

import interface_adapter.Ranked.RankedViewModel;

public class RankedInteractor {
    private final RankedOutputBoundary outputBoundary;
    private final RankedViewModel viewModel;

    public RankedInteractor(RankedOutputBoundary outputBoundary, RankedViewModel viewModel) {
        this.outputBoundary = outputBoundary;
        this.viewModel = viewModel;
    }

    /**
     * This method handles the back button action by getting the previous view
     * name from the ViewModel and notifying the output boundary.
     */
    public void handleBackAction() {
        // Retrieve previous view name from the ViewModel
        String previousViewName = viewModel.getPrevisousViewName();
        if (previousViewName != null) {
            // Pass the previous view name to the output boundary for state change
            outputBoundary.setState(previousViewName);
            outputBoundary.firePropertyChanged();
        } else {
            System.out.println("No previous view available!");
        }
    }

    // Add other methods that interact with the ViewModel, OutputBoundary, etc.
}
