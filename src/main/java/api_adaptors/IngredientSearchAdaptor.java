package api_adaptors;

/**
 * The adaptor that converts ingredient search output to api call.
 */
public class IngredientSearchAdaptor implements IngredientSearchAdaptorBoundary {
    @Override
    public void ingredientSearchToApiCall(String ingredient1, String ingredient2, String ingredient3) {
        final String ingrdients = ingredient1 + ", " + ingredient2 + ", " + ingredient3;
        System.out.println(ingrdients);
    }

}
