package interface_adapter.Ranked;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.List;

public class RankedViewModel extends ViewModel<RankedViewState> {

    private final HashMap<Integer, String> stars = new HashMap<>();
    private final int numRecipes = 5;
    private final int numRatings = 5;
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public RankedViewModel() {
        super("Ranked Recipes View");
        initializeStars();
        setState(initializeState());
    }

    private void initializeStars() {
        for (int i = 1; i <= numRatings; i++) {
            String starsString = "★".repeat(i) + "☆".repeat(numRatings - i);
            stars.put(i, starsString);
        }
    }

    private RankedViewState initializeState() {
        RankedViewState state = new RankedViewState();
        for (int i = 0; i < numRecipes; i++) {
            String ranking = "Sample recipe " + (i + 1) + ": " + stars.get(i + 1);
            state.addRanking(ranking);
        }
        return state;
    }

    public void updateRanking(int index, String newRanking) {
        RankedViewState currentState = getState();
        if (index >= 0 && index < currentState.getRankings().size()) {
            List<String> oldRankings = currentState.getRankings();
            currentState.updateRanking(index, newRanking);
            List<String> newRankings = currentState.getRankings();
            propertyChangeSupport.firePropertyChange("rankings", oldRankings, newRankings);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public String[] getRankings() {
        // Assuming the state contains a method `getRankings` that returns a List<String>.
        final List<String> rankingsList = getState().getRankings();
        // Convert the List<String> to a String[] and return.
        return rankingsList.toArray(new String[0]);
    }
}
