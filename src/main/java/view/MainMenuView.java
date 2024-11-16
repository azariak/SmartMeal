package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;

/**
 * The main menu view.
 */
public class MainMenuView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "main menu";

    private final MainMenuViewModel mainMenuViewModel;
    private MainMenuController mainMenuController;

    private final JButton signUp;
    private final JButton toLogin;

    // TODO: line below is for demo
    private final JButton demoIngredientSearch;
    private final JButton loadSavedRecipes;

    public MainMenuView(MainMenuViewModel mainMenuViewModel) {
        this.mainMenuViewModel = mainMenuViewModel;
        mainMenuViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(MainMenuViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));

        toLogin = new JButton(MainMenuViewModel.TO_LOGIN_BUTTON_LABEL);
        buttons.add(toLogin);
        signUp = new JButton(MainMenuViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);

        demoIngredientSearch = new JButton("Demo Ingredient Search");
        buttons.add(demoIngredientSearch);
        loadSavedRecipes = new JButton("Saved Recipes");
        buttons.add(loadSavedRecipes);

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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

    public String getViewName() {
        return viewName;
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final MainMenuState state = (MainMenuState) evt.getNewValue();
    }

    public void setMainMenuController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }
}
