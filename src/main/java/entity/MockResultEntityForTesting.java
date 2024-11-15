package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MockResultEntityForTesting implements TestResultEntityInterface {

    private final String name;
    private final String imageUrl;
    private final Map<String, String> properties;
    private final ArrayList<String> ingredients;
    private final Map<String, String> ingredientAmount;
    private final ArrayList<String> steps;

    public MockResultEntityForTesting(String name,
                            String imageUrl,
                            Map<String, String> properties,
                            ArrayList<String> ingredients,
                            Map<String, String> ingredientAmount,
                            ArrayList<String> steps) {

        this.name = "Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs";
        this.imageUrl = "https://img.spoonacular.com/recipes/716429-556x370.jpg";
        final Map<String, String> propertiesMock = new HashMap<String, String>() {
            {
                put("cheap", "false");
                put("dairyFree", "false");
                put("glutenFree", "false");
                put("ketogenic", "false");
                put("lowFodmap", "false");
                put("vegan", "false");
                put("vegetarian", "false");
                put("veryHealthy", "false");
            }
        };
        final ArrayList<String> ingredientsMock = new ArrayList<String>();
        ingredientsMock.add("cauliflower florets");
        ingredientsMock.add("Cheese");
        ingredientsMock.add("extra virgin olive oil");
        ingredientsMock.add("pasta");
        ingredientsMock.add("red pepper flakes");
        ingredientsMock.add("salt and pepper");
        ingredientsMock.add("scallions");
        ingredientsMock.add("white wine");
        ingredientsMock.add("whole wheat bread crumbs");
        ingredientsMock.add("butter");
        ingredientsMock.add("garlic");
        this.properties = propertiesMock;
        this.ingredients = ingredientsMock;
        final Map<String, String> ingredientAmountMock = new HashMap<String, String>() {
            {
                put("cauliflower florets", "473.176 ml");
                put("Cheese", "2.0 Tbsps");
                put("extra virgin olive oil", "1.0 Tbsp");
                put("pasta", "170.097 g");
                put("red pepper flakes", "2.0 pinches");
                put("salt and pepper", "2.0 servings");
                put("scallions", "3.0 ");
                put("whole wheat bread crumbs", "59.147 ml");
                put("white wine", "2.0 Tbsps");
                put("butter", "1.0 Tbsp");
                put("garlic", "5.0 cloves");
            }
        };
        this.ingredientAmount = ingredientAmountMock;
        final ArrayList<String> mockSteps = new ArrayList<>();
        mockSteps.add("step 1");
        mockSteps.add("step 2");
        mockSteps.add("step 3");
        mockSteps.add("step 4");
        this.steps = mockSteps;
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
