package interface_adapter.Ranked;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.List;

import interface_adapter.ViewModel;

/**
 * ViewModel class for managing the state and behavior of the Ranked Recipes View.
 * Handles recipe rankings, star ratings, and updates to the view's state.
 */
public class RankedViewModel extends ViewModel<RankedViewState> {

    private final HashMap<Integer, String> stars = new HashMap<>();
    private final int numRecipes = 5;
    private final int numRatings = 5;
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Constructs a new RankedViewModel with the default title and initializes its state.
     */
    public RankedViewModel() {
        super("Ranked Recipes View");
        initializeStars();
        setState(initializeState());
    }

    /**
     * Initializes the star ratings for each possible rating value.
     * For example, a rating of 3 generates a string like "★★★☆☆".
     */
    private void initializeStars() {
        for (int i = 1; i <= numRatings; i++) {
            final String starsString = "★".repeat(i) + "☆".repeat(numRatings - i);
            stars.put(i, starsString);
        }
    }

    /**
     * Initializes the state of the Ranked Recipes View with default recipe names and ratings.
     *
     * @return the initialized {@link RankedViewState}.
     */
    private RankedViewState initializeState() {
        // Replace this with your actual recipe names
        final String[] recipeNames = {"Spaghetti Bolognese", "Chicken Alfredo", "Beef Stroganof"
                + "f", "Vegetarian Chili", "Lemon Tart", "Lemon Tart2"};

        final RankedViewState state = new RankedViewState();
        for (int i = 0; i < numRecipes; i++) {
            // Use the recipe name if it exists, otherwise default to "Unnamed recipe"
            final String recipeName;
            recipeName = recipeNames[i];
            final String ranking = recipeName + ": " + stars.get(i + 1);
            state.addRanking(ranking);
        }
        return state;
    }

    /**
     * Updates the ranking of a recipe at a specific index in the view state.
     *
     * @param index      the index of the recipe to update.
     * @param newRanking the new ranking string to set for the recipe.
     */
    public void updateRanking(int index, String newRanking) {
        final RankedViewState currentState = getState();
        if (index >= 0 && index < currentState.getRankings().size()) {
            final List<String> oldRankings = currentState.getRankings();
            currentState.updateRanking(index, newRanking);
            final List<String> newRankings = currentState.getRankings();
            propertyChangeSupport.firePropertyChange("rankings", oldRankings, newRankings);
        }
    }

    /**
     * Adds a {@link PropertyChangeListener} to listen for changes in the view model's state.
     *
     * @param listener the listener to add.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Removes a {@link PropertyChangeListener} from the view model.
     *
     * @param listener the listener to remove.
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    /**
     * Gets the current recipe rankings as a String array.
     *
     * @return a String array of recipe rankings.
     */
    public String[] getRankings() {
        // Assuming the state contains a method `getRankings` that returns a List<String>.
        final List<String> rankingsList = getState().getRankings();
        // Convert the List<String> to a String[] and return.
        return rankingsList.toArray(new String[0]);
    }


}
