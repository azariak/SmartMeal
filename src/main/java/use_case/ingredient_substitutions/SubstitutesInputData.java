package use_case.ingredient_substitutions;

/**
 * The input data for the ingredient substitutes use case.
 */
public class SubstitutesInputData {

    private final String ingredientName;

    public SubstitutesInputData(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientName() {
        return ingredientName;
    }
}
