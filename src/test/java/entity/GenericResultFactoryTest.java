package entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GenericResultFactoryTest {

    private final GenericRecipeInterface recipe1 = new GenericRecipe("name1", "id1");
    private final GenericRecipeInterface recipe2 = new GenericRecipe("name2", "id3");
    private final GenericRecipeInterface recipe3 = new GenericRecipe("name3", "id3");
    ArrayList<GenericRecipeInterface> recipeList;

    GenericResultFactoryTest() throws IOException {
    }

    @BeforeEach
    void setUp() {
        recipeList = new ArrayList<>();
        recipeList.add(recipe1);
        recipeList.add(recipe2);
        recipeList.add(recipe3);

    }

    @AfterEach
    void tearDown() {
        recipeList.clear();

        Result entityTest = new GenericResult();
        entityTest.addRecipe(recipeList);
    }

    @Test
    void createResult() {
        GenericResultFactory factoryEntity = new GenericResultFactory();
        Result resultEntity = factoryEntity.createResult(recipeList);

        Result entityTest = new GenericResult();
        entityTest.addRecipe(recipeList);

        for (GenericRecipeInterface recipe : entityTest.getRecipes()) {
            assert resultEntity.getRecipes().contains(recipe);
        }

        assertEquals(entityTest.getRecipes().size(), resultEntity.getRecipes().size());
    }

}