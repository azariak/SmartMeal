
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.load_saved_recipe.LoadSavedRecipeController;
import interface_adapter.load_saved_recipe.LoadSavedRecipeState;
import interface_adapter.load_saved_recipe.LoadSavedRecipeViewModel;
import interface_adapter.load_saved_recipe.LoadSavedRecipeState;

/**
 * Represents the view component for loading saved recipes within the application.
 */
public class LoadSavedRecipeView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "Saved Recipes";
    private LoadSavedRecipeViewModel loadSavedRecipeViewModel;
    private LoadSavedRecipeController loadSavedRecipeController;

    private final JButton loadButton;
    private final JButton cancelButton;
    private final JButton deleteButton;

    public LoadSavedRecipeView(LoadSavedRecipeViewModel loadSavedRecipeViewModel) {
        this.loadSavedRecipeViewModel = loadSavedRecipeViewModel;

        final JLabel title = new JLabel("Saved Recipes");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        final JPanel buttons = new JPanel();
        final JPanel recipesPanel = new JPanel();
        final String[] recipe = new String[]{"Lasagna:4 cups shredded mozzarella cheese divided, ½ cup shredded Parmesan cheese shredded and divided", "Beef Noodles:", "Chicken Noodle Soup:", "Shrimp Salad:", "Pasta:", "Shrimp Udon:", "Tomato Soup:"};
        final JList<String> recipeList = new JList<>(recipe);
        recipeList.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        recipeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        final JScrollPane scrollPane = new JScrollPane(recipeList,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        final int dim = 300;
        scrollPane.setPreferredSize(new Dimension(dim, dim));
        loadButton = new JButton("load");
        buttons.add(loadButton);
        cancelButton = new JButton("Cancel");
        buttons.add(cancelButton);
        deleteButton = new JButton("Delete");
        buttons.add(deleteButton);
        loadButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(loadButton)) {
                            final LoadSavedRecipeState currentState = loadSavedRecipeViewModel.getState();

                            loadSavedRecipeController.execute(
                                    currentState.getRecipe1(),
                                    currentState.getRecipe2(),
                                    currentState.getRecipe3()
                            );
                        }
                    }
                }
        );

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
        this.add(recipesPanel);
        this.add(scrollPane);
        this.add(buttons);
    }

    public String getViewName() {
        return viewName;
    }

    public void setLoadSavedRecipeController(LoadSavedRecipeController loadSavedRecipeController) {
        this.loadSavedRecipeController = loadSavedRecipeController;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}