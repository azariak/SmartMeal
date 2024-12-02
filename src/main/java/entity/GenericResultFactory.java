package entity;

import java.util.ArrayList;

/**
 * The factory for generic result.
 */
public class GenericResultFactory implements ResultFactoryInterface {
    @Override
    public Result createResult(ArrayList<GenericRecipeInterface> recipes) {
        return new GenericResult(recipes);
    }
}
