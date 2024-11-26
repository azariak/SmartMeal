package data_access;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import entity.GenericRecipe;
import use_case.recipe_detail.RecipeDetailDataAccessInterface;

/**
 * The data object for the api calls in spoonacular pertaining to Recipe Detail use case.
 */
public class RecipeDetailDataAccessObject implements RecipeDetailDataAccessInterface {

    @Override
    public ArrayList<Integer> getIngredientIds(GenericRecipe genericRecipe) {
        System.out.println(genericRecipe.getId());
        final String recipeString = RecipeIDToRecipe.recipeIDToRecipe(genericRecipe.getId());
        final JSONObject recipe = new JSONObject(recipeString);

        final JSONArray ingredientsArray = recipe.getJSONArray("extendedIngredients");

        final ArrayList<Integer> ingredientIds = new ArrayList<>();

        for (int i = 0; i < ingredientsArray.length(); i++) {
            final JSONObject ingredient = ingredientsArray.getJSONObject(i);
            ingredientIds.add(ingredient.getInt("id"));
        }

        return ingredientIds;
    }

    @Override
    public ArrayList<String> getIngredientsNames(ArrayList<Integer> ingredientIds) {
        final ArrayList<String> ingredientNames = new ArrayList<>();

        for (Integer ingredientId : ingredientIds) {
            final JSONObject ingredientInfo = IngredientIdToIngredientInfo.getIngredientInfo(ingredientId, 1.0);

            if (ingredientInfo != null && ingredientInfo.has("name")) {
                final String name = ingredientInfo.getString("name");
                ingredientNames.add(name);
            }
            else {
                System.out.println("Failed to fetch name for ingredient ID: " + ingredientId);
            }
        }

        return ingredientNames;
    }

    @Override
    public ArrayList<String> getQuantities(GenericRecipe genericRecipe) {
        final String recipeString = RecipeIDToRecipe.recipeIDToRecipe(genericRecipe.getId());
        final JSONObject recipe = new JSONObject(recipeString);

        final JSONArray ingredientsArray = recipe.getJSONArray("extendedIngredients");

        final ArrayList<String> ingredientQuantities = new ArrayList<>();

        for (int i = 0; i < ingredientsArray.length(); i++) {
            final JSONObject ingredient = ingredientsArray.getJSONObject(i);

            final double amount = ingredient.getDouble("amount");
            final JSONObject measures = ingredient.getJSONObject("measures").getJSONObject("metric");
            final String unitLong = measures.getString("unitLong");

            final String quantity;
            if (unitLong.isEmpty()) {
                quantity = Double.toString(amount);
            }
            else {
                quantity = amount + " " + unitLong.trim();
            }

            ingredientQuantities.add(quantity);
        }

        return ingredientQuantities;
    }

    @Override
    public String getInstructions(GenericRecipe genericRecipe) {
        final String recipeString = RecipeIDToRecipe.recipeIDToRecipe(genericRecipe.getId());
        final JSONObject recipe = new JSONObject(recipeString);

        return recipe.getString("instructions");
    }
}
