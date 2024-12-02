package entity;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import data_access.FileRecipeSaver;

/**
 * A generic recipe entity with basic information of a recipe.
 */
public class GenericRecipe extends GenericRecipeFactory implements GenericRecipeInterface {
    private final String name;
    private final String id;

    public GenericRecipe(String name, String id) throws IOException {
        this.name = name;
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void save(FileRecipeSaver recipeSaver) {
        final Gson gson = new Gson();
        gson.toJson(this);

    }

    /**
     * Get JSONObject.
     * @return recipeJson.
     */
    public JSONObject toJson() {
        final JSONObject recipeJson = new JSONObject();
        recipeJson.put("recipe id", this.id);
        recipeJson.put("recipe", this.name);
        final JSONArray recipeList = new JSONArray();
        recipeList.put(this);
        return recipeJson;
    }

}
