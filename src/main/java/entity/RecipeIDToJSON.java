package entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This class takes a given recipe ID and returns a JSON of Recipe information.
 */
public class RecipeIDToJSON {

    private static final String API_KEY = " ";

    public static void main(String[] args) {

        if (API_KEY == null || API_KEY.isEmpty()) {
            System.out.println("API key is missing!");
            return;
        }

        String id = "638369"; // Sample ID for Korean Chicken
        String urlString = "https://api.spoonacular.com/recipes/" + id +"/information";

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
