package entity.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jetbrains.annotations.NotNull;

/**
 * A mock result entity.
 */
public class MockRecipeEntityForTesting implements TestRecipeEntityInterface {

    private final String name;
    private final String id;
    private final String imageUrl;
    private final Map<String, String> properties;
    private final ArrayList<String> ingredients;
    private final Map<String, String> ingredientAmount;
    private final ArrayList<String> steps;

    public MockRecipeEntityForTesting(String name,
                                      String imageUrl,
                                      Map<String, String> properties,
                                      ArrayList<String> ingredients,
                                      Map<String, String> ingredientAmount,
                                      ArrayList<String> steps, String id) {
        this.id = "73420";

        final Map<String, String> propertiesMock = setUpMockProperties();

        final ArrayList<String> ingredientsMock = setUpMockIngredients();

        final Map<String, String> ingredientAmountMock = setUpMockIngredientAmount();

        final ArrayList<String> mockSteps = setUpMockSteps();

        this.name = "Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs";
        this.imageUrl = "https://img.spoonacular.com/recipes/716429-556x370.jpg";
        this.properties = propertiesMock;
        this.ingredients = ingredientsMock;
        this.ingredientAmount = ingredientAmountMock;
        this.steps = mockSteps;
    }

    @NotNull
    private static ArrayList<String> setUpMockSteps() {
        final ArrayList<String> mockSteps = new ArrayList<>();
        mockSteps.add("step 1");
        mockSteps.add("step 2");
        mockSteps.add("step 3");
        mockSteps.add("step 4");
        return mockSteps;
    }

    @NotNull
    private static Map<String, String> setUpMockIngredientAmount() {
        final Map<String, String> ingredientAmountMock = new HashMap<String, String>();
        ingredientAmountMock.put("cauliflower florets", "473.176 ml");
        ingredientAmountMock.put("Cheese", "2.0 Tbsps");
        ingredientAmountMock.put("extra virgin olive oil", "1.0 Tbsp");
        ingredientAmountMock.put("pasta", "170.097 g");
        ingredientAmountMock.put("red pepper flakes", "2.0 pinches");
        ingredientAmountMock.put("salt and pepper", "2.0 servings");
        ingredientAmountMock.put("scallions", "3.0 ");
        ingredientAmountMock.put("whole wheat bread crumbs", "59.147 ml");
        ingredientAmountMock.put("white wine", "2.0 Tbsps");
        ingredientAmountMock.put("butter", "1.0 Tbsp");
        ingredientAmountMock.put("garlic", "5.0 cloves");
        return ingredientAmountMock;
    }

    @NotNull
    private static ArrayList<String> setUpMockIngredients() {
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
        return ingredientsMock;
    }

    @NotNull
    private static Map<String, String> setUpMockProperties() {
        final Map<String, String> propertiesMock = new HashMap<String, String>();
        final String falseString = "false";
        propertiesMock.put("cheap", falseString);
        propertiesMock.put("dairyFree", falseString);
        propertiesMock.put("glutenFree", falseString);
        propertiesMock.put("ketogenic", falseString);
        propertiesMock.put("lowFodmap", falseString);
        propertiesMock.put("vegan", falseString);
        propertiesMock.put("vegetarian", falseString);
        propertiesMock.put("veryHealthy", falseString);
        return propertiesMock;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
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
