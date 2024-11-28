package load_saved_recipe;

import data_access.InMemoryUserDataAccessObject;
import entity.CommonUserFactory;
import entity.GenericRecipe;
import entity.AdvancedRecipe;
import entity.UserFactory;
import org.junit.jupiter.api.Test;
import use_case.load_saved_recipe.*;
import use_case.login.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class LoadSavedRecipeInteractorTest {

    @Test
    void successTest() {
        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData("1", "Lasagna");
        LoadSavedRecipeDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        UserFactory factory = new CommonUserFactory();
        AdvancedRecipe recipe =
        userRepository.save(recipe);

        // This creates a successPresenter that tests whether the test case is as we expect.
        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                assertEquals("Paul", user.getUsername());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        LoadSavedRecipeInputBoundary interactor = new LoginInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void successUserLoggedInTest() {
        LoginInputData inputData = new LoginInputData("Paul", "password");
        LoginUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // For the success test, we need to add Paul to the data access repository before we log in.
        UserFactory factory = new CommonUserFactory();
        User user = factory.create("Paul", "password");
        userRepository.save(user);

        // This creates a successPresenter that tests whether the test case is as we expect.
        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                assertEquals("Paul", userRepository.getCurrentUsername());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        LoginInputBoundary interactor = new LoginInteractor(userRepository, successPresenter);
        assertEquals(null, userRepository.getCurrentUsername());

        interactor.execute(inputData);
    }

    @Test
    void failurePasswordMismatchTest() {
        LoadSavedRecipeInputData inputData = new LoadSavedRecipeInputData("Paul", "wrong");
        LoadSavedRecipeDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // For this failure test, we need to add Paul to the data access repository before we log in, and
        // the passwords should not match.
        UserFactory factory = new CommonUserFactory();
        GenericRecipe recipe = factory.create("Paul", "password");
        userRepository.save(recipe);

        // This creates a presenter that tests whether the test case is as we expect.
        LoginOutputBoundary failurePresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                // this should never be reached since the test case should fail
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Incorrect password for \"Paul\".", error);
            }
        };

        LoadSavedRecipeInputBoundary interactor = new LoadSavedRecipeInteractor(userRepository, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    void failureUserDoesNotExistTest() {
        LoadSavedRecipeInputData inputData = new LoginInputData("", "");
        LoadSavedRecipeDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // Add Paul to the repo so that when we check later they already exist

        // This creates a presenter that tests whether the test case is as we expect.
        LoginOutputBoundary failurePresenter = new LoadSavedRecipeOutputBoundary() {
            @Override
            public void prepareSuccessView(LoadSavedRecipeOutputData recipe) {
                // this should never be reached since the test case should fail
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("recipe does not exist", error);
            }
        };

        LoadSavedRecipeInputBoundary interactor = new LoadSavedRecipeInteractor(userRepository, failurePresenter);
        interactor.execute(inputData);
    }
}
