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

    public static void main(String[] args) {

        final String id = "654959"; // Sample ID for Pasta with Tuna
        String urlString = "https://api.spoonacular.com/recipes/complexSearch?apiKey="
                + System.getenv("API_KEY") + "{" + id + "}" + "/information";

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
