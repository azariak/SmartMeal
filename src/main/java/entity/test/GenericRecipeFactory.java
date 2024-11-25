package entity.test;

import java.util.ArrayList;

import entity.AdvancedRecipe;
import entity.GenericRecipe;
import entity.GenericRecipeFactoryInterface;
import entity.TemporaryAdvancedRecipe;

/**
 * Omitted.
 */
public class GenericRecipeFactory implements GenericRecipeFactoryInterface {
    @Override
    public GenericRecipe createGenericRecipe(String name, String id) {
        return new GenericRecipe(name, id);
    }

    @Override
    public AdvancedRecipe createAdvancedRecipe(String name, String id) {
        return null;
    }

    @Override
    public TemporaryAdvancedRecipe createTemporaryAdvancedRecipe(String recipeName,
                                                          ArrayList<String> ingredientNames,
                                                          ArrayList<String> ingredientQuantities,
                                                          String instructions) {
        return new TemporaryAdvancedRecipe(
                recipeName,
                ingredientNames,
                ingredientQuantities,
                instructions);
    }
}
