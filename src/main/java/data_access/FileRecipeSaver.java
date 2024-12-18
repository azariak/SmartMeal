package data_access;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import entity.AdvancedRecipeInterface;
import entity.GenericRecipe;
import use_case.load_saved_recipe.LoadSavedRecipeDataAccessInterface;
import use_case.saved_recipe.SavedRecipeDataAccessInterface;

/**
 * The DAO for Recipe data.
 */
public class FileRecipeSaver implements SavedRecipeDataAccessInterface,
        LoadSavedRecipeDataAccessInterface {
    private final List<AdvancedRecipeInterface> recipes = new ArrayList<>();

    @Override
    public void save(AdvancedRecipeInterface recipe) {
        recipes.add(recipe);
    }

    @Override
    public void search(AdvancedRecipeInterface recipe) {

    }

    @Override
    public AdvancedRecipeInterface get(String ingredient) {
        return null;
    }

    @Override
    public List<AdvancedRecipeInterface> getAllRecipes() {
        return new ArrayList<>(recipes);
    }

    @Override
    public void saveRecipe(JSONObject recipeJson, String fileName) {
        try (FileWriter file = new FileWriter("src/main/java/data_access/recipe.json", true)) {
            final int num = 4;
            file.write(recipeJson.toString(num));
            file.write(System.lineSeparator());
            System.out.println("Recipe saved successfully!");
        }
        catch (IOException exception) {
            System.err.println("Error saving recipe: " + exception.getMessage());
        }
    }

    /**
     * Main method.
     * @param args the arguments.
     */
    public static void main(String[] args) {
        final JSONObject recipeJson = new JSONObject();
        recipeJson.put("1", "lasagna");
        final FileRecipeSaver fileRecipeSaver = new FileRecipeSaver();
        fileRecipeSaver.saveRecipe(recipeJson, "/Users/anisa/Desktop/recipe.json");
        fileRecipeSaver.saveRecipeFromApi("716429", "/Users/anisa/Desktop/recipe.json");
    }

    /**
     * Saves the recipe from the API.
     * @param recipeId the recipe ID.
     */
    public JSONObject fetchRecipeFromApi(String recipeId) {
        final String urlString = "https://api.spoonacular.com/recipes/" + recipeId + "/information?apiKey="
                + System.getenv("API_KEY");

        JSONObject recipeJson = null;
        try {
            final URL url = new URL(urlString);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            final int num = 5000;
            connection.setConnectTimeout(num);
            connection.setReadTimeout(num);
            final int num2 = 200;
            final int responseCode = connection.getResponseCode();
            if (responseCode == num2) {
                final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                final StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                recipeJson = new JSONObject(response.toString());
            }
            else {
                System.err.println("Failed to fetch recipe. Response Code: " + responseCode);
                return null;
            }
        }
        catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }
        return recipeJson;
    }

    /**
     * Saves the recipe from the API.
     * @param recipeId the recipe ID.
     * @param fileName the file name.
     */
    public void saveRecipeFromApi(String recipeId, String fileName) {
        final JSONObject recipeJson = fetchRecipeFromApi(recipeId);
        if (recipeJson != null) {
            saveRecipe(recipeJson, "src/main/java/data_access/recipe.json");
        }
        else {
            System.err.println("Failed to save recipe from API.");
        }
    }

    @Override
    public GenericRecipe load(String id) {
        GenericRecipe recipe = null;

        try {
            final String content = new String(Files.readAllBytes(Paths.get("src/main/java/data_access/recipe.json")));
            final String[] recipes = content.split(System.lineSeparator());

            for (String recipeStr : recipes) {
                final JSONObject recipeJson = new JSONObject(recipeStr);
                if (recipeJson.getString("id").equals(id)) {
                    recipe = new GenericRecipe(recipeJson.getString("id"), recipeJson.getString("name"));
                    break;
                }
            }
        }
        catch (IOException exception) {
            System.err.println("Error loading recipe: " + exception.getMessage());
        }

        return recipe;
    }

    /**
     * Deletes the recipe.
     * @param recipeName the recipe name.
     */
    @Override
    public boolean delete(String recipeName) {
        try {
            final String filePath = "src/main/java/data_access/recipe.json";
            final String content = Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
            final String[] recipeLines = content.split(System.lineSeparator());
            boolean recipeFound = false;
            final StringBuilder updatedContent = new StringBuilder();

            for (String recipeStr : recipeLines) {
                final JSONObject recipeJson = new JSONObject(recipeStr);
                if (recipeJson.getString("name").equals(recipeName)) {
                    recipeFound = true;
                }
                else {
                    final int num = 4;
                    updatedContent.append(recipeJson.toString(num)).append(System.lineSeparator());
                }
            }
            if (recipeFound) {
                Files.writeString(Paths.get(filePath), updatedContent.toString(), StandardCharsets.UTF_8);
            }
            return recipeFound;
        }
        catch (IOException exception) {
            System.err.println("Error deleting recipe: " + exception.getMessage());
            return false;
        }
    }

    /**
     * Loads all the recipes.
     */
    public List<GenericRecipe> loadAll() {
        final List<GenericRecipe> recipes = new ArrayList();
        try {
            final String content = new String(Files.readAllBytes(Paths.get("src/main/java/data_access/recipe.json")));
            final String[] recipeLines = content.split(System.lineSeparator());

            for (String recipeStr : recipeLines) {
                final JSONObject recipeJson = new JSONObject(recipeStr);
                recipes.add(new GenericRecipe(
                        recipeJson.getString("id"),
                        recipeJson.getString("name")
                ));
            }
        }
        catch (IOException exception) {
            System.err.println("Error loading recipes: " + exception.getMessage());
        }
        return recipes;
    }
}
