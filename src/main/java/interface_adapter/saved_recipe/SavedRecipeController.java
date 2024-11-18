package interface_adapter.saved_recipe;

import use_case.login.LoginInputData;
import use_case.saved_recipe.SavedRecipeInputBoundary;
import use_case.saved_recipe.SavedRecipeInputData;

/**
 * The controller for the Saved Recipe Use Case.
 */
public class SavedRecipeController {
    private final SavedRecipeInputBoundary savedRecipeUseCaseInteractor;

    public SavedRecipeController(SavedRecipeInputBoundary savedRecipeUseCaseInteractor) {
        this.savedRecipeUseCaseInteractor = savedRecipeUseCaseInteractor;
    }
    /**
     * Executes the Login Use Case.
     * @param username the username of the user logging in
     * @param password the password of the user logging in
     */

    public void execute(String username, String password) {
        final LoginInputData loginInputData = new LoginInputData(
                username, password);

        loginUseCaseInteractor.execute(loginInputData);
    }

}
