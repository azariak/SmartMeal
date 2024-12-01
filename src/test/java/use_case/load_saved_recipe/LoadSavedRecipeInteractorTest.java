package use_case.load_saved_recipe.;

import data_access.FileRecipeSaver;
import entity.*;
import entity.GenericRecipeFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoginInteractorTest {

    @Test
    void successTest() throws IOException {
        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData("", "", "");
        LoadSavedRecipeDataAccessInterface recipeJson = new FileRecipeSaver();

        GenericRecipeFactoryInterface factory = new GenericRecipeFactory();
        GenericRecipeInterface recipe = factory.createGenericRecipe("", "");
        recipeJson.search((AdvancedRecipeInterface) recipe);

        LoadSavedRecipeOutputBoundary successPresenter = new LoadSavedRecipeOutputBoundary() {

            @Override
            public void prepareSuccessView(LoadSavedRecipeOutputData recipe) {
                assertEquals("lasagna", recipe.getRecipeName());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        LoadSavedRecipeInputBoundary interactor = new LoadSavedRecipeInteractor(recipeRepository, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void successUserLoggedInTest() throws IOException {
        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData("", "");
        LoadSavedRecipeDataAccessInterface recipeRepository = new FileRecipeSaver();

        // For the success test, we need to add Paul to the data access repository before we log in.
        GenericRecipeFactory factory = new GenericRecipeFactory();
        GenericRecipeInterface recipe = factory.createGenericRecipe("lasagna", "beef noodles");
        recipeRepository.get(String.valueOf(recipe));

        // This creates a successPresenter that tests whether the test case is as we expect.
        LoadSavedRecipeOutputBoundary successPresenter = new LoadSavedRecipeOutputBoundary() {

            @Override
            public void prepareSuccessView(LoadSavedRecipeOutputData recipe) {
                assertEquals("lasagna", recipeRepository.getCurrentUsername());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        LoadSavedRecipeInputBoundary interactor = new LoadSavedRecipeInteractor(recipeRepository, successPresenter);
        assertEquals(null, recipeRepository.getCurrentUsername());

        interactor.execute(inputData);
    }

    @Test
    void failurePasswordMismatchTest() {
        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData("lasagna", "wrong", "beef");
        LoadSavedRecipeDataAccessInterface recipeRepository = new FileRecipeSaver();

        // For this failure test, we need to add Paul to the data access repository before we log in, and
        // the passwords should not match.
        GenericRecipeFactory factory = new GenericRecipeFactory();
        GenericRecipeInterface recipe = factory.createGenericRecipe("", "");
        recipeRepository.save(recipe);

        // This creates a presenter that tests whether the test case is as we expect.
        LoadSavedRecipeOutputBoundary failurePresenter = new LoadSavedRecipeOutputBoundary() {
            @Override
            public void prepareSuccessView(LoadSavedRecipeOutputData recipe) {
                // this should never be reached since the test case should fail
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("failed to delete recipe\"lasagna\".", error);
            }
        };

        LoadSavedRecipeInputBoundary interactor = new LoadSavedRecipeInteractor(recipeRepository, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    void failureRecipeDoesNotExistTest() {
        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData("lasagna","noodles","beef");
        LoasSavedRecipeDataAccessInterface recipeRepository = new FileRecipeSaver();

        // Add Paul to the repo so that when we check later they already exist

        // This creates a presenter that tests whether the test case is as we expect.
        LoadSavedRecipeOutputBoundary failurePresenter = new LoadSavedRecipeOutputBoundary() {
            @Override
            public void prepareSuccessView(LoadSavedRecipeOutputData user) {
                // this should never be reached since the test case should fail
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("lasagna: recipe does not exist.", error);
            }
        };

        LoadSavedRecipeInputBoundary interactor = new LoadSavedRecipeInteractor(recipeRepository, failurePresenter);
        interactor.execute(inputData);
    }
}