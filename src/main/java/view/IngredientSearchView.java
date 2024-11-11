package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interface_adapter.ingredient_search.IngredientSearchController;
import interface_adapter.ingredient_search.IngredientSearchState;
import interface_adapter.ingredient_search.IngredientSearchViewModel;

public class IngredientSearchView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "Ingredient Search";
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

        final LabelTextPanel ingredient1 = new LabelTextPanel(
                new JLabel("Ingredient 1"), ingredientField1);
        final LabelTextPanel ingredient2 = new LabelTextPanel(
                new JLabel("Ingredient 2"), ingredientField2);
        final LabelTextPanel ingredient3 = new LabelTextPanel(
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
                            final IngredientSearchState currentState = ingredientSearchViewModel.getState();

                            ingredientSearchController.execute(
                                    currentState.getIngredient1(),
                                    currentState.getIngredient2(),
                                    currentState.getIngredient3());
                        }

                    }
                }
        );

        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(ingredient1);
        this.add(ingredient2);
        this.add(ingredient3);
        this.add(buttons);
    }

    public String getViewName() {
        return viewName;
    }

    public void setIngredientSearchController(IngredientSearchController ingredientSearchController) {
        this.ingredientSearchController = ingredientSearchController;
    }

    private void setFields(IngredientSearchState state) {
        ingredientField1.setText(state.getIngredient1());
        ingredientField2.setText(state.getIngredient2());
        ingredientField3.setText(state.getIngredient3());
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final IngredientSearchState state = (IngredientSearchState) evt.getNewValue();
        setFields(state);
    }
}
