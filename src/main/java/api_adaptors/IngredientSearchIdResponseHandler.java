package api_adaptors;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class IngredientSearchIdResponseHandler implements ApiResponseHandlerInterface {
    private final JSONObject response;
    public IngredientSearchIdResponseHandler(JSONObject response) {
        this.response = response;
    }

    @Override
    public ArrayList<IdSearchResponseResultObject> responseOutput() {
        final ArrayList<IdSearchResponseResultObject> result = new ArrayList<>();
        final JSONArray recipes = response.getJSONArray("Results");
        for (var i = 0; i < recipes.length(); i++) {
            result.add(new IdSearchResponseResultObject(recipes.getJSONObject(i).getString("id"),
                recipes.getJSONObject(i).getString("title"),
                recipes.getJSONObject(i).getString("image"),
                recipes.getJSONObject(i).getString("imageType")));
            System.out.println(recipes.getJSONObject(i).getString("id"));
            System.out.println(recipes.getJSONObject(i).getString("title"));
            System.out.println(recipes.getJSONObject(i).getString("image"));
            System.out.println(recipes.getJSONObject(i).getString("imageType"));
        }
        return result;
    }
}
