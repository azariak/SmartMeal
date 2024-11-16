package use_case.main_menu;

public interface MainMenuOutputBoundary {
    void switchToLoginView();

    void switchToIngredientSearchView();

    void switchToLoadSavedRecipeView();

    void switchToSignupView();
}
