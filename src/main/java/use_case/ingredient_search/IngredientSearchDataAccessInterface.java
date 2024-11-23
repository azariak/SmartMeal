package use_case.ingredient_search;

import java.util.Map;

/**
 * The interface for ingredient search data access object.
 */
public interface IngredientSearchDataAccessInterface {

    /**
     * Excutes the API search.
     * @param ingredients A string of ingredients separated by comma.
     * @return The results.
     */
    Map<String, String> excuteSearch(String ingredients);
}
