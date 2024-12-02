package use_case.result;

import entity.GenericRecipeInterface;

/**
 * Input data for result use case.
 */
public class ResultInputData {
    private final GenericRecipeInterface recipe;
    private final String id;
    private final String name;

    public ResultInputData(GenericRecipeInterface recipe) {
        this.recipe = recipe;
        this.id = recipe.getId();
        this.name = recipe.getName();
    }

    public GenericRecipeInterface getRecipe() {
        return recipe;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
