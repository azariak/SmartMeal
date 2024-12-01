package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.GenericRecipeInterface;
import interface_adapter.back.BackController;
import interface_adapter.result.ResultController;
import interface_adapter.result.ResultViewModel;

/**
 * The result view.
 */
public class ResultView extends JPanel implements ActionListener, PropertyChangeListener {

    private static final Integer MAXIMUM_RECIPE_TO_DISPLAY = 10;
    private static final Integer MINIMUM_RECIPE_TO_DISPLAY = 0;
    private static final String VIEW_NAME = "Result View";

    private final ResultViewModel resultViewModel;

    private ResultController resultController;
    private BackController backController;

    private JPanel recipeButtons;

    public ResultView(ResultViewModel resultViewModel) {

        this.resultViewModel = resultViewModel;
        this.resultViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        addRecipeButtonsPanel();
        addBackButton();
    }

    private void addBackButton() {
        final JPanel backButtonPanel = new JPanel();
        final JButton back = new JButton("Back");
        back.addActionListener(evt -> backController.backToLastView());
        backButtonPanel.add(back);
        this.add(backButtonPanel);
    }

    private void addRecipeButtonsPanel() {
        this.recipeButtons = new JPanel();

        recipeButtons.setBorder(BorderFactory.createTitledBorder("Results"));
        recipeButtons.setLayout(new BoxLayout(recipeButtons, BoxLayout.Y_AXIS));

        this.add(recipeButtons);
    }

    /**
     * Add the recipe buttons.
     */
    public void addRecipeButtons() {

        final ArrayList<GenericRecipeInterface> recipeArrayList = resultViewModel.getState().getResult().getRecipes();

        if (recipeArrayList.size() == MINIMUM_RECIPE_TO_DISPLAY) {
            final JLabel zeroRecipeErrorMessage = new JLabel("No Recipe Found");
            recipeButtons.add(zeroRecipeErrorMessage);
        }
        else {
            for (int i = 0; i < Math.min(MAXIMUM_RECIPE_TO_DISPLAY, recipeArrayList.size()); i++) {
                final JButton recipeButton = new JButton(recipeArrayList.get(i).getName());

                addListenerToRecipeButtonByIndex(recipeButton, recipeArrayList, i);

                recipeButtons.add(recipeButton);
            }
        }
    }

    /**
     * Remove all recipe buttons.
     */
    public void removeAllRecipeButtons() {
        recipeButtons.removeAll();
    }

    private void addListenerToRecipeButtonByIndex(JButton recipeButton,
                                                  ArrayList<GenericRecipeInterface> recipeArrayList,
                                                  int recipeIndex) {
        recipeButton.addActionListener(evt -> {

            if (evt.getSource().equals(recipeButton)) {
                resultController.execute(recipeArrayList.get(recipeIndex));
            }

        });
    }

    public String getViewName() {
        return VIEW_NAME;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            removeAllRecipeButtons();
            addRecipeButtons();
        }
    }

    public void setResultController(ResultController resultController) {
        this.resultController = resultController;
    }

    public void setBackController(BackController backController) {
        this.backController = backController;
    }

}
