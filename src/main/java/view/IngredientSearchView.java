package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.ingredient_search.IngredientSearchController;
import interface_adapter.ingredient_search.IngredientSearchState;
import interface_adapter.ingredient_search.IngredientSearchViewModel;

/**
 * Represents the view component for searching ingredients within the application.
 * <p>
 * The IngredientSearchView class is responsible for displaying the user interface
 * elements related to searching for ingredients, including input fields, search
 * buttons, and result displays. It connects with the underlying model to retrieve
 * ingredient data based on user input.
 * </p>
 */
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
                            final ArrayList<String> ingredients = new ArrayList<>();
                            ingredients.add(currentState.getIngredient1());
                            ingredients.add(currentState.getIngredient2());
                            ingredients.add(currentState.getIngredient3());
                            try {
                                ingredientSearchController.execute(ingredients);
                            }
                            catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }

                    }
                }
        );

        cancel.addActionListener(this);

        addIngredient1Listener();
        addIngredient2Listener();
        addIngredient3Listener();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(ingredient1);
        this.add(ingredient2);
        this.add(ingredient3);
        this.add(buttons);
    }

    private void addIngredient1Listener() {
        ingredientField1.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final IngredientSearchState currentState = ingredientSearchViewModel.getState();
                currentState.setIngredient1(new String(ingredientField1.getText()));
                ingredientSearchViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    private void addIngredient2Listener() {
        ingredientField2.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final IngredientSearchState currentState = ingredientSearchViewModel.getState();
                currentState.setIngredient2(new String(ingredientField2.getText()));
                ingredientSearchViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    private void addIngredient3Listener() {
        ingredientField3.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final IngredientSearchState currentState = ingredientSearchViewModel.getState();
                currentState.setIngredient3(new String(ingredientField3.getText()));
                ingredientSearchViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
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
