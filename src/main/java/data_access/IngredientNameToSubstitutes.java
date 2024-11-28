package data_access;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * A class responsible for making an API call that takes an ingredient name and returns an arraylist of substitutes for
 * that ingredient.
 */
public class IngredientNameToSubstitutes {

    static final int TIMEOUT = 5000;
    static final int HTTP_OK = 200;

    /**
     * Makes an API call to Spoonacular's Get Ingredient Substitutes endpoint and retrieves
     * an arraylist of substitutes for the given ingredient.
     *
     * @param ingredientName The name of the ingredient to find substitutes for.
     * @return An arraylist of substitutes for the ingredient.
     */
    public static ArrayList<String> ingredientNameToSubstitutes(String ingredientName) {
        final ArrayList<String> ingredientSubstitutes = new ArrayList<>();

        final String urlString = "https://api.spoonacular.com/food/ingredients/substitutes?apiKey="
                + System.getenv("API_KEY") + "&ingredientName=" + ingredientName;

        try {
            final URL url = new URL(urlString);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(TIMEOUT);
            connection.setReadTimeout(TIMEOUT);

            final int responseCode = connection.getResponseCode();
            if (responseCode == HTTP_OK) {

                final JSONObject responseObject = getResponseAsJSON(connection);

                if (responseObject.has("substitutes")) {
                    final JSONArray substitutesArray = responseObject.getJSONArray("substitutes");
                    for (int i = 0; i < substitutesArray.length(); i++) {
                        ingredientSubstitutes.add(substitutesArray.getString(i));
                    }
                }
                else {
                    System.out.println("No substitutes found for the ingredient: " + ingredientName);
                }
            }
            else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return ingredientSubstitutes;
    }

    /**
     * Reads the response from the HTTP connection and converts it to a JSONObject.
     *
     * @param connection The HTTP connection.
     * @return A JSONObject containing the response.
     * @throws IOException If an error occurs while reading the response.
     */
    private static JSONObject getResponseAsJSON(HttpURLConnection connection) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        final StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return new JSONObject(response.toString());
    }
}
