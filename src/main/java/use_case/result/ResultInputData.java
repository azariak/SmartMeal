package use_case.result;

import entity.GenericRecipe;

/**
 * Input data for result use case.
 */
public class ResultInputData {
    private final GenericRecipe recipe;
    private final String id;
    private final String name;

    public ResultInputData(GenericRecipe recipe) {
        this.recipe = recipe;
        this.id = recipe.getId();
        this.name = recipe.getName();
    }

    public GenericRecipe getRecipe() {
        return recipe;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
