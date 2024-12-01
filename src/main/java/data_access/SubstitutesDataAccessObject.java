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
 * The data access object for interacting with Spoonacular API to retrieve ingredient substitutes.
 */
public class SubstitutesDataAccessObject {

    private static final int TIMEOUT = 5000;
    private static final int SUCCESS_CODE = 200;
    private final ApiAccessKeyManagerInterface keyManager;

    public SubstitutesDataAccessObject(ApiAccessKeyManagerInterface keyManager) {
        this.keyManager = keyManager;
    }

    /**
     * Fetch ingredient substitutes based on the ingredient name.
     * @param ingredientName The name of the ingredient for which we need substitutes.
     * @return A list of ingredient substitute names.
     */
    public ArrayList<String> getSubstitutes(String ingredientName) {
        final ArrayList<String> substitutes = new ArrayList<>();
        final String urlString = buildSubstituteUrl(ingredientName);
        final String response = makeApiRequest(urlString);

        if (response != null) {
            final JSONObject jsonResponse = new JSONObject(response);
            final JSONArray substitutions = jsonResponse.getJSONArray("substitutes");

            for (int i = 0; i < substitutions.length(); i++) {
                substitutes.add(substitutions.getString(i));
            }
        }

        return substitutes;
    }

    /**
     * Build the URL to fetch ingredient substitutes based on the ingredient name.
     * @param ingredientName The name of the ingredient for which we need substitutes.
     * @return The constructed URL string.
     */
    private String buildSubstituteUrl(String ingredientName) {
        final String apiKey = keyManager.getValidApiKey();
        return "https://api.spoonacular.com/food/ingredients/substitutes?ingredientName="
                + ingredientName + "&apiKey=" + apiKey;
    }

    /**
     * Helper method for making API requests.
     * @param urlString the URL as a String.
     * @return The response from the API as a String, or null if there was an error.
     */
    private String makeApiRequest(String urlString) {
        final StringBuilder response = new StringBuilder();

        try {
            final URL url = new URL(urlString);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(TIMEOUT);
            connection.setReadTimeout(TIMEOUT);

            final int responseCode = connection.getResponseCode();
            if (responseCode == SUCCESS_CODE) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                }
            }
            else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        final String finalResponse;

        if (response.length() > 0) {
            finalResponse = response.toString();
        }
        else {
            finalResponse = null;
        }
        return finalResponse;
    }
}
