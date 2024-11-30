package dataaccess;

import data_access.RecipeIDToServings;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RecipeIDToServingsTest {
    @Test
    void recipeToServingsTest() throws IOException {
        String result = RecipeIDToServings.getServings("716429");
        System.out.println(result);
    }
}
