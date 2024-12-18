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
     * and returns a JSON string with Recipe information.
     *
     * @param id The ID of the recipe.
     * @return A JSON string containing the recipe details or an error message.
     */
    public static String recipeIDToRecipe(String id) {

        final String urlString =
                "https://api.spoonacular.com/recipes/" + id + "/information?apiKey=" + System.getenv("API_KEY");
        final int fiveThousand = 5000;
        final int twoHundred = 200;

        String result = "Failed.";

        try {
            // Make a GET request to the API
            System.out.println("Executed recipe ID to Recipe Detail Search");
            final URL url = new URL(urlString);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(fiveThousand);
            connection.setReadTimeout(fiveThousand);

            // Get the response code
            final int responseCode = connection.getResponseCode();

            // If the request is successful, read the response
            if (responseCode == twoHundred) {
                final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                final StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                result = response.toString();
            }
            else {
                result = "GET request failed. Response Code: " + responseCode;
            }

        }
        catch (IOException ex) {
            ex.printStackTrace();
            result = "Failed to fetch recipe data due to an exception.";
        }

        return result;
    }
}
