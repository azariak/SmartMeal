package interface_adapter.main_menu;

import interface_adapter.ViewModel;
import interface_adapter.signup.SignupState;

public class MainMenuViewModel extends ViewModel<MainMenuState> {
    public static final String TITLE_LABEL = "                        Smart Meal";
    public static final String TO_LOGIN_BUTTON_LABEL = "To Login";
    public static final String SIGNUP_BUTTON_LABEL = "Sign Up";

    public MainMenuViewModel() {
        super("main menu");
    }
}
