package entity;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The advanced recipe entity.
 */
public class AdvancedRecipe extends GenericRecipe implements AdvancedRecipeInterface {

    private final ArrayList<String> ingredientNames;
    private final ArrayList<String> ingredientQuantities;
    private final String instructions;

    public AdvancedRecipe(String name,
                          String id,
                          ArrayList<String> ingredientNames,
                          ArrayList<String> ingredientQuantities,
                          String instructions) throws IOException {
        super(name, id);
        this.ingredientNames = ingredientNames;
        this.ingredientQuantities = ingredientQuantities;
        this.instructions = instructions;
    }

    @Override
    public String getRecipeName() {
        return super.getName();
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
