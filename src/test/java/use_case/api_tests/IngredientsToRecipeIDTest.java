package use_case.api_tests;

import org.junit.jupiter.api.Test;

import data_access.IngredientsToRecipeID;
import java.util.Map;

class IngredientsToRecipeIDTest {
    @Test
    void successTest() {
        Map<String, Integer> recipes = IngredientsToRecipeID.ingredientsToRecipeID("tomato,cheese,basil");
        System.out.println(recipes);
    }
}


