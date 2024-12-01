package entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GenericResultTest {
    private final GenericRecipe recipe1 = new GenericRecipe("name1", "id1");
    private final GenericRecipe recipe2 = new GenericRecipe("name2", "id3");
    private final GenericRecipe recipe3 = new GenericRecipe("name3", "id3");
    ArrayList<GenericRecipe> recipes = new ArrayList<>();
    ArrayList<GenericRecipe> recipes2 = new ArrayList<>();

    GenericResultTest() throws IOException {
    }

    @BeforeEach
    void setUp() {
        recipes.add(recipe1);
        recipes.add(recipe2);

        recipes2.add(recipe2);
        recipes2.add(recipe3);
    }

    @AfterEach
    void tearDown() {
        recipes.clear();
        recipes2.clear();
    }

    @Test
    void emptyResult() {
        final GenericResult result = new GenericResult();
        assert result.getRecipes().isEmpty();
    }

    @Test
    void addListOfRecipes() {
        assert recipes.contains(recipe1);
        assert recipes.contains(recipe2);

        GenericResult result = new GenericResult();
        result.addRecipe(recipes);

        assertEquals(2, result.getRecipes().size());
        for (GenericRecipe recipe : recipes) {
            assert result.getRecipes().contains(recipe);
        }
    }

    @Test
    void addListOfRecipesWithRepetition() {
        assert recipes.contains(recipe1);
        assert recipes.contains(recipe2);

        recipes.add(recipe2);
        recipes.add(recipe3);

        assertEquals(4, recipes.size());

        GenericResult result = new GenericResult();
        result.addRecipe(recipes);

        assertEquals(3, result.getRecipes().size());
        for (GenericRecipe recipe : recipes) {
            assert result.getRecipes().contains(recipe);
        }

    }

    @Test
    void addSecondListOfRecipesWithRepetition() {
        assert recipes.contains(recipe1);
        assert recipes.contains(recipe2);

        GenericResult result = new GenericResult();
        result.addRecipe(recipes);
        result.addRecipe(recipes2);

        assertEquals(3, result.getRecipes().size());
        for (GenericRecipe recipe : recipes) {
            assert result.getRecipes().contains(recipe);
        }
        for (GenericRecipe recipe : recipes2) {
            assert result.getRecipes().contains(recipe);
        }

    }

    @Test
    void getRecipes() {
        assert recipes.contains(recipe1);
        assert recipes.contains(recipe2);

        GenericResult result = new GenericResult();
        result.addRecipe(recipes);

        assert recipes.equals(result.getRecipes());
    }
}