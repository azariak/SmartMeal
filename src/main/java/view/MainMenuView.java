package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuViewModel;

/**
 * The main menu view, which is displayed when
 * the user accesses the application.
 * It contains buttons for different
 * functionality such as login, sign up, and navigating
 * to other views such as ingredient search,
 * saved recipes, and ranked recipes.
 */
public class MainMenuView extends JPanel implements ActionListener, PropertyChangeListener {
    private static final String VIEW_NAME = "main menu";

    private final MainMenuViewModel mainMenuViewModel;
    private MainMenuController mainMenuController;

    private final JButton signUp;
    private final JButton toLogin;

    // TODO: line below is for demo
    private final JButton demoIngredientSearch;
    private final JButton loadSavedRecipes;

    private final JButton rankedRecipes;

    /**
     * Constructs the MainMenuView with the provided MainMenuViewModel.
     * Sets up the layout and action listeners for various buttons.
     *
     * @param mainMenuViewModel The view model that holds the
     *                          state and logic for the main menu view.
     */
    public MainMenuView(MainMenuViewModel mainMenuViewModel) {
        this.mainMenuViewModel = mainMenuViewModel;
        mainMenuViewModel.addPropertyChangeListener(this);

        // Title and welcome message
        final JLabel title = new JLabel("Welcome to SmartMeal!");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 30));

        // Create the panel layout for the main menu
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Add the welcome message
        this.add(Box.createVerticalStrut(50));
        this.add(title);
        this.add(Box.createVerticalStrut(50));
        this.setPreferredSize(new Dimension(650, 550));

        // Create the functional buttons panel
        final JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));

        demoIngredientSearch = new JButton("Ingredient Search");
        buttons.add(demoIngredientSearch);

        loadSavedRecipes = new JButton("Saved Recipes");
        buttons.add(loadSavedRecipes);

        rankedRecipes = new JButton("Ranked Recipes");
        buttons.add(rankedRecipes);

        // Create the login/signup buttons panel
        final JPanel accountButtons = new JPanel();
        accountButtons.setLayout(new BoxLayout(accountButtons, BoxLayout.X_AXIS));

        toLogin = new JButton("Login");
        accountButtons.add(toLogin);

        signUp = new JButton("Sign Up");
        accountButtons.add(signUp);

        // Add the buttons to the view
        this.add(Box.createVerticalStrut(20));
        this.add(buttons);
        this.add(Box.createVerticalStrut(20));
        this.add(accountButtons);

        // Action listeners for buttons
        signUp.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        mainMenuController.switchToSignupView();
                    }
                }
        );

        toLogin.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        mainMenuController.switchToLoginView();
                    }
                }
        );

        demoIngredientSearch.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        mainMenuController.switchToIngredienSearchView();
                    }
                }
        );

        loadSavedRecipes.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        mainMenuController.switchToLoadSavedRecipeView();
                    }
                }
        );

        rankedRecipes.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainMenuController.switchToRankedView();
                    }
                }
        );
    }

    /**
     * Returns the name of this view.
     *
     * @return The name of the view.
     */
    public String getViewName() {
        return VIEW_NAME;
    }

    /**
     * Handles the click action on buttons. This method is currently not used for
     * handling actions directly, but serves as a placeholder for potential future actions.
     *
     * @param evt The event triggered by the button click.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    /**
     * Property change listener that reacts to property changes in the view model.
     * Currently, no specific actions are defined for the property changes.
     *
     * @param evt The property change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // No specific action needed for property changes at the moment
    }

    /**
     * Sets the MainMenuController, which is responsible for handling the
     * navigation between views.
     *
     * @param mainMenuController The controller responsible
     *                           for handling main menu actions.
     */
    public void setMainMenuController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }
}
