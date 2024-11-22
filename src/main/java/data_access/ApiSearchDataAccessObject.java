package data_access;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import entity.GenericRecipe;
import entity.GenericResult;

/**
 * The data access object for api search call to Spoonacular.
 */
public class ApiSearchDataAccessObject {
    // Note: FOR EACH RECIPE, YOU NEED ANOTHER API CALL FOR THE RECIPE DETAILS.
    // Store the API key as a constant in your code. DO NOT PUSH TO GIT.
    static final int FIVE_THOUSAND = 5000;
    static final int TWO_HUNDRED = 200;

    /**
     * This method fetches recipe data for a given list of ingredients from the Spoonacular API
     * and returns a HashMap mapping recipe names to their corresponding IDs.
     *
     * @param ingredients The comma-separated list of ingredients.
     * @return A HashMap where the key is the recipe name and the value is the recipe ID.
     */
    public static GenericResult ingredientsToRecipeID(String ingredients) {
        final ArrayList<GenericRecipe> resultRecipes = new ArrayList<>();
        final String urlString = "https://api.spoonacular.com/recipes/complexSearch?apiKey="
                + System.getenv("API_KEY") + "&includeIngredients=" + ingredients + "&number=10";

        try {
            final URL url = new URL(urlString);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(FIVE_THOUSAND);
            connection.setReadTimeout(FIVE_THOUSAND);

            final int responseCode = connection.getResponseCode();
            if (responseCode == TWO_HUNDRED) {
                final JSONArray results = getObjects(connection);

                for (int i = 0; i < results.length(); i++) {
                    addRecipeEntityToResult(results, i, resultRecipes);
                }
            }
            else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        final GenericResult result = new GenericResult(resultRecipes);
        return result;
    }

    private static void addRecipeEntityToResult(JSONArray results, int index, ArrayList<GenericRecipe> resultRecipes) {
        final JSONObject recipe = results.getJSONObject(index);
        final String title = recipe.getString("title");
        final String id = String.valueOf(recipe.getInt("id"));

        final GenericRecipe genericRecipe = new GenericRecipe(title, id);
        resultRecipes.add(genericRecipe);
    }

    private static JSONArray getObjects(HttpURLConnection connection) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        final StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        final JSONObject jsonObject = new JSONObject(response.toString());
        return jsonObject.getJSONArray("results");
    }
}
