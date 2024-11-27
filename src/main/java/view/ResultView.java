package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.*;

import entity.GenericRecipe;
import interface_adapter.result.ResultController;
import interface_adapter.result.ResultViewModel;

/**
 * The result view.
 */
public class ResultView extends JPanel implements ActionListener, PropertyChangeListener {

    private static final Integer MAXIMUM_RECIPE_TO_DISPLAY = 10;
    private static final Integer MINIMUM_RECIPE_TO_DISPLAY = 0;

    private final String viewName = "Result View";
    private final ResultViewModel resultViewModel;
    private ResultController resultController;
    private final JPanel recipeButtons;

    public ResultView(ResultViewModel resultViewModel) {
        this.resultViewModel = resultViewModel;
        this.resultViewModel.addPropertyChangeListener(this);
        final JLabel title = new JLabel("Results");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.recipeButtons = new JPanel();
        recipeButtons.setLayout(new BoxLayout(recipeButtons, BoxLayout.Y_AXIS));

        final JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resultController.backTolastView();

            }
        });
        this.add(back);
    }

    /**
     * Add the recipe buttons.
     */
    public void addRecipeButtons() {

        final ArrayList<GenericRecipe> recipeArrayList = resultViewModel.getState().getResult().getRecipes();

        if (recipeArrayList.size() == MINIMUM_RECIPE_TO_DISPLAY) {
            final JLabel zeroRecipeErrorMessage = new JLabel("No Recipe Found");
            this.add(zeroRecipeErrorMessage);
        }
        else {
            for (int i = 0; i < Math.min(MAXIMUM_RECIPE_TO_DISPLAY, recipeArrayList.size()); i++) {
                final int recipeIndex = i;
                final JButton recipeButton = new JButton(recipeArrayList.get(recipeIndex).getName());

                addListenerToRecipeButtonByIndex(recipeButton, recipeArrayList, recipeIndex);

                recipeButtons.add(recipeButton);
            }
        }
        this.add(recipeButtons);
    }

    /**
     * Remove all recipe buttons.
     */
    public void removeAllRecipeButtons() {
        recipeButtons.removeAll();
    }

    private void addListenerToRecipeButtonByIndex(JButton recipeButton,
                                                  ArrayList<GenericRecipe> recipeArrayList,
                                                  int recipeIndex) {
        recipeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                if (evt.getSource().equals(recipeButton)) {
                    resultController.execute(recipeArrayList.get(recipeIndex));
                }

            }
        });
    }

    public String getViewName() {
        return viewName;
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
}
