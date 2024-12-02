package interface_adapter.ranked;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import interface_adapter.ViewModel;

/**
 * The RankedViewModel class represents the ViewModel for a ranked recipe list.
 * It manages the state of ranked recipes and allows for updating the rankings
 * with star ratings. It also supports property change listeners for updating
 * the view when the rankings change.
 */
public class RankedViewModel extends ViewModel<RankedViewState> {

    private final HashMap<Integer, String> stars = new HashMap<>();
    private final int numRecipes = 5;
    private final int numRatings = 5;
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Constructs a RankedViewModel and initializes the stars and the initial state.
     */
    public RankedViewModel() {
        super("Ranked Recipes View");
        initializeStars();
        setState(initializeState());
    }

    /**
     * Initializes the star ratings for the recipes.
     * It creates star ratings from 1 to 5 stars.
     */
    private void initializeStars() {
        for (int i = 1; i <= numRatings; i++) {
            final String starsString = "★".repeat(i) + "☆".repeat(numRatings - i);
            stars.put(i, starsString);
        }
    }

    /**
     * Initializes the state of the ranked recipes by shuffling a list of
     * recipe names and assigning random star ratings to them.
     *
     * @return the initial RankedViewState containing the shuffled and rated recipes.
     */
    private RankedViewState initializeState() {
        // As per Piazza Post #1423, I can hard code in values to save time during the demo.
        //
        String[] recipeNames = {"Spaghetti Bolognese",
                                "Chicken and Rice", "Chicken Alfredo", "Beef Stroganoff",
                                "Vegetarian Chili", "Lemon Tart"};

        final List<String> recipeList = Arrays.asList(recipeNames);

        // Shuffle the list of recipe names to randomize their order
        Collections.shuffle(recipeList);

        recipeNames = recipeList.toArray(new String[0]);

        final RankedViewState state = new RankedViewState();
        for (int i = 0; i < recipeNames.length; i++) {
            final String recipeName = recipeNames[i];
            final int randomStar = (new Random().nextInt(4)) + 1;
            final String ranking = recipeName + ": " + stars.get(randomStar);
            state.addRanking(ranking);
        }
        return state;
    }

    /**
     * Updates the star rating for a given recipe.
     *
     * @param recipeIndex the index of the recipe to update.
     * @param newStarCount the new star rating (1 to 5).
     */
    public void updateStarRating(int recipeIndex, int newStarCount) {
        final RankedViewState currentState = getState();
        final String recipeName = currentState.getRankings().get(recipeIndex).split(":")[0];
        final String newRanking = recipeName + ": " + stars.get(newStarCount);
        updateRanking(recipeIndex, newRanking);
    }

    /**
     * Updates the ranking of a recipe at a specific index.
     *
     * @param index the index of the recipe to update.
     * @param newRanking the new ranking string to set.
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
     * Adds a PropertyChangeListener to the view model. The listener will be notified
     * of changes to the rankings.
     *
     * @param listener the PropertyChangeListener to add.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Removes a PropertyChangeListener from the view model.
     *
     * @param listener the PropertyChangeListener to remove.
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    /**
     * Retrieves the current rankings as an array of strings.
     *
     * @return an array of strings representing the current rankings.
     */
    public String[] getRankings() {
        final List<String> rankingsList = getState().getRankings();
        return rankingsList.toArray(new String[0]);
    }
}
