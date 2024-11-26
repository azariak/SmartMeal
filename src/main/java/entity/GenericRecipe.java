package entity;

import java.io.IOException;

import org.json.JSONObject;

/**
 * A generic recipe entity with basic information of a recipe.
 */
public class GenericRecipe implements GenericRecipeInterface {
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

//    /**
//     * Save recipes.
//     * @param fileName the file name.
//     */
//    public void save(String fileName) {
//        final JSONObject recipeJson = this.toJson();
//        recipeSaver.saveRecipe(recipeJson, fileName);
//    }

}
