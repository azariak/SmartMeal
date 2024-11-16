
package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.load_saved_recipe.LoadSavedRecipeController;
import interface_adapter.load_saved_recipe.LoadSavedRecipeState;
import interface_adapter.load_saved_recipe.LoadSavedRecipeViewModel;

/**
 * Represents the view component for loading saved recipes within the application.
 */
public class LoadSavedRecipeView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "Saved Recipes";
    private LoadSavedRecipeViewModel loadSavedRecipeViewModel;
    private LoadSavedRecipeController loadSavedRecipeController;

    private final JTextField recipeField1 = new JTextField(15);
    private final JTextField recipeField2 = new JTextField(15);
    private final JTextField recipeField3 = new JTextField(15);

    private final JButton loadButton;
    private final JButton cancelButton;
    private final JButton deleteButton;

    public LoadSavedRecipeView(LoadSavedRecipeViewModel loadSavedRecipeViewModel) {
        this.loadSavedRecipeViewModel = loadSavedRecipeViewModel;

        final JLabel title = new JLabel("Load Saved Recipes");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel recipe1 = new LabelTextPanel(new JLabel("Recipe 1"), recipeField1);
        final LabelTextPanel recipe2 = new LabelTextPanel(new JLabel("Recipe 2"), recipeField2);
        final LabelTextPanel recipe3 = new LabelTextPanel(new JLabel("Recipe 3"), recipeField3);

        final JPanel buttons = new JPanel();
        loadButton = new JButton("Back");
        buttons.add(loadButton);
        cancelButton = new JButton("Cancel");
        buttons.add(cancelButton);
        deleteButton = new JButton("Delete");
        buttons.add(deleteButton);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(loadButton)) {
                    final LoadSavedRecipeState currentState = loadSavedRecipeViewModel.getState();
                    loadSavedRecipeController.loadRecipes(
                            currentState.getRecipe1(),
                            currentState.getRecipe2(),
                            currentState.getRecipe3()
                    );
                }
            }
        });

        cancelButton.addActionListener(this);
        deleteButton.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(recipe1);
        this.add(recipe2);
        this.add(recipe3);
        this.add(buttons);
    }

    public String getViewName() {
        return viewName;
    }

    public void setLoadSavedRecipeController(LoadSavedRecipeController loadSavedRecipeController) {
        this.loadSavedRecipeController = loadSavedRecipeController;
    }

    private void setFields(LoadSavedRecipeState state) {
        recipeField1.setText(state.getRecipe1());
        recipeField2.setText(state.getRecipe2());
        recipeField3.setText(state.getRecipe3());
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final LoadSavedRecipeState state = (LoadSavedRecipeState) evt.getNewValue();
        setFields(state);
    }
}