package data_access;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 * This class fetches ingredient information using the Spoonacular API.
 */
public class IngredientIdToIngredientInfo {

    static final int TIMEOUT = 5000;
    static final int SUCCESS_CODE = 200;

    /**
     * Fetches information for a specific ingredient ID.
     *
     * @param ingredientId The ID of the ingredient.
     * @param amount       The amount of the ingredient.
     * @return A JSONObject containing ingredient information, or null if the request fails.
     */
    public static JSONObject getIngredientInfo(int ingredientId, double amount) {
        JSONObject result = null;

        final String urlString = "https://api.spoonacular.com/food/ingredients/"
                + ingredientId
                + "/information?amount="
                + amount
                + "&apiKey="
                + System.getenv("API_KEY");

        try {
            final URL url = new URL(urlString);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(TIMEOUT);
            connection.setReadTimeout(TIMEOUT);

            final int responseCode = connection.getResponseCode();
            if (responseCode == SUCCESS_CODE) {
                result = getResponseObject(connection);
            }
            else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    private static JSONObject getResponseObject(HttpURLConnection connection) throws IOException {
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
