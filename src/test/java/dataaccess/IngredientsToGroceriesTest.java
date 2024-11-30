package dataaccess;

import data_access.IngredientsToGroceries;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class IngredientsToGroceriesTest {
    @Test
    void ingredientsToGroceriesTest() throws IOException {
        ArrayList<JSONObject> result = IngredientsToGroceries.getGroceries("{ \"ingredients\": [\"eggs\",\"bacon\"], \"servings\": 2 }");
        System.out.println(result);
    }
}
