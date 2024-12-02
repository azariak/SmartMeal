package view;

import java.awt.Component;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.change_password.LoggedInState;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.logout.LogoutController;

/**
 * The View for when the user is logged into the program.
 */
public class LoggedInView extends JPanel implements PropertyChangeListener {

    private final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final JLabel passwordErrorField = new JLabel();
    private ChangePasswordController changePasswordController;
    private LogoutController logoutController;

    private final JButton logOut;

    private final JTextField passwordInputField = new JTextField(15);
    private final JButton changePassword;

    private final JButton demoIngredientSearch;
    private final JButton loadSavedRecipes;

    private final JButton rankedRecipes;

    private LoginController loginController;


    public LoggedInView(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);

        // Title label (empty, as we have other content)
        final JLabel title = new JLabel("");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Welcome message
        final JLabel welcomeMessage = new JLabel("Welcome ");
        welcomeMessage.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Change font size and make it bold
        welcomeMessage.setFont(new Font("Arial", Font.BOLD, 24));

        // Create the panel layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Center the welcome message
        this.add(Box.createVerticalStrut(50));
        this.add(welcomeMessage);

        this.add(Box.createVerticalStrut(50));

        // Password field
        final LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel("Change Password"), passwordInputField);
        passwordInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();

        demoIngredientSearch = new JButton("Ingredient Search");
        buttons.add(demoIngredientSearch);
        loadSavedRecipes = new JButton("Saved Recipes");
        buttons.add(loadSavedRecipes);

        rankedRecipes = new JButton("Ranked Recipes");
        buttons.add(rankedRecipes);

        final JPanel accountButtons = new JPanel();

        logOut = new JButton("Log Out");
        accountButtons.add(logOut);

        changePassword = new JButton("Change Password");
        accountButtons.add(changePassword);

        // Initially hide the password field, error field, and password info label
        passwordInputField.setVisible(false);
        passwordErrorField.setVisible(false);
        passwordInfo.setVisible(false);

        // Add buttons and password field
        this.add(passwordInfo);
        this.add(passwordErrorField);

        this.add(Box.createVerticalStrut(240));

        // Add buttons panel to layout
        this.add(buttons);
        this.add(accountButtons);

        // Action listeners
        demoIngredientSearch.addActionListener(
                evt -> loginController.switchToIngredienSearchView()
        );

        loadSavedRecipes.addActionListener(
                evt -> loginController.switchToLoadSavedRecipeView()
        );

        rankedRecipes.addActionListener(
                evt -> loginController.switchToRankedView()
        );

        passwordInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final LoggedInState currentState = loggedInViewModel.getState();
                currentState.setPassword(passwordInputField.getText());
                loggedInViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        // Toggle visibility of password input field, error field, and password info label
        changePassword.addActionListener(
                evt -> {
                    final boolean isVisible = passwordInputField.isVisible();
                    // Toggle visibility for all relevant components. TODO: This broke functionality
                    passwordInputField.setVisible(!isVisible);
                    passwordErrorField.setVisible(!isVisible);
                    passwordInfo.setVisible(!isVisible);
                }
        );

        logOut.addActionListener(
                evt -> {
                    if (evt.getSource().equals(logOut)) {
                        logoutController.execute(loggedInViewModel.getState().getUsername());
                    }
                }
        );
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            // Update welcome message dynamically
            ((JLabel) this.getComponent(1)).setText("Welcome " + state.getUsername() + " :)");
        }
        else if (evt.getPropertyName().equals("password")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            JOptionPane.showMessageDialog(null, "password updated for " + state.getUsername());
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setChangePasswordController(ChangePasswordController changePasswordController) {
        this.changePasswordController = changePasswordController;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}
