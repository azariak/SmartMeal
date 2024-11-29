package interface_adapter.ranked;

import entity.GenericRecipe;

import java.util.ArrayList;
import java.util.List;

/**
 * The state for the Ranked View.
 */
public class RankedViewState {
    private final List<String> rankings = new ArrayList<>();

    /**
     * Gets the list of rankings.
     *
     * @return The rankings as a List of Strings.
     */
    public List<String> getRankings() {
        return new ArrayList<>(rankings);
    }

    /**
     * Adds a new ranking to the state.
     *
     * @param ranking The ranking to add.
     */
    public void addRanking(String ranking) {
        rankings.add(ranking);
    }

    /**
     * Updates a ranking at the specified index.
     *
     * @param index   The index of the ranking to update.
     * @param ranking The new ranking string.
     */
    public void updateRanking(int index, String ranking) {
        rankings.set(index, ranking);
    }

    public void setGenericRecipe(GenericRecipe genericRecipe) {
    }
}
