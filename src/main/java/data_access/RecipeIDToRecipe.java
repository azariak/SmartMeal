package data_access;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

/**
 * This class takes a given recipe ID and returns a JSON of Recipe information.
 */
public class RecipeIDToRecipe {

    /**
     * This method fetches recipe data for a given recipe ID from the Spoonacular API
     * and returns a HashMap mapping the recipe name to its ID.
     *
     * @param id The ID of the recipe.
     * @return A HashMap where the key is the recipe name and the value is the recipe ID.
     */
    public static Map<String, Integer> recipeIDToRecipe(String id) {
        final Map<String, Integer> recipeMap = new HashMap<>();

        final String urlString = "https://api.spoonacular.com/recipes/" + id + "/information?apiKey=" + System.getenv("API_KEY");

        try {
            // Make a GET request to the API
            final URL url = new URL(urlString);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);  // Set connection timeout (ms)
            connection.setReadTimeout(5000);  // Set read timeout (ms)

            // Get the response code
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                // If the request is successful, read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse the response JSON
                JSONObject jsonObject = new JSONObject(response.toString());

                // Extract recipe name and ID from the JSON response
                String recipeName = jsonObject.getString("title");
                int recipeID = jsonObject.getInt("id");

                // Populate the map
                recipeMap.put(recipeName, recipeID);

            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return recipeMap;
    }
}
