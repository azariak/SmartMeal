package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jetbrains.annotations.NotNull;

import interface_adapter.back.BackController;
import interface_adapter.ingredient_search.IngredientSearchController;
import interface_adapter.ingredient_search.IngredientSearchState;
import interface_adapter.ingredient_search.IngredientSearchViewModel;

/**
 * Represents the view component for searching ingredients within the application.
 *
 * <p>
 * The IngredientSearchView class is responsible for displaying the user interface
 * elements related to searching for ingredients, including input fields, search
 * buttons, and result displays. It connects with the underlying model to retrieve
 * ingredient data based on user input.
 * </p>
 */
public class IngredientSearchView extends JPanel implements ActionListener, PropertyChangeListener {

    private static final String VIEW_NAME = "Ingredient Search";

    private final IngredientSearchViewModel ingredientSearchViewModel;
    private IngredientSearchController ingredientSearchController;
    private BackController backController;

    private final JTextField ingredientField1 = new JTextField(15);
    private final JTextField ingredientField2 = new JTextField(15);
    private final JTextField ingredientField3 = new JTextField(15);

    private final JPanel ingredientSearchPanel;
    private final JPanel buttons;

    private JButton search;
    private JButton cancel;

    public IngredientSearchView(IngredientSearchViewModel ingredientSearchViewModel) {

        this.ingredientSearchViewModel = ingredientSearchViewModel;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.ingredientSearchPanel = new JPanel();
        this.buttons = new JPanel();

        addIngredientSearchPanel();
        addButtons();
    }

    private void addButtons() {
        addSearchButton();
        addCancelButton();

        this.add(buttons);
    }

    private void addCancelButton() {
        cancel = new JButton("cancel");
        cancel.addActionListener(evt -> backController.backToLastView());

        buttons.add(cancel);
    }

    private void addSearchButton() {
        search = new JButton("Search");
        search.addActionListener(searchButtonListener());

        buttons.add(search);
    }

    @NotNull
    private ActionListener searchButtonListener() {
        return new ActionListener() {
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
                    catch (IOException exception) {
                        throw new RuntimeException(exception);
                    }
                }

            }
        };
    }

    private void addIngredientSearchPanel() {
        ingredientSearchPanel.setLayout(new BoxLayout(ingredientSearchPanel, BoxLayout.Y_AXIS));
        ingredientSearchPanel.setBorder(BorderFactory.createTitledBorder(VIEW_NAME));

        final LabelTextPanel ingredient1 = new LabelTextPanel(
                new JLabel("Ingredient 1"), ingredientField1);
        final LabelTextPanel ingredient2 = new LabelTextPanel(
                new JLabel("Ingredient 2"), ingredientField2);
        final LabelTextPanel ingredient3 = new LabelTextPanel(
                new JLabel("Ingredient 3"), ingredientField3);

        addIngredient1Listener();
        addIngredient2Listener();
        addIngredient3Listener();

        ingredientSearchPanel.add(ingredient1);
        ingredientSearchPanel.add(ingredient2);
        ingredientSearchPanel.add(ingredient3);

        this.add(ingredientSearchPanel);
    }

    private void addIngredient1Listener() {
        ingredientField1.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final IngredientSearchState currentState = ingredientSearchViewModel.getState();
                currentState.setIngredient1(ingredientField1.getText());
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
                currentState.setIngredient2(ingredientField2.getText());
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
                currentState.setIngredient3(ingredientField3.getText());
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
        return VIEW_NAME;
    }

    public void setIngredientSearchController(IngredientSearchController ingredientSearchController) {
        this.ingredientSearchController = ingredientSearchController;
    }

    public void setBackController(BackController backController) {
        this.backController = backController;
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
