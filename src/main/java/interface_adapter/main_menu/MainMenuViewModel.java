package interface_adapter.main_menu;

import interface_adapter.ViewModel;

/**
 * The view model for main menu view.
 */
public class MainMenuViewModel extends ViewModel<MainMenuState> {
    public static final String TITLE_LABEL = "                        " + "SmartMeal";
    public static final String TO_LOGIN_BUTTON_LABEL = "Login";
    public static final String SIGNUP_BUTTON_LABEL = "Sign Up";

    public MainMenuViewModel() {
        super("main menu");
    }
}
