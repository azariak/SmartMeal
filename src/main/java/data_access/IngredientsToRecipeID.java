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

/**
 * This class returns a list of recipes for the given ingredients.
 */
public class IngredientsToRecipeID {

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
    public static Map<String, Integer> ingredientsToRecipeID(String ingredients) {
        final Map<String, Integer> recipeMap = new HashMap<>();
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
                    final JSONObject recipe = results.getJSONObject(i);
                    final String title = recipe.getString("title");
                    final int id = recipe.getInt("id");

                    recipeMap.put(title, id);
                }
            }
            else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return recipeMap;
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
