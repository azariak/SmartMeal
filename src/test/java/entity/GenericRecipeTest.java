package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GenericRecipeTest {
     GenericRecipe entity;

    @BeforeEach
    void setUp() throws IOException {
        entity = new GenericRecipe("name", "id");
    }

    @Test
    void getName() {
        assertEquals("name", entity.getName());
    }

    @Test
    void getId() {
        assertEquals("id", entity.getId());
    }

    @Test
    void save() {

    }

    @Test
    void toJson() {
    }
}