package use_case.ingredient_substitutions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubstitutesInputDataTest {

    private SubstitutesInputData substitutesInputData;

    @BeforeEach
    void setUp() {
        substitutesInputData = new SubstitutesInputData("Sugar");
    }

    @AfterEach
    void tearDown() {
        substitutesInputData = null;
    }

    @Test
    void getIngredientName() {
        assertEquals("Sugar", substitutesInputData.getIngredientName());
    }
}
