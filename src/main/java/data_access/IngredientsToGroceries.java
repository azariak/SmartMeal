package data_access;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * This class take a list of ingredients and serving number to use
 * the api call and return the possible grocery items needed for the recipe.
 */

public class IngredientsToGroceries {
    private static final String BASE_URL = "https://api.spoonacular.com/food/ingredients/map";

    /**
     * Returns a JSON Object with grocery information for a recipe.
     * @param info A string of list of ingredients and servings.
     * @return The list of JSON Objects with ingredient information or null if none.
     * @throws IOException if error occurs during API call.
     */
    public static ArrayList<JSONObject> getGroceries(String info) throws IOException {

        final String url = BASE_URL + "?apiKey=" + "ac77230dfdf14548b77b78cb800fe0af";

        // Make a POST request to the API
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // Write the request body (JSON payload)
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = info.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Read the response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Output Data
        final String stringresult = response.toString();
        final JSONArray jsonArray = new JSONArray(stringresult);
        final ArrayList<JSONObject> finalresult = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            finalresult.add(jsonArray.getJSONObject(i));
        }
        // return result.
        ArrayList<JSONObject> result = null;
        if (!(finalresult.equals(""))) {
            result = finalresult;
        }
        return result;
    }

}
