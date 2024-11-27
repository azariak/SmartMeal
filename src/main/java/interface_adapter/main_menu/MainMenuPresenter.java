package interface_adapter.main_menu;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import use_case.main_menu.MainMenuOutputBoundary;

public class MainMenuPresenter implements MainMenuOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final LoginViewModel loginViewModel;
    private final SignupViewModel signupViewModel;
    private final MainMenuViewModel mainMenuViewModel;


    public MainMenuPresenter(ViewManagerModel viewManagerModel,
                             SignupViewModel signupViewModel,
                             LoginViewModel loginViewModel,
                             MainMenuViewModel mainMenuViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.signupViewModel = signupViewModel;
        this.mainMenuViewModel = mainMenuViewModel;
    }

    @Override
    public void switchToLoginView() {
        viewManagerModel.setState(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToIngredientSearchView() {
        viewManagerModel.setState("Ingredient Search");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToLoadSavedRecipeView() {
        viewManagerModel.setState("Saved Recipes");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToSignupView() {
        viewManagerModel.setState(signupViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToRankedView() {
        this.viewManagerModel.switchView("Ranked Recipes View");
        viewManagerModel.firePropertyChanged();
    }
}
