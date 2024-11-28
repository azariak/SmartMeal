package dataaccess;

import data_access.RecipeIDToIngredients;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class RecipeIDToIngredientsTest {
    @Test
    public void generateIngredientsTest() throws IOException {
        ArrayList<String> result = RecipeIDToIngredients.getFullIngredients("1003464");
        System.out.println(result);
    }
}

