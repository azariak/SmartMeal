package entity;

import java.io.IOException;

import use_case.saved_recipe.SavedRecipeDataAcessInterface;

/**
 * The advanced recipe entity.
 */
public class AdvancedRecipe extends GenericRecipe implements AdvancedRecipeInterface {

    public AdvancedRecipe(String id, String name, SavedRecipeDataAcessInterface recipeSaver) throws IOException {
        super(name, id, recipeSaver);
    }

    @Override
    public String getingredients() {
        return "";
    }

    @Override
    public String getnutrition() {
        return "";
    }

    @Override
    public String getrecipename() {
        return "";
    }

    @Override
    public int getcooktime() {
        return 0;
    }

    @Override
    public String getsimilarrecipe() {
        return "";
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getId() {
        return super.getId();
    }
}
