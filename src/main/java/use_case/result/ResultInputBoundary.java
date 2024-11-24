package use_case.result;

import entity.GenericRecipe;

/**
 * The input boundary for the result use case.
 */
public interface ResultInputBoundary {

    /**
     * Execute a api call.
     * @param recipe the recipe to search.
     */
    void execute(GenericRecipe recipe);
}
