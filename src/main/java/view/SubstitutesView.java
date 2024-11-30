package view;

import java.awt.Component;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import interface_adapter.ingredient_substitutions.SubstitutesController;
import interface_adapter.ingredient_substitutions.SubstitutesViewModel;

/**
 * View for the ingredient substitutions use case.
 */
public class SubstitutesView extends JPanel implements PropertyChangeListener {

    private static final int FOUR_HUNDRED = 400;
    private static final int FIFTY = 50;

    private final String viewName = "Substitutes";
    private final SubstitutesViewModel substitutesViewModel;
    private SubstitutesController substitutesController;

    public SubstitutesView(SubstitutesViewModel substitutesViewModel) {
        this.substitutesViewModel = substitutesViewModel;
        this.substitutesViewModel.addPropertyChangeListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JLabel title = new JLabel("Substitutes");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);
    }

    /**
     * This is where the view gets built.
     */
    public void buildSubstitutesView() {
        this.add(createTopPanel());
        this.add(createBottomPanel());
    }

    /**
     * This is where the view gets reset.
     */
    public void breakSubstitutesView() {
        this.removeAll();
    }

    /**
     * A function to create the top panel.
     * @return a JPanel which represents the top panel.
     */
    public JPanel createTopPanel() {
        final JPanel topPanel = new JPanel();
        final JButton backButton = new JButton("Back");

        // Modify the action listener to include breakSubstitutesView()
        backButton.addActionListener(event -> {
            breakSubstitutesView();
            substitutesController.backTolastView();
        });

        final JLabel ingredientLabel = new JLabel("Ingredient Name:");
        final JLabel ingredientName = new JLabel(substitutesViewModel.getState().getIngredientName());
        System.out.println("Ingredient name dummy is : " + substitutesViewModel.getState().getIngredientName());

        topPanel.add(backButton);
        topPanel.add(ingredientLabel);
        topPanel.add(ingredientName);

        return topPanel;
    }

    /**
     * A function to create the bottom panel.
     * @return a JPanel which represents the bottom panel.
     */
    public JPanel createBottomPanel() {
        final JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        final ArrayList<String> ingredientSubstitutes = substitutesViewModel.getState().getIngredientSubstitutes();

        if (!ingredientSubstitutes.isEmpty()) {
            // Case: Substitutes found
            for (int i = 0; i < ingredientSubstitutes.size(); i++) {
                final String ingredientName = ingredientSubstitutes.get(i);

                // Create a JTextArea for each substitute
                final JTextArea substituteTextArea = new JTextArea("Substitute " + (i + 1) + ": " + ingredientName);
                substituteTextArea.setLineWrap(true);
                substituteTextArea.setWrapStyleWord(true);
                substituteTextArea.setEditable(false);

                // Wrap in a JScrollPane
                final JScrollPane scrollPane = new JScrollPane(substituteTextArea);
                scrollPane.setPreferredSize(new Dimension(FOUR_HUNDRED, FIFTY));

                bottomPanel.add(scrollPane);
            }
        }
        else {
            // Case: No substitutes found
            final String errormsg = "Sorry, we weren't able to find any substitutes for: "
                    + substitutesViewModel.getState().getIngredientName();

            // Create a JTextArea for the error message
            final JTextArea errorTextArea = new JTextArea(errormsg);
            errorTextArea.setLineWrap(true);
            errorTextArea.setWrapStyleWord(true);
            errorTextArea.setEditable(false);

            // Wrap in a JScrollPane
            final JScrollPane errorScrollPane = new JScrollPane(errorTextArea);
            errorScrollPane.setPreferredSize(new Dimension(FOUR_HUNDRED, FIFTY));

            bottomPanel.add(errorScrollPane);
        }

        return bottomPanel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            breakSubstitutesView();
            buildSubstitutesView();
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setSubstitutesController(SubstitutesController substitutesController) {
        this.substitutesController = substitutesController;
    }
}
