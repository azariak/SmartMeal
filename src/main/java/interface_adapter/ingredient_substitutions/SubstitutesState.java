package interface_adapter.ingredient_substitutions;

import java.util.ArrayList;
/**
 * Contains important information to be displayed for the ingredient substitutions use case.
 */
public class SubstitutesState {
    private String ingredientName;
    private ArrayList<String> ingredientSubstitutes = new ArrayList<>();

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public ArrayList<String> getIngredientSubstitutes() {
        return ingredientSubstitutes;
    }

    public void setIngredientSubstitutes(ArrayList<String> ingredientSubstitutes) {
        this.ingredientSubstitutes = ingredientSubstitutes;
    }
}
