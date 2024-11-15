package api_adaptors;

/**
 * The Boundary for ingredient search output.
 */
public interface IngredientSearchAdaptorBoundary {

    /**
     * Convert the ingredient search queries to api call.
     * @param ingredient1 ingredient input 1
     * @param ingredient2 ingredient input 2
     * @param ingredient3 ingredient input 3
     */
    void ingredientSearchToApiCall(String ingredient1, String ingredient2, String ingredient3);

    /**
     * Excutes the api call and then pass the result to result api adaptor.
     * @param ingredients ingredients
     */
    void excuteApiCall(String ingredients);
}
