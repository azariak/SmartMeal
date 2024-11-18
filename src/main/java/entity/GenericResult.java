package entity;

import java.util.ArrayList;

/**
 * The generic result entity.
 */
public class GenericResult implements Result {
    private final ArrayList<GenericRecipe> recipes;

    public GenericResult(ArrayList<GenericRecipe> recipes) {
        this.recipes = recipes;
    }
}
