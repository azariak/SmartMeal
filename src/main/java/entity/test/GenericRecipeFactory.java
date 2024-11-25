package entity.test;

import entity.AdvancedRecipe;
import entity.GenericRecipe;
import entity.GenericRecipeFactoryInterface;

import java.io.IOException;

public class GenericRecipeFactory implements GenericRecipeFactoryInterface {
    @Override
    public GenericRecipe createGenericRecipe(String name, String id) throws IOException {
        return new GenericRecipe(name, id);
    }

    @Override
    public AdvancedRecipe createAdvancedRecipe(String name, String id) {
        return null;
    }
}
