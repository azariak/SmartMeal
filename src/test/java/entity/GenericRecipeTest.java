package entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericRecipeTest {

    private GenericRecipe genericRecipe;

    @BeforeEach
    void setUp() throws IOException {
        String name = "Pancakes";
        String id = "5678";
        genericRecipe = new GenericRecipe(name, id);
    }

    @AfterEach
    void tearDown() {
        genericRecipe = null;
    }

    @Test
    void getName() {
        assertEquals("Pancakes", genericRecipe.getName());
    }

    @Test
    void getId() {
        assertEquals("5678", genericRecipe.getId());
    }

    @Test
    void save() {
        // Anisa implement
    }

    @Test
    void toJson() {
        // Anisa implement
    }
}
