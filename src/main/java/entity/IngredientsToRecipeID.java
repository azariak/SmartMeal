package entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This class returns a list of recipes for the given ingredients.
 */
public class IngredientsToRecipeID {

    // Note: FOR EACH RECIPE, YOU NEED ANOTHER API CALL FOR THE RECIPE DETAILS.


    // Store the API key as a constant in your code. DO NOT PUSH TO GIT.
    private static final String API_KEY = "";

    public static void main(String[] args) {

        String ingredients = "chicken, flour,sugar, eggs, avacodo";
        String urlString = "https://api.spoonacular.com/recipes/complexSearch?apiKey="
                + API_KEY + "&includeIngredients=" + ingredients + "&number=10";

        try {
            // Make a GET request to the API
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);  // Set connection timeout (ms)
            connection.setReadTimeout(5000);  // Set read timeout (ms)

            // Get the response code
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                // If the request is successful, read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Output the response (for now, just print it)
                System.out.println(response.toString());
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
