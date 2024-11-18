package entity;

/**
 * A HashMap of Recipes to their Ranking.
 */
public interface Ranked {

    /**
     * Given the ID of a Recipe, return its ranking.
     */
    void get_ranking(String recipe);

    /**
     * Given the ID of a Recipe, and a new ranking, set its ranking.
     */
    void set_ranking(String recipe, Integer new_ranking);

}
