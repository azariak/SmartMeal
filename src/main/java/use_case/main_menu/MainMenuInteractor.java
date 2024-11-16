package use_case.main_menu;

import use_case.main_menu.MainMenuInputBoundary;

public class MainMenuInteractor implements MainMenuInputBoundary{
    private final MainMenuOutputBoundary mainMenuPresenter;

    public MainMenuInteractor(MainMenuOutputBoundary mainMenuPresenter) {
        this.mainMenuPresenter = mainMenuPresenter;
    }

    @Override
    public void switchToLoginView() {
        mainMenuPresenter.switchToLoginView();
    }

    @Override
    public void switchToIngredientSearchView() {
        mainMenuPresenter.switchToIngredientSearchView();
    }

    @Override
    public void switchToLoadSavedRecipeView() {
        mainMenuPresenter.switchToLoadSavedRecipeView();
    }

    @Override
    public void switchToSignupView() {
        mainMenuPresenter.switchToSignupView();
    }
}
