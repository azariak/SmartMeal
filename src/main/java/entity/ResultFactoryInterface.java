package entity;

import java.util.ArrayList;

/**
 * Factory for creating results.
 */
public interface ResultFactoryInterface {
    /**
     * Creates a new Result.
     *
     * @param recipes a list of recipes to be included in result
     * @return the new result
     */
    Result createResult(ArrayList<GenericRecipe> recipes);
}
