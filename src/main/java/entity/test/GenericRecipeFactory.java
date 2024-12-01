package entity.test;

import java.io.IOException;
import java.util.ArrayList;

import entity.AdvancedRecipe;
import entity.GenericRecipe;
import entity.GenericRecipeFactoryInterface;

/**
 * The generic recipe factory.
 */
public class GenericRecipeFactory implements GenericRecipeFactoryInterface {

    @Override
    public GenericRecipe createGenericRecipe(String name, String id) throws IOException {
        return new GenericRecipe(name, id);
    }

    @Override
    public AdvancedRecipe createAdvancedRecipe(String name,
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
