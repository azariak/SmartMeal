package entity;

import java.util.ArrayList;

/**
 * The generic result entity.
 */
public class GenericResult implements Result {
    private ArrayList<GenericRecipe> recipes;

    public GenericResult() {
        this.recipes = new ArrayList<>();
    }

    public GenericResult(ArrayList<GenericRecipe> recipes) {
        this.recipes = recipes;
    }

    /**
     * Add an array of recipe entities to result.
     * @param recipeToAdd recipe array.
     */
    public void addRecipe(ArrayList<GenericRecipe> recipeToAdd) {

        for (GenericRecipe recipeToAddRecipe : recipeToAdd) {
            Boolean contained = false;
            for (GenericRecipe recipe : recipes) {
                if (recipeToAddRecipe.getId().equals(recipe.getId())
                        && (recipeToAddRecipe.getName().equals(recipe.getName()))) {
                    contained = true;
                }
                if (!contained) {
                    recipes.add(recipeToAddRecipe);
                }
            }
        }
    }
}
