package use_case.ingredient_substitutions;

/**
 * Input data class for retrieving ingredient substitutes.
 */
public class IngredientToSubstituteInputData {
    private final String ingredientName;

    public IngredientToSubstituteInputData(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientName() {
        return ingredientName;
    }
}
