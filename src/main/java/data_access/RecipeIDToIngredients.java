package data_access;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;

/**
 * This class takes a given recipe ID and returns a JSONObject of the required
 * ingredients.
 */
public class RecipeIDToIngredients {

    private static final String BASE_URL = "https://api.spoonacular.com/recipes/";

    /**
     * Returns an array with ingredient information for a recipe.
     * @param id the recipe id.
     * @param keyManager The api key manager.
     * @return The ArrayList with ingredient names or null if request fails.
     * @throws IOException if error occurs during API call.
     */
    public static ArrayList<String> getFullIngredients(String id, ApiAccessKeyManagerInterface keyManager) throws IOException {
        ArrayList<String> result = null;
        final String apiKey = keyManager.getValidApiKey();

        final String urlString = BASE_URL + id + "/ingredientWidget.json" + "?apiKey="
                + apiKey;
        try {
            final URL url = new URL(urlString);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            final int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                final StringBuilder response = new StringBuilder();

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
