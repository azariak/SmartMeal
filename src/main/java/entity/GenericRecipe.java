package entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.FileWriter;

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

    @Override
    public void saveRecipe() {
        final JSONObject recipe = new JSONObject();
        recipe.put(this.id, this.name);
        final JSONArray recipeList = new JSONArray();
        recipeList.put(this);
        try {
            final FileWriter file = new FileWriter("recipename.json");
            file.write(recipe.toString());
        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
