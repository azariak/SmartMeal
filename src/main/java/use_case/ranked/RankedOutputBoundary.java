package use_case.ranked;

public interface RankedOutputBoundary {

    // Other methods...

    void presentRankedView(String rankedView);

    // Optionally, other methods like:
    void displayRankedList(String[] rankedData);
    void displayError(String message);

    void firePropertyChanged();

    void setState(String previousViewName);
}
