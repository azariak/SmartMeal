package entity;

import java.io.IOException;

import org.json.JSONObject;

import use_case.saved_recipe.SavedRecipeDataAcessInterface;

/**
 * A generic recipe entity with basic information of a recipe.
 */
public class GenericRecipe implements GenericRecipeInterface {
    private final String name;
    private final String id;
    private final SavedRecipeDataAcessInterface recipeSaver;

    public GenericRecipe(String name, String id, SavedRecipeDataAcessInterface recipeSaver) throws IOException {
        this.name = name;
        this.id = id;
        this.recipeSaver = recipeSaver;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    /**
     * Get JSONObject.
     * @return recipeJson.
     */
    public JSONObject toJson() {
        final JSONObject recipeJson = new JSONObject();
        recipeJson.put("id", this.id);
        recipeJson.put("name", this.name);
        return recipeJson;
    }

    /**
     * Save recipes.
     * @param fileName the file name.
     */
    public void save(String fileName) {
        final JSONObject recipeJson = this.toJson();
        recipeSaver.saveRecipe(recipeJson, fileName);
    }

}
