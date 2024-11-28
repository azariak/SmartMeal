package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.*;

import interface_adapter.ingredient_substitutions.SubstitutesController;
import interface_adapter.recipe_detail.RecipeDetailController;
import interface_adapter.recipe_detail.RecipeDetailViewModel;

/**
 * The RecipeDetailView for our program.
 */
public class RecipeDetailView extends JPanel implements PropertyChangeListener {

    // Constants
    private static final int THIRTY = 30;
    private static final int ZERO = 0;
    private static final int TWO_HUNDRED = 200;
    private static final int FIFTEEN = 15;
    private static final int TEN = 10;

    // Instance variables
    private final String viewName = "Recipe Detail";
    private final RecipeDetailViewModel recipeDetailViewModel;
    private RecipeDetailController recipeDetailController;
    private SubstitutesController substitutesController;

    // Constructor to initialize the ViewModel and layout
    public RecipeDetailView(RecipeDetailViewModel recipeDetailViewModel) {
        this.recipeDetailViewModel = recipeDetailViewModel;
        this.recipeDetailViewModel.addPropertyChangeListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        final JLabel title = new JLabel("Recipe Detail");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);
    }

    /**
     * Main method that calls all helper methods to build the view.
     */
    public void buildRecipeDetailView() {
        this.add(createTopPanel());
        this.add(createMiddlePanel());
        this.add(createInstructionsPanel());
    }

    // Create and return the top panel with recipe name and back button
    private JPanel createTopPanel() {
        final JButton backButton = new JButton("Back");
        final JLabel recipeLabel = new JLabel("Recipe Name:");
        final JLabel recipeName = new JLabel(recipeDetailViewModel.getState().getRecipeName());

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                recipeDetailController.backTolastView();
            }
        });

        final JPanel topPanel = new JPanel();
        topPanel.add(backButton);
        topPanel.add(recipeLabel);
        topPanel.add(recipeName);

        return topPanel;
    }

    private JPanel createMiddlePanel() {
        final JPanel middlePanel = new JPanel();
        middlePanel.add(createIngredientPanel());
        middlePanel.add(Box.createRigidArea(new Dimension(THIRTY, ZERO)));
        middlePanel.add(createQuantityPanel());
        middlePanel.add(Box.createRigidArea(new Dimension(THIRTY, ZERO)));
        middlePanel.add(createSubstitutionsPanel());
        return middlePanel;
    }

    // Create and return the panel displaying ingredients
    private JPanel createIngredientPanel() {
        final JPanel ingredientPanel = new JPanel();
        ingredientPanel.setLayout(new BoxLayout(ingredientPanel, BoxLayout.Y_AXIS));

        final JLabel ingredientsLabel = new JLabel("Ingredients");
        ingredientPanel.add(ingredientsLabel);

        final ArrayList<String> ingredients = recipeDetailViewModel.getState().getIngredients();
        for (String ingredient : ingredients) {
            ingredientPanel.add(new JLabel(ingredient));
        }

        return ingredientPanel;
    }

    // Create and return the panel displaying quantities for each ingredient
    private JPanel createQuantityPanel() {
        final JPanel quantityPanel = new JPanel();
        quantityPanel.setLayout(new BoxLayout(quantityPanel, BoxLayout.Y_AXIS));

        final JLabel quantityLabel = new JLabel("Quantity");
        quantityPanel.add(quantityLabel);

        final ArrayList<String> quantities = recipeDetailViewModel.getState().getQuantities();
        for (String quantity : quantities) {
            quantityPanel.add(new JLabel(quantity));
        }

        return quantityPanel;
    }

    private JPanel createSubstitutionsPanel() {
        final JPanel substitutionsPanel = new JPanel();
        substitutionsPanel.setLayout(new BoxLayout(substitutionsPanel, BoxLayout.Y_AXIS));

        final JLabel substitutionsLabel = new JLabel("Substitute Ingredients");
        substitutionsPanel.add(substitutionsLabel);

        final ArrayList<String> ingredients = recipeDetailViewModel.getState().getIngredients();
        for (int i = 0; i < ingredients.size(); i++) {
            final String ingredient = ingredients.get(i);

            final JButton substituteButton = new JButton("Substitutes for " + ingredient + " (" + i + ")");

            substituteButton.setPreferredSize(new Dimension(TWO_HUNDRED, FIFTEEN));
            substituteButton.setMaximumSize(new Dimension(TWO_HUNDRED, FIFTEEN));
            substituteButton.setMinimumSize(new Dimension(TWO_HUNDRED, FIFTEEN));
            substituteButton.setFont(new Font(substituteButton.getFont().getName(), Font.PLAIN, TEN));

            substituteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    substitutesController.execute(ingredient);
                }
            });

            substitutionsPanel.add(substituteButton);
        }

        return substitutionsPanel;
    }

    // Create and return the panel displaying the recipe instructions
    private JPanel createInstructionsPanel() {
        final JPanel bottomPanel = new JPanel();

        final JLabel instructionsLabel = new JLabel("Instructions");
        final String instructions = recipeDetailViewModel.getState().getInstructions();
        final JLabel instructionsText = new JLabel(instructions);

        bottomPanel.add(instructionsLabel);
        bottomPanel.add(instructionsText);

        return bottomPanel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            recipeDetailController.execute(recipeDetailViewModel.getState().getGenericRecipe());
            buildRecipeDetailView();
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setRecipeDetailController(RecipeDetailController recipeDetailController) {
        this.recipeDetailController = recipeDetailController;
    }

    public void setSubstitutesController(SubstitutesController substitutesController) {
        this.substitutesController = substitutesController;
    }
}

