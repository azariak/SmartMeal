package data_access;

import java.io.FileWriter;
import java.io.IOException;

import entity.GenericRecipe;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import entity.AdvancedRecipe;
import use_case.saved_recipe.SavedRecipeDataAcessInterface;

/**
 * The DAO for Recipe data.
 */
public class FileRecipeSaver implements SavedRecipeDataAcessInterface {
    @Override
    public void save(AdvancedRecipe recipe) {
    }

    @Override
    public AdvancedRecipe get(String ingredient) {
        return null;
    }

    @Override
    public void saveRecipe(JSONObject recipeJson, String fileName) {
        try (FileWriter file = new FileWriter(fileName, true)) {
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
     * Saves the recipe from the API.
     * @param recipeId the recipe ID.
     */
    public JSONObject fetchrecipefromApi(String recipeId) {
        final String urlString = "https://api.spoonacular.com/recipes/" + recipeId + "/information?apiKey="
                + System.getenv("API_KEY");

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
                return new JSONObject(response.toString());
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
    }

    /**
     * Saves the recipe from the API.
     * @param recipeId the recipe ID.
     * @param fileName the file name.
     */
    public void saverecipefromApi(String recipeId, String fileName) {
        final JSONObject recipeJson = fetchrecipefromApi(recipeId);
        if (recipeJson != null) {
            saveRecipe(recipeJson, fileName);
        }
        else {
            System.err.println("Failed to save recipe from API.");
        }
    }

    @Override
    public GenericRecipe load(String id) {
        try {
            final String content = new String(Files.readAllBytes(Paths.get("recipes.json")));
            final String[] recipes = content.split(System.lineSeparator());

            for (String recipeStr : recipes) {
                final JSONObject recipeJson = new JSONObject(recipeStr);
                if (recipeJson.getString("id").equals(id)) {
                    return new GenericRecipe(recipeJson.getString("id"), recipeJson.getString("name"));
                }
            }
        }
        catch (IOException exception) {
            System.err.println("Error loading recipe: " + exception.getMessage());
        }
        return null;
    }
}
