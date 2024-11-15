package interface_adapter.signup;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the Signup View.
 */
public class SignupViewModel extends ViewModel<SignupState> {

    // TODO: changed for ingredient search demo, previous strings are in the commented out section.
    public static final String TITLE_LABEL = "Sign Up View";
    public static final String USERNAME_LABEL = "Choose username";
    public static final String PASSWORD_LABEL = "Choose password";
    public static final String REPEAT_PASSWORD_LABEL = "Enter password again";

    public static final String SIGNUP_BUTTON_LABEL = "Sign up";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    public static final String TO_LOGIN_BUTTON_LABEL = "To Login";

//    public static final String TITLE_LABEL = "Sign Up View";
//    public static final String USERNAME_LABEL = "Choose username";
//    public static final String PASSWORD_LABEL = "Choose password";
//    public static final String REPEAT_PASSWORD_LABEL = "Enter password again";
//
//    public static final String SIGNUP_BUTTON_LABEL = "Sign up";
//    public static final String CANCEL_BUTTON_LABEL = "Cancel";
//
//    public static final String TO_LOGIN_BUTTON_LABEL = "Ingredient Search";

    public SignupViewModel() {
        super("sign up");
        setState(new SignupState());
    }

}
