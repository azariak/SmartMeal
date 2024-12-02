package entity;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The generic recipe factory.
 */
public class GenericRecipeFactory implements GenericRecipeFactoryInterface {

    @Override
    public GenericRecipeInterface createGenericRecipe(String name, String id) throws IOException {
        return new GenericRecipe(name, id);
    }

    @Override
    public AdvancedRecipeInterface createAdvancedRecipe(String name,
                                                        String id,
                                                        ArrayList<String> ingredientNames,
                                                        ArrayList<String> ingredientQuantities,
                                                        String instructions) throws IOException {
        return new AdvancedRecipe(name,
                id,
                ingredientNames,
                ingredientQuantities,
                instructions);
    }
}
