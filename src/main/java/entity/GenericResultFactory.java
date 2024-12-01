package entity;

import java.util.ArrayList;

/**
 * The factory for generic result.
 */
public class GenericResultFactory implements ResultFactoryInterface {
    @Override
    public GenericResult createResult(ArrayList<GenericRecipe> recipes) {
        return new GenericResult(recipes);
    }
}
