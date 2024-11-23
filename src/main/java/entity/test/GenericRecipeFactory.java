package entity.test;

import entity.AdvancedRecipe;
import entity.GenericRecipe;
import entity.GenericRecipeFactoryInterface;

public class GenericRecipeFactory implements GenericRecipeFactoryInterface {
    @Override
    public GenericRecipe createGenericRecipe(String name, String id) {
        return new GenericRecipe(name, id);
    }

    @Override
    public AdvancedRecipe createAdvancedRecipe(String name, String id) {
        return null;
    }
}
