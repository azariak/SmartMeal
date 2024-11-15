package use_case.ingredient_search;

/**
 * The Input Data for the Ingredient search Use Case.
 */
public class IngredientSearchInputData {
    private final String ingredient1;
    private final String ingredient2;
    private final String ingredient3;

    public IngredientSearchInputData(String ingredient1, String ingredient2, String ingredient3) {
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
    }

    public String getIngredient1() {
        return ingredient1;
    }

    public String getIngredient2() {
        return ingredient2;
    }

    public String getIngredient3() {
        return ingredient3;
    }
}
