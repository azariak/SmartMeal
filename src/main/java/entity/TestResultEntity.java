package entity;

import java.util.ArrayList;
import java.util.Map;

/**
 * A result entity for testing purposes.
 */
public class TestResultEntity implements TestResultEntityInterface {

    private final String name;
    private final String imageUrl;
    private final Map<String, String> properties;
    private final ArrayList<String> ingredients;
    private final Map<String, String> ingredientAmount;
    private final ArrayList<String> steps;

    public TestResultEntity(String name,
                            String imageUrl,
                            Map<String, String> properties,
                            ArrayList<String> ingredients,
                            Map<String, String> ingredientAmount,
                            ArrayList<String> steps) {

        this.name = name;
        this.imageUrl = imageUrl;
        this.properties = properties;
        this.ingredients = ingredients;
        this.ingredientAmount = ingredientAmount;
        this.steps = steps;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getImage() {
        return imageUrl;
    }

    @Override
    public Map<String, String> getProperties() {
        return properties;
    }

    @Override
    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    @Override
    public Map<String, String> getIngredientAmount() {
        return ingredientAmount;
    }

    @Override
    public ArrayList<String> getSteps() {
        return steps;
    }
}
