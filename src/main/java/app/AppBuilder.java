package app;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import data_access.InMemoryUserDataAccessObject;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.Ranked.RankedViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.change_password.ChangePasswordPresenter;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.ingredient_search.IngredientSearchController;
import interface_adapter.ingredient_search.IngredientSearchPresenter;
import interface_adapter.ingredient_search.IngredientSearchViewModel;
import interface_adapter.load_saved_recipe.LoadSavedRecipeController;
import interface_adapter.load_saved_recipe.LoadSavedRecipePresenter;
import interface_adapter.load_saved_recipe.LoadSavedRecipeViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuPresenter;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.recipe_search.RecipeSearchViewModel;
import interface_adapter.result.ResultViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import use_case.change_password.ChangePasswordInputBoundary;
import use_case.change_password.ChangePasswordInteractor;
import use_case.change_password.ChangePasswordOutputBoundary;
import use_case.ingredient_search.IngredientSearchDataAccessInterface;
import use_case.ingredient_search.IngredientSearchInputBoundary;
import use_case.ingredient_search.IngredientSearchInteractor;
import use_case.ingredient_search.IngredientSearchOutputBoundary;
import use_case.load_saved_recipe.LoadSavedRecipeInputBoundary;
import use_case.load_saved_recipe.LoadSavedRecipeInteractor;
import use_case.load_saved_recipe.LoadSavedRecipeOutputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.main_menu.MainMenuInputBoundary;
import use_case.main_menu.MainMenuInteractor;
import use_case.main_menu.MainMenuOutputBoundary;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import view.*;

/**
 * The AppBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * <p/>
 * This is done by adding each View and then adding related Use Cases.
 */
