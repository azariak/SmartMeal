package interface_adapter.login;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

/**
 * The controller for the Login Use Case.
 */
public class LoginController {

    private final LoginInputBoundary loginUseCaseInteractor;

    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
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

    /**
     * Switch to saved recipe view.
     */
    public void switchToLoadSavedRecipeView() {
        loginUseCaseInteractor.switchToLoadSavedRecipeView();
    }

    /**
     * Switch to demo ingredient search view.
     */
    public void switchToIngredienSearchView() {
        loginUseCaseInteractor.switchToIngredientSearchView();
    }

    /**
     * Switch to ranked view.
     */
    public void switchToRankedView() {
        loginUseCaseInteractor.switchToRankedView();
    }
}
