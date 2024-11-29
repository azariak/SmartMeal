package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jetbrains.annotations.NotNull;

import interface_adapter.ingredient_substitutions.SubstitutesController;
import interface_adapter.recipe_detail.RecipeDetailController;
import interface_adapter.recipe_detail.RecipeDetailViewModel;

/**
 * The RecipeDetailView for our program.
 */
public class RecipeDetailView extends JPanel implements PropertyChangeListener {

    private static final int THIRTY = 30;
    private static final int ZERO = 0;
    private static final int TWO_HUNDRED = 200;
    private static final int FIFTEEN = 15;
    private static final int TEN = 10;

    private final String viewName = "Recipe Detail";
    private final RecipeDetailViewModel recipeDetailViewModel;
    private RecipeDetailController recipeDetailController;
    private SubstitutesController substitutesController;

    public RecipeDetailView(RecipeDetailViewModel recipeDetailViewModel) {
        this.recipeDetailViewModel = recipeDetailViewModel;
        this.recipeDetailViewModel.addPropertyChangeListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        final JLabel title = new JLabel("Recipe Detail");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);
    }

    /**
     * Method that calls all helper methods to build the view.
     */
    public void buildRecipeDetailView() {
        this.add(createTopPanel());
        this.add(createMiddlePanel());
        this.add(createInstructionsPanel());
    }

    private JPanel createTopPanel() {
        final JButton backButton = new JButton("Back");
        final JLabel recipeLabel = new JLabel("Recipe Name:");
        final JLabel recipeName = new JLabel(recipeDetailViewModel.getState().getRecipeName());

        backButton.addActionListener(event -> recipeDetailController.backToLastView());

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
            final JButton substituteButton = getjButton(ingredients, i);

            substitutionsPanel.add(substituteButton);
        }

        return substitutionsPanel;
    }

    @NotNull
    private JButton getjButton(ArrayList<String> ingredients, int i) {
        final String ingredient = ingredients.get(i);

        final JButton substituteButton = new JButton("Substitutes for " + ingredient + " (" + i + ")");

        substituteButton.setPreferredSize(new Dimension(TWO_HUNDRED, FIFTEEN));
        substituteButton.setMaximumSize(new Dimension(TWO_HUNDRED, FIFTEEN));
        substituteButton.setMinimumSize(new Dimension(TWO_HUNDRED, FIFTEEN));
        substituteButton.setFont(new Font(substituteButton.getFont().getName(), Font.PLAIN, TEN));
        substituteButton.addActionListener(event -> substitutesController.execute(ingredient));

        return substituteButton;
    }

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

