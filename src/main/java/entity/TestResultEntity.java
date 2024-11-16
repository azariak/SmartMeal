package entity;

import java.util.ArrayList;
import java.util.Map;

/**
 * A result entity for testing.
 */
public class TestResultEntity implements TestResultEntityInterface {
    private Map<String, String> reciepeNameToId;

    public TestResultEntity(Map<String, String> reciepeNameToId) {
        this.reciepeNameToId = reciepeNameToId;
    }

    @Override
    public ArrayList<String> getRecipeNames() {

        final ArrayList<String> recipeNames = new ArrayList<>();

        recipeNames.addAll(reciepeNameToId.keySet());

        return recipeNames;
    }

    @Override
    public String getRecipeId(String recipeName) {

        return recipeName;
    }

}