// Checkstyle note: you can ignore the "Class Data Abstraction Coupling"
//                  and the "Class Fan-Out Complexity" issues for this lab; we encourage
//                  your team to think about ways to refactor the code to resolve these
//                  if your team decides to work with this as your starter code
//                  for your final project this term.
public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    // thought question: is the hard dependency below a problem?
    private final UserFactory userFactory = new CommonUserFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    // thought question: is the hard dependency below a problem?
    private final InMemoryUserDataAccessObject userDataAccessObject = new InMemoryUserDataAccessObject();

    private SignupView signupView;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private LoggedInViewModel loggedInViewModel;
    private LoggedInView loggedInView;
    private LoginView loginView;

    private IngredientSearchView ingredientSearchView;
    private IngredientSearchViewModel ingredientSearchViewModel;

    private LoadSavedRecipeView loadSavedRecipeView;
    private LoadSavedRecipeViewModel loadSavedRecipeViewModel;

    private ResultViewModel resultViewModel;
    private ResultView resultView;

    private MainMenuView mainMenuView;
    private MainMenuViewModel mainMenuViewModel;

    private RankedView rankedView;
    private RankedViewModel rankedViewModel;

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    /**
     * Adds the Signup View to the application.
     * @return this builder
     */
    public AppBuilder addSignupView() {
        signupViewModel = new SignupViewModel();
        signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, signupView.getViewName());
        return this;
    }

    /**
     * Adds the Login View to the application.
     * @return this builder
     */
    public AppBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return this;
    }

    /**
     * Adds the LoggedIn View to the application.
     * @return this builder
     */
    public AppBuilder addLoggedInView() {
        loggedInViewModel = new LoggedInViewModel();
        loggedInView = new LoggedInView(loggedInViewModel);
        cardPanel.add(loggedInView, loggedInView.getViewName());
        return this;
    }

    /**
     * Adds the Signup Use Case to the application.
     * @return this builder
     */
    public AppBuilder addSignupUseCase() {
        final SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel, loginViewModel);
        final SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        final SignupController controller = new SignupController(userSignupInteractor);
        signupView.setSignupController(controller);
        return this;
    }

    /**
     * Adds the Login Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

    /**
     * Adds the Change Password Use Case to the application.
     * @return this builder
     */
    public AppBuilder addChangePasswordUseCase() {
        final ChangePasswordOutputBoundary changePasswordOutputBoundary =
                new ChangePasswordPresenter(loggedInViewModel);

        final ChangePasswordInputBoundary changePasswordInteractor =
                new ChangePasswordInteractor(userDataAccessObject, changePasswordOutputBoundary, userFactory);

        final ChangePasswordController changePasswordController =
                new ChangePasswordController(changePasswordInteractor);
        loggedInView.setChangePasswordController(changePasswordController);
        return this;
    }

    /**
     * Adds the Logout Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLogoutUseCase() {
        final LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);

        final LogoutInputBoundary logoutInteractor =
                new LogoutInteractor(userDataAccessObject, logoutOutputBoundary);

        final LogoutController logoutController = new LogoutController(logoutInteractor);
        loggedInView.setLogoutController(logoutController);
        return this;
    }

    public AppBuilder addLoadSavedRecipeUseCase() {
        final LoadSavedRecipeOutputBoundary loadSavedRecipeOutputBoundary =
                new LoadSavedRecipePresenter(viewManagerModel, loadSavedRecipeViewModel);

        final LoadSavedRecipeInputBoundary loadSavedRecipeInteractor =
                new LoadSavedRecipeInteractor(userDataAccessObject,
                        loadSavedRecipeOutputBoundary);

        final LoadSavedRecipeController loadSavedRecipeController =
                new LoadSavedRecipeController(loadSavedRecipeInteractor);
        loadSavedRecipeView.setLoadSavedRecipeController(loadSavedRecipeController);
        return this;
    }

    public AppBuilder addIngredientSearchView() {
        ingredientSearchViewModel = new IngredientSearchViewModel();
        ingredientSearchView = new IngredientSearchView(ingredientSearchViewModel);
        cardPanel.add(ingredientSearchView, ingredientSearchView.getViewName());
        return this;
    }

    public AppBuilder addResultView() {
        resultViewModel = new ResultViewModel();
        resultView = new ResultView("");
        cardPanel.add(resultView, resultView.getViewName());
        return this;
    }

    public AppBuilder addMainMenuView() {
        mainMenuViewModel = new MainMenuViewModel();
        mainMenuView = new MainMenuView(mainMenuViewModel);
        cardPanel.add(mainMenuView, mainMenuView.getViewName());
        return this;
    }

    public AppBuilder addRankedView() {
        rankedViewModel = new RankedViewModel();
        rankedView = new RankedView(rankedViewModel);
        cardPanel.add(rankedView, rankedView.getViewName());
        return this;
    }

    public AppBuilder addMainMenuUseCase() {
        final MainMenuOutputBoundary mainMenuOutputBoundary =
                new MainMenuPresenter(viewManagerModel, signupViewModel, loginViewModel, mainMenuViewModel);

        final MainMenuInputBoundary mainMenuInputBoundary =
                new MainMenuInteractor(mainMenuOutputBoundary);

        final MainMenuController mainMenuController =
                new MainMenuController(mainMenuInputBoundary);
        mainMenuView.setMainMenuController(mainMenuController);
        return this;
    }

    public AppBuilder addLoadSavedRecipeView() {
        loadSavedRecipeViewModel = new LoadSavedRecipeViewModel();
        loadSavedRecipeView = new LoadSavedRecipeView(loadSavedRecipeViewModel);
        cardPanel.add(loadSavedRecipeView, loadSavedRecipeView.getViewName());
        return this;
    }

    /**
     * Adds the Ingredient Search Use Case to the application.
     * @return this builder
     */
    public AppBuilder addIngredientSearchUseCase() {
        final IngredientSearchOutputBoundary ingredientSearchOutputBoundary =
                new IngredientSearchPresenter(viewManagerModel, ingredientSearchViewModel);

        final IngredientSearchInputBoundary ingredientSearchInteractor =
                new IngredientSearchInteractor(userDataAccessObject,
                        ingredientSearchOutputBoundary);

        final IngredientSearchController ingredientSearchController =
                new IngredientSearchController(ingredientSearchInteractor);
        ingredientSearchView.setIngredientSearchController(ingredientSearchController);
        return this;
    }

    /**
     * Creates the JFrame for the application and initially sets the SignupView to be displayed.
     * @return the application
     */
    public JFrame build() {
        final JFrame application = new JFrame("SmartMeal");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(mainMenuView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}
