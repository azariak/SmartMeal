package interface_adapter.recipe_detail;

import java.util.List;

/**
 * ViewModel for the RecipeDetailView.
 * Encapsulates the data required to render the RecipeDetailView.
 */
public class RecipeDetailViewModel {

    private String recipeName;
    private List<String> ingredients;
    private List<String> quantities;
    private String instructions;

    public RecipeDetailViewModel(String recipeName, List<String> ingredients, List<String> quantities, String instructions) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.quantities = quantities;
        this.instructions = instructions;
    }

    // Getters and Setters
    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<String> quantities) {
        this.quantities = quantities;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
