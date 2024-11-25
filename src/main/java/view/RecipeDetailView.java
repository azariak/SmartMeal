package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interface_adapter.recipe_detail.RecipeDetailController;
import interface_adapter.recipe_detail.RecipeDetailViewModel;

/**
 * The RecipeDetailView for our program.
 */
public class RecipeDetailView extends JFrame {

    static final int SIXTEEN = 16;
    static final int SIX_HUNDRED = 600;
    static final int FOUR_HUNDRED = 400;

    private final RecipeDetailViewModel recipeDetailViewModel;
    private final RecipeDetailController recipeDetailController;

    public RecipeDetailView(RecipeDetailViewModel viewModel, RecipeDetailController controller) {
        this.recipeDetailViewModel = viewModel;
        this.recipeDetailController = controller;

        setTitle("Recipe Detail View");
        setSize(SIX_HUNDRED, FOUR_HUNDRED);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel
        final JPanel topPanel = new JPanel(new BorderLayout());
        final JButton backButton = new JButton("Back");
        final JLabel recipeNameLabel =
                new JLabel("Recipe Name: " + recipeDetailViewModel.getState().getRecipeName(), JLabel.CENTER);
        recipeNameLabel.setFont(new Font("Arial", Font.BOLD, SIXTEEN));
        topPanel.add(backButton, BorderLayout.WEST);
        topPanel.add(recipeNameLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        // Center panel
        final JPanel centerPanel =
                getjPanel(recipeDetailViewModel.getState().getIngredients(), recipeDetailViewModel.getState().getQuantities());
        add(centerPanel, BorderLayout.CENTER);

        // Bottom panel
        final JPanel bottomPanel = new JPanel(new BorderLayout());
        final JLabel instructionsLabel =
                new JLabel("Instructions: " + recipeDetailViewModel.getState().getInstructions(), JLabel.CENTER);
        final JButton saveButton = new JButton("Save Recipe");
        bottomPanel.add(instructionsLabel, BorderLayout.CENTER);
        bottomPanel.add(saveButton, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private static JPanel getjPanel(List<String> ingredients, List<String> quantities) {
        final JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < ingredients.size(); i++) {
            final JPanel ingredientRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
            final JLabel ingredientLabel = new JLabel(ingredients.get(i) + ": ");
            final JLabel quantityLabel = new JLabel(quantities.get(i));
            final JButton substituteButton = new JButton("Click for more info");

            ingredientRow.add(ingredientLabel);
            ingredientRow.add(quantityLabel);
            ingredientRow.add(substituteButton);

            centerPanel.add(ingredientRow);

            final int finalI = i;
            substituteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Substitute options for "
                            + ingredients.get(finalI));
                }
            });

        }

        return centerPanel;
    }
}
