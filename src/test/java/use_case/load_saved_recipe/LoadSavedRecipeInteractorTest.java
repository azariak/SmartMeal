package use_case.load_saved_recipe;

import data_access.FileRecipeSaver;
import entity.AdvancedRecipe;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoadSavedRecipeInteractorTest {

    private static final String TEST_FILE_PATH = "src/test/resources/recipe_test.json";
    private FileRecipeSaver fileRecipeSaver;

    @BeforeEach
    void setUp() {
        fileRecipeSaver = new FileRecipeSaver();
        File testFile = new File(TEST_FILE_PATH);
        testFile.getParentFile().mkdirs();
        testFile.delete();
    }

    @AfterEach
    void tearDown() {
        new File(TEST_FILE_PATH).delete();
    }

    @Test
    void successTest() {
        JSONObject recipe1 = new JSONObject();
        recipe1.put("id", "1");
        recipe1.put("name", "Lasagna");
        fileRecipeSaver.saveRecipe(recipe1, TEST_FILE_PATH);

        JSONObject recipe2 = new JSONObject();
        recipe2.put("id", "2");
        recipe2.put("name", "Chicken Soup");
        fileRecipeSaver.saveRecipe(recipe2, TEST_FILE_PATH);

        // Success Presenter to test the interaction
        LoadSavedRecipeOutputBoundary successPresenter = new LoadSavedRecipeOutputBoundary() {
            @Override
            public void prepareSuccessView(LoadSavedRecipeOutputData outputData) {
                // Validate the recipes returned by the use case
                List<String> recipes = (List<String>) outputData.getRecipeName();
                assertEquals(2, recipes.size());
                assertTrue(recipes.contains("Lasagna"));
                assertTrue(recipes.contains("Chicken Soup"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };
        LoadSavedRecipeInputBoundary interactor = new LoadSavedRecipeInteractor(fileRecipeSaver, successPresenter);

        // Execute the use case
        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData();
        interactor.execute(inputData);
    }

    @Test
    void noRecipesTest() {
        // Failure Presenter to test the interaction
        LoadSavedRecipeOutputBoundary failPresenter = new LoadSavedRecipeOutputBoundary() {
            @Override
            public void prepareSuccessView(LoadSavedRecipeOutputData outputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                // Check the failure message
                assertEquals("No saved recipes found.", error);
            }
        };

        // Create the interactor with the repository and presenter
        LoadSavedRecipeInputBoundary interactor = new LoadSavedRecipeInteractor(fileRecipeSaver, failPresenter);

        // Execute the use case
        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData("recipe 1", "recipe 2", "recipe 3");
        interactor.execute(inputData);
    }
}