package entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdvancedRecipeTest {

    private AdvancedRecipe advancedRecipe;

    @BeforeEach
    void setUp() throws IOException {
        String name = "Chocolate Cake";
        String id = "1234";
        ArrayList<String> ingredientNames = new ArrayList<>();
        ingredientNames.add("Flour");
        ingredientNames.add("Sugar");
        ingredientNames.add("Cocoa Powder");

        ArrayList<String> ingredientQuantities = new ArrayList<>();
        ingredientQuantities.add("2 cups");
        ingredientQuantities.add("1 cup");
        ingredientQuantities.add("1/2 cup");

        String instructions = "Mix all ingredients and bake for 30 minutes at 350°F.";

        advancedRecipe = new AdvancedRecipe(name, id, ingredientNames, ingredientQuantities, instructions);
    }

    @AfterEach
    void tearDown() {
        advancedRecipe = null;
    }

    @Test
    void getRecipeName() {
        assertEquals("Chocolate Cake", advancedRecipe.getRecipeName());
    }

    @Test
    void getIngredientNames() {
        ArrayList<String> expectedNames = new ArrayList<>();
        expectedNames.add("Flour");
        expectedNames.add("Sugar");
        expectedNames.add("Cocoa Powder");

        assertEquals(expectedNames, advancedRecipe.getIngredientNames());
    }

    @Test
    void getIngredientQuantities() {
        ArrayList<String> expectedQuantities = new ArrayList<>();
        expectedQuantities.add("2 cups");
        expectedQuantities.add("1 cup");
        expectedQuantities.add("1/2 cup");

        assertEquals(expectedQuantities, advancedRecipe.getIngredientQuantities());
    }

    @Test
    void getInstructions() {
        assertEquals("Mix all ingredients and bake for 30 minutes at 350°F.", advancedRecipe.getInstructions());
    }
}
