package entity;

import java.util.ArrayList;

/**
 * The factory for generic result.
 */
public class GenericResultFactory implements ResultFactoryInterface {
    @Override
    public GenericResult createGenericResult(ArrayList<GenericRecipe> recipes) {
        return new GenericResult(recipes);
    }
}
