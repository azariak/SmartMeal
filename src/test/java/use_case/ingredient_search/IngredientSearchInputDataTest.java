package use_case.ingredient_search;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IngredientSearchInputDataTest {
    private final ArrayList<String> ingredients = new ArrayList<>();
    private IngredientSearchInputData dataAll;
    private IngredientSearchInputData dataOne;
    @BeforeEach
    void setUp() {
        ingredients.add("ingredient1");
        dataOne = new IngredientSearchInputData(ingredients);

        ingredients.add("ingredient2");
        ingredients.add("ingredient3");
        dataAll = new IngredientSearchInputData(ingredients);

    }

    @AfterEach
    void tearDown() {
        ingredients.clear();
    }

    @Test
    void getIngredients() {
        String ingredientStringAll = "ingredient1,ingredient2,ingredient3";
        assertEquals(ingredientStringAll, dataAll.getIngredients());

        String ingredientStringOne = "ingredient1";
        assertEquals(ingredientStringOne, dataOne.getIngredients());
    }
}