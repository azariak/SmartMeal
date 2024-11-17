package data_access;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A class responsible for making an api call that takes an ingredient name and returns substitutes for that ingredient.
 */
public class IngredientToSubstitute {

    private static final String API_KEY = System.getenv("API_KEY");
    private static final String BASE_URL = "https://api.spoonacular.com/food/ingredients/substitutes";

    /**
     * Entry point for testing purposes.
     * @param args are the arguments.
     */
    public static void main(String[] args) {
        final String ingredientName = "butter";
        try {
            final String response = getIngredientSubstitutes(ingredientName);
            System.out.println(response);
        }
        catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }

    private static String getIngredientSubstitutes(String ingredientName) throws IOException {
        final OkHttpClient client = new OkHttpClient();

        // Build the API URL with the ingredient name and API key
        final String url = BASE_URL + "?apiKey=" + API_KEY + "&ingredientName=" + ingredientName;

        // https://api.spoonacular.com/food/ingredients/substitutes?ingredientName=butter
        // Create the request
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Content-Type", "application/json")
                .build();

        // Execute the request
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code: " + response);
            }
            // Return the API response body as a string
            return response.body().string();
        }
    }

}
