package interface_adapter.main_menu;

import use_case.main_menu.MainMenuInputBoundary;

/**
 * The controller for main menu view.
 */
public class MainMenuController {

    private final MainMenuInputBoundary mainMenuInteractor;

    public MainMenuController(MainMenuInputBoundary mainMenuInteractor) {
        this.mainMenuInteractor = mainMenuInteractor;
    }

    /**
     * Switch to log in view.
     */
    public void switchToLoginView() {
        mainMenuInteractor.switchToLoginView();
    }

    /**
     * Switch to saved recipe view.
     */
    public void switchToLoadSavedRecipeView() {
        mainMenuInteractor.switchToLoadSavedRecipeView();
    }

    /**
     * Switch to demo ingredient search view.
     */
    public void switchToIngredienSearchView() {
        mainMenuInteractor.switchToIngredientSearchView();
    }

    /**
     * Switch to signup view.
     */
    public void switchToSignupView() {
        mainMenuInteractor.switchToSignupView();
    }

    public void switchToRankedView() {
        mainMenuInteractor.switchToRankedView();
    }
}
