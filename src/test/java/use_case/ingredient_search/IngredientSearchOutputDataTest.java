package use_case.ingredient_search;

import entity.GenericRecipe;
import entity.GenericResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IngredientSearchOutputDataTest {
    private final GenericRecipe recipe1 = new GenericRecipe("name1", "id1");
    private final GenericRecipe recipe2 = new GenericRecipe("name2", "id3");
    GenericResult resultEntity;
    GenericResult resultEntityEmpty;
    Boolean useCaseTrue = true;
    Boolean useCaseFalse = false;

    IngredientSearchOutputDataTest() throws IOException {
    }

    @BeforeEach
    void setUp() {
        ArrayList<GenericRecipe> recipeList = new ArrayList<>();
        recipeList.add(recipe1);
        recipeList.add(recipe2);

        resultEntity = new GenericResult();
        resultEntity.addRecipe(recipeList);

        resultEntityEmpty = new GenericResult();
        resultEntityEmpty.addRecipe(new ArrayList<>());
    }

    @AfterEach
    void tearDown() {
        resultEntity = null;
        resultEntityEmpty = null;
    }

    @Test
    void getResult() {
        IngredientSearchOutputData data = new IngredientSearchOutputData(resultEntity, useCaseFalse);
        assertEquals(data.getResult(), resultEntity);

        IngredientSearchOutputData dataEmpty = new IngredientSearchOutputData(resultEntityEmpty, useCaseFalse);
        assertEquals(dataEmpty.getResult(), resultEntityEmpty);
    }

    @Test
    void isUseCaseFailed() {
        IngredientSearchOutputData data = new IngredientSearchOutputData(resultEntity, useCaseTrue);
        assertEquals(data.isUseCaseFailed(), useCaseTrue);

        IngredientSearchOutputData data2 = new IngredientSearchOutputData(resultEntity, useCaseFalse);
        assertEquals(data2.isUseCaseFailed(), useCaseFalse);

        IngredientSearchOutputData dataEmpty = new IngredientSearchOutputData(resultEntityEmpty, useCaseFalse);
        assertEquals(dataEmpty.isUseCaseFailed(), useCaseFalse);

        IngredientSearchOutputData dataEmpty2 = new IngredientSearchOutputData(resultEntityEmpty, useCaseTrue);
        assertEquals(dataEmpty2.isUseCaseFailed(), useCaseTrue);

    }
}