package entity.test;

import java.io.IOException;
import java.util.ArrayList;

import entity.AdvancedRecipe;
import entity.GenericRecipe;
import entity.GenericRecipeFactoryInterface;
import entity.TemporaryAdvancedRecipe;
import use_case.saved_recipe.SavedRecipeDataAcessInterface;

/**
 * The generic recipe factory.
 */
public class GenericRecipeFactory implements GenericRecipeFactoryInterface {

    @Override
    public GenericRecipe createGenericRecipe(String name, String id, SavedRecipeDataAcessInterface recipeSaver)
            throws IOException {
        return new GenericRecipe(name, id, recipeSaver);
    }

    @Override
    public GenericRecipe createGenericRecipe(String name, String id) throws IOException {
        return null;
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
