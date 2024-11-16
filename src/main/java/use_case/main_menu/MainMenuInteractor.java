package use_case.main_menu;

/**
 * The main menu interactor.
 */
public class MainMenuInteractor implements MainMenuInputBoundary {
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
