package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jetbrains.annotations.NotNull;

/**
 * The RecipeDetailView for our program.
 */
public class RecipeDetailView extends JFrame {

    static final int SIX_HUNDRED = 600;
    static final int FOUR_HUNDRED = 400;
    static final int SIXTEEN = 16;

    public RecipeDetailView(String recipeName, String[] ingredients, String[] quantities, String instructions) {

        setTitle("Recipe Detail View");
        setSize(SIX_HUNDRED, FOUR_HUNDRED);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        final JPanel topPanel = new JPanel(new BorderLayout());
        final JButton backButton = new JButton("Back");
        final JLabel recipeNameLabel = new JLabel("Recipe Name:" + recipeName, JLabel.CENTER);
        recipeNameLabel.setFont(new Font("Arial", Font.BOLD, SIXTEEN));
        topPanel.add(backButton, BorderLayout.WEST);
        topPanel.add(recipeNameLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        final JPanel centerPanel = getjPanel(ingredients, quantities);

        add(centerPanel, BorderLayout.CENTER);

        final JPanel bottomPanel = new JPanel(new BorderLayout());

        final JLabel instructionsLabel = new JLabel("Instructions:" + instructions, JLabel.CENTER);
        final JButton saveButton = new JButton("Save Recipe");

        bottomPanel.add(instructionsLabel, BorderLayout.CENTER);
        bottomPanel.add(saveButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Recipe saved successfully!");

            }
        });
    }

    @NotNull
    private static JPanel getjPanel(String[] ingredients, String[] quantities) {
        final JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < ingredients.length; i++) {
            final JPanel ingredientRow = new JPanel(new FlowLayout(FlowLayout.LEFT));

            final JLabel ingredientLabel = new JLabel(ingredients[i] + ": ");
            final JLabel quantityLabel = new JLabel(quantities[i]);

            final JButton substituteButton = new JButton("Click for more info");

            ingredientRow.add(ingredientLabel);
            ingredientRow.add(quantityLabel);
            ingredientRow.add(substituteButton);

            centerPanel.add(ingredientRow);

            // Add functionality to the substitute button (example)
            substituteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Substitute options for " + ingredients[i]);
                }
            });
        }
        return centerPanel;
    }
}
