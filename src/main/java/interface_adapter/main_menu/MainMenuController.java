package interface_adapter.main_menu;

import use_case.main_menu.MainMenuInputBoundary;

public class MainMenuController {

    private final MainMenuInputBoundary mainMenuInteractor;

    public MainMenuController(MainMenuInputBoundary mainMenuInteractor) {
        this.mainMenuInteractor = mainMenuInteractor;
    }

    public void switchToLoginView() {
        mainMenuInteractor.switchToLoginView();
    }

    public void switchToLoadSavedRecipeView() {
        mainMenuInteractor.switchToLoadSavedRecipeView();
    }

    public void switchToIngredienSearchView() {
        mainMenuInteractor.switchToIngredientSearchView();
    }
}
