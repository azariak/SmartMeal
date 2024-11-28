package data_access;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import org.json.JSONObject;
import org.json.JSONArray;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import use_case.map_groceries.MapGroceriesDataAccessInterface;

/**
 * This class takes a given recipe ID and returns a JSONObject of the required
 * ingredients.
 */
public class RecipeIDToIngredients {

    private static final String BASE_URL = "https://api.spoonacular.com/recipes/";

    /**
     * Returns an array with ingredient information for a recipe.
     * @param id the recipe id.
     * @return The ArrayList with ingredient names or null if request fails.
     * @throws IOException if error occurs during API call.
     */
    public static ArrayList<String> getFullIngredients(String id) throws IOException {
        ArrayList<String> result = null;

        final String urlString = BASE_URL + id + "/ingredientWidget.json" + "?apiKey="
                + "ac77230dfdf14548b77b78cb800fe0af";
        try {
            // Create url
            final URL url = new URL(urlString);
            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // Set request method type to GET
            connection.setRequestMethod("GET");
            // Get response code.
            final int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Output the list of ingredients.
                final String stringresult = response.toString();
                final JSONArray jsonArray = new JSONArray(stringresult.substring(15, stringresult.length() - 1));
                final ArrayList<String> finalresult = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    finalresult.add(jsonArray.getJSONObject(i).getString("name"));
                }
                result = finalresult;
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}