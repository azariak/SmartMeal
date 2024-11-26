package data_access;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
    public static String recipeIDToRecipe(String id) {

        final String urlString = "https://api.spoonacular.com/recipes/"
                + id + "/information?apiKey=" + System.getenv("API_KEY");

        try {
            // Make a GET request to the API
            final URL url = new URL(urlString);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            // Set connection timeout (ms)
            connection.setConnectTimeout(5000);
            // Set read timeout (ms)
            connection.setReadTimeout(5000);

            // Get the response code
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                // If the request is successful, read the response
                final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                final StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Output the response (for now, just print it)
                return response.toString();
            }
            else {
                return "GET request failed. Response Code: " + responseCode;
            }

        }
        catch (IOException e) {
            e.printStackTrace();
            return "Failed.";
        }

    }
}
