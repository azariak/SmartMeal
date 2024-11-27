package interface_adapter.Ranked;

import use_case.ranked.RankedOutputBoundary;
import interface_adapter.ViewModel;  // Adjust import if needed

public class RankedPresenter implements RankedOutputBoundary {

    private final ViewModel viewModelManager;

    // Constructor to initialize RankedPresenter with a ViewModelManagerModel
    public RankedPresenter(ViewModel viewModelManager) {
        this.viewModelManager = viewModelManager;
    }

    /**
     * Handles the back button action by updating the state to the previous view
     * and notifying listeners.
     */
    public void handleBackButton() {
        try {
            String previousView = this.viewModelManager.getPrevisousViewName();
            if (previousView != null && !previousView.isEmpty()) {
                this.viewModelManager.setState(previousView);
                this.viewModelManager.firePropertyChanged();
            } else {
                System.out.println("No previous view available. Returning to default view.");
                this.viewModelManager.setState("DefaultView"); // Replace with your actual default view name
                this.viewModelManager.firePropertyChanged();
            }
        } catch (Exception e) {
            System.err.println("Error handling back button: " + e.getMessage());
            this.viewModelManager.setState("DefaultView");
            this.viewModelManager.firePropertyChanged();
        }
    }
    /**
     * Example method to process ranked data (expand this based on your use case).
     */
    public void processData(String data) {
        // Implement ranked-specific logic here
        System.out.println("Processing ranked data: " + data);
    }

    // Implement the methods from RankedOutputBoundary interface, including the required presentRankedView
    @Override
    public void presentRankedView(String rankedView) {
        // Handle presenting the ranked view to the user
        System.out.println("Presenting ranked view: " + rankedView);
    }

    @Override
    public void displayRankedList(String[] rankedData) {
        // Handle displaying ranked data to the user
        System.out.println("Displaying ranked list: ");
        for (String rank : rankedData) {
            System.out.println(rank);
        }
    }

    @Override
    public void displayError(String message) {
        // Handle displaying an error message
        System.out.println("Error: " + message);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void setState(String previousViewName) {

    }
}
