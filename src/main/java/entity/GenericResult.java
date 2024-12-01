package entity;

import java.util.ArrayList;

/**
 * The generic result entity.
 */
public class GenericResult implements Result {

    private final ArrayList<GenericRecipeInterface> recipes;

    public GenericResult() {
        this.recipes = new ArrayList<>();
    }

    public GenericResult(ArrayList<GenericRecipeInterface> recipes) {
        this.recipes = recipes;
    }

    /**
     * Add an array of recipe entities to result.
     * @param recipeToAdd recipe array.
     */
    public void addRecipe(ArrayList<GenericRecipeInterface> recipeToAdd) {

        for (GenericRecipeInterface recipeToAddRecipe : recipeToAdd) {
            boolean contained = false;
            for (GenericRecipeInterface recipe : recipes) {
                if (recipeToAddRecipe.getId().equals(recipe.getId())
                        && (recipeToAddRecipe.getName().equals(recipe.getName()))) {
                    contained = true;
                }
            }

            if (!contained) {
                recipes.add(recipeToAddRecipe);
            }
        }
    }

    public ArrayList<GenericRecipeInterface> getRecipes() {
        return recipes;
    }

}
