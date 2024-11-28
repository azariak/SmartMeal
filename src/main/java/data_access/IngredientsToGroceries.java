package data_access;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class take a list of ingredients and serving number to use
 * the api call and return the possible grocery items needed for the recipe.
 */

public class IngredientsToGroceries {
    private static final String BASE_URL = "https://api.spoonacular.com/food/ingredients/map";

    /**
     * Returns a JSON Object with grocery information for a recipe.
     * @param input A string of list of ingredients and servings.
     * @return The list of JSON Objects with ingredient information.
     * @throws IOException if error occurs during API call.
     */
    public static ArrayList<JSONObject> getFullIngredients(String id) throws IOException {
        /* final OkHttpClient client = new OkHttpClient();

        final String url = BASE_URL + id + "/ingredientWidget.json";

        final Request request = new Request.Builder().url(url).get()
                .addHeader("Content-Type", "application/json").build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected Code: " + response);
            }
            final String stringresult = response.body().toString();
            final JSONArray jsonArray = new JSONArray(stringresult);
            final ArrayList<JSONObject> finalresult = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                finalresult.add(jsonArray.getJSONObject(i));
            }
            return finalresult;
        } */
        return null;
    }

}