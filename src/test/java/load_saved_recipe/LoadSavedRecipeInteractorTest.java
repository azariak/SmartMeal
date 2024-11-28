package load_saved_recipe;

import data_access.InMemoryUserDataAccessObject;
import entity.GenericRecipe;
import entity.CommonUserFactory;
import org.junit.jupiter.api.Test;
import use_case.load_saved_recipe.*;

import static org.junit.jupiter.api.Assertions.*;

public class LoadSavedRecipeInteractorTest {

    @Test
    void successRecipeFoundTest() {
        // Setup input and repository
        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData("1", "Lasagna");
        LoadSavedRecipeDataAccessInterface recipeRepository = new InMemoryUserDataAccessObject();

        // Save the recipe in the repository
        GenericRecipe lasagna = new GenericRecipe("1", "Lasagna");
        recipeRepository.save(lasagna);

        // Setup presenter to verify success
        LoadSavedRecipeOutputBoundary successPresenter = new LoadSavedRecipeOutputBoundary() {
            @Override
            public void prepareSuccessView(LoadSavedRecipeOutputData outputData) {
                assertEquals("1", outputData.getRecipeId());
                assertEquals("Lasagna", outputData.getRecipeName());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        // Execute interactor
        LoadSavedRecipeInputBoundary interactor = new LoadSavedRecipeInteractor(recipeRepository, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void failureRecipeNotFoundTest() {
        // Setup input and repository
        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData("999", "NonExistentRecipe");
        LoadSavedRecipeDataAccessInterface recipeRepository = new InMemoryUserDataAccessObject();

        // Setup presenter to verify failure
        LoadSavedRecipeOutputBoundary failurePresenter = new LoadSavedRecipeOutputBoundary() {
            @Override
            public void prepareSuccessView(LoadSavedRecipeOutputData outputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Recipe with ID \"999\" does not exist.", error);
            }
        };

        // Execute interactor
        LoadSavedRecipeInputBoundary interactor = new LoadSavedRecipeInteractor(recipeRepository, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    void failureEmptyInputTest() {
        // Setup input and repository
        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData("", "");
        LoadSavedRecipeDataAccessInterface recipeRepository = new InMemoryUserDataAccessObject();

        // Setup presenter to verify failure
        LoadSavedRecipeOutputBoundary failurePresenter = new LoadSavedRecipeOutputBoundary() {
            @Override
            public void prepareSuccessView(LoadSavedRecipeOutputData outputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Recipe ID and name cannot be empty.", error);
            }
        };

        // Execute interactor
        LoadSavedRecipeInputBoundary interactor = new LoadSavedRecipeInteractor(recipeRepository, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    void failureInvalidRepositoryTest() {
        // Setup input and use a null repository to simulate failure
        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData("1", "Lasagna");

        // Setup presenter to verify failure
        LoadSavedRecipeOutputBoundary failurePresenter = new LoadSavedRecipeOutputBoundary() {
            @Override
            public void prepareSuccessView(LoadSavedRecipeOutputData outputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Data access error: repository is null.", error);
            }
        };

        // Execute interactor with null repository
        LoadSavedRecipeInputBoundary interactor = new LoadSavedRecipeInteractor(null, failurePresenter);
        interactor.execute(inputData);
    }
}
