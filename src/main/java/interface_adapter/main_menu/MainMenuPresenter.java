package interface_adapter.main_menu;

import interface_adapter.ViewManagerModel;
import interface_adapter.ingredient_search.IngredientSearchViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import use_case.main_menu.MainMenuOutputBoundary;

/**
 * The presenter for the main menu use case.
 */
public class MainMenuPresenter implements MainMenuOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final LoginViewModel loginViewModel;
    private final SignupViewModel signupViewModel;
    private final MainMenuViewModel mainMenuViewModel;
    private final IngredientSearchViewModel ingredientSearchViewModel;

    public MainMenuPresenter(ViewManagerModel viewManagerModel,
                             SignupViewModel signupViewModel,
                             LoginViewModel loginViewModel,
                             MainMenuViewModel mainMenuViewModel,
                             IngredientSearchViewModel ingredientSearchViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.signupViewModel = signupViewModel;
        this.mainMenuViewModel = mainMenuViewModel;
        this.ingredientSearchViewModel = ingredientSearchViewModel;
    }

    @Override
    public void switchToLoginView() {
        viewManagerModel.switchView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToIngredientSearchView() {
        viewManagerModel.switchView(ingredientSearchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToLoadSavedRecipeView() {
        viewManagerModel.switchView("Saved Recipes");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToSignupView() {
        viewManagerModel.switchView(signupViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToRankedView() {
        this.viewManagerModel.switchView("Ranked Recipes View");
        viewManagerModel.firePropertyChanged();
    }
}
