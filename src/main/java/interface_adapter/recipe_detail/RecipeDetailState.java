package interface_adapter.recipe_detail;

import java.util.ArrayList;

/**
 * RecipeDetailState. This contains the important information to be displayed.
 */
public class RecipeDetailState {
    private String recipeName = "";
    private ArrayList<String> ingredients = new ArrayList<>();
    private ArrayList<String> quantities = new ArrayList<>();
    private String instructions = "";

    public String getRecipName() {
        return recipeName;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    /**
     * Getter method for quantities attribute.
     * @return an array list of quantities for each respective ingredient.
     */
    public ArrayList<String> getquantities() {
        return quantities;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setRecipName(String recipeName2) {
        this.recipeName = recipeName2;
    }

    public void setIngredients(ArrayList<String> ingredients2) {
        this.ingredients = ingredients2;
    }

    /**
     * Sets the quantities for each ingredient.
     * @param quantities2 is an array list of quantities.
     */
    public void setquantities(ArrayList<String> quantities2) {
        this.quantities = quantities2;
    }

    public void setInstructions(String instructions2) {
        this.instructions = instructions2;
    }

}
