package view;

import interface_adapter.ingredient_search.IngredientSearchController;
import interface_adapter.ingredient_search.IngredientSearchViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import javax.swing.event.DocumentEvent;
// import javax.swing.event.DocumentListener;

// import java.beans.PropertyChangeEvent;

public class IngredientSearchView extends JPanel {

    private final String viewName = "log in";
    private IngredientSearchViewModel ingredientSearchViewModel;
    private IngredientSearchController ingredientSearchController;

    private final JTextField ingredientField1 = new JTextField(15);
    private final JTextField ingredientField2 = new JTextField(15);
    private final JTextField ingredientField3 = new JTextField(15);

    private final JButton search;
    private final JButton cancel;

    public IngredientSearchView(IngredientSearchViewModel ingredientSearchViewModel) {

        this.ingredientSearchViewModel = ingredientSearchViewModel;

        final JLabel title = new JLabel("Ingredient Search");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel ingredientField1 = new LabelTextPanel(
                new JLabel("Ingredient 1"), ingredientField1);
        final LabelTextPanel ingredientField2 = new LabelTextPanel(
                new JLabel("Ingredient 2"), ingredientField2);
        final LabelTextPanel ingredientField3 = new LabelTextPanel(
                new JLabel("Ingredient 3"), ingredientField3);

        final JPanel buttons = new JPanel();
        search = new JButton("Search");
        buttons.add(search);
        cancel = new JButton("cancel");
        buttons.add(cancel);

        search.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(search)) {
                            IngredientSearchController.execute(
                                    //TBD
                            );
                        }
                    }
                }
        );

        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(ingredientField1);
        this.add(ingredientField2);
        this.add(ingredientField3);
        this.add(buttons);
    }

    public String getViewName() {
        return viewName;
    }

    public void setIngredientSearchController(IngredientSearchController ingredientSearchController) {
        this.ingredientSearchController = ingredientSearchController;
    }
}
