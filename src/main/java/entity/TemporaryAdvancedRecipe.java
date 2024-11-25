package entity;

import java.util.ArrayList;

/**
 * A temporary Advanced Recipe entity for the Recipe Detail use case.
 */
public class TemporaryAdvancedRecipe implements TemporaryAdvancedRecipeInterface{

    private String recipeName;
    private ArrayList<String> ingredientNames;
    private ArrayList<String> ingredientQuantities;
    private String instructions;

    public TemporaryAdvancedRecipe(String recipeName,
                                   ArrayList<String> ingredientNames,
                                   ArrayList<String> ingredientQuantities,
                                   String instructions) {
        this.recipeName = recipeName;
        this.ingredientNames = ingredientNames;
        this.ingredientQuantities = ingredientQuantities;
        this.instructions = instructions;
    }

    @Override
    public String getRecipeName() {
        return this.recipeName;
    }

    @Override
    public ArrayList<String> getIngredientNames() {
        return this.ingredientNames;
    }

    @Override
    public ArrayList<String> getIngredientQuantities() {
        return this.ingredientQuantities;
    }

    @Override
    public String getInstructions() {
        return this.instructions;
    }
}