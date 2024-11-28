package data_access;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import use_case.map_groceries.MapGroceriesDataAccessInterface;
/**
 * This class takes a given recipe ID and returns a Map of the required
 * ingredients.
 */
public class RecipeIDToIngredients {

    private static final String API_KEY = System.getenv("API_KEY");
    private static final String BASE_URL = "https://api.spoonacular.com/recipes/";

    /**
     * Returns a JSON Object with ingredient information for a recipe.
     * @param id the recipe id.
     * @return The JSON Object with ingredient information.
     * @throws IOException if error occurs during API call.
     */
    public JSONObject getFullIngredients(String id) throws IOException {
        final OkHttpClient client = new OkHttpClient();

        final String url = BASE_URL + id + "/ingredientWidget.json" + "&apiKey="
                + System.getenv("API_KEY");

        final Request request = new Request.Builder().url(url).get()
                .addHeader("Content-Type", "application/json").build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected Code: " + response);
            }
            return new JSONObject(response.toString());
        }
    }

}

