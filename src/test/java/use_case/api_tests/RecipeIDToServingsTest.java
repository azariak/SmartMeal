package use_case.api_tests;

import data_access.ApiAccessKeyManager;
import data_access.ApiAccessKeyManagerInterface;
import data_access.RecipeIDToRecipe;
import data_access.RecipeIDToServings;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RecipeIDToServingsTest {
    @Test
    void successTest() {
        ApiAccessKeyManagerInterface api = new ApiAccessKeyManager();
        ArrayList<String> recipe = RecipeIDToServings.getInfo("716429", api);
        System.out.println(recipe);
    }
}
