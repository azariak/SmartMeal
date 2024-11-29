package interface_adapter.ingredient_search;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientSearchStateTest {
    private final IngredientSearchState state = new IngredientSearchState();

    @BeforeEach
    void setUp() {
        state.setIngredient1("beef");
        state.setIngredient2("chicken");
        state.setIngredient3("pasta");
    }

    @AfterEach
    void tearDown() {
        state.setIngredient1("beef");
        state.setIngredient2("chicken");
        state.setIngredient3("pasta");
    }

    @Test
    void getIngredient2() {
        assertEquals("chicken", state.getIngredient2());
    }

    @Test
    void getIngredient3() {
        assertEquals("pasta", state.getIngredient3());
    }

    @Test
    void getIngredient1() {
        assertEquals("beef", state.getIngredient1());
    }

    @Test
    void setIngredient1() {
        state.setIngredient1("test");
        assertEquals("test", state.getIngredient1());
    }

    @Test
    void setIngredient2() {
        state.setIngredient2("test");
        assertEquals("test", state.getIngredient2());
    }

    @Test
    void setIngredient3() {
        state.setIngredient3("test");
        assertEquals("test", state.getIngredient3());
    }
}