package use_case.ingredient_substitutions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SubstitutesOutputDataTest {

    private SubstitutesOutputData substitutesOutputData;
    private ArrayList<String> substitutes;

    @BeforeEach
    void setUp() {
        substitutes = new ArrayList<>();
        substitutes.add("Honey");
        substitutes.add("Maple Syrup");
        substitutesOutputData = new SubstitutesOutputData("Sugar", substitutes, false);
    }

    @AfterEach
    void tearDown() {
        substitutesOutputData = null;
        substitutes = null;
    }

    @Test
    void getIngredientName() {
        assertEquals("Sugar", substitutesOutputData.getIngredientName());
    }

    @Test
    void getIngredientSubstitutes() {
        assertEquals(substitutes, substitutesOutputData.getIngredientSubstitutes());
    }

    @Test
    void isUseCaseFailed() {
        assertFalse(substitutesOutputData.isUseCaseFailed());
    }
}
