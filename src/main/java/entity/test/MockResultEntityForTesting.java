package entity.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A mock result entity for testing.
 */
public class MockResultEntityForTesting implements TestResultEntityInterface {
    private Map<String, String> reciepeNameToId;

    public MockResultEntityForTesting(Map<String, String> reciepeNameToId) {
        this.reciepeNameToId = new HashMap<String, String>();
        reciepeNameToId.put("Apple Or Peach Strudel", "73420");
        reciepeNameToId.put("Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs", "716429");
    }

    @Override
    public ArrayList<String> getRecipeNames() {
        final ArrayList<String> recipeNames = new ArrayList<>();

        recipeNames.addAll(reciepeNameToId.keySet());

        return recipeNames;
    }

    @Override
    public String getRecipeId(String recipeName) {
        return reciepeNameToId.get(recipeName);
    }
}
