package view;

import interface_adapter.ingredient_substitutions.SubstitutesController;
import interface_adapter.ingredient_substitutions.SubstitutesViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.util.ArrayList;

/**
 * View for the ingredient substitutions use case.
 */
public class SubstitutesView extends JPanel implements PropertyChangeListener {

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
     * A function to create the top panel.
     * @return a JPanel which represents the top panel.
     */
    public JPanel createTopPanel() {
        final JPanel topPanel = new JPanel();
        final JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                substitutesController.backTolastView();
            }
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
        final ArrayList<String> ingredientSubstitutes = substitutesViewModel.getState().getIngredientSubstitutes();
        for (int i = 0; i < ingredientSubstitutes.size(); i++) {
            final String ingredientName = ingredientSubstitutes.get(i);
            final JLabel substituteLabel = new JLabel("Substitute " + (i + 1) + ":" + ingredientName);
            bottomPanel.add(substituteLabel);
        }
        return bottomPanel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            buildSubstitutesView();
            System.out.println("Building view...");
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setSubstitutesController(SubstitutesController substitutesController) {
        this.substitutesController = substitutesController;
    }
}
