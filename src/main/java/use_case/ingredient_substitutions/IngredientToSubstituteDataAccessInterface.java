package use_case.ingredient_substitutions;

import java.io.IOException;

/**
 * Interface for data access operations related to ingredient substitutes.
 */
public interface IngredientToSubstituteDataAccessInterface {

    /**
     * Retrieves substitutes for the specified ingredient by making an API call.
     *
     * @param ingredientName the name of the ingredient to find substitutes for.
     * @return a JSON string containing the ingredient and its substitutes.
     * @throws IOException if an error occurs during the API call.
     */
    String getIngredientSubstitutes(String ingredientName) throws IOException;
}
