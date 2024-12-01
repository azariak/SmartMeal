package entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GenericResultTest {
    private final GenericRecipeInterface recipe1 = new GenericRecipe("name1", "id1");
    private final GenericRecipeInterface recipe2 = new GenericRecipe("name2", "id3");
    private final GenericRecipeInterface recipe3 = new GenericRecipe("name3", "id3");
    ArrayList<GenericRecipeInterface> recipes = new ArrayList<>();
    ArrayList<GenericRecipeInterface> recipes2 = new ArrayList<>();

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
        final Result result = new GenericResult();
        assert result.getRecipes().isEmpty();
    }

    @Test
    void addListOfRecipes() {
        assert recipes.contains(recipe1);
        assert recipes.contains(recipe2);

        Result result = new GenericResult();
        result.addRecipe(recipes);

        assertEquals(2, result.getRecipes().size());
        for (GenericRecipeInterface recipe : recipes) {
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

        Result result = new GenericResult();
        result.addRecipe(recipes);

        assertEquals(3, result.getRecipes().size());
        for (GenericRecipeInterface recipe : recipes) {
            assert result.getRecipes().contains(recipe);
        }

    }

    @Test
    void addSecondListOfRecipesWithRepetition() {
        assert recipes.contains(recipe1);
        assert recipes.contains(recipe2);

        Result result = new GenericResult();
        result.addRecipe(recipes);
        result.addRecipe(recipes2);

        assertEquals(3, result.getRecipes().size());
        for (GenericRecipeInterface recipe : recipes) {
            assert result.getRecipes().contains(recipe);
        }
        for (GenericRecipeInterface recipe : recipes2) {
            assert result.getRecipes().contains(recipe);
        }

    }

    @Test
    void getRecipes() {
        assert recipes.contains(recipe1);
        assert recipes.contains(recipe2);

        Result result = new GenericResult();
        result.addRecipe(recipes);

        assert recipes.equals(result.getRecipes());
    }
}