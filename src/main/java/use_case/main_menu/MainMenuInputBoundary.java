package use_case.main_menu;

/**
 * The input boundary for main menu view.
 */
public interface MainMenuInputBoundary {

    /**
     * Switch to log in view.
     */
    void switchToLoginView();

    /**
     * Switch to demo ingredient search view.
     */
    void switchToIngredientSearchView();

    /**
     * Switch to saved recipe view.
     */
    void switchToLoadSavedRecipeView();

    /**
     * Switch to signup view.
     */
    void switchToSignupView();
}
