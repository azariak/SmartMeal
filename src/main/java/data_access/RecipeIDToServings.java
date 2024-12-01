package data_access;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * This class takes a given recipe ID and returns a string of number of
 * servings.
 */
public class RecipeIDToServings {

    private static final String BASE_URL = "https://api.spoonacular.com/recipes/";

    /**
     * Returns a list of length 2 with recipe info; [servings, title].
     * @param id the recipe id.
     * @return The list of info of strings or null if request fails.
     * @throws IOException if error occurs during API call.
     */
    public static ArrayList<String> getInfo(String id) throws IOException {
        ArrayList<String> result = null;

        final String urlString = BASE_URL + id + "/information" + "?apiKey="
                + "ac77230dfdf14548b77b78cb800fe0af";
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

                // Output the servings.
                final String stringresult = response.toString();

                // Convert JSON string to JSONObject
                final JSONObject jsonObject = new JSONObject(stringresult);

                // Convert JSONObject to HashMap
                final Map<String, Object> map = new HashMap<>();
                final Iterator<String> keys = jsonObject.keys();

                while (keys.hasNext()) {
                    final String key = keys.next();
                    map.put(key, jsonObject.get(key));
                }

                result = new ArrayList<String>();
                result.add(map.get("servings").toString());
                result.add(map.get("title").toString());

            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
