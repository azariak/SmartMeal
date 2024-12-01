package data_access;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import entity.GenericRecipe;
import use_case.recipe_detail.RecipeDetailDataAccessInterface;

/**
 * The data access object for interacting with Spoonacular API to retrieve recipe details.
 */
public class RecipeDetailDataAccessObject implements RecipeDetailDataAccessInterface {

    private static final int TIMEOUT = 5000;
    private static final int SUCCESS_CODE = 200;

    private final ApiAccessKeyManagerInterface keyManager;

    public RecipeDetailDataAccessObject(ApiAccessKeyManagerInterface keyManager) {
        this.keyManager = keyManager;
    }

    @Override
    public ArrayList<Integer> getIngredientIds(GenericRecipe genericRecipe) {
        final ArrayList<Integer> ingredientIds = new ArrayList<>();
        final String recipeString = fetchRecipeDetails(genericRecipe.getId());

        if (recipeString != null) {
            final JSONObject recipe = new JSONObject(recipeString);
            final JSONArray ingredientsArray = recipe.getJSONArray("extendedIngredients");

            for (int i = 0; i < ingredientsArray.length(); i++) {
                final JSONObject ingredient = ingredientsArray.getJSONObject(i);
                ingredientIds.add(ingredient.getInt("id"));
            }
        }

        return ingredientIds;
    }

    @Override
    public ArrayList<String> getIngredientsNames(ArrayList<Integer> ingredientIds) {
        final ArrayList<String> ingredientNames = new ArrayList<>();
        for (Integer ingredientId : ingredientIds) {
            final JSONObject ingredientInfo = fetchIngredientInfo(ingredientId);
            if (ingredientInfo != null && ingredientInfo.has("name")) {
                ingredientNames.add(ingredientInfo.getString("name"));
            }
        }

        return ingredientNames;
    }

    @Override
    public ArrayList<String> getQuantities(GenericRecipe genericRecipe) {
        final ArrayList<String> ingredientQuantities = new ArrayList<>();
        final String recipeString = fetchRecipeDetails(genericRecipe.getId());

        if (recipeString != null) {
            final JSONObject recipe = new JSONObject(recipeString);
            final JSONArray ingredientsArray = recipe.getJSONArray("extendedIngredients");

            for (int i = 0; i < ingredientsArray.length(); i++) {
                final JSONObject ingredient = ingredientsArray.getJSONObject(i);
                final double amount = ingredient.getDouble("amount");
                final String unitLong = ingredient.getJSONObject("measures")
                        .getJSONObject("metric")
                        .getString("unitLong");

                if (unitLong.isEmpty()) {
                    ingredientQuantities.add(String.valueOf(amount));
                }
                else {
                    ingredientQuantities.add(amount + " " + unitLong);
                }
            }
        }

        return ingredientQuantities;
    }

    @Override
    public String getInstructions(GenericRecipe genericRecipe) {
        final String recipeString = fetchRecipeDetails(genericRecipe.getId());
        String instructions = null;

        if (recipeString != null) {
            final JSONObject recipe = new JSONObject(recipeString);
            instructions = recipe.getString("instructions");
        }

        return instructions;
    }

    /**
     * Fetch recipe details by recipe ID, using the API key from the key manager.
     * @param recipeId the id of the recipe
     */
    private String fetchRecipeDetails(String recipeId) {
        final String apiKey = keyManager.getValidApiKey();
        final String urlString = "https://api.spoonacular.com/recipes/" + recipeId + "/information?apiKey=" + apiKey;
        return makeApiRequest(urlString);
    }

    /**
     * Fetch ingredient information by ingredient ID, using the API key from the key manager.
     * @param ingredientId the id of the recipe.
     */
    private JSONObject fetchIngredientInfo(int ingredientId) {
        final String apiKey = keyManager.getValidApiKey();
        final String urlString = "https://api.spoonacular.com/food/ingredients/"
                + ingredientId + "/information?apiKey=" + apiKey;
        final String response = makeApiRequest(urlString);

        JSONObject ingredientInfo = null;
        if (response != null) {
            ingredientInfo = new JSONObject(response);
        }

        return ingredientInfo;
    }

    /**
     * Helper method for making API requests.
     * @param urlString the url as a String.
     */
    private String makeApiRequest(String urlString) {
        final StringBuilder response = new StringBuilder();
        int responseCode = -1;

        try {
            final URL url = new URL(urlString);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(TIMEOUT);
            connection.setReadTimeout(TIMEOUT);

            responseCode = connection.getResponseCode();

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
