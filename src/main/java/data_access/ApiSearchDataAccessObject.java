package data_access;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import use_case.ingredient_search.IngredientSearchDataAccessInterface;

/**
 * The data access object for api search call to Spoonacular.
 */
public class ApiSearchDataAccessObject implements IngredientSearchDataAccessInterface {
    // Note: FOR EACH RECIPE, YOU NEED ANOTHER API CALL FOR THE RECIPE DETAILS.
    // Store the API key as a constant in your code. DO NOT PUSH TO GIT.
    static final int FIVE_THOUSAND = 5000;
    static final int TWO_HUNDRED = 200;

    public ApiSearchDataAccessObject() {
    }

    /**
     * This method fetches recipe data for a given list of ingredients from the Spoonacular API
     * and returns a HashMap mapping recipe names to their corresponding IDs.
     *
     * @param ingredients The comma-separated list of ingredients.
     * @return A HashMap where the key is the recipe name and the value is the recipe ID.
     */
    public Map<String, String> excuteSearch(String ingredients) {
        final Map<String, String> recipeMap = new HashMap<>();
        final String urlString = "https://api.spoonacular.com/recipes/complexSearch?apiKey="
                + System.getenv("API_KEY") + "&includeIngredients=" + ingredients + "&number=10";

        try {
            final URL url = new URL(urlString);
            System.out.println("Executed ingredient to recipe Search API");
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(FIVE_THOUSAND);
            connection.setReadTimeout(FIVE_THOUSAND);

            final int responseCode = connection.getResponseCode();
            if (responseCode == TWO_HUNDRED) {
                addResultToRecipeMap(connection, recipeMap);
            }
            else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        return recipeMap;
    }

    private void addResultToRecipeMap(HttpURLConnection connection, Map<String,
            String> recipeMap) throws IOException {
        final JSONArray results = getObjects(connection);

        for (int i = 0; i < results.length(); i++) {
            final JSONObject recipe = results.getJSONObject(i);
            final String title = recipe.getString("title");
            final String id = String.valueOf(recipe.getInt("id"));

            System.out.println(title);
            System.out.println(id);

            recipeMap.put(title, id);
        }
    }

    private JSONArray getObjects(HttpURLConnection connection) throws IOException {
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
