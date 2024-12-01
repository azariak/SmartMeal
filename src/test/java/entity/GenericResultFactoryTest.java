package entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GenericResultFactoryTest {

    private final GenericRecipe recipe1 = new GenericRecipe("name1", "id1");
    private final GenericRecipe recipe2 = new GenericRecipe("name2", "id3");
    private final GenericRecipe recipe3 = new GenericRecipe("name3", "id3");
    ArrayList<GenericRecipe> recipeList;

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

        GenericResult entityTest = new GenericResult();
        entityTest.addRecipe(recipeList);
    }

    @Test
    void createResult() {
        GenericResultFactory factoryEntity = new GenericResultFactory();
        GenericResult resultEntity = factoryEntity.createResult(recipeList);

        GenericResult entityTest = new GenericResult();
        entityTest.addRecipe(recipeList);

        for (GenericRecipe recipe : entityTest.getRecipes()) {
            assert resultEntity.getRecipes().contains(recipe);
        }

        assertEquals(entityTest.getRecipes().size(), resultEntity.getRecipes().size());
    }

}